package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPageObject {
    WebDriver driver;
    public DashboardPageObject(WebDriver driver){
        this.driver = driver;
    }



    @FindBy(how=How.CLASS_NAME, using ="o_loading")
    public WebElement dashboardMenu;


    @FindBy(how=How.XPATH, using ="/html/body/div[2]/div[3]/div/a[2]/div[1]")
    WebElement btn_Inventory;

    @FindBy(how=How.XPATH, using ="/html/body/div[2]/div[3]/div/a[3]/div[1]")
    WebElement btn_manufacturing;

    public void clickInventory(){
        btn_Inventory.click();
    }

    public boolean isPageOpened(){
        return dashboardMenu.getText().toString().contains("Loading");
    }

    public void clickManufacturing(){
        btn_manufacturing.click();
    }
}
