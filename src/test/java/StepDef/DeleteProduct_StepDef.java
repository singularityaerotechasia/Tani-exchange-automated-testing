package StepDef;
import Pages.LoginPage;
import Pages.ManageProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeleteProduct_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageProductPage manageProductPage;

    public DeleteProduct_StepDef(){
        loginPage = new LoginPage(driver);
        manageProductPage = new ManageProductPage(driver);
    }
    
    @Given("User select My Account DeleteProduct")
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

    @And("User select Manage Product DeleteProduct")
    public void user_select_Manage_Product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        //WebElement view_as_farmer_btn = driver.findElement(By.xpath("//div[normalize-space()='View as Farmer']"));
        //view_as_farmer_btn.click();

        //TimeUnit.SECONDS.sleep(wait);

        manageProductPage.manage_product_btn();
    }

    @And("User select unpublish on chosen product")
    public void user_select_unpublish_on_chosen_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.unpublish_btn();
    }

    @And("User click on Delete product")
    public void user_click_on_delete_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.delete_btn();
    }

    @And("User cancel on Delete product")
    public void user_cancel_on_delete_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        WebElement confirm_btn = driver.findElement(By.xpath("//button[@class='borderedButton']"));
        confirm_btn.click();
    }

    @Then("User confirm on Delete product")
    public void user_confirm_on_delete_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.delete_btn();

        TimeUnit.SECONDS.sleep(wait);

        WebElement confirm_btn = driver.findElement(By.xpath("//button[@class='saveButton']"));
        confirm_btn.click();
    }
}
