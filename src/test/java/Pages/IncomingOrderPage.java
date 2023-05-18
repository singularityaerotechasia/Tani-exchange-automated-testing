package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncomingOrderPage {
    int wait=2;
    WebDriver driver;

    public IncomingOrderPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void incoming_order_button(){
        WebElement incoming_order_button = driver.findElement(By.xpath("//div[normalize-space()='Incoming Orders']"));
        incoming_order_button.click();
    }

    public void details_button_farmer(){
        WebElement details_button = driver.findElement(By.xpath("//button[@class='hidden laptop:flex btn-border-green w-[120px] items-center justify-center text-center']"));
        details_button.click();
    }

    public void details_button_buyer(){
        WebElement details_button = driver.findElement(By.xpath("//button[@class='hidden laptop:flex btn-border-green w-[120px] w-[100px] items-center justify-center text-center']"));
        details_button.click();
    }

    public void start_delivery_button(){
        WebElement start_delivery_button = driver.findElement(By.xpath("//button[@class='saveButton self-center w-fit']"));
        start_delivery_button.click();
    }

    public void accept_delivery_button(){
        WebElement accept_delivery_button = driver.findElement(By.xpath("//button[@class='saveButton self-center w-fit']"));
        accept_delivery_button.click();
    }

    public void switch_account_buyer_button(){
        WebElement switch_account_button = driver.findElement(By.xpath("//div[normalize-space()='View as Buyer']"));
        switch_account_button.click();
    }

    public void switch_account_farmer_button(){
        WebElement switch_account_farmer_button = driver.findElement(By.xpath("//div[normalize-space()='View as Farmer']"));
        switch_account_farmer_button.click();
    }

    public void my_order_button(){
        WebElement my_order_button = driver.findElement(By.xpath("//div[normalize-space()='My Orders']"));
        my_order_button.click();
    }
}
