package stepDefs;

import grids.WorkShiftGrid;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.DefaultStepsData;
import steps.WorkShiftsSteps;

import java.util.List;

public class WorkShiftsStepDefs extends DefaultStepsData {

    @Steps
    private WorkShiftsSteps workShiftsSteps;

    @When("I click on Add Work Shift button")
    public void clickOnAddWorkShiftButton() {
        workShiftsSteps.clickOnAddWorkShiftButton();
    }

    @Then("Check that rows with values $General, $Twilight in WorkShift column are shown by default")
    public void  checkDefaultValues(String general, String twilight){
        workShiftsSteps.test();
    }
}
