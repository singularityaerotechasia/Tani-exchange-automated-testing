package StepDef;
import Pages.DemandPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class CreateDemand_StepDef {
    int wait=2;

    LoginPage loginPage;
    DemandPage demandPage;

    public CreateDemand_StepDef(){
        loginPage = new LoginPage(driver);
        demandPage = new DemandPage(driver);
    }

    @Given("User select My Account CreateDemand Buyer")
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
    
    @And("User select My Demand CreateDemand")
    public void user_select_My_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.my_demand_button();
    }

    @And("User add New Demand")
    public void user_add_New_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.add_demand_button();
    }

    @And("User doesnt fill in required demand details and click save")
    public void user_doesnt_fill_in_required_demand_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

    @And("User fill in required demand details and click save")
    public void user_fill_in_required_demand_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String categories = "fruits";
        String available_crop = "Musang King";
        String grades = "Musang King";
        String amount_required = "10";
        String frequency = "once";
        String deliver_one_off = "10/06/2023";
        String demand_period_start = "01/06/2023";
        String demand_period_end = "07/06/2023";
        demandPage.demandform(categories, available_crop, grades, amount_required, frequency,deliver_one_off, demand_period_start, demand_period_end);

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,50)");

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

    @And("User doesnt upload image CreateDemand")
    public void user_doesnt_upload_image() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

    @And("User upload image but no image description CreateDemand")
    public void user_upload_image_but_no_image_description() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.edit_demand_button();

        String photoPath = "C:/Users/SharzKim/Downloads/corn.jpeg";
        demandPage.upload_photo(photoPath);

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        demandPage.edit_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        demandPage.photo_description_button();

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

    @Then("User add image description CreateDemand")
    public void user_upload_image_with_image_description() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.photo_description_button();

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");

        TimeUnit.SECONDS.sleep(wait);
        String date = "01/01/2023";
        String description = "canteknyaa";
        demandPage.photodescriptionform(date, description);

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }
}
