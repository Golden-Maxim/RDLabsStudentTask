package stepDefs.runners;

import net.serenitybdd.jbehave.annotations.Metafilter;


//https://jbehave.org/reference/latest/meta-filtering.html
@Metafilter("+regression +newTask")
public class RegressionRunner extends BaseRunnerConfiguration {
}
