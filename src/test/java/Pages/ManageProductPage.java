package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class ManageProductPage {
    WebDriver driver;
    int wait=3;
    
    public ManageProductPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void manage_product_btn(){
        WebElement manage_product_btn = driver.findElement(By.xpath("//div[normalize-space()='Manage Products']"));
        manage_product_btn.click();
    }

    public void add_new_product_btn(){
        WebElement add_new_product_btn = driver.findElement(By.xpath("//button[normalize-space()='Add New Product']"));
        add_new_product_btn.click();
    }

    public void save_add_product_btn(){
        WebElement save_add_product_btn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        save_add_product_btn.click();
    }

    public void add_product_form(String category, String origin, String crop, String grade, String quantity){
        WebElement farm_categories= driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > section:nth-child(2) > select:nth-child(2)"));
        Select categories_dropdown = new Select(farm_categories);
        // Select by visible text
        categories_dropdown.selectByVisibleText(category);
        WebElement farm_origin= driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > section:nth-child(3) > select:nth-child(2)"));
        Select farm_dropdown = new Select(farm_origin);
        // Select by visible text
        farm_dropdown.selectByVisibleText(origin);
        WebElement farm_crop= driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > section:nth-child(4) > select:nth-child(2)"));
        Select crop_dropdown = new Select(farm_crop);
        // Select by visible text
        crop_dropdown.selectByVisibleText(crop);
        WebElement grades= driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > section:nth-child(5) > select:nth-child(2)"));
        Select grades_dropdown = new Select(grades);
        // Select by visible text
        grades_dropdown.selectByVisibleText(grade);
        WebElement quantity_field = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/section[6]/input[1]"));
        quantity_field.sendKeys(quantity);
    }

    public void edit_product_btn(){
        WebElement edit_product_btn = driver.findElement(By.xpath("//section[contains(@class,'w-1/3 p-4 hidden productLarge:flex flex-row space-y-4 items-end justify-end gap-2')]//button[contains(@type,'button')][normalize-space()='Edit']"));
        edit_product_btn.click();
    }

    public void publish_btn(){
        WebElement publish_btn = driver.findElement(By.xpath("//button[normalize-space()='Publish']"));
        publish_btn.click();
    }

    public void upload_photo(String photoPath) throws AWTException,InterruptedException {
        WebElement photo_btn = driver.findElement(By.xpath("//*[name()='path' and contains(@fill,'currentCol')]"));
        photo_btn.click();

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

    public void save_product_btn(){
        WebElement save_add_product_btn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        save_add_product_btn.click();
    }

    public void add_image_description_btn(){
        WebElement add_image_description_btn = driver.findElement(By.xpath("//button[contains(@class,'absolute top-2 left-2 fosuc:pointer-events-auto')]//div//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]"));
        add_image_description_btn.click();
    }

    public void save_image_description_btn(){
        WebElement save_image_description_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        save_image_description_btn.click();
    }

    public void image_description_form(String date, String description){
        WebElement date_field = driver.findElement(By.xpath("//input[@type='date']"));
        date_field.sendKeys(date);
        WebElement description_field = driver.findElement(By.xpath("//textarea[@placeholder='Add description here..']"));
        description_field.sendKeys(description);
    }

    public void clear_product_form() throws InterruptedException, AWTException{
        WebElement inputField = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > section:nth-child(6) > div:nth-child(2) > input:nth-child(1)"));

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

    public void unpublish_btn(){
        WebElement unpublish_btn = driver.findElement(By.xpath("//button[contains(@class,'btn-border-red w-1/3 rounded-md')]"));
        unpublish_btn.click();
    }

    public void delete_btn(){
        WebElement unpublish_btn = driver.findElement(By.xpath("//button[contains(@class,'btn-border-red w-1/3 rounded-md')]"));
        unpublish_btn.click();
    }

    public void dismiss_button(){
        //WebElement open_farm_btn = driver.findElement(By.xpath("//div[@class='absolute w-full bottom-0 flex flex-col items-start p-2 rounded-b-md box-img-card-cursor']"));
        //open_farm_btn.click();
        Actions actions = new Actions(driver);

        WebElement dismiss_btn = driver.findElement(By.xpath("//button[@class='borderedButton']"));

        // Move the mouse to the center of the element
        actions.moveToElement(dismiss_btn);

        // Perform a mouse click on the element
        actions.click();

        // Compile the actions into a single step and execute them
        actions.build().perform();

    }
}
