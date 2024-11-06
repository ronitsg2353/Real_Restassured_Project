import io.cucumber.core.gherkin.Feature;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.awt.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature",
        monochrome = true,
        tags = "@test3",
        glue = {"StepDefinition"}


)
public class TestRunner {
}
