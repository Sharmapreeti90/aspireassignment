package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObject {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how=How.NAME, using ="login")
    WebElement txt_email;

    @FindBy(how=How.NAME, using ="password")
    WebElement txt_password;

    @FindBy(how=How.XPATH,using ="//button[@type='submit']")
    WebElement submitButton;

    public void setEmailId(String emailId){
        txt_email.sendKeys(emailId);
    }

    public void setPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
