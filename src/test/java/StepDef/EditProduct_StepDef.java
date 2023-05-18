package StepDef;
import Pages.LoginPage;
import Pages.ManageProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class EditProduct_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageProductPage manageProductPage;

    public EditProduct_StepDef(){
        loginPage = new LoginPage(driver);
        manageProductPage = new ManageProductPage(driver);
    }
    
    @Given("User select My Account EditProduct")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();
        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        TimeUnit.SECONDS.sleep(wait);
        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();
        
        TimeUnit.SECONDS.sleep(wait);
        WebElement myAccount_btn = driver.findElement(By.xpath("//label[contains(text(),'My Account')]"));
        myAccount_btn.click();
    }

    @And("User select Manage Product EditProduct")
    public void user_select_Manage_Product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        //WebElement view_as_farmer_btn = driver.findElement(By.xpath("//div[normalize-space()='View as Farmer']"));
        //view_as_farmer_btn.click();

        //TimeUnit.SECONDS.sleep(wait);

        manageProductPage.manage_product_btn();
    }

    @And("User select on chosen product EditProduct")
    public void user_select_on_chosen_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.edit_product_btn();
    }

    @And("User edit but doesnt fill the required product details and click save")
    public void user_edit_but_doesnt_fill_the_required_product_details_and_click_save() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.clear_product_form();

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_product_btn();
    }

    @Then("User edit and fill the product details and click save")
    public void user_edit_and_fill_the_required_product_details_and_click_save() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement quantity_field = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > section:nth-child(6) > div:nth-child(2) > input:nth-child(1)"));
        quantity_field.sendKeys("2");

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_product_btn();
    }
}
