package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver;
    int wait=3;
    
    public RegistrationPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void Registerform(String username, String phone_number, String password, String password_confirm) {
        WebElement user_username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        user_username.sendKeys(username);
        WebElement user_phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number*']"));
        user_phoneNumber.sendKeys(phone_number);
        WebElement user_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        user_password.sendKeys(password);
        WebElement user_password_confirmation = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
        user_password_confirmation.sendKeys(password_confirm);
    }

    public void Companyform(String profile_url, String person_name, String surname, String company_name, String company_registration, String company_address, String contact_number) {
        WebElement com_profileURL = driver.findElement(By.xpath("//input[@placeholder='Profile Url']"));
        com_profileURL.sendKeys(profile_url);
        WebElement com_personName = driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
        com_personName.sendKeys(person_name);
        WebElement com_surname = driver.findElement(By.xpath("//input[@placeholder='Surname ']"));
        com_surname.sendKeys(surname);
        WebElement com_name = driver.findElement(By.xpath("//input[@placeholder='Company Name']"));
        com_name.sendKeys(company_registration);
        WebElement com_registration = driver.findElement(By.xpath("//input[@placeholder='Company Registration Number']"));
        com_registration.sendKeys(company_registration);
        WebElement com_address = driver.findElement(By.xpath("//input[@placeholder='Company Address (Billing Address)']"));
        com_address.sendKeys(company_address);
        WebElement com_number = driver.findElement(By.xpath("//input[@placeholder='Business Contact Number']"));
        com_number.sendKeys(contact_number);
    }
}
