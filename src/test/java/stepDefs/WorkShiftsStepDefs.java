package stepDefs;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.WorkShiftsSteps;

public class WorkShiftsStepDefs extends DefaultStepsData {

    @Steps
    private WorkShiftsSteps workShiftsSteps;

    @When("I click on Add Work Shift button")
    public void clickOnAddWorkShiftButton() {
        workShiftsSteps.clickOnAddWorkShiftButton();
    }

    @Then("Check that rows with values $General, $Twilight in WorkShift column are shown by default")
    public void checkDefaultValues(String general, String twilight) {
        softly.assertThat(workShiftsSteps.checkWorkShiftColumn()).contains(general, twilight);
    }

    @When("I click on Save button in Add Work Shift window")
    public void clickOnSaveButtonInAddWorkShiftWindow() {
        workShiftsSteps.workShiftClickOnTheSaveButton();
    }

    @Then("I check that $Required error message is shown under Work Shift field")
    public void checkErrorMessage(String message) {
        softly.assertThat(workShiftsSteps.messageUnderWorkShift()).isEqualTo(message);
    }
}
