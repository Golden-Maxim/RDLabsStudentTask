package steps;

import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.AfterScenario;
import pages.*;

public class DefaultStepsData extends ScenarioSteps {

    //https://joel-costigliola.github.io/assertj/core/api/org/assertj/core/api/SoftAssertions.html
    //https://blog.codeleak.pl/2015/09/assertjs-softassertions-do-we-need-them.html

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected PersonalDetailsPage personalDetailsPage;
    protected UsersPage usersPage;
    protected MyGoalsPage myGoalsPage;
    protected WorkShiftPage workShiftPage;
    protected EmployeeTimeSheetsPage employeeTimeSheetsPage;

    protected SoftAssertions softly = new SoftAssertions();

    @AfterScenario
    public void softlyAssertAll() {
        softly.assertAll();
    }
}
