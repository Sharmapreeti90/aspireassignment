package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPageObject {
    WebDriver driver;
    public InventoryPageObject(WebDriver driver){
        this.driver = driver;
    }


    @FindBy(how=How.XPATH, using ="/html/body/header/nav/ul[1]/li[3]/a")
    WebElement menu_product;

    @FindBy(how=How.XPATH, using ="/html/body/header/nav/ul[1]/li[3]/div/a[1]")
    WebElement sub_menu_product;

    @FindBy(how=How.XPATH, using ="/html/body/header/nav/a[1]")
    WebElement btn_application;
//
    public void clickProductMenu(){
        menu_product.click();
    }

    public void clickProductSubMenu(){
        sub_menu_product.click();
    }

    public boolean isPageOpened(){
        return menu_product.getText().toString().contains("Products");
    }

    public void clickApplicationMenu(){
        btn_application.click();
    }
}
