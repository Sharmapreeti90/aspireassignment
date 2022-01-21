
///

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManufacturingPageObject {
    WebDriver driver;
    public ManufacturingPageObject(WebDriver driver){
        this.driver = driver;
    }


    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[1]/div[1]/div[2]/div/div/div/ul/li[2]/a[1]")
    WebElement productMenu;

    @FindBy(how=How.XPATH,using ="/html/body/ul[1]/li[1]/a")
    WebElement productSubMenu;

    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[2]/div[3]/table[1]/tbody/tr[5]/td[2]/div/div/input")
    WebElement searchProduct;

    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[1]/div[2]/div[1]/div/div/button[3]")
    WebElement btn_create_manufacturing_order;

    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td/a")
    WebElement btn_add_line;
    //


    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[1]/div/div/input")
    WebElement product_material_text_box;
    //


    @FindBy(how=How.XPATH,using ="/html/body/ul[9]/li[1]/a")
    WebElement product_material_text_box_select;

    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/table/tbody/tr[1]/td[2]/input")
    WebElement product_material_text_box_qty;


    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[1]/div[1]/button[3]")
    WebElement btn_save_manufacturing_order;


    @FindBy(how=How.XPATH,using ="/html/body/div[4]/div/div[2]/div/div[1]/div[1]/div[1]/button[2]")
    WebElement btn_mark_done;
  
    @FindBy(how=How.XPATH,using ="/html/body/div[8]/div/div/footer/div/footer/button[1]")
    WebElement btn_pop_up_apply;

  ///html/body/div[8]/div/div/footer/div/footer/button[1]
    public void selectProduct(){
        productMenu.click();
        productSubMenu.click();
    }

    public void enterProductSearchText(String productName){
        searchProduct.sendKeys(productName);
        productSubMenu.click();
    }

    public void clickCreateManufacturingOrder(){
        btn_create_manufacturing_order.click();
    }

    public void addMaterial(String productName){
        btn_add_line.click();
        product_material_text_box.click();
        product_material_text_box.sendKeys(productName);
        product_material_text_box_select.click();
        product_material_text_box_qty.clear();
        product_material_text_box_qty.sendKeys("20");
    }

    public void saveManufacturingOrder(){
        btn_save_manufacturing_order.click();
    }
    public void clickMarkDone(){
        try {
            btn_mark_done.click();
            btn_pop_up_apply.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            btn_mark_done.click();
            btn_pop_up_apply.click();
        }
    }
    public Boolean isMarkDone(){
       return btn_mark_done.getText().toString().contains("MARK AS DONE");
    }
}
