package framework_CarsonWagonlit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import commonframework.*;

public class CarlsonWagonlitMainPage extends PageBase 
{

    private Browser _browser;
    public CarlsonWagonlitMainPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Travel Management')]")
    private WebElement cwTravelManagement;
    
    @FindBy(how = How.LINK_TEXT, using = "Meetings & Events")
    private WebElement cwMeetingsEvents;
   
    @FindBy(how = How.LINK_TEXT, using = "Travel Consulting")
    private WebElement cwTravelConsulting;
    
    @FindBy(how = How.LINK_TEXT, using = "Why CWT")
    private WebElement cwWhyCWT;
    
    @FindBy(how = How.CSS, using = "a[https://news.carlsonwagonlit.com]")
    private WebElement cwNews;

    @FindBy(how = How.LINK_TEXT, using = "Contact")
    private WebElement cwContact;

    @FindBy(how = How.LINK_TEXT, using = "View Policy")
    private WebElement cwViewPolicy;

    @FindBy(how = How.CLASS_NAME, using = "agree")
    private WebElement cwAgree;

    @FindBy(how = How.XPATH, using = "//img[@alt='Carlson Wagonlit Travel Logo'])[2]")
    private WebElement cwReturnMainPage;

    public void GoToCwTravelManagement() throws Exception {
    	cwTravelManagement.click();
    }
    
    public void GoToCwMeetingsEvents() throws Exception {
    	cwMeetingsEvents.click();
    }
    public void GoToCwTravelConsulting() throws Exception {
    	cwTravelConsulting.click();
    }
    public void GoToCwWhyCWT() throws Exception {
    	cwWhyCWT.click();
    }
    public void GoToCwNews() throws Exception {
    	cwNews.click();
    }
    public void GoToCwContact() throws Exception {
    	cwContact.click();
    }
    public void GoToCwViewPolicy() throws Exception {
    	cwViewPolicy.click();
    }

    public void GoToCwAgree() throws Exception {
    	cwAgree.click();
    }

    public void GoToCwReturnMainPage() throws Exception {
    	cwReturnMainPage.click();
    }
    public int TestCwViewPolicy() throws Exception {
    	try {
    		cwViewPolicy.isDisplayed();	
    		return 1;
    	}
    	catch (Exception err) {
    		return 0;
    		
    	}
    }

}
