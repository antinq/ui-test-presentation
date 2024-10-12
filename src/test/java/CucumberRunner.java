import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsons/report.json"}
        ,
        features = "features/google_searsh_scenario.feature"
        ,
        glue = {"com/presentation/stepdefs"}
)
public class CucumberRunner {

}
