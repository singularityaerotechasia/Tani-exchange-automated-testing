package StepDef;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class EditAccountFarmer_StepDef {
    int wait=2;

    LoginPage loginPage;

    public EditAccountFarmer_StepDef(){
        loginPage = new LoginPage(driver);
    }

    @Given("User select My Account EditAccount Farmer")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();
    }

    @And("User doesnt edit personal details and click save Farmer")
    public void user_doesnt_edit_personal_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,400)");

        TimeUnit.SECONDS.sleep(wait);
        loginPage.save_button();
    }

    @And("User edit personal details and click save Farmer")
    public void user_edit_personal_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,400)");

        String email = "admin@gmail.com";
        TimeUnit.SECONDS.sleep(wait);
        loginPage.email_address_button(email);

        TimeUnit.SECONDS.sleep(wait);
        loginPage.save_button();
    }

    @And("User doesnt edit company details and click save Farmer")
    public void user_doesnt_edit_company_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,-400)");

        TimeUnit.SECONDS.sleep(wait);
        loginPage.company_button();

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,400)");

        TimeUnit.SECONDS.sleep(wait);
        loginPage.clear_company_form();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.save_button();
    }

    @Then("User edit company details and click save Farmer")
    public void user_edit_company_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String company_name = "SAT ASIA";
        loginPage.company_name_button(company_name);

        TimeUnit.SECONDS.sleep(10);
        loginPage.save_button();
    }
    
}
