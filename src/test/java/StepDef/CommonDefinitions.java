package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CommonDefinitions {
    public static WebDriver driver;

    @Before
    public void setup() {
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //Firefox Webdriver
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver.exe");
////        System.setProperty("webdriver.firefox.bin", "C:/Program Files/Mozilla Firefox/firefox.exe/");
////        driver = new FirefoxDriver();
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //Microsoft Edge Webdriver
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe");
////        driver = new EdgeDriver();
//
//
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //Chrome Webdriver
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // Map<String, Object> mobileEmulation = new HashMap<>();
        // mobileEmulation.put("deviceName", "Samsung Galaxy S20 Ultra");

        System.setProperty("webdriver.chrome.driver","C:/Users/SharzKim/coding/automate_testing/TaniExchange_AutomateTesting/src/Drivers/chromedriver13.exe");
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*");
        //chromeOption.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOption);
        
        //web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.navigate().to("http://tani-exchange-web.test:3000/");

        //mobile
        //Get the screen resolution
        // java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // int screenWidth = (int) screenSize.getWidth();
        // int screenHeight = (int) screenSize.getHeight();

        // //Center the browser window on the screen
        // int windowX = (screenWidth - (int) 412) / 2;
        // int windowY = (screenHeight - (int) 915) / 2;

        // driver.manage().window().setPosition(new Point(windowX, windowY));
        // driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension((int) 412, (int) 915));
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // driver.navigate().to("http://tani-exchange-web.test:3000/");
       }

    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
              }
            else{
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}