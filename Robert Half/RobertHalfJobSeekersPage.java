package framework_RobertHalf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonframework.Browser;
import commonframework.PageBase;



public class RobertHalfJobSeekersPage extends PageBase 
{

    private Browser _browser;
    public RobertHalfJobSeekersPage(Browser pBrowser) {
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

    
    public void GoToRhEmployers() throws Exception {
    	rhEmployers.click();
    }
    
    public void GoToRhRequestTalent() throws Exception {
    	rhRequestTalent.click();
    }
    public void GoToRhSearchCandidates() throws Exception {
    	rhSearchCandidates.click();
    }
    public void GoToRhTimeSheets() throws Exception {
    	rhTimeSheets.click();
    }

}
