package parallel;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/parallel",
        glue = "parallel",
        tags = "@1,@3"
)


public class RunnerTest extends AbstractTestNGCucumberTests{

    public static void main(String[] args) {

    }

}
