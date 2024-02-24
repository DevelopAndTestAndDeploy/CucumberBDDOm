package awsomecucumber.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        glue = {"awsomecucumber"},
        features = {"src/test/resources/awsomecucumber"}
)

public class MyTestNgRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
