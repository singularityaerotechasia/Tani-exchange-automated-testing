package StepDef;
import Pages.LoginPage;
import Pages.MyDemandPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;
import java.util.concurrent.TimeUnit;

public class AcceptDemand_StepDef {
    int wait=2;

    LoginPage loginPage;
    MyDemandPage mydemandPage;

    public AcceptDemand_StepDef(){
        loginPage = new LoginPage(driver);
        mydemandPage = new MyDemandPage(driver);
    }

    @Given("User select My Account AcceptDemand Buyer")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "PasarAli21";
        String password = "PasarAli123";

        loginPage.Loginform(username, password);

        loginPage.next_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();
    }
    
    @And("User select My Demand Buyer")
    public void user_select_My_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.my_demand_button();
    }

    @And("User click on chosen demand AcceptDemand")
    public void user_click_on_chosen_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.details_demand_button();
    }

    @And("User click on view farm AcceptDemand")
    public void user_view_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.view_farm_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.go_back_view_farm_button();
    }

    @And("User click on accept demand")
    public void user_click_on_accept_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.accept_demand_button();
    }

    @And("User cancel accept demand")
    public void user_cancel_accept_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @And("User confirm accept demand")
    public void user_confirm_accept_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.accept_demand_button();

        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }

    @Then("User go back to My Demand")
    public void user_go_back_to_Market_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.go_back_demand_market_button();
    }

}
