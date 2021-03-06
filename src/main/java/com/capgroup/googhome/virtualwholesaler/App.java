package com.capgroup.googhome.virtualwholesaler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class App 
{   
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy");
    private static final SimpleDateFormat dateFormatterShort = new SimpleDateFormat("MM/dd/yy");
    private static final SimpleDateFormat dateFormatterLong = new SimpleDateFormat("EEEE MMMM d yyyy");
    
    public List <News> getNews(WebClient webClient) throws Exception {
    	
    	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.SEVERE); 
    	
    	// final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080);
//    	final WebClient webClient = new WebClient();
        final HtmlPage homePage = webClient.getPage("https://www.americanfunds.com/advisor/");
        
        List <News> newsList = new ArrayList <News>();
        final List<HtmlDivision> teaserListing = homePage.getByXPath("//div[@class='ns-news-teaser standard  ']/h3[text()='News']/../div[@class='teaser-listing']");
        for (final HtmlDivision teaser : teaserListing) {
        	DomText teaserHeader = teaser.getFirstByXPath("p/a/text()");
        	DomText teaserDate = teaser.getFirstByXPath("p[2]/span/text()");
        	
        	System.out.println(teaserHeader.asText());
        	System.out.println(teaserDate.getNodeValue());
        	
        	News news = new News();
        	news.teaserHeader = teaserHeader.asText();
        	String tempDateStr = teaserDate.getNodeValue();
        	if (tempDateStr.contains("/")) {
        		news.teaserDate = dateFormatterShort.parse(tempDateStr);
        	} else {
        		tempDateStr = tempDateStr.replaceAll("PDT", "");
            	tempDateStr = tempDateStr.replaceAll("PST", "");
            	news.teaserDate = dateFormatter.parse(tempDateStr);
        	}      
        	
        	news.teaserDateString = dateFormatterLong.format(news.teaserDate);
        	newsList.add(news);
        }
        
        return newsList;
    }

    
    public static int getAccumulation (int age, int retirementAge) {
    	int accumulationPeriod = retirementAge - age;
    	int retValue = 0;
    		if (accumulationPeriod > 20) {
    			retValue = 5;
    		} else if (accumulationPeriod > 10) {
    			retValue = 4;
    		} else if (accumulationPeriod > 5) {
    			retValue = 3;
    		} else {
    			retValue = 2;
    		} 
    	return retValue;
    }
   
    public static int getDistribution (int retirementAge) {
    	Hashtable distributionTable = new Hashtable();
    	int retValue = 0;
    	
    	distributionTable.put(16,66.9);
    	distributionTable.put(17,66.0);
    	distributionTable.put(18,65.0);
    	distributionTable.put(19,64.0);
    	distributionTable.put(20,63.0);
    	distributionTable.put(21,62.1);
    	distributionTable.put(22,61.1);
    	distributionTable.put(23,60.1);
    	distributionTable.put(24,59.1);
    	distributionTable.put(25,58.2);
    	distributionTable.put(26,57.2);
    	distributionTable.put(27,56.2);
    	distributionTable.put(28,55.3);
    	distributionTable.put(29,54.3);
    	distributionTable.put(30,53.3);
    	distributionTable.put(31,52.4);
    	distributionTable.put(32,51.4);
    	distributionTable.put(33,50.4);
    	distributionTable.put(34,49.4);
    	distributionTable.put(35,48.5);
    	distributionTable.put(36,47.5);
    	distributionTable.put(37,46.5);
    	distributionTable.put(38,45.6);
    	distributionTable.put(39,44.6);
    	distributionTable.put(40,43.6);
    	distributionTable.put(41,42.7);
    	distributionTable.put(42,41.7);
    	distributionTable.put(43,40.7);
    	distributionTable.put(44,39.8);
    	distributionTable.put(45,38.8);
    	distributionTable.put(46,37.9);
    	distributionTable.put(47,37.0);
    	distributionTable.put(48,36.0);
    	distributionTable.put(49,35.1);
    	distributionTable.put(50,34.2);
    	distributionTable.put(51,33.3);
    	distributionTable.put(52,32.3);
    	distributionTable.put(53,31.4);
    	distributionTable.put(54,30.5);
    	distributionTable.put(55,29.6);
    	distributionTable.put(56,28.7);
    	distributionTable.put(57,27.9);
    	distributionTable.put(58,27.0);
    	distributionTable.put(59,26.1);
    	distributionTable.put(60,25.2);
    	distributionTable.put(61,24.4);
    	distributionTable.put(62,23.5);
    	distributionTable.put(63,22.7);
    	distributionTable.put(64,21.8);
    	distributionTable.put(65,21.0);
    	distributionTable.put(66,20.2);
    	distributionTable.put(67,19.4);
    	distributionTable.put(68,18.6);
    	distributionTable.put(69,17.8);
    	distributionTable.put(70,17.0);
    	distributionTable.put(71,16.3);
    	distributionTable.put(72,15.5);
    	distributionTable.put(73,14.8);
    	distributionTable.put(74,14.1);
    	distributionTable.put(75,13.4);
    	distributionTable.put(76,12.7);
    	distributionTable.put(77,12.1);
    	distributionTable.put(78,11.4);
    	distributionTable.put(79,10.8);
    	distributionTable.put(80,10.2);
    	distributionTable.put(81,9.7);
    	distributionTable.put(82,9.1);
    	distributionTable.put(83,8.6);
    	distributionTable.put(84,8.1);
    	distributionTable.put(85,7.6);
    	distributionTable.put(86,7.1);
    	distributionTable.put(87,6.7);
    	distributionTable.put(88,6.3);
    	distributionTable.put(89,5.9);
    	distributionTable.put(90,5.5);
    	distributionTable.put(91,5.2);
    	distributionTable.put(92,4.9);
    	distributionTable.put(93,4.6);
    	distributionTable.put(94,4.3);
    	distributionTable.put(95,4.1);
    	distributionTable.put(96,3.8);
    	distributionTable.put(97,3.6);
    	distributionTable.put(98,3.4);
    	distributionTable.put(99,3.1);
    	distributionTable.put(100,2.9);
    	distributionTable.put(101,2.7);
    	distributionTable.put(102,2.5);
    	distributionTable.put(103,2.3);
    	distributionTable.put(104,2.1);
    	distributionTable.put(105,1.9);
    	distributionTable.put(106,1.7);
    	distributionTable.put(107,1.5);
    	distributionTable.put(108,1.4);
    	distributionTable.put(109,1.2);
    	distributionTable.put(110,1.1);
    	
    	double distributionPeriod = (Double) distributionTable.get(retirementAge);
    	
    	if (distributionPeriod > 20) {
			retValue = 5;
		} else if (distributionPeriod > 10) {
			retValue = 4;
		} else if (distributionPeriod > 5) {
			retValue = 3;
		} else {
			retValue = 2;
		} 
	return retValue;
    }
    
    public List <FundAllocation> getFundAllocations(WebClient webClient, int age, int retirementAge, String riskTolerance) throws Exception {
    	System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog", "error");
    	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.SEVERE); 
    	List <FundAllocation> retFundAllocations = new ArrayList <FundAllocation>();
    	
    	try {
    		
//    		int age = 50;
//    		int retirementAge = 60;
//    		String riskTolerance = "H";
    		
    		
    		if ("H".equals(riskTolerance)) {
    			riskTolerance = "5";
    		} else if ("M".equals(riskTolerance)) {
    			riskTolerance = "3";
    		} else {
    			riskTolerance = "1";
    		}
    			
    		
        	//webClient = new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080);
            // final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        	final HtmlPage loginPage = webClient.getPage("https://www.americanfunds.com/advisor/login.htm");
//            System.out.print(loginPage.asText());
//            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
            // System.out.print(loginPage.getTitleText());
            
            final HtmlForm loginForm = loginPage.getFormByName("loginForm2");
//            System.out.print(loginForm.asXml());
            
            // final HtmlSubmitInput loginButton = loginForm.getInputByName("doLogin");
            final HtmlButton loginButton = loginForm.getButtonByName("doLogin");
            
            final HtmlHiddenInput useridFieldName = loginForm.getInputByName("useridFieldName");
            // System.out.println("useridFieldName = " + useridFieldName);
            final HtmlTextInput userIdTextField = loginForm.getInputByName(useridFieldName.getValueAttribute());
            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("password");

            // Change the value of the text field
            userIdTextField.setValueAttribute("8726");
            passwordTextField.setValueAttribute("gkbb");

            // Now submit the form by clicking the button and get back the second page.
            final HtmlPage nextPage = loginButton.click();
            // System.out.println("login ? " + nextPage.asText().indexOf("Web3 E. User11, Generic Dealer"));
            // System.out.println(nextPage.asXml());
            
            final HtmlPage timeHorizonPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/time-horizon.htm?start=true");
            
            final DomAttr href = timeHorizonPage.getFirstByXPath("//table[@id='time-grid']/tbody/tr[" + App.getDistribution(retirementAge)+ "]/td[" + App.getAccumulation(age, retirementAge) + "]/a/@href");
//            for (final HtmlTableRow row : timeHorizonPageTable.getRows()) {
//                System.out.println("Found row");
//                for (final HtmlTableCell cell : row.getCells()) {
//                    System.out.println("   Found cell: " + cell.asXml());
//                }
//            }

 
            
            // final HtmlPage timeProcessHorizonPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-time-horizon.htm?accu=3&dist=3&group=3&Next=Next");
            final HtmlPage timeProcessHorizonPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/" + href.getValue() + "&group=3&Next=Next");
          
            final HtmlPage processRiskTolerancePage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-risk-tolerance.htm?risk=" + riskTolerance + "&Next=Next");

            
//            final HtmlForm processRiskToleranceForm = processRiskTolerancePage.getFormByName("fundAllocForm");
//            System.out.print(processRiskToleranceForm.asXml());
            
            final HtmlTable processRiskTolerancePageTable = processRiskTolerancePage.getHtmlElementById("fund-allocation-table");
            
            List <FundAllocation> fundAllocations = new ArrayList <FundAllocation>();
            for (final HtmlTableRow row : processRiskTolerancePageTable.getRows()) {
//                System.out.println("Found row");
                
//                List<HtmlTableCell> cells = row.getCells();
//                FundAllocation fundAllocation = new FundAllocation();
//                fundAllocation.fundName = cells.get(0).asText();
//                fundAllocation.percentage = cells.get(1).asText();
                
                if ("Growth".equals(row.getCells().get(0).asText()) 
                		|| "Growth-and-Income".equals(row.getCells().get(0).asText()) 
                		|| (row.getCells().get(0).asText()).startsWith("Equity-Income")
                		|| "Bond".equals(row.getCells().get(0).asText())) {
                	FundAllocation fundAllocation = new FundAllocation();
                	fundAllocation.fundName = row.getCells().get(0).asText();
                	fundAllocation.percentage = row.getCells().get(1).asText();
                	fundAllocation.percentage = fundAllocation.percentage.substring(0, fundAllocation.percentage.length()-1);
                	fundAllocations.add(fundAllocation);
                } 
//                for (final HtmlTableCell cell : row.getCells()) {
//                    System.out.println("   Found cell: " + cell.asText());
//                    if ("Growth".equals(cell.asText())) {
//                    	objectiveType = cell.asText();
//                    	
//                    } 
//                }
            }
            
//            for (final FundAllocation fundAllocation : fundAllocations) {
//                System.out.println(fundAllocation.fundName + " = " + fundAllocation.percentage);
//            }
//            
//            String processChooseFundURL = "https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-choose-funds.htm?";
//            for (final FundAllocation fundAllocation : fundAllocations) {
//                System.out.println(fundAllocation.fundName + " = " + fundAllocation.percentage);
//                if ("Growth".equals(fundAllocation.fundName)) {
//                	processChooseFundURL += "fundPct_1-2=" + fundAllocation.percentage + "&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=";
//                } else {
//                	processChooseFundURL += "fundPct_1-2=&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=";
//                }
//                
//                if ("Growth-and-Income".equals(fundAllocation.fundName)) {
//                	processChooseFundURL += "&fundPct_2-100=" + fundAllocation.percentage + "&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=";
//                } else {
//                	processChooseFundURL += "&fundPct_2-100=&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=";
//                }
//                
//                if (fundAllocation.fundName.startsWith("Equity-Income")) {
//                	processChooseFundURL += "&fundPct_3-12=" + fundAllocation.percentage + "&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=";
//                } else {
//                	processChooseFundURL += "&fundPct_3-12=20&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=";
//                }
//                
//                if (fundAllocation.fundName.startsWith("Bond")) {
//                	processChooseFundURL += "&fundPct_4-32=" + fundAllocation.percentage + "&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true";
//                } else {
//                	processChooseFundURL += "&fundPct_4-32=&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true";
//                }
//            }
            
//            final HtmlForm fundAllocForm = processRiskTolerancePage.getFormByName("fundAllocForm");
//            System.out.print(fundAllocForm.asXml());
//            
//            for (final FundAllocation fundAllocation : fundAllocations) {
//                System.out.println(fundAllocation.fundName + " = " + fundAllocation.percentage);
//                
//                if ("Growth".equals(fundAllocation.fundName)) {
//                	final HtmlNumberInput fundPct_1_2 = fundAllocForm.getInputByName("fundPct_1-2");
//                	fundPct_1_2.setValueAttribute(fundAllocation.percentage);
//                }
//                
//                if ("Growth-and-Income".equals(fundAllocation.fundName)) {
//                	final HtmlNumberInput fundPct_2_100 = fundAllocForm.getInputByName("fundPct_2-100");
//                	fundPct_2_100.setValueAttribute(fundAllocation.percentage);
//                }
//                
//                if (fundAllocation.fundName.startsWith("Equity-Income")) {
//                	final HtmlNumberInput fundPct_3_12 = fundAllocForm.getInputByName("fundPct_3-12");
//                	fundPct_3_12.setValueAttribute(fundAllocation.percentage);
//                }
//                
//                if (fundAllocation.fundName.startsWith("Bond")) {
//                	final HtmlNumberInput fundPct_4_32 = fundAllocForm.getInputByName("fundPct_4-32");
//                	fundPct_4_32.setValueAttribute(fundAllocation.percentage);
//                }
//            }
            
//            final HtmlSubmitInput nextButton = fundAllocForm.getInputByName("Next");
//            final HtmlPage processChooseFundsPage = nextButton.click();
            
            String processChooseFundURL = "https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-choose-funds.htm?";
        	
        	String fundPercentageGrowth = "";
        	String fundPercentageGrowthIncome = "";
        	String fundPercentageEquityIncome = "";
        	String fundPercentageBond = "";
        	
        	for (final FundAllocation fundAllocation : fundAllocations) {
        		if ("Growth".equals(fundAllocation.fundName)) {
        			fundPercentageGrowth = fundAllocation.percentage;
        		}
        	}
        	
        	for (final FundAllocation fundAllocation : fundAllocations) {
        		if ("Growth-and-Income".equals(fundAllocation.fundName)) {
        			fundPercentageGrowthIncome = fundAllocation.percentage;
        		}
        	}
        	
        	for (final FundAllocation fundAllocation : fundAllocations) {
        		if (fundAllocation.fundName.startsWith("Equity-Income")) {
        			fundPercentageEquityIncome = fundAllocation.percentage;
        		}
        	}
        	
        	for (final FundAllocation fundAllocation : fundAllocations) {
        		if ("Bond".equals(fundAllocation.fundName)) {
        			fundPercentageBond = fundAllocation.percentage;
        		}
        	}
        	
        	processChooseFundURL += "fundPct_1-2=" + fundPercentageGrowth + "&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=";
        	processChooseFundURL += "&fundPct_2-100=" + fundPercentageGrowthIncome + "&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=";
        	processChooseFundURL += "&fundPct_3-12=" + fundPercentageEquityIncome + "&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=";
        	processChooseFundURL += "&fundPct_4-32=" + fundPercentageBond + "&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true";
        	
//             final HtmlPage processChooseFundsPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-choose-funds.htm?fundPct_1-2=15&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=&fundPct_2-100=25&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=&fundPct_3-12=20&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=&fundPct_4-32=40&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true");
            final HtmlPage processChooseFundsPage = webClient.getPage(processChooseFundURL);
            System.out.print("\n\n\n****************\n");
            final HtmlTable processChooseFundsTable = processChooseFundsPage.getHtmlElementById("fund-allocation-table");
            
            final List<HtmlTableBody> tbodylist = processChooseFundsPage.getByXPath("//table[@id='fund-allocation-table']/tbody");
            
  		  for (final HtmlTableBody tbody : tbodylist) {
  			  
//            	System.out.println(String.format("fund body: [%s]", tbody.asXml()));
              DomText fundName = tbody.getFirstByXPath("tr[2]/th/a/text()");
              DomText fundPercent = tbody.getFirstByXPath("tr[2]/td/text()");
              // System.out.println(String.format("fund [%s], pct [%s]", fundName, fundPercent));
              if (fundName != null) {
  	            FundAllocation fundAllocation = new FundAllocation();
  	            fundAllocation.fundName = fundName.asText();
  	            fundAllocation.fundName = fundAllocation.fundName.substring(0, fundAllocation.fundName.length()-1);
  	            fundAllocation.percentage = fundPercent.asText();
  	            fundAllocation.percentage = fundAllocation.percentage.substring(0, fundAllocation.percentage.length()-1);
  	          retFundAllocations.add(fundAllocation);
              }
  		  }
  		  
//  		for (FundAllocation fundAllocation : retFundAllocations) {
//			  System.out.println(fundAllocation);
//		  }
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    	return retFundAllocations;
    }
}
