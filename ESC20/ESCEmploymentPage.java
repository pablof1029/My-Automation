package framework_ESC20;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import commonframework.Browser;
import commonframework.PageBase;
import commonframework.Utilities;



public class ESCEmploymentPage extends PageBase 
{

    private Browser _browser;
    public ESCEmploymentPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.XPATH, using = "//div[@id='ContentPlaceHolder3_ContentRepeater3_ctl00_2_ContentRepeater1_2_WidgetBox_0']/div/div[2]/div/a/span")
    private WebElement escExternalApplicants;
    
    @FindBy(how = How.XPATH, using = "//div[@id='edit-specialized-service-container']/fieldset/div/div/i")
    private WebElement escJobFunction;
    
    @FindBy(how = How.XPATH, using = "//div[@id='edit-specialized-service-container']/fieldset/div/div/i[2]")
    private WebElement escRetypeJobFunction;
    
    @FindBy(how = How.XPATH, using = "//div[@id='edit-request-type-container']/fieldset/div/div/i")
    private WebElement escPositionType;

    @FindBy(how = How.XPATH, using = "//div[@id='edit-request-type-container']/fieldset/div/ul/li[2]")
    private WebElement escSelectPositionType;

    @FindBy(how = How.ID, using = "esc-job-order__position")
    private WebElement escJobOrderPosition;

    
    @FindBy(how = How.ID, using = "esc-job-order__zip")
    private WebElement escJobOrderZip;

    @FindBy(how = How.ID, using = "esc-job-order__comments")
    private WebElement escJobOrderComments;

    
    public void GoToEscExternalApplicants() throws Exception {
    	escExternalApplicants.click();
    }

  @FindBy(how = How.ID, using = "IRC_EXT_SITE_VISITOR_HOME_SUB")
  private WebElement escHomeTab;
 
  @FindBy(how = How.ID, using = "newEmail")
  private WebElement escNewEmail;
  
  @FindBy(how = How.ID, using = "NationalIdentifier")
  private WebElement escNationalIdentifier;
    
  @FindBy(how = How.ID, using = "IRC_EXT_SITE_VISITOR_JOBS_SUB")
  private WebElement escJobTab;
   
  @FindBy(how = How.ID, using = "Keywords")
  private WebElement escKeywords;
  
  @FindBy(how = How.ID, using = "VisAdvancedSearchBtn")
  private WebElement escVisAdvancedSearchBtn;
    
    public void ClickEscJobTab() throws Exception {
    	escJobTab.click();
    }

    public void ClickEscHomeTab() throws Exception {
    	escHomeTab.click();
    }

    public void ClickEscVisAdvancedSearchBtn() throws Exception {
    	escVisAdvancedSearchBtn.click();
    }
    // get a count of field of interest
    public int GetSelectProfessionalAreaCodeCount() throws Exception {
    	WebElement wTempElement = driver.findElement(By.id("ProfessionalAreaCode"));
    	Select myDropDown=new Select(wTempElement);
    	List<WebElement> rowList = myDropDown.getOptions();
    	return rowList.size();
    }
  // using the count and a for loop highlight each one
    public void SelectProfessionalAreaCode(int pTract) throws Exception {
    	WebElement wTempElement = driver.findElement(By.id("ProfessionalAreaCode"));
    	Select myDropDown=new Select(wTempElement);
    	myDropDown.selectByIndex(pTract);
    }
    // get a count of the date posted drop down
    public int GetSelectDatePosted2Count() throws Exception {
    	WebElement wTempElement = driver.findElement(By.id("DatePosted2"));
    	Select myDropDown=new Select(wTempElement);
    	List<WebElement> rowList = myDropDown.getOptions();
    	return rowList.size();
    }
    // using the count and a for loop click on each item in the drop down
    public void SelectDatePosted2(int pTract) throws Exception {
    	WebElement wTempElement = driver.findElement(By.id("DatePosted2"));
    	Select myDropDown=new Select(wTempElement);
    	myDropDown.selectByIndex(pTract);
    }
    // enter data using sendkeys
    public void EnterHomeData() throws Exception {
        Utilities.sendKeys(escNewEmail, "MyEmail@esc20.net");
        Utilities.sendKeys(escNationalIdentifier, "123456789");
    }
    // enter data using sendkeys
    public void EnterKeywordsData() throws Exception {
        Utilities.sendKeys(escKeywords, "Automater");
    }

    public int checkForAlternateFrame0() {
        try {
        	_browser.getDriver().switchTo().frame(0);
        	return 0;
        } 
        catch (NoAlertPresentException Ex) {
            return 1;
        }
    }
    // highlight each item in the current vacancies
    public void HightLightCurrentVacancies() throws Exception {
    	WebElement webElementTemp1 = null;
        Actions action = new Actions(driver);
        WebElement currentVacancies = driver.findElement(By.id("report_87473104799396442_catch"));
    	WebElement currentVacancies1 = currentVacancies.findElement(By.tagName("table"));
    	WebElement currentVacancies2 = currentVacancies1.findElement(By.tagName("tbody"));
    	List<WebElement> trRows = currentVacancies2.findElements(By.tagName("tr"));
    	int trRowCount = trRows.size();
    	for (int i = 1; i <  trRowCount; i ++) {
    		webElementTemp1 = trRows.get(i).findElement(By.tagName("td"));
    		action.moveToElement(webElementTemp1).perform();
    	}
    }
    // picking an item in the current vacacies
    public void SelectCurrentVacancies(int pTimeout, WebDriver pWebDriver) throws Exception {
    	WebElement webElementTemp1 = null;
    	WebElement webElementTemp2 = null;
        WebElement currentVacancies = driver.findElement(By.id("report_87473104799396442_catch"));
    	WebElement currentVacancies1 = currentVacancies.findElement(By.tagName("table"));
    	WebElement currentVacancies2 = currentVacancies1.findElement(By.tagName("tbody"));
    	List<WebElement> trRows = currentVacancies2.findElements(By.tagName("tr"));
    	int trRowCount = trRows.size();
    	for (int i = 1; i <  2; i ++) {
    		webElementTemp1 = trRows.get(i).findElement(By.tagName("td"));
    		webElementTemp2 = webElementTemp1.findElement(By.tagName("a"));
        	pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
        	webElementTemp2.click();
        	pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    	}
    }

}
