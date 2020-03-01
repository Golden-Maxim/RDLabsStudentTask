package stepDefs;

import grids.UsersGrid;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import pageComponents.FilterUsersModalWindow;
import steps.DefaultStepsData;
import steps.UsersSteps;

import java.util.List;
import java.util.Map;

import static utils.SessionVariables.FILTER_USERS_WINDOW;

public class UsersPageStepDef extends DefaultStepsData {

    @Steps
    private UsersSteps usersSteps;

    @When("filter users by Employee Name $userName")
    public void filterUsersByEmployeeName(String employeeName) {
        usersSteps.filterUsersByEmployeeName(employeeName);
    }

    @Then("record is shown with following parameters:$table")
    public void checkResultOfFiltering(ExamplesTable examplesTable) {
        Map<String, String> row = examplesTable.getRow(0);
        List<UsersGrid> allItems = usersSteps.getUsersGrid();
        softly.assertThat(allItems).as("Wrong search result size is shown").hasSize(1);
        softly.assertThat(allItems.get(0).getUserName()).as("Wrong [Username] is shown").isEqualTo(row.get("Username"));
        softly.assertThat(allItems.get(0).getUserRole()).as("Wrong [User Role(s)] is shown").isEqualTo(row.get("User Role(s)"));
        softly.assertThat(allItems.get(0).getEmployeeName()).as("Wrong [Employee Name] is shown").isEqualTo(row.get("Employee Name"));
        softly.assertThat(allItems.get(0).getStatus()).as("Wrong [Status] is shown").isEqualTo(row.get("Status"));
        softly.assertThat(allItems.get(0).getRegions()).as("Region field is not empty").isEqualTo(row.get("Region"));
    }

    @When("I open filter users window")
    public void openFilterUsersWindow() {
        usersSteps.openFilterWindow();
    }

    @When("I click on the Search button in Filter Users window")
    public void clickOnTheSearchButtonInFilterUsersWindow() {
        usersSteps.clickOnTheSearchButton();
    }

    @Then("Filter user by $Status with option Disabled")
    public void filterUserByStatusDisabled(String value) {
        usersSteps.switchFilter(value);
    }

    @When("I click on the Search button")
    public void clickSearchButton() {
        usersSteps.clickOnTheSearchButton();
    }

    @Then("I check that employee with name $name is $condition in the search result")
    public void checkThatEmployeeNotShowm(String name, String condition) {
        if (condition.contains("NOT")) {
            softly.assertThat(usersSteps.employeeIsShown(name)).isEqualTo(false);
        } else {
            softly.assertThat(usersSteps.employeeIsShown(name)).isEqualTo(true);
        }
    }

    @Then("Filter user by $parameter with option Global Admin")
    public void filterUserByAdminRole(String value) {
        usersSteps.switchFilter(value);
    }

    @When("Click on the Filter users button again")
    public void againOpenFilterWindow() {
        usersSteps.openFilterWindow();
    }

    @Then("Check that previously entered values $values1 and $values2 saved in Status and Admin Role selects")
    public void checkThatPreviouslyValuesIsSaved(String values1,String values2) {
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        softly.assertThat(filterUsersModalWindow.getStatus().getValue()).isEqualTo(values1);
        softly.assertThat(filterUsersModalWindow.getAdminRole().getValue()).isEqualTo(values2);

    }
}