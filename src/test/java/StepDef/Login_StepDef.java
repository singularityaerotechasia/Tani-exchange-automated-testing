// can put tag here. example @loginpage
package StepDef;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.util.concurrent.TimeUnit;

public class Login_StepDef{
    int wait=2;
    LoginPage loginPage;
    
    public Login_StepDef(){
        loginPage = new LoginPage(driver);
    }
    //public static WebDriver driver;

    @Given("User click login")
    public void user_click_login() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement login_btn = driver.findElement(By.xpath("//label[normalize-space()='Login']"));
        login_btn.click();
    }

    @And("User fill in requested login information")
    public void user_fill_in_requested_login_information() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);
    }
    
    @And("User click Next buttonn")
    public void user_click_next_buttonn() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();

        TimeUnit.SECONDS.sleep(wait);

        WebElement profile_btn = driver.findElement(By.xpath("//label[contains(text(),'My Account')]"));
        profile_btn.click();

        TimeUnit.SECONDS.sleep(wait);

        WebElement logout_btn = driver.findElement(By.xpath("//div[normalize-space()='Logout']"));
        logout_btn.click();
    }

    @And("User fill half information")
    public void user_fill_half_information() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "";

        loginPage.Loginform(username, password);

        TimeUnit.SECONDS.sleep(wait);

        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.clearform();
    }

    @Then("User fill wrong information")
    public void user_fill_wrong_information() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "0123456789";

        loginPage.Loginform(username, password);

        TimeUnit.SECONDS.sleep(wait);

        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.clearform();
    }
}