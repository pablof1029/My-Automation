package automatedtester.test_CarlsonWagonlitTravel;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import automatedtester.vo.TestResult;
import commonframework.Browser;
import commonframework.Utilities;
import commonframework.WebDriverEnum;
import framework_CarsonWagonlit.CarlsonWagonlitMainPage;
import framework_CarsonWagonlit.CarlsonWagonlitMeetingEventsPage;
import framework_CarsonWagonlit.CarlsonWagonlitTravelManagementPage;
import framework_CarsonWagonlit.Pages;
import commontest.TestBase;
import commontest.TextLogger;
//import commontest.Validation;

public class CarlsonWagonlitTravelTests extends TestBase
{
    public CarlsonWagonlitTravelTests(int pTestRun, Browser pExistingBrowser) throws Exception {
        Initialize(pTestRun, pExistingBrowser);
    }
    public CarlsonWagonlitTravelTests(String pStartingURI, WebDriverEnum pWebDriverType, Boolean pRunRemotely) throws Exception {
        Initialize(pStartingURI, pWebDriverType, pRunRemotely);
    }
    
    public TestResult CarlsonWagonlitTravelMainTests() throws Exception
    {
    	// start logging information to the mySQL DB
    	TextLogger.Log("MainMenuTest:CanLogin started");
    	
    	TestResult tr = initializeTestResult(getTestName());
    	// if I was using parameters in this test I would extract them from a mySql DB I have setup.
    	// normally the website would always be in a parameters
//    	Map<String, TestParameter> params = getTestParameters(getTestRunID(), tr.getId());

        try {
        	// main page. It has the main menu options 
        	// TRAVEL MANAGEMENT || MEETINGS & EVENTS || TRAVEL CONSULTING || WHY CWT  || NEWS || CONTACT
        	CarlsonWagonlitMainPage carlsonWagonlitMainPage = Pages.CarlsonWagonlitMain(getBrowser());
        	// website to be tested - smoke test.
        	carlsonWagonlitMainPage.GoToLoginPage("http://www.carlsonwagonlit.com/ ");
        	//I will be using javascripting for scrolling
        	JavascriptExecutor jse = (JavascriptExecutor)getBrowser().getDriver();
        	
        	// testing to see if their cookies policy is up. If yes, view it and accept. Scroll up and down to view. 
        	int returnCode = carlsonWagonlitMainPage.TestCwViewPolicy();
        	if (returnCode == 1) {
        		carlsonWagonlitMainPage.GoToCwViewPolicy();
        		Thread.sleep(5000);
        		carlsonWagonlitMainPage.GoToCwAgree();
        		Thread.sleep(5000);
            	jse.executeScript("scroll(0, 250);");
        		Thread.sleep(5000);
            	jse.executeScript("scroll(0, -250);");
        		Thread.sleep(5000);
        	}
        	// Selecting the TRAVEL MANAGEMENT menu option. Normally this option would only be in the main page but since they're
        	// using hoving menu/sub menu/sub sub menu sytem I've included it in the TRAVEL MANAGEMENT page also. 
        	// setting -1 for pageLoadTimeout. I'm not timing the page at this time. I just want it to load.
        	// I had to really slow down this website test.

        	int maxRunTime = -1;
        	CarlsonWagonlitTravelManagementPage carlsonWagonlitTravelManagementPage = Pages.CarlsonWagonlitTravelManagement(getBrowser());
        	carlsonWagonlitTravelManagementPage.GoToCwTravelManagement(maxRunTime, getBrowser().getDriver());
    		Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmGettingStartedCTP(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
          	carlsonWagonlitTravelManagementPage.GoToCwTmEngagingTravelersTBS(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmStayingOvernight(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmManagingRiskTC(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmDeliveringTravelROITR(maxRunTime, getBrowser().getDriver());
       	 	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmDeliveringTravelROIBTS(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmDrivingAction(maxRunTime, getBrowser().getDriver());
        	Thread.sleep(5000);
        	carlsonWagonlitTravelManagementPage.GoToCwTmEnergyResourcesMarine(maxRunTime, getBrowser().getDriver());
       	 	Thread.sleep(5000);        	
       	 	
       	 	// now loading the MEETINGS & EVENTS page
        	CarlsonWagonlitMeetingEventsPage carlsonWagonlitMeetingEventsPage = Pages.CarlsonWagonlitMeetingEvents(getBrowser());
        	carlsonWagonlitMeetingEventsPage.GoToCwMeetingsEvents(maxRunTime, getBrowser().getDriver());
    		Thread.sleep(5000);
    		// Clicking on the FIND OUT MORE button 
    		// this button opens a new window. I will check for additional 
    		// widows and load them to an array if I find them
    		carlsonWagonlitMeetingEventsPage.GoToCwFindOutMore();
    		Thread.sleep(5000);
        	List<String> browserTabs = null;
    		int maxAttempts = 0;
			while (returnCode != 3 && maxAttempts < 5) {
				browserTabs = new ArrayList<String> (_browser.getDriver().getWindowHandles());
				returnCode = browserTabs.size();
				maxAttempts++;
	        }
			// If I find an extra window, switch to that window, click an options then 
			// close the that window and return to the original wind and proceed. 
			if (returnCode > 1) {
				_browser.getDriver().switchTo().window(browserTabs .get(1));
				carlsonWagonlitMeetingEventsPage.GoToCwExploreTheExperience();
	    		Thread.sleep(5000);
	        	carlsonWagonlitMeetingEventsPage.GoToCwExploreTheExperienceEvent(maxRunTime, getBrowser().getDriver());
	    		Thread.sleep(5000);
	    		_browser.getDriver().close();
	    		_browser.getDriver().switchTo().window(browserTabs .get(0));
			}
    		getBrowser().getDriver().switchTo().defaultContent();
    		_browser.getDriver().close();
	        // close the window, write the status to the mySQL DB and move on
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

