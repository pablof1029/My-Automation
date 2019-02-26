package automatedtester.test_KSAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import automatedtester.vo.TestParameter;
import automatedtester.vo.TestResult;
import commonframework.Browser;
import commonframework.Utilities;
import commonframework.WebDriverEnum;
import framework_KSAT.KSATMainPage;
import framework_KSAT.Pages;
import net.tcc.automatedtester.service.TestService;
import commontest.TestBase;
import commontest.TextLogger;
import commontest.Validation;


public class KSATTests extends TestBase
{
    public KSATTests(int pTestRun, Browser pExistingBrowser) throws Exception {
        Initialize(pTestRun, pExistingBrowser);
    }
    public KSATTests(String pStartingURI, WebDriverEnum pWebDriverType, Boolean pRunRemotely) throws Exception {
        Initialize(pStartingURI, pWebDriverType, pRunRemotely);
    }
    
    
    public TestResult KSATMainTests() throws Exception
    {
    	// start logging information to the mySQL DB
    	TextLogger.Log("MainMenuTest:CanLogin started");
    	
    	TestResult tr = initializeTestResult(getTestName());
    	// if I was using parameters in this test I would extract them from a mySql DB I have setup.
    	// normally the website would always be in a parameters
//    	Map<String, TestParameter> params = getTestParameters(getTestRunID(), tr.getId());

        try {
        	// loading the main page
        	KSATMainPage kSATMainPage = Pages.KSATMain(getBrowser());
        	// loading the website. I would normally put this in my parameter
        	// table in mySQL DB
        	// I had to use pageLoadTimeout because it's not the fastest website.
        	// I then reset the pageLoadTimeout to 30 seconds.
        	getBrowser().getDriver().manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
        	kSATMainPage.GoToLoginPage("http://www.KSAT.com/");
        	getBrowser().getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        	Thread.sleep(1000);
        	// scrolling through the images
        	kSATMainPage.GoToKsatFirstScrollArrow();
        	Thread.sleep(1000);
        	kSATMainPage.GoToKsatSecondScrollArrow();
        	Thread.sleep(1000);
        	kSATMainPage.GoToKsatSecondScrollArrow();
        	Thread.sleep(1000);
        	// hover over the upper menu to display their sub menus
        	kSATMainPage.HighlightTheUpperMenu(-1, getBrowser().getDriver());
        	kSATMainPage.HighlightTheUpperMenu2(-1, getBrowser().getDriver());
        	// click the home button to reset the page.
        	kSATMainPage.GoToKsatHome();
        	// load JavascriptExecutor interface because I plan to use Javascript 
        	// to page down
        	JavascriptExecutor jse = (JavascriptExecutor)getBrowser().getDriver();
        	// click on the weather 
        	kSATMainPage.GoToKsatWeather(-1, getBrowser().getDriver());
        	Thread.sleep(1000);
        	jse.executeScript("scroll(0, 250);");
        	// enter san antonio and press search
        	kSATMainPage.CheckSanAntonioWeather();
        	// scroll to the bottom of the page
        	jse.executeScript("scroll(0, document.body.scrollHeight)");
        	// press the about link
        	kSATMainPage.GoToKsatAboutLlink();
        	Thread.sleep(1000);
        	// return to home page and close
        	kSATMainPage.GoToKsatHome();
        	Thread.sleep(1000);
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

