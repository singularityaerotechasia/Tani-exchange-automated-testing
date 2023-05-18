package StepDef;
import Pages.LoginPage;
import Pages.ManageFarmPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class DeleteFarm_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageFarmPage manageFarmPage;

    public DeleteFarm_StepDef(){
        loginPage = new LoginPage(driver);
        manageFarmPage = new ManageFarmPage(driver);
    }

    @Given("User select My Account DeleteFarm")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();
    }
    
    @And("User select Manage Farm DeleteFarm")
    public void user_select_Manage_Farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.manage_farm_button();
    }

    @And("User select on chosen farm DeleteFarm")
    public void user_select_on_chosen_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.open_farm_button();
    }

    @And("User select on chosen plot DeleteFarm")
    public void user_select_on_chosen_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.plot_btn();
    }

    @And("User click on Delete Plot")
    public void user_click_on_delete_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,900)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_plot_btn();
    }

    @And("User cancel on Delete Plot")
    public void user_cancel_on_delete_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @And("User confirm on Delete Plot")
    public void user_confirm_on_delete_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        user_click_on_delete_plot();
        
        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }

    @And("User select on chosen crop DeleteFarm")
    public void user_select_on_chosen_crop() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();
    }

    @And("User click on Delete Grade")
    public void user_click_on_delete_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,500)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_grade_button();
    }

    @And("User cancel on Delete Grade")
    public void user_cancel_on_delete_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @And("User confirm on Delete Grade")
    public void user_confirm_on_delete_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_grade_button();

        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }

    @And("User click on Delete Crop")
    public void user_click_on_delete_crop() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_crop_button();
    }

    @And("User cancel on Delete Crop")
    public void user_cancel_on_delete_crop() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @And("User confirm on Delete Crop")
    public void user_confirm_on_delete_crop() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_crop_button();

        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }

    @And("User click on Delete Farm")
    public void user_click_on_delete_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,1000)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_farm_button();
    }

    @And("User cancel on Delete Farm")
    public void user_cancel_on_delete_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        // switch to the alert
        driver.switchTo().alert().dismiss();
    }

    @Then("User confirm on Delete Farm")
    public void user_confirm_on_delete_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.delete_farm_button();

        TimeUnit.SECONDS.sleep(wait);
        // switch to the alert
        driver.switchTo().alert().accept();
    }
}
