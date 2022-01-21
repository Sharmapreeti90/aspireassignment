package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BrowserManager {

    public static WebDriver getDriver(String type, String url){
        WebDriver driver = null;
        if(type.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/divyeshsharma/Downloads/chromedriver");
            driver = new ChromeDriver();
        }
        else if(type.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else{
            Assert.assertTrue(false,"No Browser tyoe found");
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        Reporter.log("Navigated to Browser:" + type + " URL:" + url);
        return driver;
    }
    
}
