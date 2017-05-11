package com.capgroup.googhome.virtualwholesaler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    @org.junit.Test
    public void testApp() throws Exception
    {
    	App app = new App();
    	List<FundAllocation> allocations = app.getFundAllocations(new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080),50, 60, "medium");
    	assertTrue( allocations.size() > 0 );
    	System.out.println(allocations);
    }
    
    public void testURL() {
    	
    	List <FundAllocation> fundAllocations = new ArrayList <FundAllocation>();
    	FundAllocation fundAllocation1 = new FundAllocation();
    	fundAllocation1.fundName = "Growth";
    	fundAllocation1.percentage = "15";
    	fundAllocations.add(fundAllocation1);
    	fundAllocation1 = new FundAllocation();
    	fundAllocation1.fundName = "Growth-and-Income";
    	fundAllocation1.percentage = "25";
    	fundAllocations.add(fundAllocation1);
    	fundAllocation1 = new FundAllocation();
    	fundAllocation1.fundName = "Equity-Income/Balanced";
    	fundAllocation1.percentage = "20";
    	fundAllocations.add(fundAllocation1);
    	fundAllocation1 = new FundAllocation();
    	fundAllocation1.fundName = "Bond";
    	fundAllocation1.percentage = "40";
    	fundAllocations.add(fundAllocation1);
    	
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
        
        System.out.println(processChooseFundURL);
        Assert.assertEquals(processChooseFundURL, "https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-choose-funds.htm?fundPct_1-2=15&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=&fundPct_2-100=25&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=&fundPct_3-12=20&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=&fundPct_4-32=40&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true");
    }
    
    public void testAccumulation () {
    	Assert.assertEquals(4, getAccumulation(49, 65));
    }
    
    private int getAccumulation (int age, int retirementAge) {
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
    
    public void testGetDistribution () {
    	Assert.assertEquals(5, getDistribution(65));
    }
    
    private int getDistribution (int retirementAge) {
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
    
    @org.junit.Test
    public void testDistributions() throws Exception {
    	final WebClient webClient = new WebClient();
        final HtmlPage processChooseFundsPage = webClient.getPage("file:///users/ayh/desktop/pr-tool.html");
        final List<HtmlTableBody> tbodylist = processChooseFundsPage.getByXPath("//table[@id='fund-allocation-table']/tbody");
        
        List <FundAllocation> fundAllocations = new ArrayList <FundAllocation>();
        
		  for (final HtmlTableBody tbody : tbodylist) {
			  
//          	System.out.println(String.format("fund body: [%s]", tbody.asXml()));
            DomText fundName = tbody.getFirstByXPath("tr[2]/th/a/text()");
            DomText fundPercent = tbody.getFirstByXPath("tr[2]/td/text()");
            System.out.println(String.format("fund [%s], pct [%s]", fundName, fundPercent));
            if (fundName != null) {
	            FundAllocation fundAllocation = new FundAllocation();
	            fundAllocation.fundName = fundName.asText();
	            fundAllocation.fundName = fundAllocation.fundName.substring(0, fundAllocation.fundName.length()-1);
	            fundAllocation.percentage = fundPercent.asText();
	            fundAllocation.percentage = fundAllocation.percentage.substring(0, fundAllocation.percentage.length()-1);
	            fundAllocations.add(fundAllocation);
            }
		  }
		  for (FundAllocation fundAllocation : fundAllocations) {
			  System.out.println(fundAllocation);
		  }
    }
    
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yy");
    
    @org.junit.Test
    public void testNews() throws Exception {
    	App app = new App();
    	List <News> newsList = app.getNews(new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080));
    	Assert.assertTrue(newsList.size() > 0);
    	System.out.println(newsList);
    }
    
    public void testHomePage() throws Exception {
    	App app = new App();
    	List <FundAllocation> fundAllocations = app.getFundAllocations(new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080), 40, 65, "M");
    	Assert.assertTrue(fundAllocations.size() > 0);
    	System.out.println(fundAllocations);
    }
}
