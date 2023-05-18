package StepDef;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowseProduct_StepDef {
    int wait=2;

    LoginPage loginPage;
    
    public BrowseProduct_StepDef(){
        loginPage = new LoginPage(driver);
    }

    @Given("User select farmer produce when not login")
    public void user_select_farmer_produce_when_not_login() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        user_click_farmer_produce_page();
        user_click_product();
        user_add_to_cart();
        login();
    }

    public void user_click_farmer_produce_page() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement farmer_produce_btn = driver.findElement(By.xpath("//label[normalize-space()='Farmers Produce']"));
        farmer_produce_btn.click();
    }

    public void user_click_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);

        WebElement product_btn = driver.findElement(By.xpath("//div[contains(@class,'p-3')]//div[1]//img[1]"));
        product_btn.click();
    }

    public void user_add_to_cart() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement add_to_cart_btn = driver.findElement(By.xpath("//button[@class='btn-add-carts']"));
        add_to_cart_btn.click();
    }

    public void login() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();
    }

    @And("User view and scroll page")
    public void user_view_and_scroll_page() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        user_click_farmer_produce_page();
        TimeUnit.SECONDS.sleep(5);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,200)");
    }

    @And("User choose and view product")
    public void user_choose_and_view_product() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement product_btn = driver.findElement(By.xpath("//div[18]//section[1]"));
        product_btn.click();

        TimeUnit.SECONDS.sleep(wait);

        WebElement product_img = driver.findElement(By.xpath("//div[contains(@class,'absolute bg-black/50 text-white left-0 bottom-0 rounded-b-lg flex flex-col w-full h-1/4 p-2 box-img-card')]"));
        product_img.isDisplayed();
    }

    @And("User continue browsing")
    public void user_continue_browsing() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement farmer_produce_btn = driver.findElement(By.xpath("//span[normalize-space()='Farmers Produce']"));
        farmer_produce_btn.click();

        user_choose_and_view_product();
    }

    @And("User select farm details in product details page")
    public void user_select_farm_details_in_product_details_page() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement farmer_produce_btn = driver.findElement(By.xpath("//button[normalize-space()='Farm Details']"));
        farmer_produce_btn.click();

        TimeUnit.SECONDS.sleep(wait);
        user_continue_browsing();
    }

    @And("User doesnt fill in details on product details page")
    public void user_doesnt_fill_in_details_on_product_details_page() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        user_add_to_cart();
    }

    @And("User fill in details on product details page")
    public void user_fill_in_details_on_product_details_page() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);

        WebElement grade_btn = driver.findElement(By.xpath("//select[contains(@class,'w-1/2 select-grade')]"));
        Select dropdown = new Select(grade_btn);
        // Select by visible text
        dropdown.selectByVisibleText("Cavendish Banana");
        // Select by value
        //dropdown.selectByValue("Cavendish Banana");

        TimeUnit.SECONDS.sleep(wait);
        WebElement add_btn = driver.findElement(By.xpath("//span[normalize-space()='+']"));
        add_btn.click();
        add_btn.click();

        TimeUnit.SECONDS.sleep(wait);
        user_add_to_cart();
    }

    @And("User view cart")
    public void user_view_cart() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);

        WebElement view_cart_btn = driver.findElement(By.xpath("//button[normalize-space()='View Cart']"));
        view_cart_btn.click();

        TimeUnit.SECONDS.sleep(wait);

        WebElement delete_btn = driver.findElement(By.xpath("//section[contains(@class,'hidden items-center px-4 justify-end tablet:flex basis-1/6')]//img[contains(@alt,'trash icon')]"));
        delete_btn.click();

        TimeUnit.SECONDS.sleep(wait);

         // switch to the alert
         driver.switchTo().alert().accept();
    }

    @Then("User continue shopping")
    public void user_continue_shopping() throws InterruptedException{
        user_click_farmer_produce_page();
        user_choose_and_view_product();
        user_fill_in_details_on_product_details_page();

        TimeUnit.SECONDS.sleep(wait);

        WebElement continue_shopping_btn = driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']"));
        continue_shopping_btn.click();
        
    }
}
