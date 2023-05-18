package StepDef;

import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Registration_StepDef {
    int wait=3;
    RegistrationPage registerPage;
    
    public Registration_StepDef(){
        registerPage = new RegistrationPage(driver);
    }
    //public static WebDriver driver;

    @Given("User launch Tani Exchange")
    public void user_launch_website(){
    }

    @And("User try Register Route 1")
    public void user_try_register_route_1() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement registerbtn = driver.findElement(By.xpath("//label[normalize-space()='Register']"));
        registerbtn.click();
    }

    @And("User try Register Route 2")
    public void user_try_register_route_2() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement loginbtn = driver.findElement(By.xpath("//label[normalize-space()='Login']"));
        loginbtn.click();
    }

    @And("User select Sign up button")
    public void user_select_sign_up_button() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement sign_up_btn = driver.findElement(By.xpath("//u[normalize-space()='Sign up here!']"));
        sign_up_btn.click();
    }

    @And("User fill half required account details")
    public void user_fill_half_required_account_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String username = "Admin";
        String phone_number = "0123456789";
        String password = "123456789";
        String password_confirm = "123456789";
        registerPage.Registerform(username, phone_number,password, password_confirm);

        WebElement checkbox = driver.findElement(By.xpath("//section[@class='self-center flex flex-col space-y-2']//input[@value='false']"));
        checkbox.click();
    }

    @And("User click Next button")
    public void user_click_next_button_register() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,800)");

        WebElement next_btn = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        TimeUnit.SECONDS.sleep(wait);
        next_btn.click();
    }
    
    @And("User select Registration role")
    public void user_select_registration_role() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement role_btn = driver.findElement(By.xpath("//img[@class='w-23']"));
        role_btn.click();
    }

    @And("User fill required company details")
    public void user_fill_required_company_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String profile_url = "";
        String person_name = "admin";
        String surname = "1";
        String company_name = "testing";
        String company_registration = "123456789";
        String company_address = "SAT_ASIA";
        String contact_number = "0123456789";

        registerPage.Companyform(profile_url, person_name, surname, company_name, company_registration, company_address, contact_number);

        WebElement submit_btn = driver.findElement(By.xpath("//button[@type='button']"));
        submit_btn.click();

        TimeUnit.SECONDS.sleep(wait);
        WebElement account_btn = driver.findElement(By.xpath("//button[@type='button']"));
        account_btn.click();
        //button[@type='button']
    }

    @And("User fill requested profile information")
    public void user_fill_requested_profile_information() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String email = "admin@gmail.com";
        String pass = "123456789";

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,900)");

        WebElement email_address = driver.findElement(By.xpath("//input[contains(@type,'email')]"));
        email_address.sendKeys(email);
        WebElement password = driver.findElement(By.xpath("//div[2]//div[1]//div[2]//div[1]//form[1]//div[2]//section[4]//input[1]"));
        password.sendKeys(pass);
        WebElement confirm_password = driver.findElement(By.xpath("//section[4]//input[1]"));
        confirm_password.sendKeys(pass);
    }

    @Then("User click Save button")
    public void user_click_save_button() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement submit_btn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        submit_btn.click();
    }
}
