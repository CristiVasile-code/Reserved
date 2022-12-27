package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[data-testid=\"account-info-logged-false\"]")
    public WebElement mainMenu1;
    @FindBy(css="[data-testid=\"account-info-logged-true\"]")
    public WebElement mainMenulogged;
    @FindBy(css="[data-testid=\"login\"]")
    public WebElement subMenuLogin;
    @FindBy(css="[data-testid=\"cart-button\"]")
    public WebElement mainMenuCart;
    //data-testid="minicart-go-to-cart-button"
    @FindBy(css="#headerWrapper > div > div.page-header__HeaderItems-qbclzk-4.kCEgxi > div.mini-cart__StyledMiniCart-ne31ro-0.iBgxQr > div.footer__StyledFooter-sc-1qncqgu-0.hiPmsJ > button")
    public WebElement subMenuSHowCart;

    @FindBy(id="login[username]_id")

    private WebElement emailField;
    @FindBy(id="login[password]_id")
    private WebElement passwordField;
    @FindBy(css = "[data-selen=\"login-submit\"]")
    private WebElement submitButton;
    @FindBy(id="newsletterContainer")
    public WebElement newsLetterContainer;
    @FindBy(css = "data-testid=\"logout\"")
    public WebElement logOutButton;

    @FindBy(css="input__InputText-sc-1mxde2b-0")
    private WebElement searchInputText;
    @FindBy(css = "#navigation-wrapper > div > ul > li:nth-child(4) > a")
    public WebElement menuItemBarbati;
    @FindBy(css = "#navigation-wrapper > div > ul > li:nth-child(4) > ul > li:nth-child(1) > ul > li:nth-child(8) > a")
    public WebElement subMeniuTricouri;
    public void setEmailField(String value){
        emailField.sendKeys(value);
     }
    public void setPasswordField(String value){
        passwordField.sendKeys(value);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void clickLogoutButton(){
        logOutButton.click();
    }
//    public void setSearchInput(){
//        searchInputText.click();
//    }
}
