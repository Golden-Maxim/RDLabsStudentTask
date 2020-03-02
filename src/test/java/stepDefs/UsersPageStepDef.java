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

import static utils.SessionVariables.*;


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

    @Then("Filter user by $select with option $value")
    public void filterUserByStatus(String selectValue,String option) {
        if (selectValue.equals("Status")){
            usersSteps.switchFilter(selectValue);
            STATUS_DISABLED.put(option);
        }else if(selectValue.equals("Admin Role")){
            usersSteps.switchFilter(selectValue);
            STATUS_GLOBAL_ADMIN.put(option);
        }else throw new IllegalStateException("Unexpected value");

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

    @Then("Check that previously entered values saved in Status and Admin Role selects")
    public void checkThatPreviouslyValuesIsSaved() {
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        String statusDisabled = STATUS_DISABLED.get();
        String statusGlobalAdmin = STATUS_GLOBAL_ADMIN.get();
        softly.assertThat(filterUsersModalWindow.getStatus().getValue()).isEqualTo(statusDisabled);
        softly.assertThat(filterUsersModalWindow.getAdminRole().getValue()).isEqualTo(statusGlobalAdmin);
    }

}