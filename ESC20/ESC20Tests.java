package automatedtester.test_ESC20;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import automatedtester.vo.TestParameter;
import automatedtester.vo.TestResult;
import commonframework.Browser;
import commonframework.Utilities;
import commonframework.WebDriverEnum;
import framework_ESC20.ESC20MainPage;
import framework_ESC20.ESCEmploymentPage;
import framework_ESC20.Pages;
import commontest.TestBase;
import commontest.TextLogger;


public class ESC20Tests extends TestBase
{
    public ESC20Tests(int pTestRun, Browser pExistingBrowser) throws Exception {
        Initialize(pTestRun, pExistingBrowser);
    }
    public ESC20Tests(String pStartingURI, WebDriverEnum pWebDriverType, Boolean pRunRemotely) throws Exception {
        Initialize(pStartingURI, pWebDriverType, pRunRemotely);
    }
    
    public TestResult ESC20MainTests() throws Exception
    {
    	// start logging information to the mySQL DB
    	TextLogger.Log("MainMenuTest:CanLogin started");
    	
    	TestResult tr = initializeTestResult(getTestName());
    	// if I was using parameters in this test I would extract them from a mySql DB I have setup.
    	// normally the website would always be in a parameters
//    	Map<String, TestParameter> params = getTestParameters(getTestRunID(), tr.getId());

        try {
        	// loading the main page
        	ESC20MainPage eSC20MainPage = Pages.ESC20Main(getBrowser());
        	// loading the website. I would normally put this in my parameter
        	// table in mySQL DB
        	eSC20MainPage.GoToLoginPage("http://www.ESC20.net/");
        	// I am going through and clicking on the different images.
        	// Since the amount of images changes I would probably in a for loop
        	// I put a little pause in between images
        	eSC20MainPage.GoToEscImage2();
        	Thread.sleep(1000);
        	eSC20MainPage.GoToEscImage4();
        	Thread.sleep(1000);
        	eSC20MainPage.GoToEscImage6();
        	Thread.sleep(1000);
//        	eSC20MainPage.GoToEscImage8();
//        	Thread.sleep(1000);
        	eSC20MainPage.GoToEscImage3();
        	Thread.sleep(1000);
        	eSC20MainPage.GoToEscImage5();
        	Thread.sleep(1000);
//        	eSC20MainPage.GoToEscImage7();
//        	Thread.sleep(1000);
//        	eSC20MainPage.GoToEscImage9();
//        	Thread.sleep(1000);
        	eSC20MainPage.GoToEscImage1();
        	Thread.sleep(1000);
        	// I hover over the upper menu option to display the drop down sub menu. Just for display.
        	eSC20MainPage.HoverEscAll();
        	// to make sure the upper menu sub menu is no longer displaying I click the home button.
        	eSC20MainPage.GoToEscHome();
        	Thread.sleep(1000);
        	// load JavascriptExecutor interface because I plan to use Javascript 
        	// to page down
        	JavascriptExecutor jse = (JavascriptExecutor)getBrowser().getDriver();
        	jse.executeScript("scroll(0, 250);");
        	// once I page down I click the Employment button
        	eSC20MainPage.GoToEscEmploymentButton();
        	// I now load the employment page
        	ESCEmploymentPage eSCEmploymentPage = Pages.ESCEmployment(getBrowser());
        	// I select the external applicants link
        	eSCEmploymentPage.GoToEscExternalApplicants();
        	// the current vacancies are actually in a frame. I first check
        	// to see if a frame exist. If I find a frame I highlight each one ( just to show I can)
        	// and then I select one
            int returnCode = eSCEmploymentPage.checkForAlternateFrame0();
            if (returnCode == 0) {
	            eSCEmploymentPage.HightLightCurrentVacancies();
	            eSCEmploymentPage.SelectCurrentVacancies(-1, getBrowser().getDriver());
            }
            Thread.sleep(2000);
            // Selecting a current vacancy will open a new window.
            // I will first find and load my new window into an array
        	List<String> browserTabs = null;
    		int maxAttempts = 0;
			while (returnCode != 3 && maxAttempts < 5) {
				browserTabs = new ArrayList<String> (_browser.getDriver().getWindowHandles());
				returnCode = browserTabs.size();
				maxAttempts++;
	        }
			if (returnCode > 1) {
				// I will switch to the new window and scroll up and down
				_browser.getDriver().switchTo().window(browserTabs .get(1));
				jse.executeScript("scroll(0, 250);");
				Thread.sleep(1000);
				jse.executeScript("scroll(0, -250);");
				Thread.sleep(1000);
				// I will select the "Home" tab
				eSCEmploymentPage.ClickEscHomeTab();
				// I will enter an email address and a ssn (both fake)
				eSCEmploymentPage.EnterHomeData();
				Thread.sleep(1000);
				// I will select the "Jobs" tab. Since I have unsaved data
				// I will get an alert warning. I will test for this warning and 
				// then accept the warning. This will allow me to move on to the Jobs tab
				eSCEmploymentPage.ClickEscJobTab();
	            returnCode = checkForAltert();
	            if (returnCode == 0) {
	        		getBrowser().getDriver().switchTo().alert().accept();
	        		getBrowser().getDriver().switchTo().defaultContent();
	            }
				// enter keyword
	            eSCEmploymentPage.EnterKeywordsData();
	            // get a count of all the field of interest
	    		int rowCount = eSCEmploymentPage.GetSelectProfessionalAreaCodeCount();
	    		// highlight all the field of interest
		        for (int tNbr = 0; tNbr < rowCount; tNbr++) {
		        	eSCEmploymentPage.SelectProfessionalAreaCode(tNbr);
		        	Thread.sleep(1000);
			    }
		        // get a count on the date posted drop down
	    		rowCount = eSCEmploymentPage.GetSelectDatePosted2Count();
	    		// click on all the items in the date posted drop down
		        for (int tNbr = 0; tNbr < rowCount; tNbr++) {
		        	eSCEmploymentPage.SelectDatePosted2(tNbr);
		        	Thread.sleep(1000);
			    }
		        // click on the advanced search button
		        eSCEmploymentPage.ClickEscVisAdvancedSearchBtn();
		        // enter all the data again
				eSCEmploymentPage.EnterKeywordsData();
	    		rowCount = eSCEmploymentPage.GetSelectProfessionalAreaCodeCount();
		        for (int tNbr = 0; tNbr < rowCount; tNbr++) {
		        	eSCEmploymentPage.SelectProfessionalAreaCode(tNbr);
		        	Thread.sleep(1000);
			    }

	    		rowCount = eSCEmploymentPage.GetSelectDatePosted2Count();
		        for (int tNbr = 0; tNbr < rowCount; tNbr++) {
		        	eSCEmploymentPage.SelectDatePosted2(tNbr);
		        	Thread.sleep(1000);
			    }
		        Thread.sleep(1000);
		        // close the employment window
	    		_browser.getDriver().close();
			}
			// get back to main window and close up
    		_browser.getDriver().switchTo().window(browserTabs .get(0));
    		getBrowser().getDriver().switchTo().defaultContent();
    		eSC20MainPage.GoToEscHome();
    		Thread.sleep(1000);
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

    private int checkForAltert() {
	    try {
	    	_browser.getDriver().switchTo().alert();
	    	return 0;
	    } 
	    catch (NoAlertPresentException Ex) {
	        return 1;
	    } 
    }
}    

