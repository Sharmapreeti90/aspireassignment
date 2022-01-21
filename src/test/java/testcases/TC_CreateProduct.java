package testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.DashboardPageObject;
import pageobjects.InventoryPageObject;
import pageobjects.LoginPageObject;
import pageobjects.ManufacturingPageObject;
import pageobjects.ProductPageObject;
import utils.BrowserManager;
import utils.PropertiesFile;

public class TC_CreateProduct {

    String url = "https://aspireapp.odoo.com/web/login#cids=1&home=";

  
    @Test(description = "Test for creating the product", priority = 2)
    public void clickInventory() {    WebDriver driver = BrowserManager.getDriver("chrome", url);
        LoginPageObject loginPageObject = PageFactory.initElements(driver,LoginPageObject.class);
        loginPageObject.setEmailId(PropertiesFile.getEmailId());
        loginPageObject.setPassword(PropertiesFile.getPassword());
        loginPageObject.clickSubmit();

        DashboardPageObject dashboardPageObject = PageFactory.initElements(driver, DashboardPageObject.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        
        if(dashboardPageObject.isPageOpened())
            dashboardPageObject.clickInventory();
        else
            Assert.fail("Inventory button not working");
        
        InventoryPageObject inventoryPageObject = PageFactory.initElements(driver, InventoryPageObject.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        if(inventoryPageObject.isPageOpened())
            inventoryPageObject.clickProductMenu();
        else
            Assert.fail("Product button click failed");

        inventoryPageObject.clickProductSubMenu();

        ProductPageObject productPageObject= PageFactory.initElements(driver, ProductPageObject.class);

        if(productPageObject.isProductListPageLoaded())
            productPageObject.clickCreateProduct();
        else
            Assert.fail("Product create button click failed");

        productPageObject.enterProductName(PropertiesFile.getProductName());
        productPageObject.clickUpdateQuantity();
        productPageObject.clickCreateQuantity();
        productPageObject.clickLocation();
        productPageObject.enterVirtualLocations();
        productPageObject.enterQuantity();
        productPageObject.clickSaveQuantity();

        inventoryPageObject.clickApplicationMenu();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
        if(dashboardPageObject.isPageOpened())
            dashboardPageObject.clickManufacturing();
        else
            Assert.fail("Manufacturing button not working");

        ManufacturingPageObject manufacturingPageObject = PageFactory.initElements(driver, ManufacturingPageObject.class);
        manufacturingPageObject.clickCreateManufacturingOrder();
        manufacturingPageObject.enterProductSearchText(PropertiesFile.getProductName());
        manufacturingPageObject.addMaterial(PropertiesFile.getProductName());
        manufacturingPageObject.saveManufacturingOrder();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        manufacturingPageObject.clickMarkDone();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));

        if(manufacturingPageObject.isMarkDone()){
            Assert.fail("Error is marking Manufacturing order as done");

        }
        else{
            Assert.assertTrue(true, "Manufacturing done");
        }
    }
}
