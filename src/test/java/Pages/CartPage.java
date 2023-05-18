package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    int wait=2;
    WebDriver driver;

    public CartPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void deliveryAddressform(String unit_no, String street, String city, String state, String zip_code, String country) {
        WebElement unit_no_field = driver.findElement(By.xpath("//input[@placeholder='Unit No']"));
        unit_no_field.sendKeys(unit_no);
        WebElement street_field = driver.findElement(By.xpath("//input[@placeholder='Street']"));
        street_field.sendKeys(street);
        WebElement city_field = driver.findElement(By.xpath("//input[@placeholder='City']"));
        city_field.sendKeys(city);
        WebElement state_field = driver.findElement(By.xpath("//input[@placeholder='State']"));
        state_field.sendKeys(state);
        WebElement zip_code_field = driver.findElement(By.xpath("//input[@placeholder='Zip Code']"));
        zip_code_field.sendKeys(zip_code);
        WebElement country_field = driver.findElement(By.xpath("//input[@placeholder='Country']"));
        country_field.sendKeys(country);
    }

    public void deliveryform(String delivery, String description) {
        WebElement delivery_field= driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > section:nth-child(2) > div:nth-child(4) > select:nth-child(2)"));
        Select delivery_dropdown = new Select(delivery_field);
        // Select by visible text
        delivery_dropdown.selectByVisibleText(delivery);
        WebElement description_field = driver.findElement(By.xpath("//textarea[@placeholder='Type something...']"));
        description_field.sendKeys(description);
    }

    public void paymentform(String payment) {
        WebElement payment_field= driver.findElement(By.cssSelector("select[class='input-search']"));
        Select payment_dropdown = new Select(payment_field);
        // Select by visible text
        payment_dropdown.selectByVisibleText(payment);
    }

    public void cart_button(){
        WebElement cart_button = driver.findElement(By.xpath("//img[@class='hidden tablet:inline w-8 h-8 cursor-pointer']"));
        cart_button.click();
    }

    public void delete_order_button(){
        WebElement delete_order_button = driver.findElement(By.xpath("//img[@class='w-[2rem] h-[2rem] aspect-square cursor-pointer']"));
        delete_order_button.click();
    }

    public void delivery_and_payment_button(){
        WebElement delivery_and_payment_button = driver.findElement(By.xpath("//button[@class='saveButton']"));
        delivery_and_payment_button.click();
    }

    public void view_cart_farmer_produce_btn(){
        WebElement view_cart_farmer_produce_btn = driver.findElement(By.xpath("//button[normalize-space()='View Cart']"));
        view_cart_farmer_produce_btn.click();
    }

    public void finish_order_button(){
        WebElement finish_order_button = driver.findElement(By.xpath("//button[@class='saveButton rounded-md']"));
        finish_order_button.click();
    }

    public void track_delivery_button(){
        WebElement track_delivery_button = driver.findElement(By.xpath("//button[@class='saveButton w-fit rounded-md w-[15rem]']"));
        track_delivery_button.click();
    }

    public void go_back_catalog_btn(){
        WebElement go_back_catalog_btn = driver.findElement(By.xpath("//a[@class='font-medium text-center']"));
        go_back_catalog_btn.click();
    }
}
