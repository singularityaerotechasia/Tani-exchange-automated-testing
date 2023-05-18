package StepDef;
import Pages.LoginPage;
import Pages.MyDemandPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class ApplyDemand_StepDef {
    int wait=2;

    LoginPage loginPage;
    MyDemandPage mydemandPage;

    public ApplyDemand_StepDef(){
        loginPage = new LoginPage(driver);
        mydemandPage = new MyDemandPage(driver);
    }

    @Given("User select My Account ApplyDemand Farmer")
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
    
    @And("User select Market Demand")
    public void user_select_Market_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.my_demand_button();
    }

    @And("User click on chosen demand ApplyDemand")
    public void user_click_on_chosen_demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.select_demand_button();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,150)");
    }

    @And("User doesnt select on demand grade and apply ApplyDemand")
    public void user_doesnt_choose_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.apply_demand_button();
    }

    @And("User select on demand grade and apply ApplyDemand")
    public void user_choose_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String grade_demand = "Crop: corn - A - Price: rm2 - Quantity: 2KG";
        mydemandPage.gradedemandform(grade_demand);

        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.apply_demand_button();
    }

    @And("User already apply")
    public void user_already_apply() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        user_click_on_chosen_demand();

        TimeUnit.SECONDS.sleep(wait);
        user_choose_grade();
    }

    @Then("User go back to Market Demand")
    public void user_go_back_to_Market_Demand() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,-100)");

        TimeUnit.SECONDS.sleep(wait);
        mydemandPage.go_back_demand_market_button();
    }

}
