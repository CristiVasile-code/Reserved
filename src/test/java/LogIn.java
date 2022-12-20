import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LogIn{
    WebDriver driver;
    WebElement mainMenu;
    WebElement subMenu;
    Actions actions;

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

    }
    @Test
    public void register(){
        mainMenu = driver.findElement(By.cssSelector("[data-testid=\"account-info-logged-false\"]"));
        actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();
        subMenu = driver.findElement(By.cssSelector("[data-testid=\"register\"]"));
        actions.moveToElement(subMenu).perform();
        subMenu.click();
        driver.findElement(By.id("email_id")).sendKeys("ing_vasile_cristian@yahoo.co.uk");
        driver.findElement(By.id("firstname_id")).sendKeys("Cristi");
    }


    public void wait(int seconds){
        try{
            Thread.sleep(seconds*1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //imi face probleme partea asta, incetineste tot testul la final
    @After
    public void quit(){
        driver.close();
    }
}
