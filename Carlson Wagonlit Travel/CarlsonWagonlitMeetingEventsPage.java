package framework_CarsonWagonlit;

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



public class CarlsonWagonlitMeetingEventsPage extends PageBase 
{

    private Browser _browser;
    public CarlsonWagonlitMeetingEventsPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.XPATH, using = "//a[contains(@href, '/meetings-and-events/')]")
    private WebElement cwMeetingsEvents;
    
    @FindBy(how = How.XPATH, using = "//div[@id='searchText']/p[2]/a/span")
    private WebElement cwFindOutMore;
    

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Explore the experience')]")
    private WebElement cwExploreTheExperience;

    @FindBy(how = How.LINK_TEXT, using = "Events")
    private WebElement cwEvents;
    
    public void GoToCwFindOutMore() throws Exception {
    	cwFindOutMore.click();
    }

    public void GoToCwExploreTheExperience() throws Exception {
    	cwExploreTheExperience.click();
    }

    public void GoToCwEvents() throws Exception {
    	cwEvents.click();
    }
    // clicking on Meetings & Events page
    //  I set the pageLoadTimeout to -1. I'm not timing the page I just want it to load.
    // I will reset to 30 seconds afterwards.
    public void GoToCwMeetingsEvents(int pTimeout, WebDriver pWebDriver) throws Exception {
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		cwMeetingsEvents.click();
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
    }
    // clicking on the Explore The Experience Event
    public void GoToCwExploreTheExperienceEvent(int pTimeout, WebDriver pWebDriver) throws Exception {
		WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'Explore the experience')]"));
		WebElement sub_menu =  driver.findElement(By.xpath("//a[contains(text(),'Events')]"));
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(menu).moveToElement(sub_menu).click().build().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
    }


}
