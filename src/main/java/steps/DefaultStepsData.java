package steps;

import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.AfterScenario;
import pages.*;

public class DefaultStepsData extends ScenarioSteps {

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
