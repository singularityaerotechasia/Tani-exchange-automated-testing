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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AddProduct_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageProductPage manageProductPage;

    public AddProduct_StepDef(){
        loginPage = new LoginPage(driver);
        manageProductPage = new ManageProductPage(driver);
    }

    @Given("User select My Account AddProduct")
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

    @And("User select Manage Product AddProduct")
    public void user_select_Manage_Product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        //WebElement view_as_farmer_btn = driver.findElement(By.xpath("//div[normalize-space()='View as Farmer']"));
        //view_as_farmer_btn.click();

        //TimeUnit.SECONDS.sleep(wait);

        manageProductPage.manage_product_btn();
    }

    @And("User add New Product")
    public void user_add_New_Product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.add_new_product_btn();
    }

    @And("User doesnt fill the product details and click save")
    public void user_doesnt_fill_the_product_details_and_click_save() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_add_product_btn();
    }

    @And("User fill the product details and click save")
    public void user_fill_the_product_details_and_click_save() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
    
        String category = "fruits";
        String origin = "SAT ASIA";
        String crop = "corn";
        String grade = "A";
        String quantity = "2";

        manageProductPage.add_product_form(category, origin, crop, grade, quantity);

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_add_product_btn();
    }

    @And("User view unpublished product")
    public void user_view_unpublished_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.manage_product_btn();

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.edit_product_btn();
    }

    public void edit_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.edit_product_btn();
    }

    @And("User doesnt upload image")
    public void user_doesnt_upload_image() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.publish_btn();
    }

    @And("User upload images but not image description")
    public void user_upload_image_but_not_image_description() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        
        String photoPath = "C:/Users/SharzKim/Downloads/corn.jpeg";
        manageProductPage.upload_photo(photoPath);

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.add_image_description_btn();

        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300)");

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_image_description_btn();
    }

    @And("User add image description")
    public void user_add_image_description() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
    
        manageProductPage.add_image_description_btn();

        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300)");

        TimeUnit.SECONDS.sleep(wait);
        String date = "11/05/2023";
        String description = "product added";
        manageProductPage.image_description_form(date, description);

        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.save_image_description_btn();
    }

    @Then("User publish product")
    public void user_publish_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageProductPage.publish_btn();
    }
}
