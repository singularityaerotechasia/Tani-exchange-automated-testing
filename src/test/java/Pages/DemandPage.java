package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemandPage {
    int wait=2;
    WebDriver driver;

    public DemandPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void my_demand_button(){
        WebElement my_demand_button = driver.findElement(By.xpath("//div[normalize-space()='My Demands']"));
        my_demand_button.click();
    }

    public void add_demand_button(){
        WebElement add_demand_button = driver.findElement(By.xpath("//button[contains(@type,'button')]"));
        add_demand_button.click();
    }

    public void demandform(String categories, String available_crop, String grades, String amount_required,
     String frequency,String delivery_one_off, String demand_period_start, String demand_period_end) {
        WebElement categories_field = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > select:nth-child(1)"));
        Select categories_dropdown = new Select(categories_field);
        // Select by visible text
        categories_dropdown.selectByVisibleText(categories);
        WebElement available_crop_field = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > select:nth-child(1)"));
        Select available_crop_dropdown = new Select(available_crop_field);
        // Select by visible text
        available_crop_dropdown.selectByVisibleText(available_crop);
        WebElement grades_field = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > select:nth-child(1)"));
        Select grades_dropdown = new Select(grades_field);
        // Select by visible text
        grades_dropdown.selectByVisibleText(grades);
        WebElement amount_required_field = driver.findElement(By.xpath("//input[@placeholder='Amount Required']"));
        amount_required_field.sendKeys(amount_required);
        WebElement frequencey_field = driver.findElement(By.cssSelector("div:nth-child(6) div:nth-child(2) select:nth-child(1)"));
        Select frequency_dropdown = new Select(frequencey_field);
        // Select by visible text
        frequency_dropdown.selectByVisibleText(frequency);
        WebElement delivery_one_off_field = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[2]/input[1]"));
        delivery_one_off_field.sendKeys(delivery_one_off);
        WebElement demand_period_start_field = driver.findElement(By.xpath("//div[contains(@class,'col-md-6 col-sm-6')]//input[contains(@placeholder,'Date Requirement Open')]"));
        demand_period_start_field.sendKeys(demand_period_start);
        WebElement demand_period_end_field = driver.findElement(By.xpath("//input[@placeholder='Date Requirement Close']"));
        demand_period_end_field.sendKeys(demand_period_end);
    }

    public void save_demand_button(){
        WebElement save_demand_button = driver.findElement(By.xpath("//button[@type='submit']"));
        save_demand_button.click();
    }

    public void upload_photo(String photoPath) throws AWTException,InterruptedException {
        WebElement upload_photo_button = driver.findElement(By.xpath("//div[contains(@class,'flex flex-col justify-center items-center bg-white rounded-md border-[.01rem] border-green-500 space-y-2')]//*[name()='svg']"));
        upload_photo_button.click();

        Robot robot=new Robot();

        // Create a file object
        File f = new File(photoPath);
        TimeUnit.SECONDS.sleep(3);

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        TimeUnit.SECONDS.sleep(3);

        //Store the path of the file to be uploaded using StringSelection class object
        StringSelection filepath =new StringSelection (""+ absolute);
        TimeUnit.SECONDS.sleep(3);

        //Copy above path to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents( filepath,null);
        TimeUnit.SECONDS.sleep(3);

        //Now press CTRL
        robot.keyPress (KeyEvent.VK_CONTROL);

        //Press V
        robot.keyPress(KeyEvent.VK_V);

        //Release V
        robot.keyRelease (KeyEvent.VK_V);

        //Release CTRL
        robot.keyRelease (KeyEvent.VK_CONTROL);

        //Press ENTER
        robot.keyPress (KeyEvent.VK_ENTER);

        //Release ENTER
        robot.keyRelease (KeyEvent.VK_ENTER); 
    }

    public void photo_description_button(){
        WebElement photo_description_button = driver.findElement(By.xpath("//button[@class='absolute top-2 left-2 fosuc:pointer-events-auto']//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]"));
        photo_description_button.click();
    }

    public void photodescriptionform(String date, String description) {
       WebElement date_field = driver.findElement(By.xpath("//input[@type='date']"));
       date_field.sendKeys(date);
       WebElement description_field = driver.findElement(By.xpath("//textarea[@placeholder='Add description here..']"));
       description_field.sendKeys(description);
    }

    public void edit_demand_button(){
        WebElement edit_demand_button = driver.findElement(By.xpath("//button[@class='hidden laptop:inline btn-border-green w-[120px]']"));
        edit_demand_button.click();
    }

    public void clear_demand_form() throws InterruptedException, AWTException{
        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Musang King']"));

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

    public void editdemandform(String product_name) {
        WebElement product_name_field = driver.findElement(By.xpath("//input[@type='text']"));
        product_name_field.sendKeys(product_name);
    }

    public void delete_demand_button(){
        WebElement delete_demand_button = driver.findElement(By.xpath("//button[contains(@class,'saveButton bg-red-500 hover:bg-red-600 hover:ring-2 hover:ring-red-600')]"));
        delete_demand_button.click();
    }
}
