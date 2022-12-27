package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.RegisterPage;

public class LogIn{
    WebDriver driver;
    WebElement mainMenu, mainMenu1;
    WebElement subMenu, subMenu1;
    Actions actions, actions1;
    HomePage homePage;
    RegisterPage regPage;
    WebElement bla;

    @Before
    //@Test
    public void initDrive(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reserved.com/ro/ro/");
        if(driver.findElement(By.id("cookiebotDialogOkButton")).isDisplayed()){
            driver.findElement(By.id("cookiebotDialogOkButton")).click();
        }
        homePage = new HomePage(driver);
        regPage = new RegisterPage(driver);
   }
    public void logIn(WebDriver driver){
        actions = new Actions(driver);
        actions.moveToElement(homePage.mainMenu1).perform();
        actions.moveToElement(homePage.subMenuLogin).perform();
        homePage.subMenuLogin.click();
        homePage.setEmailField("ing_vasile_cristian@yahoo.co.uk");
        homePage.setPasswordField("123456");
        homePage.clickSubmitButton();
        wait(3);
        //dismiss the newsletter
        if(homePage.newsLetterContainer.isDisplayed()){
            driver.findElement(By.cssSelector("#newsletterContainer > div")).click();}
    }

    @Ignore
    @Test
    public void register() {
        mainMenu = driver.findElement(By.cssSelector("[data-testid=\"account-info-logged-false\"]"));
        actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();
        subMenu = driver.findElement(By.cssSelector("[data-testid=\"register\"]"));
        actions.moveToElement(subMenu).perform();
        subMenu.click();
        regPage.setEmailField("ing_vasile_cristian@yahoo.co.uk");
        regPage.setFirstNameField("Cristi");
        regPage.setLastNameField("Vasile");
        regPage.setPasswordField("123456");
        regPage.clickSubmitButton();
    }
    @Test
    public void logInWithCorrectCredentials(){
        logIn(driver);
        Assert.assertTrue(homePage.mainMenulogged.isEnabled());

    }
    @Test
    public void addToCart(){
        //log in
        logIn(driver);
        //add
        actions = new Actions(driver);
        actions.moveToElement(homePage.menuItemBarbati).perform();
        actions.moveToElement(homePage.subMeniuTricouri).perform();
        homePage.subMeniuTricouri.click();
        wait(1);
        driver.findElement(By.cssSelector("#categoryProducts > article:nth-child(2) > figure > a > img")).click();
        wait(1);
        bla = driver.findElement(By.cssSelector("[alt=\"Cămașă slim fit din bumbac - alb\"]"));
//        while(!bla.isDisplayed()){
//            wait(1);
//        }
        bla.click();
        wait(1);
        driver.findElement(By.cssSelector("#productContainer > section > div.product-info > section.size-picker > div > div.size-selected")).click();
        wait(1);
        driver.findElement(By.cssSelector("#productContainer > section > div.product-info > section.size-picker > div > div.size-list-overlay.visible > div > div:nth-child(2) > div:nth-child(1) > ul > li:nth-child(3)")).click();
        wait(1);
        driver.findElement(By.cssSelector("#productContainer > section > div.product-info > section.sc-kEjbQP.cIhnHO > button")).click();
        wait(2);
        driver.findElement(By.cssSelector("[data-selen=\"cart-confirmation-close\"]")).click();
        //go to cart page
        actions1 = new Actions(driver);
        actions1.moveToElement(homePage.mainMenuCart).perform();
        wait(1);
        actions1.moveToElement(homePage.subMenuSHowCart).perform();
        homePage.subMenuSHowCart.click();
        wait(1);
        Assert.assertEquals("Coș de cumpărături",driver.findElement(By.cssSelector("[data-dynamicyield=\"cart-heading\"] span")).getText());

    }
//    @Ignore
    @Test
    public void logOut(){
        if(homePage.mainMenulogged.isDisplayed()){
            actions = new Actions(driver);
            actions.moveToElement(homePage.mainMenulogged).perform();
            wait(1);
            actions.moveToElement(homePage.logOutButton).click();
        }
    }

    public void wait(int seconds){
        try{
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //imi face probleme partea asta, incetineste tot testul la final
   // @After
    public void quit(){
        driver.close();
    }
}
