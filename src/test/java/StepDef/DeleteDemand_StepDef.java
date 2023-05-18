package StepDef;
import Pages.DemandPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class DeleteDemand_StepDef {
    int wait=2;

    LoginPage loginPage;
    DemandPage demandPage;

    public DeleteDemand_StepDef(){
        loginPage = new LoginPage(driver);
        demandPage = new DemandPage(driver);
    }

    @Given("User select My Account DeleteDemand Buyer")
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
    
    @And("User select My Demand DeleteDemand")
    public void user_select_My_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.my_demand_button();
    }

    @And("User click delete on chosen demand")
    public void user_click_delete_on_chosen_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.edit_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,50)");
        
        TimeUnit.SECONDS.sleep(wait);
        demandPage.delete_demand_button();
    }

    @And("User cancel delete demand")
    public void user_click_cancel_on_chosen_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @Then("User confirm delete demand")
    public void user_click_confirm_on_chosen_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        demandPage.delete_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }
 
}
