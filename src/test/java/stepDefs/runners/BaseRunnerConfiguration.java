package stepDefs.runners;

import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import resources.Constants;

import static net.thucydides.core.ThucydidesSystemProperty.*;

public class BaseRunnerConfiguration extends SerenityStories {

    private Configuration configuration;
    private EnvironmentVariables environmentVariables;

    public BaseRunnerConfiguration() {
        environmentVariables = WebDriverConfiguredEnvironment.getEnvironmentVariables();
        configuration = this.getSystemConfiguration();
        configuration.setIfUndefined(WEBDRIVER_DRIVER.getPropertyName(), "provided");
        configuration.setIfUndefined(WEBDRIVER_PROVIDED_TYPE.getPropertyName(), "mydriver");
        configuration.setIfUndefined("webdriver.provided.mydriver", "driverFactory.DriverManager");
        environmentVariables.setProperty(WEBDRIVER_BASE_URL.getPropertyName(), Constants.BASE_URL);
        configuration.setIfUndefined(SERENITY_LOGGING.getPropertyName(), "QUIET");
    }
}
