package framework_ESC20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commonframework.Browser;
import commonframework.PageBase;



public class ESC20MainPage extends PageBase 
{

    private Browser _browser;
    public ESC20MainPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
    
   
    @FindBy(how = How.ID, using = "ContentPlaceHolder2_ContentRepeater2_ctl00_0_ContentRepeater1_0_ctl00_0_imgImage_0")
    private WebElement escHome;

    @FindBy(how = How.LINK_TEXT, using = "About Us")
    private WebElement escAboutUs;
    
    @FindBy(how = How.LINK_TEXT, using = "Administrative & Instructional Services")
    private WebElement escAdministrativeInstructionalServices;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ContentPlaceHolder1_ContentRepeater1_ctl00_0_megamenu_0']/ul/li[3]/span")
    private WebElement escBusinessTechnologyServices;
    
    @FindBy(how = How.LINK_TEXT, using = "Superintendent Resources")
    private WebElement escSuperintendentResources;
    
    @FindBy(how = How.XPATH, using = "//div[@id='ContentPlaceHolder1_ContentRepeater1_ctl00_0_megamenu_0']/ul/li[5]/span")
    private WebElement escQuicklinks;

    @FindBy(how = How.XPATH, using = "//img[@alt='Employment Button']")
    private WebElement escEmploymentButton;

    
    public void GoToEscHome() throws Exception {
    	escHome.click();
    }

    public void GoToEscAboutUs() throws Exception {
    	escAboutUs.click();
    }
    
    public void GoToEscAdministrativeInstructionalServices() throws Exception {
    	escAdministrativeInstructionalServices.click();
    }
    
    public void GoToEscBusinessTechnologyServices() throws Exception {
    	escBusinessTechnologyServices.click();
    }
    
    public void GoToEscSuperintendentResources() throws Exception {
    	escSuperintendentResources.click();
    }
    
    public void GoToEscQuicklinks() throws Exception {
    	escQuicklinks.click();
    }
    
    
    public void GoToEscEmploymentButton() throws Exception {
    	escEmploymentButton.click();
    }
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s1")
    private WebElement escImage1;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s2")
    private WebElement escImage2;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s3")
    private WebElement escImage3;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s4")
    private WebElement escImage4;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s5")
    private WebElement escImage5;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s6")
    private WebElement escImage6;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s7")
    private WebElement escImage7;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s8")
    private WebElement escImage8;
    
    @FindBy(how = How.CLASS_NAME, using = "callbacks1_s9")
    private WebElement escImage9;
    
    public void GoToEscImage1() throws Exception {
    	escImage1.click();
    }

    public void GoToEscImage2() throws Exception {
    	escImage2.click();
    }

    public void GoToEscImage3() throws Exception {
    	escImage3.click();
    }

    public void GoToEscImage4() throws Exception {
    	escImage4.click();
    }

    public void GoToEscImage5() throws Exception {
    	escImage5.click();
    }

    public void GoToEscImage6() throws Exception {
    	escImage6.click();
    }

    public void GoToEscImage7() throws Exception {
    	escImage7.click();
    }

    public void GoToEscImage8() throws Exception {
    	escImage8.click();
    }

    public void GoToEscImage9() throws Exception {
    	escImage9.click();
    }

    
    public void HoverEscAll() throws Exception {
        Actions action = new Actions(driver);
        action.moveToElement(escAboutUs).perform();
        Thread.sleep(500);
        action.moveToElement(escAdministrativeInstructionalServices).perform();
        Thread.sleep(500);
        action.moveToElement(escBusinessTechnologyServices).perform();
        Thread.sleep(500);
        action.moveToElement(escSuperintendentResources).perform();
        Thread.sleep(500);
        action.moveToElement(escQuicklinks).perform();
        //        action.moveToElement(escEmployer s).moveToElement(escJobSeekers).moveToElement(escWorkWithUs).build().perform();
    }

//    
//    public void GoToescJobSeekers() throws Exception {
//    	escJobSeekers.click();
//    }
//    public void GoToescWorkWithUs() throws Exception {
//    	escWorkWithUs.click();
//    }

}
