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

public class EditDemand_StepDef {
    int wait=2;

    LoginPage loginPage;
    DemandPage demandPage;

    public EditDemand_StepDef(){
        loginPage = new LoginPage(driver);
        demandPage = new DemandPage(driver);
    }

    @Given("User select My Account EditDemand Buyer")
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
    
    @And("User select My Demand EditDemand")
    public void user_select_My_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.my_demand_button();
    }

    @And("User select chosen demand")
    public void user_add_New_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.edit_demand_button();
    }

    @And("User edit but doesnt fill in required demand details and click save")
    public void user_edit_but_doesnt_fill_in_required_demand_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.clear_demand_form();

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,50)");

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

    @Then("User edit and fill in required demand details and click save")
    public void user_edit_and_fill_in_required_demand_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String product_name = "Musang King";
        demandPage.editdemandform(product_name);

        TimeUnit.SECONDS.sleep(wait);
        demandPage.save_demand_button();
    }

}
