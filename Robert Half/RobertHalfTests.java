package automatedtester.test_RobertHalf;

import org.openqa.selenium.JavascriptExecutor;
import automatedtester.vo.TestParameter;
import automatedtester.vo.TestResult;
import commonframework.Browser;
import commonframework.Utilities;
import commonframework.WebDriverEnum;
import framework_RobertHalf.Pages;
import framework_RobertHalf.RobertHalfEmployersPage;
import framework_RobertHalf.RobertHalfMainPage;
import commontest.TestBase;
import commontest.TextLogger;
import commontest.Validation;


public class RobertHalfTests extends TestBase
{
    public RobertHalfTests(int pTestRun, Browser pExistingBrowser) throws Exception {
        Initialize(pTestRun, pExistingBrowser);
    }
    public RobertHalfTests(String pStartingURI, WebDriverEnum pWebDriverType, Boolean pRunRemotely) throws Exception {
        Initialize(pStartingURI, pWebDriverType, pRunRemotely);
    }
    
    
    public TestResult RobertHalfMainTests() throws Exception
    {
    	// start logging information to the mySQL DB
    	TextLogger.Log("MainMenuTest:CanLogin started");
    	
    	TestResult tr = initializeTestResult(getTestName());
    	// if I was using parameters in this test I would extract them from a mySql DB I have setup.
    	// normally the website would always be in a parameters
//    	Map<String, TestParameter> params = getTestParameters(getTestRunID(), tr.getId());

        try {
        	// loading the main page
        	RobertHalfMainPage robertHalfMainPage = Pages.RobertHalfMain(getBrowser());
        	// loading the website. I would normally put this in my parameter
        	// table in mySQL DB
        	robertHalfMainPage.GoToLoginPage("http://www.RobertHalf.com/");
        	// hovering over the three main menu options
        	robertHalfMainPage.HoverRhAll();
        	// selecting the Employers menu 
        	robertHalfMainPage.GoToRhEmployers();
        	// loading the Employer page
        	RobertHalfEmployersPage robertHalfEmployersPage = Pages.RobertHalfEmployers(getBrowser());
        	int maxRunTime = -1;
        	// selecting the request talent sub menu
        	robertHalfEmployersPage.GoToRhRequestTalent(maxRunTime, getBrowser().getDriver());
        	// get a row count of the job function drop down
	        int rowCount = robertHalfEmployersPage.GetSelectJobFunctionCount();
	        // this drop down requires clicking on the drop down first
	        robertHalfEmployersPage.ClickRhJobFunction();
	        // go through the drop down and select all the options
	        for (int tNbr = 2; tNbr <= rowCount; tNbr++) {
	        	robertHalfEmployersPage.SelectJobFunction(tNbr);
	        }
	        // loading the JavascriptExecutor interface to scroll down
        	JavascriptExecutor jse = (JavascriptExecutor)getBrowser().getDriver();
        	jse.executeScript("scroll(0, 250);");
        	// clicking on the position type drop down
        	robertHalfEmployersPage.ClickRhPositionType();
        	// selecting a position type
        	robertHalfEmployersPage.ClickRhSelectPositionType();
        	// entering data
        	robertHalfEmployersPage.EnterDate();
        	Thread.sleep(5000);
        	// clicking the search button
        	robertHalfEmployersPage.GoToRhSearchCandidates(maxRunTime, getBrowser().getDriver());
        	robertHalfEmployersPage.GoToRhRequestTalent(maxRunTime, getBrowser().getDriver());
    		_browser.getDriver().close();
    		// write the status to the mySQL DB
	    if (tr.getFailed() == 0)
	        	tr.setMessage("CanLogin Passed");
        }
        catch (Exception err) {
        	Utilities.setTestResultError(tr, "Error trying to log in.\n\n", err, getBrowser().getDriver(), 2);
        }

        TextLogger.Log("MainMenuTest:CanLogin started - " + tr.getMessage());
        return tr;
    }

}    

