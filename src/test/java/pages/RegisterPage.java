package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email_id")
    private WebElement emailField;
    @FindBy(id="firstname_id")
    private WebElement firstNameField;
    @FindBy(id="lastname_id")
    private WebElement lastNameField;
    @FindBy(id="password_id")
    private WebElement passwordField;
    @FindBy(css="[data-selen=\"create-account-submit\"]")
    private WebElement submitButton;

    public void setEmailField(String value){
        emailField.sendKeys(value);
    }
    public void setFirstNameField(String value){
        firstNameField.sendKeys(value);
    }
    public void setLastNameField(String value){
        lastNameField.sendKeys(value);
    }
    public void setPasswordField(String value){
        passwordField.sendKeys(value);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
