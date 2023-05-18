package Pages;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ManageFarmPage {
    int wait=2;
    WebDriver driver;

    public ManageFarmPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void addFarm_btn(){
        WebElement addFarm_btn = driver.findElement(By.xpath("//button[contains(@class,'min-w-[12rem] w-full min-h-[12rem] h-full flex flex-col justify-center items-center bg-white rounded-md border-[.01rem] border-green-500 space-y-2')]//*[name()='svg']"));
        addFarm_btn.click();
    }

    public void Farmform(String name, String address) {
        WebElement farm_name = driver.findElement(By.xpath("//input[@placeholder='Farm Name']"));
        farm_name.sendKeys(name);
        WebElement farm_adress = driver.findElement(By.xpath("//input[@placeholder='Farm Address']"));
        farm_adress.sendKeys(address);
    }

    public void editform(String name) {
        WebElement farm_name = driver.findElement(By.xpath("//div[4]//div[1]//input[1]"));
        farm_name.sendKeys(name);
    }

    public void save_form_btn(){
        WebElement save_btn = driver.findElement(By.xpath("//button[@type='submit']"));
        save_btn.click();
    }

    public void clearform() {
        WebElement farm_name = driver.findElement(By.xpath("//input[@placeholder='Farm Name']"));
        farm_name.clear();
        WebElement farm_adress = driver.findElement(By.xpath("//input[@placeholder='Farm Address']"));
        farm_adress.clear();
    }

    public void upload_certificate(String certificatePath) throws AWTException,InterruptedException {
        WebElement certificate_btn = driver.findElement(By.xpath("//label[normalize-space()='Upload Certificate']"));
        certificate_btn.click();

        Robot robot=new Robot();

        // Create a file object
        File f = new File(certificatePath);
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
    
    public void upload_farm_photos(String photoPath) throws AWTException,InterruptedException {
        WebElement photo_btn = driver.findElement(By.xpath("//label[normalize-space()='Upload Photos']"));
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
    
    public void save_upload_btn(){
        WebElement save_btn = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        save_btn.click();
    }

    public void clearUpload() {
        WebElement certificate_btn = driver.findElement(By.xpath("//label[normalize-space()='Upload Certificate']"));
        certificate_btn.clear();
        WebElement photo_btn = driver.findElement(By.xpath("//label[normalize-space()='Upload Photos']"));
        photo_btn.clear();
    }

    public void add_plot_btn(){
        WebElement add_plot_btn = driver.findElement(By.xpath("//button[normalize-space()='Add Plot']"));
        add_plot_btn.click();
    }

    public void crop_btn(){
        WebElement crop_btn = driver.findElement(By.xpath("//button[@class='w-full laptop:w-[16rem] wide:w-[16rem] btn-border-green bg-white']"));
        crop_btn.click();
    }

    public void crop_and_stock_form(String name2) {
        WebElement crop_name = driver.findElement(By.xpath("//input[@placeholder='Crop Name']"));
        crop_name.sendKeys(name2);
        WebElement grade_btn = driver.findElement(By.xpath("//select[@class='input-search']"));
        Select dropdown = new Select(grade_btn);
        // Select by visible text
        dropdown.selectByVisibleText("fruits");
    }

    public void collection_center_form(String name) {
        WebElement cc_name = driver.findElement(By.xpath("//input[@placeholder='Collection Center Name']"));
        cc_name.sendKeys(name);
    }

    public void add_crop_btn(){
        WebElement add_crop_btn = driver.findElement(By.xpath("//button[@class='btn-home btn-browser-product laptop:w-[12rem] wide:w-[12rem]']"));
        add_crop_btn.click();
    }

    public void add_grade_btn(){
        WebElement add_grade_btn = driver.findElement(By.xpath("//div[@class='w-full text-left']//*[name()='svg']"));
        add_grade_btn.click();
    }

    public void grade_form(String grade_name, String grade_criteria, String price, String currency, String stock) {
        WebElement grade_name_field = driver.findElement(By.xpath("//input[@placeholder='Grade Name']"));
        grade_name_field.sendKeys(grade_name);
        WebElement grade_criteria_field = driver.findElement(By.xpath("//input[@placeholder='Grade Criteria']"));
        grade_criteria_field.sendKeys(grade_criteria);
        WebElement price_field = driver.findElement(By.xpath("//input[@placeholder='Price per unit']"));
        price_field.sendKeys(price);
        WebElement currency_field = driver.findElement(By.xpath("//select[@class='select-options input-search']"));
        Select currency_dropdown = new Select(currency_field);
        // Select by visible text
        currency_dropdown.selectByVisibleText(currency);
        WebElement stock_field = driver.findElement(By.xpath("//input[@placeholder='Available Stock']"));
        stock_field.sendKeys(price);
    }

    public void go_back_crop_button(){
        WebElement go_back_plot_btn = driver.findElement(By.xpath("//label[@class='cursor-pointer head-bar-nav']"));
        go_back_plot_btn.click();
    }

    public void delete_crop_button(){
        WebElement delete_crop_btn = driver.findElement(By.xpath("//body/div/div/div/div/div/div/form/div/div[3]/div[1]/div[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]"));
        delete_crop_btn.click();
    }

    public void open_farm_button(){
        //WebElement open_farm_btn = driver.findElement(By.xpath("//div[@class='absolute w-full bottom-0 flex flex-col items-start p-2 rounded-b-md box-img-card-cursor']"));
        //open_farm_btn.click();
        Actions actions = new Actions(driver);

        WebElement open_farm_btn = driver.findElement(By.xpath("//div[@class='absolute w-full bottom-0 flex flex-col items-start p-2 rounded-b-md box-img-card-cursor']"));

        // Move the mouse to the center of the element
        actions.moveToElement(open_farm_btn);

        // Perform a mouse click on the element
        actions.click();

        // Compile the actions into a single step and execute them
        actions.build().perform();

    }

    public void clear_farm_name() throws AWTException, InterruptedException{
        WebElement inputField = driver.findElement(By.xpath("//div[4]//div[1]//input[1]"));

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

    public void clear_crop_form() throws InterruptedException, AWTException {
        WebElement cc_name = driver.findElement(By.xpath("//input[@placeholder='Collection Center Name']"));

        // Click on the input field to focus it
        cc_name.click();

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

    public void edit_crop_form(String name) {
        WebElement cc_name = driver.findElement(By.xpath("//input[@placeholder='Collection Center Name']"));
        cc_name.sendKeys(name);
    }

    public void plot_form(String plot_name, String crop_name, String crop_stage, String planning_start_date, String harvesting_start_date, 
    String harvesting_end_date, String expected_harvesting_quantity, String expected_harvesting_quantity_unit) {
        WebElement plot_name_field = driver.findElement(By.xpath("//input[@placeholder='Plot Name']"));
        plot_name_field.sendKeys(plot_name);
        WebElement crop_name_field = driver.findElement(By.xpath("//select[@class='input-search']"));
        Select crop_dropdown = new Select(crop_name_field);
        // Select by visible text
        crop_dropdown.selectByVisibleText(crop_name);
        WebElement crop_stage_field = driver.findElement(By.xpath("//input[@placeholder='Stage of the crop']"));
        crop_stage_field.sendKeys(crop_stage);
        WebElement planning_start_date_field = driver.findElement(By.xpath("//input[@placeholder='Planting Start Date']"));
        planning_start_date_field.sendKeys(planning_start_date);
        WebElement harvesting_start_date_field = driver.findElement(By.xpath("//input[@placeholder='Harvesting Start Date']"));
        harvesting_start_date_field.sendKeys(harvesting_start_date);
        WebElement harvesting_end_date_field = driver.findElement(By.xpath("//input[@placeholder='Harvesting End Date']"));
        harvesting_end_date_field.sendKeys(harvesting_end_date);
        WebElement expected_harvesting_quantity_field = driver.findElement(By.xpath("//input[@placeholder='Quantity']"));
        expected_harvesting_quantity_field.sendKeys(expected_harvesting_quantity);
        WebElement expected_harvesting_unit_field = driver.findElement(By.xpath("//select[@class='input-search w-1/3']"));
        Select crop_dexpected_harvesting_unit_dropdown = new Select(expected_harvesting_unit_field);
        // Select by visible text
        crop_dexpected_harvesting_unit_dropdown.selectByVisibleText(expected_harvesting_quantity_unit);
    }

    public void save_plot_btn(){
        WebElement save_plot_btn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        save_plot_btn.click();
    }

    public void upload_crop_photos(String photoPath) throws AWTException,InterruptedException {
        WebElement photo_btn = driver.findElement(By.xpath("//label[@class='cursor-pointer text-sm']"));
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

    public void plot_btn(){
        WebElement plot_btn = driver.findElement(By.xpath("//section[@class='absolute bg-black/50 text-white left-0 bottom-0 rounded-b-lg flex flex-col w-full h-1/4 p-2 box-img-card-70']"));
        plot_btn.click();
    }

    public void edit_plot_form(String plot_name) {
        WebElement plot_name_field = driver.findElement(By.xpath("//input[@placeholder='Plot Name']"));
        plot_name_field.sendKeys(plot_name);
    }

    public void clear_plot_form() throws InterruptedException, AWTException {
        WebElement plot_name_field = driver.findElement(By.xpath("//input[@placeholder='Plot Name']"));
        // Click on the input field to focus it
        plot_name_field.click();

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

    public void delete_plot_btn(){
        WebElement delete_plot_btn = driver.findElement(By.xpath("//button[@class='saveButton bg-red-500 hover:bg-red-600 hover:ring-red-600']"));
        delete_plot_btn.click();
    }

    public void delete_farm_button(){
        WebElement delete_farm_btn = driver.findElement(By.xpath("//button[normalize-space()='Delete Farm']"));
        delete_farm_btn.click();
    }

    public void clear_grade_form() throws InterruptedException, AWTException {
        WebElement grade_name_field = driver.findElement(By.xpath("//input[@placeholder='Grade Name']"));
        // Click on the input field to focus it
        grade_name_field.click();

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

    public void edit_grade_form(String grade_name) {
        WebElement grade_name_field = driver.findElement(By.xpath("//input[@placeholder='Grade Name']"));
        grade_name_field.sendKeys(grade_name);
    }

    public void delete_grade_button(){
        WebElement delete_grade_button = driver.findElement(By.xpath("//div[@class='flex flex-col space-y-4 self-center w-full mb-5']//div[@class='flex flex-row space-x-8 relative']//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]"));
        delete_grade_button.click();
    }
}
