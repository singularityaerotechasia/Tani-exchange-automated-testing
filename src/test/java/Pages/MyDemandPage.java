package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyDemandPage {
    int wait=2;
    WebDriver driver;

    public MyDemandPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void market_demand_button(){
        WebElement my_demand_button = driver.findElement(By.xpath("//label[normalize-space()='Market Demand']"));
        my_demand_button.click();
    }

    public void my_demand_button(){
        WebElement my_demand_button = driver.findElement(By.xpath("//div[normalize-space()='My Demands']"));
        my_demand_button.click();
    }

    public void select_demand_button(){
        WebElement select_demand_button = driver.findElement(By.xpath("//div[contains(@class,'p-3')]//div[1]//img[1]"));
        select_demand_button.click();
    }

    public void apply_demand_button(){
        WebElement apply_demand_button = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        apply_demand_button.click();
    }

    public void gradedemandform(String grade_demand){
        WebElement grade_demand_field = driver.findElement(By.xpath("//select[@class='select-grade']"));
        Select grade_demand_dropdown = new Select(grade_demand_field);
        // Select by visible text
        grade_demand_dropdown.selectByVisibleText(grade_demand);
    }

    public void go_back_demand_market_button(){
        WebElement go_back_demand_market_button = driver.findElement(By.xpath("//button[@class='btn-border-green']"));
        go_back_demand_market_button.click();
    }

    public void go_back_view_farm_button(){
        WebElement go_back_view_farm_button = driver.findElement(By.xpath("//label[@class='cursor-pointer head-bar-nav']"));
        go_back_view_farm_button.click();
    }

    public void details_demand_button(){
        WebElement details_demand_button = driver.findElement(By.xpath("//body//div//div[contains(@data-testid,'order-list')]//div//div//div[2]//div[1]//section[4]//button[2]"));
        details_demand_button.click();
    }

    public void view_farm_demand_button(){
        WebElement view_farm_demand_button = driver.findElement(By.xpath("//button[contains(@class,'btn-border-green')]"));
        view_farm_demand_button.click();
    }

    public void accept_demand_button(){
        WebElement accept_demand_button = driver.findElement(By.xpath("//button[@class='saveButton']"));
        accept_demand_button.click();
    }
}
