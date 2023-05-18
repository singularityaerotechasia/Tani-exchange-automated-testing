package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions (plugin = {"pretty"}, tags = "@EditAccountBuyer", features = "src/test/Features", glue = "StepDef")
 //kalau nak run banyak just put tag dekat step def java. and tulis dekat sini
public class RunnerClass extends AbstractTestNGCucumberTests {
}


