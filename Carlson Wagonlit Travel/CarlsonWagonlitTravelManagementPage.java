package framework_CarsonWagonlit;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import commonframework.Browser;
import commonframework.PageBase;

// the CarlsonWagonlit Travel Management Page
public class CarlsonWagonlitTravelManagementPage extends PageBase {

    private Browser _browser;
    public CarlsonWagonlitTravelManagementPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Travel Management')]")
    private WebElement cwTravelManagement;
    
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Getting started')]")
    private WebElement cwGettingStarted;
    
    // this sets the TRAVEL MANAGEMENT menu screen. I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.
    public void GoToCwTravelManagement(int pTimeout, WebDriver pWebDriver) throws Exception {
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
    	cwTravelManagement.click();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    // display how to get to the sub menu if I wish. - not used at this time
    public void GoToCwTmGettingStarted() throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Getting started')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
    }
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I use the 
    // I will reset to 30 seconds afterwards.
    public void GoToCwTmGettingStartedCTP(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Getting started')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Corporate Travel Policy')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    // display how to get to the sub menu if I wish. - not used at this time
    public void GoToCwTmEngagingTravelers() throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Engaging Travelers')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
    }
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.

    public void GoToCwTmEngagingTravelersTBS(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Engaging Travelers')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Travel Booking Services')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    // I use actions class for the purpose selecting the sub sub menu option using the hovering menu method. I put multiple actions
    // together using the build and I execute (perform) the click command.
    // I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.

    public void GoToCwTmStayingOvernight(int pTimeout, WebDriver pWebDriver) throws Exception {  
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Staying overnight')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void GoToCwTmManagingRisk() throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Managing Risk')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
    }
    public void GoToCwTmManagingRiskTC(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Managing Risk')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Traveler Care')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void GoToCwTmDeliveringTravelROI() throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Delivering Travel ROI')]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
    }

    public void GoToCwTmDeliveringTravelROITR(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Delivering Travel ROI')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Travel Reporting')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public void GoToCwTmDeliveringTravelROIBTS(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Delivering Travel ROI')]"));
		WebElement sub_sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Business Travel Savings')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).moveToElement(sub_sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void GoToCwTmDrivingAction(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//a[contains(text(),'Driving Action')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void GoToCwTmEnergyResourcesMarine(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu =  driver.findElement(By.xpath("//a[contains(text(),'Travel Management')]"));
		WebElement sub_menu = driver.findElement(By.xpath("//nav[@id='main_nav']/div/div/ul/li/div/ul/li[7]/a"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
