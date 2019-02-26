package framework_RobertHalf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonframework.Browser;
import commonframework.PageBase;

public class RobertHalfWorkWithUsPage extends PageBase 
{

    private Browser _browser;
    public RobertHalfWorkWithUsPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.LINK_TEXT, using = "Work With Us")
    private WebElement rhWorkWithUs;
    
    public void GoToRhWorkWithUs() throws Exception {
    	rhWorkWithUs.click();
    }
//
//    @FindBy(how = How.LINK_TEXT, using = "Employers")
//    private WebElement rhEmployers;
//   
//    @FindBy(how = How.LINK_TEXT, using = "Request Talent")
//    private WebElement rhRequestTalent;
//    
//    @FindBy(how = How.LINK_TEXT, using = "Search Candidates")
//    private WebElement rhSearchCandidates;
//    
//    @FindBy(how = How.XPATH, using = "(//a[contains(text(),'Timesheets')])[3]")
//    private WebElement rhTimeSheets;
//
//    
//    public void GoToRhEmployers() throws Exception {
//    	rhEmployers.click();
//    }
//    
//    public void GoToRhRequestTalent() throws Exception {
//    	rhRequestTalent.click();
//    }
//    public void GoToRhSearchCandidates() throws Exception {
//    	rhSearchCandidates.click();
//    }
//    public void GoToRhTimeSheets() throws Exception {
//    	rhTimeSheets.click();
//    }
   
    public void GoToRhWwuAF(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Our Services')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Accounting & Finance')]')]"));
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(rhWorkWithUs).moveToElement(sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void GoToCwTmEngagingTravelersTBS(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Engaging Travelers')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Travel Booking Services')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
