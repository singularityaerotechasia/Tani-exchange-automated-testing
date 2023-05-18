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

public class AddFarm_StepDef {
    int wait=2;

    LoginPage loginPage;
    ManageFarmPage manageFarmPage;

    public AddFarm_StepDef(){
        loginPage = new LoginPage(driver);
        manageFarmPage = new ManageFarmPage(driver);
    }

    @Given("User select My Account AddFarm")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();
    }
    
    @And("User select Manage Farm")
    public void user_select_Manage_Farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.manage_farm_button();
    }

    @And("User select Add New Farm")
    public void user_select_Add_Farm() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.addFarm_btn();
    }

    @And("User fill in half create farm details")
    public void user_fill_in_half_create_farm_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String name = "SAT ASIA";
        String address = "";

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.Farmform(name, address);
        manageFarmPage.save_form_btn();

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.clearform();
    }

    @And("User fill in create farm details")
    public void user_fill_in_create_farm_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        String name = "SAT ASIA";
        String address = "B-13-03-A, PJ Trade Center, 8, Jalan PJU 8/8, Damansara Perdana, 47820 Petaling Jaya, Selangor";

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.Farmform(name, address);
        manageFarmPage.save_form_btn();
    }

    @And("User doesnt upload farm certificate and photos")
    public void user_doesnt_upload_farm_certificate_and_photos() throws InterruptedException,AWTException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_upload_btn();
    }

    @And("User upload farm certificate and photos")
    public void user_upload_farm_certificate_and_photos() throws InterruptedException,AWTException{
        TimeUnit.SECONDS.sleep(5);
        manageFarmPage.open_farm_button();

        TimeUnit.SECONDS.sleep(wait);
        String certificatePath = "C:/Users/SharzKim/Downloads/Kapitan Menu 2022(KL Price).pdf";
        String photoPath = "C:/Users/SharzKim/Downloads/multiple layer.png";

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.upload_certificate(certificatePath);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.upload_farm_photos(photoPath);

        //JavascriptExecutor js = (JavascriptExecutor) driver;

        //TimeUnit.SECONDS.sleep(wait);
        // Scroll down
        //js.executeScript("window.scrollBy(0,1000)");

        //TimeUnit.SECONDS.sleep(wait);
        //manageFarmPage.save_upload_btn();
    }

    @And("User add Plot")
    public void user_add_plot() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.add_plot_btn();
    }

    @And("User select crop and stock")
    public void user_select_crop_and_stock() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_btn();
    }

    @And("User add crop and doesnt fill in crop details")
    public void user_add_crop_and_doesnt_fill_in_crop_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        manageFarmPage.add_crop_btn();
        TimeUnit.SECONDS.sleep(wait);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }

    @And("User add crop and fill in crop details")
    public void user_fill_crop_and_stock_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        manageFarmPage.crop_btn();
        TimeUnit.SECONDS.sleep(wait);

        String cc_name = "Jelebu";
        String crop_name = "corn";
        manageFarmPage.collection_center_form(cc_name);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.crop_and_stock_form(crop_name);
        TimeUnit.SECONDS.sleep(wait);
    }

    @And("User add grade and doesnt fill in grade details")
    public void user_add_grade_and_doesnt_fill_in_grade_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        manageFarmPage.add_grade_btn();
        TimeUnit.SECONDS.sleep(wait);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }

    @And("User add grade and fill in grade details")
    public void user_add_grade_and_fill_in_grade_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        manageFarmPage.crop_btn();
        TimeUnit.SECONDS.sleep(wait);

        String grade_name = "A";
        String grade_criteria = "normal";
        String price = "2";
        String currency = "MYR RM";
        String stock = "100";
        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,900)");
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.grade_form(grade_name, grade_criteria, price, currency, stock);
        
        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,-300)");
        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.go_back_crop_button();
    }

    @And("User click Plot and doesnt fill plot details")
    public void user_click_plot_and_doesnt_fill_plot_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        manageFarmPage.add_plot_btn();

        TimeUnit.SECONDS.sleep(wait);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        TimeUnit.SECONDS.sleep(wait);
        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_plot_btn();
    }

    @Then("User click Plot and fill plot details")
    public void user_click_plot_and_fill_plot_details() throws InterruptedException, AWTException{
        TimeUnit.SECONDS.sleep(wait);
        
        String pic = "C:/Users/SharzKim/Downloads/corn.jpeg";
        TimeUnit.SECONDS.sleep(wait);
        String plot_name = "Jelebu";
        String crop_name = "corn";
        String stage_of_crop = "Planting";
        String planning_start_date = "10/05/2023";
        String harvesting_start_date = "10/07/2023";
        String harvesting_end_date = "20/07/2023";
        String expected_harvesting_quantity = "100";
        String expected_harvesting_quantity_unit = "Kg";
        manageFarmPage.plot_form(plot_name, crop_name, stage_of_crop, planning_start_date, harvesting_start_date, harvesting_end_date, expected_harvesting_quantity, expected_harvesting_quantity_unit);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_plot_btn();

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.upload_crop_photos(pic);

        TimeUnit.SECONDS.sleep(wait);
        manageFarmPage.save_plot_btn();
    }
}
