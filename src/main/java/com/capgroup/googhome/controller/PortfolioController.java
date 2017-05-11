package com.capgroup.googhome.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgroup.googhome.domain.HookResponse;
import com.capgroup.googhome.domain.portfolioconstruction.Context;
import com.capgroup.googhome.domain.portfolioconstruction.PortfolioConstructionRequest;
import com.capgroup.googhome.virtualwholesaler.App;
import com.capgroup.googhome.virtualwholesaler.FundAllocation;
import com.capgroup.googhome.virtualwholesaler.News;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;



@RestController
public class PortfolioController {

	private Map<String, List<FundAllocation>> portfolioCache = new HashMap<String, List<FundAllocation>>();
	

	private Map<String, List<News>> newsCache = new HashMap<String, List<News>>();
	

	@PostMapping("/debug")
	public void debug(@RequestBody String body, Writer writer) throws IOException {
		System.out.print(body);
		writer.write(body);
	}
	
	
	@PostMapping("/webHook")
	public HookResponse routeAction(@RequestBody PortfolioConstructionRequest pRequest) throws Exception {
		
		if (pRequest.result.action.equalsIgnoreCase("portfolio"))
			return getPortfolioRecommendation(pRequest);
		else if (pRequest.result.action.equalsIgnoreCase("news"))
			return getNews(pRequest);
			
		return new HookResponse();
		
	}
	
	
	@GetMapping("/primecache")
	public String cache(@RequestParam int age, @RequestParam int yearsToRetirement, @RequestParam String riskTolerance) throws Exception {
					
		getFunds(age, yearsToRetirement, riskTolerance);
		
		return "Done";
		
	}
	
	
	public HookResponse getNews(PortfolioConstructionRequest pRequest) throws Exception {
		
		HookResponse response = new HookResponse();
		response.source="";
		String speechResponse= "";
		
		App app = new App();
		List<News> news= null;
		
	    String newsKey="NEWS";

	    news=this.newsCache.get(newsKey);
		
	    if (news==null) {
	    	news=app.getNews((new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080)));
	    	//news=app.getNews((new WebClient()));

	    	this.newsCache.put(newsKey, news);
		
	    }
		
		for (News newsReport : news) {
			speechResponse+= " News for " + newsReport.teaserDateString + ". " + newsReport.teaserHeader + "";
		}
		
		response.text=speechResponse;
		response.speech=speechResponse;
		
		return response;
		
	}
	
	public HookResponse getPortfolioRecommendation(PortfolioConstructionRequest pRequest) {
		
		HookResponse response = new HookResponse();
		response.source="";
		String speechResponse= "The recommended portfolio for your client is ";
		
		try {
		
			Integer age=null;
			Integer yearsToRetirement=null;
			String riskTolerance=null;
			
			
			for (Context context : pRequest.result.contexts) {
				if (context.parameters.age!=null & context.parameters.age.length==1)
					age=context.parameters.age[0];
				
				if (context.parameters.YearstoRetirement!=null)
					yearsToRetirement=context.parameters.YearstoRetirement;
				
				if (context.parameters.RiskTolerance!=null && !("".equals(context.parameters.RiskTolerance)))
					riskTolerance=context.parameters.RiskTolerance;
				
			}
			
			
		    List<FundAllocation> funds = getFunds(age, yearsToRetirement, riskTolerance);
		    
			if (funds==null || funds.isEmpty())
				speechResponse="I'm sorry, I was not able to create a portfolio for your client. Try different parameters.";
			else {
				int i=1;
				for (FundAllocation fund: funds) {
					
					if (i!=1 && i==funds.size())
						speechResponse+=" and ";
					
					speechResponse+= fund.percentage + " percent in " + fund.fundName + ", ";
					i++;
				
				}
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
			speechResponse = "I'm sorry, there was an error, please try again.";
			
		}
		response.text=speechResponse;
		response.speech=speechResponse;
	
		return response;
		
	}
	
	private List<FundAllocation> getFunds (int age, int yearsToRetirement,  String riskTolerance) throws Exception {
		
	    List<FundAllocation> funds= null;
	    
	    String recommendationsKey="RECOMMENDATIONS_"+ riskTolerance.substring(0, 1).toUpperCase() +"_"+App.getDistribution(age)+"_"+App.getAccumulation(age, yearsToRetirement);

	    funds=this.portfolioCache.get(recommendationsKey);
	    
	    App app = new App();
	    
	    if (funds==null) {
		    funds=app.getFundAllocations(new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080), age, age+yearsToRetirement, riskTolerance.substring(0, 1).toUpperCase());
		    //funds=app.getFundAllocations(new WebClient(), age, age+yearsToRetirement, riskTolerance.substring(0, 1).toUpperCase());

	    	portfolioCache.put(recommendationsKey, funds);
	    }
	    
		
	    return funds;
	}
	
	
	@GetMapping("/cacheclear")
	public void cleanCache(Writer writer) throws IOException {
		
		synchronized (this.portfolioCache) {
			this.portfolioCache.clear();
		}
		
		synchronized (this.newsCache) {
			this.newsCache.clear();
		}
		
		writer.write("Cache Cleared");
	}
	

	
}
