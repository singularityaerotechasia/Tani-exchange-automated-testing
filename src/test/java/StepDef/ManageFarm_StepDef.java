package StepDef;
import Pages.LoginPage;
import Pages.ManageFarmPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ManageFarm_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageFarmPage manageFarmPage;

    public ManageFarm_StepDef(){
        loginPage = new LoginPage(driver);
        manageFarmPage = new ManageFarmPage(driver);
    }

    @Given("User select My Account ManageFarm")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();
    }

    @And("User select Manage Farm ManageFarm")
    public void user_select_Manage_Farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.manage_farm_button();
    }

    @And("User select on chosen farm ManageFarm")
    public void user_select_on_chosen_farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.open_farm_button();
    }

    @And("User select on chosen plot ManageFarm")
    public void user_select_on_chosen_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.plot_btn();

        TimeUnit.SECONDS.sleep(wait);
        WebElement go_back_plot_btn = driver.findElement(By.xpath("//label[@class='cursor-pointer head-bar-nav']"));
        go_back_plot_btn.click();
    }

    @Then("User select on crop and stock ManageFarm")
    public void user_select_on_crop_and_stock() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();

        TimeUnit.SECONDS.sleep(wait);
    }
}
