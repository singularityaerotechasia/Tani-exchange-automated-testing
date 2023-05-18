package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    int wait=2;
    WebDriver driver;

    public LoginPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void Loginform(String username, String password) {
        WebElement user_username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        user_username.sendKeys(username);
        WebElement user_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        user_password.sendKeys(password);
    }

    public void clearform() {
        WebElement user_username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        user_username.clear();
        WebElement user_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        user_password.clear();
    }

    public void click_Login(){
        WebElement login_btn = driver.findElement(By.xpath("//label[normalize-space()='Login']"));
        login_btn.click();
    }

    public void next_button(){
        WebElement next_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        next_btn.click();
    }

    public void my_account_button(){
        WebElement profile_btn = driver.findElement(By.xpath("//label[contains(text(),'My Account')]"));
        profile_btn.click();
    }

    public void manage_farm_button(){
        WebElement farm_btn = driver.findElement(By.xpath("//div[normalize-space()='Manage Farms']"));
        farm_btn.click();
    }

    public void email_address_button(String email){
        WebElement email_address_button = driver.findElement(By.xpath("//input[@type='email']"));
        email_address_button.sendKeys(email);
    }

    public void save_button(){
        WebElement save_button = driver.findElement(By.xpath("//button[@type='submit']"));
        save_button.click();
    }

    public void clear_company_form() throws InterruptedException, AWTException{
        WebElement inputField = driver.findElement(By.xpath("//section[2]//input[1]"));

        // Click on the input field to focus it
        inputField.click();
        
        TimeUnit.SECONDS.sleep(wait);
        // Simulate pressing the "CONTROL" and "a" keys to select all text in the input field
        Robot robot = new Robot();
        TimeUnit.SECONDS.sleep(wait);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        TimeUnit.SECONDS.sleep(wait);
        // Simulate pressing the "DELETE" key to clear the selected text
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    } 

    public void company_name_button(String company_name){
        WebElement company_name_button = driver.findElement(By.xpath("//section[2]//input[1]"));
        company_name_button.sendKeys(company_name);
    }

    public void company_button(){
        WebElement company_button = driver.findElement(By.xpath("//button[contains(@class,'border-b-2 border-b-gray-500')]"));
        company_button.click();
    }
}
