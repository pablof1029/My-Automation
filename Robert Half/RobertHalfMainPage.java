package framework_RobertHalf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonframework.Browser;
import commonframework.PageBase;


public class RobertHalfMainPage extends PageBase 
{

    private Browser _browser;
    public RobertHalfMainPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.LINK_TEXT, using = "Employers")
    private WebElement rhEmployers;
   
    @FindBy(how = How.LINK_TEXT, using = "Job Seekers")
    private WebElement rhJobSeekers;
    
    @FindBy(how = How.LINK_TEXT, using = "Work With Us")
    private WebElement rhWorkWithUs;
    
    public void GoToRhEmployers() throws Exception {
    	rhEmployers.click();
    }
    
    public void HoverRhAll() throws Exception {
        Actions action = new Actions(driver);
//        action.moveToElement(rhEmployers).perform();
        action.moveToElement(rhEmployers).moveToElement(rhJobSeekers).moveToElement(rhWorkWithUs).build().perform();
    }

    
    public void GoToRhJobSeekers() throws Exception {
    	rhJobSeekers.click();
    }
    public void GoToRhWorkWithUs() throws Exception {
    	rhWorkWithUs.click();
    }

}
