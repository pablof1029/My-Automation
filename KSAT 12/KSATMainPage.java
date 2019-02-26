package framework_KSAT;

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
import commonframework.Utilities;



public class KSATMainPage extends PageBase 
{

    private Browser _browser;
    public KSATMainPage(Browser pBrowser) {
    	super(pBrowser.getDriver());
    	_browser = pBrowser;
    }
    
    public void GoToLoginPage(String pURL) {
    	_browser.GoTo(pURL);
    }
   
    @FindBy(how = How.XPATH, using = "//img[contains(@src,'https://t.gmg.io/header/logo-ksat.gif')]")
    private WebElement ksatHome;

    @FindBy(how = How.XPATH, using = "//div[@id='carousel-hero']/div[2]/div[2]/div[2]")
    private WebElement ksatFirstScrollArrow;
    
    @FindBy(how = How.XPATH, using = "//div[@id='carousel-hero']/div[2]/div[2]/div[2]/span")
    private WebElement ksatSecondScrollArrow;
  
    @FindBy(how = How.XPATH, using = "//ul[@id='nav_weather']/li/span")
    private WebElement ksatWeather;
    
    @FindBy(how = How.XPATH, using = "//div[@id='article_10154_17332_726956672_1.0']/div/div/wx-widget/div/div[2]/input")
    private WebElement ksatSearchInput;

    @FindBy(how = How.XPATH, using = "//div[@id='article_10154_17332_726956672_1.0']/div/div/wx-widget/div/div[2]/button")
    private WebElement ksatSearchButton;

        @FindBy(how = How.XPATH, using = "//a[contains(text(),'About')]")
    private WebElement ksatAboutLlink;
    
    public void GoToKsatHome() throws Exception {
    	ksatHome.click();
    }

    public void GoToKsatFirstScrollArrow() throws Exception {
    	ksatFirstScrollArrow.click();
    }
    
    public void GoToKsatSecondScrollArrow() throws Exception {
    	ksatSecondScrollArrow.click();
    }
    
    public void CheckSanAntonioWeather() throws Exception {
        Utilities.sendKeys(ksatSearchInput, "San Antonio");
        ksatSearchButton.click();
    }
    
    public void GoToKsatAboutLlink() throws Exception {
    	ksatAboutLlink.click();
    }
    
    public void HighlightTheUpperMenu(int pTimeout, WebDriver pWebDriver) throws Exception {
    	WebElement webElementTemp = null;
    	WebElement webElementTemp1 = null;
    	WebElement webElementTemp2 = null;
    	String value = "";
        Actions action = new Actions(driver);
        WebElement navNews = driver.findElement(By.className("sections"));
    	WebElement navNewsSubMenu = navNews.findElement(By.tagName("ul"));
    	List<WebElement> liRows = navNewsSubMenu.findElements(By.tagName("li"));
    	int trRowCount = liRows.size();
    	for (int i = 0; i <  trRowCount; i ++) {
    		webElementTemp1 = liRows.get(i);
    		value = webElementTemp1.getAttribute("id");
    		if (!value.trim().equalsIgnoreCase("")) {
        		webElementTemp2 = driver.findElement(By.id(value));
        		action.moveToElement(webElementTemp2).perform();
        		Thread.sleep(1000);
    		}
    	}
    }

    public void HighlightTheUpperMenu2(int pTimeout, WebDriver pWebDriver) throws Exception {
    	WebElement webElementTemp = null;
    	WebElement webElementTemp1 = null;
    	WebElement webElementTemp2 = null;
    	String value = "";
        Actions action = new Actions(driver);
        WebElement navNews = driver.findElement(By.className("sections"));
    	WebElement navNewsSubMenu = navNews.findElement(By.className("overflow"));
    	List<WebElement> liRows = navNewsSubMenu.findElements(By.tagName("li"));
    	int trRowCount = liRows.size();
    	for (int i = 0; i <  trRowCount; i ++) {
    		webElementTemp1 = liRows.get(i);
    		value = webElementTemp1.getAttribute("id");
    		if (!value.trim().equalsIgnoreCase("")) {
        		webElementTemp2 = driver.findElement(By.id(value));
        		action.moveToElement(webElementTemp2).perform();
    		}
    	}
    }
    
    public void HighlightNewsMenuCurrentVacancies1(int pTimeout, WebDriver pWebDriver) throws Exception {
    	WebElement webElementTemp = null;
    	WebElement webElementTemp1 = null;
    	WebElement webElementTemp2 = null;
    	String value = "";
        Actions action = new Actions(driver);
        WebElement navNews = driver.findElement(By.id("nav_news"));
    	WebElement navNewsSubMenu = navNews.findElement(By.tagName("ul"));
    	List<WebElement> liRows = navNewsSubMenu.findElements(By.tagName("li"));
    	action.moveToElement(navNews).perform();
    	int trRowCount = liRows.size();
    	for (int i = 0; i <  trRowCount; i ++) {
    		webElementTemp1 = liRows.get(i).findElement(By.tagName("a"));
    		value = webElementTemp1.getAttribute("ga-label");
    		if (value.contains("Traffic")) {
    			webElementTemp2 = liRows.get(i).findElement(By.cssSelector("a[href='/traffic']"));
    			action.moveToElement(webElementTemp2).perform();
    		}
    		action.moveToElement(webElementTemp1).perform();
    	}
    }

  public void GoToKsatWeather(int pTimeout, WebDriver pWebDriver) throws Exception {
		Actions action = new Actions(driver);
		pWebDriver.manage().timeouts().pageLoadTimeout(pTimeout, TimeUnit.SECONDS);
		action.moveToElement(ksatWeather).click().perform();
		pWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

}
