package com.cg;

import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

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
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testHomePage() throws Exception {
        try {
        	final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52, "irvcache", 8080);
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
            Assert.assertEquals("Time-Based Portfolio Planner", timeHorizonPage.getTitleText());
            final HtmlPage timeProcessHorizonPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-time-horizon.htm?accu=3&dist=3&group=3&Next=Next");
            Assert.assertEquals("Time-Based Portfolio Planner", timeProcessHorizonPage.getTitleText());
            final HtmlPage processRiskTolerancePage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-risk-tolerance.htm?risk=3&Next=Next");
            Assert.assertEquals("Time-Based Portfolio Planner", timeProcessHorizonPage.getTitleText());
            
//            final HtmlForm processRiskToleranceForm = processRiskTolerancePage.getFormByName("fundAllocForm");
//            System.out.print(processRiskToleranceForm.asXml());
            
            final HtmlTable processRiskTolerancePageTable = processRiskTolerancePage.getHtmlElementById("fund-allocation-table");
            for (final HtmlTableRow row : processRiskTolerancePageTable.getRows()) {
                System.out.println("Found row");
                for (final HtmlTableCell cell : row.getCells()) {
                    System.out.println("   Found cell: " + cell.asText());
                }
            }
            
            final HtmlPage processChooseFundsPage = webClient.getPage("https://www.americanfunds.com/advisor/tools/planning/portfolio-resources/time-based-portfolio-planner/process-choose-funds.htm?fundPct_1-2=15&fundPct_1-16=&fundPct_1-5=&fundPct_1-14=&fundPct_1-7=&fundPct_1-36=&fundPct_1-35=&fundPct_2-100=25&fundPct_2-3=&fundPct_2-33=&fundPct_2-10=&fundPct_2-34=&fundPct_2-4=&fundPct_2-1=&fundPct_3-12=20&fundPct_3-6=&fundPct_3-11=&fundPct_3-37=&fundPct_4-32=40&fundPct_4-114=&fundPct_4-60=&fundPct_4-42=&fundPct_4-112=&fundPct_4-21=&fundPct_4-8=&fundPct_4-31=&fundPct_4-23=&fundPct_4-48=&fundPct_4-22=&fundPct_4-39=&fundPct_4-41=&fundPct_4-40=&fundPct_4-43=&fundPct_4-19=&fundPct_4-20=&Next=Next&allocateByPercent=true");
            System.out.print("\n\n\n****************\n");
            final HtmlTable processChooseFundsTable = processChooseFundsPage.getHtmlElementById("fund-allocation-table");
            for (final HtmlTableRow row : processChooseFundsTable.getRows()) {
                System.out.println("Found row");
                for (final HtmlTableCell cell : row.getCells()) {
                    System.out.println("   Found cell: " + cell.asText());
                }
            }
            // System.out.print(processChooseFundsPage.getElementById("fund-allocation-table").asXml());
            
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
