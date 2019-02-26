package framework_RobertHalf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import commonframework.Browser;
import commonframework.PageBase;
import commonframework.Utilities;



public class RobertHalfEmployersPage extends PageBase 
{

    private Browser _browser;
    public RobertHalfEmployersPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.LINK_TEXT, using = "Employers")
    private WebElement rhEmployers;
   
    @FindBy(how = How.LINK_TEXT, using = "Request Talent")
    private WebElement rhRequestTalent;
    
    @FindBy(how = How.LINK_TEXT, using = "Search Candidates")
    private WebElement rhSearchCandidates;
    
    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'Timesheets')])[3]")
    private WebElement rhTimeSheets;

    @FindBy(how = How.XPATH, using = "//div[@id='edit-specialized-service-container']/fieldset/div/div/i")
    private WebElement rhJobFunction;
    
    @FindBy(how = How.XPATH, using = "//div[@id='edit-specialized-service-container']/fieldset/div/div/i[2]")
    private WebElement rhRetypeJobFunction;
    
    @FindBy(how = How.XPATH, using = "//div[@id='edit-request-type-container']/fieldset/div/div/i")
    private WebElement rhPositionType;

    @FindBy(how = How.XPATH, using = "//div[@id='edit-request-type-container']/fieldset/div/ul/li[2]")
    private WebElement rhSelectPositionType;

    @FindBy(how = How.ID, using = "rh-job-order__position")
    private WebElement rhJobOrderPosition;

    
    @FindBy(how = How.ID, using = "rh-job-order__zip")
    private WebElement rhJobOrderZip;

    @FindBy(how = How.ID, using = "rh-job-order__comments")
    private WebElement rhJobOrderComments;

    
    public void GoToRhRequestTalent() throws Exception {
    	rhRequestTalent.click();
    }
    public void GoToRhSearchCandidates() throws Exception {
    	rhSearchCandidates.click();
    }
    public void GoToRhTimeSheets() throws Exception {
    	rhTimeSheets.click();
    }

    public void ClickRhJobFunction() throws Exception {
    	rhJobFunction.click();
    }

    public void ClickRhPositionType() throws Exception {
    	rhPositionType.click();
    }

    public void ClickRhSelectPositionType() throws Exception {
    	rhSelectPositionType.click();
    }
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.

    public void GoToRhRequestTalent(int pTimeout, WebDriver pWebDriver) throws Exception {
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(rhEmployers).moveToElement(rhRequestTalent).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    // get the row count
    public int GetSelectJobFunctionCount() throws Exception {
    	WebElement wTempElement = driver.findElement(By.id("rh-job-order__specialization"));
    	Select myDropDown=new Select(wTempElement);
    	List<WebElement> rowList = myDropDown.getOptions();
    	return rowList.size();
    }
    // using the row count to go through the drop down
    public void SelectJobFunction(int pTract) throws Exception {
    	if (pTract != 2) {
    		rhRetypeJobFunction.click();	
    	}
    	String ddPath = "//div[@id='edit-specialized-service-container']/fieldset/div/ul/li[" + pTract + "]";
    	WebElement wTempElement = driver.findElement(By.xpath(ddPath));
    	wTempElement.click();
    }

    //  entering data using sendkeys
    public void EnterDate() throws Exception {
        Utilities.sendKeys(rhJobOrderPosition, "Aitomation Master");
        Utilities.sendKeys(rhJobOrderZip, "78214");
        Utilities.sendKeys(rhJobOrderComments, "I can automate. Will pause for you to read.");
    }
    
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.
    public void GoToRhSearchCandidates(int pTimeout, WebDriver pWebDriver) throws Exception {
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(rhEmployers).moveToElement(rhSearchCandidates).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.
    public void GoToRhTimeSheets(int pTimeout, WebDriver pWebDriver) throws Exception {
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(rhEmployers).moveToElement(rhTimeSheets).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
