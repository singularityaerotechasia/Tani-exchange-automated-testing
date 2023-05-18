package StepDef;
import Pages.LoginPage;
import Pages.ManageFarmPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class EditFarm_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageFarmPage manageFarmPage;

    public EditFarm_StepDef(){
        loginPage = new LoginPage(driver);
        manageFarmPage = new ManageFarmPage(driver);
    }

    @Given("User select My Account EditFarm")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();
    }

    @And("User select Manage Farm EditFarm")
    public void user_select_Manage_Farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.manage_farm_button();
    }

    @And("User select on chosen farm EditFarm")
    public void user_select_on_chosen_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.open_farm_button();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,900)");
    }

    @And("User edit and doesnt fill in required farm details")
    public void user_edit_and_doesnt_fill_in_reqiured_farm_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.clear_farm_name();

        user_save_farm_edit();
    }

    @And("User edit and fill in required farm details")
    public void user_edit_and_fill_in_reqiured_farm_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        user_select_on_chosen_farm();

        TimeUnit.SECONDS.sleep(wait);
        String name = "Kg Baru";
        manageFarmPage.editform(name);
    }

    @And("User save farm edit")
    public void user_save_farm_edit() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_form_btn();
    }

    @And("User select on chosen plot EditFarm")
    public void user_select_on_chosen_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);
        manageFarmPage.open_farm_button();
        
        TimeUnit.SECONDS.sleep(5);
        manageFarmPage.plot_btn();
    }
    
    @And("User edit and doesnt fill in required plot details")
    public void user_edit_and_doesnt_fill_in_reqiured_plot_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.clear_plot_form();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_plot_btn();
    }

    @And("User edit and fill in required plot details")
    public void user_edit_and_fill_in_reqiured_plot_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.plot_btn();

        String plot_name = "Jempol";

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.edit_plot_form(plot_name);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_plot_btn();
    }
   
    @And("User select on chosen crop EditFarm")
    public void user_select_on_chosen_crop() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();
    }
    
    @And("User edit and doesnt fill in required crop details")
    public void user_edit_and_doesnt_fill_in_reqiured_crop_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.clear_crop_form();

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }

    @And("User edit and fill in required crop details")
    public void user_edit_and_fill_in_reqiured_crop_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();

        TimeUnit.SECONDS.sleep(wait);
        String cc_name= "Jempol";
        manageFarmPage.edit_crop_form(cc_name);

        TimeUnit.SECONDS.sleep(5);
        manageFarmPage.go_back_crop_button();
    }

    @And("User select on chosen grade EditFarm")
    public void user_select_on_chosen_grade() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);
        manageFarmPage.crop_btn();
    }
    
    @And("User edit and doesnt fill in required grade details")
    public void user_edit_and_doesnt_fill_in_reqiured_grade_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,500)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.clear_grade_form();

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,-300)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }

    @Then("User edit and fill in required grade details")
    public void user_edit_and_fill_in_reqiured_grade_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();

        String grade_name = "B";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,500)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.edit_grade_form(grade_name);

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,-300)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }
}
