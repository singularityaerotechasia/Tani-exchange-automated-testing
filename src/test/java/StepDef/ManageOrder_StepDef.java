package StepDef;
import Pages.IncomingOrderPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static StepDef.CommonDefinitions.driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class ManageOrder_StepDef {
    int wait=2;

    LoginPage loginPage;
    IncomingOrderPage incomingOrderPage;

    public ManageOrder_StepDef(){
        loginPage = new LoginPage(driver);
        incomingOrderPage = new IncomingOrderPage(driver);
    }

    @Given("User select My Account Farmer ReceiveOrder")
    public void user_select_My_Account() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        loginPage.click_Login();

        TimeUnit.SECONDS.sleep(wait);

        String username = "Admin";
        String password = "123456789";

        loginPage.Loginform(username, password);

        loginPage.next_button();

        TimeUnit.SECONDS.sleep(wait);
        loginPage.my_account_button();
    }

    @And("User select Incoming Order Farmer")
    public void user_select_incoming_order() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.incoming_order_button();
    }

    @And("User select chosen order details Farmer")
    public void user_select_chosen_order_details() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.details_button_farmer();
    }

    @And("User select start delivery Farmer")
    public void user_select_start_delivery() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300)");

        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.start_delivery_button();
    }

    public void switch_account_buyer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.switch_account_buyer_button();
    }

    @And("User select Incoming Order Buyer")
    public void user_select_incoming_order_buyer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        switch_account_buyer();

        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.my_order_button();
    }

    @And("User select chosen order details Buyer")
    public void user_select_chosen_order_details_buyer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.details_button_buyer();
    }

    @And("User select accept delivery Buyer")
    public void user_select_accept_delivery_buyer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300)");
        
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.accept_delivery_button();
    }

    public void switch_account_farmer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.switch_account_farmer_button();
    }

    @Then("User select done when order received Farmer")
    public void user_select_done_when_order_received_farmer() throws InterruptedException{
        TimeUnit.SECONDS.sleep(wait);
        switch_account_farmer();

        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.incoming_order_button();

        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.details_button_farmer();

        TimeUnit.SECONDS.sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        js.executeScript("window.scrollBy(0,300)");
        
        TimeUnit.SECONDS.sleep(wait);
        incomingOrderPage.accept_delivery_button();
    }
}
