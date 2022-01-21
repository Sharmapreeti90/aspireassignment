package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPageObject {
    WebDriver driver;
    public ProductPageObject(WebDriver driver){
        this.driver = driver;
    }


    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[1]/div[2]/div[1]/div/div/button")
    WebElement btn_create_product;

    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[2]/div/div[1]/div[2]/div[4]/h1/input")
    WebElement txt_product_name;
    
    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[2]/div/div[1]/div[1]/div/button[2]")
    WebElement btn_update_quantity;
    
    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[1]/div[2]/div[1]/div/div/button[3]")
    WebElement btn_create_quantity;

    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[2]/div/div/input")
    WebElement txt_location_input;
    

    @FindBy(how=How.XPATH, using ="/html/body/div[4]/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]/input")
    WebElement txt_quantity;
    

    @FindBy(how=How.XPATH, using ="html/body/div[4]/div/div[1]/div[2]/div[1]/div/div/button[1]")
    WebElement btn_save_quantity;
    

    @FindBy(how=How.CLASS_NAME, using ="ui-menu-item-wrapper")
    WebElement txt_option_virtual_location;

    ////
    public void clickCreateProduct(){
        btn_create_product.click();
    }

    public void enterProductName(String productName){
        txt_product_name.sendKeys(productName);
    }

    public Boolean isProductListPageLoaded(){
        return btn_create_product.getText().toString().contains("CREATE");
    }

    public void clickUpdateQuantity(){
        btn_update_quantity.click();
    }

    public void clickCreateQuantity(){
        btn_create_quantity.click();
    }

    public void clickLocation(){
        txt_location_input.click();
    }

    public void enterVirtualLocations(){
        txt_location_input.click();
        txt_option_virtual_location.click();
    }

    public void clearQuantity(){
        txt_quantity.clear();
    }
    public void enterQuantity(){
        clearQuantity();
        txt_quantity.sendKeys("20");
    }
    public void clickSaveQuantity(){
        btn_save_quantity.click();
    }
}
