package steps;

import grids.WorkShiftGrid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import pageComponents.AddWorkShiftModalWindow;
import pageComponents.TimePicker;

import java.util.ArrayList;
import java.util.List;

import static utils.SessionVariables.WORK_SHIFT_MODAL_WINDOW;

@Getter
@Slf4j
public class WorkShiftsSteps extends DefaultStepsData {

    @Step
    public List<WorkShiftGrid> getWorkShiftGrid() {
        log.info("Getting Work Shift table from Work Shifts page");
        return new WorkShiftGrid().getAllItems(getDriver());
    }

    @Step
    public void clickOnAddWorkShiftButton() {
        log.info("Clicking on the [Add work shift] button");
        workShiftPage.getAddWorkShiftButton().waitUntilClickable().click();
        WORK_SHIFT_MODAL_WINDOW.put(new AddWorkShiftModalWindow(workShiftPage.getAddWorkShiftWindow()));
    }

    @Step
    private AddWorkShiftModalWindow getAddWorkShiftModalWindow() {
        return new AddWorkShiftModalWindow(workShiftPage.getAddWorkShiftWindow());
    }

    @Step
    private TimePicker getTimePickerElement() {
        return new TimePicker(workShiftPage.getTimePickerLocator());
    }

    @Step
    public List<String> checkWorkShiftColumn() {
        List<String> valuesOfWorkShiftColumn = new ArrayList<>();
        List<WorkShiftGrid> allItems = getWorkShiftGrid();
        for (WorkShiftGrid single : allItems) {
            if (single.getWorkShift().equals("General") || single.getWorkShift().equals("Twilight")) {
                valuesOfWorkShiftColumn.add(single.getWorkShift());
            }
        }
        return valuesOfWorkShiftColumn;
    }

    @Step
    public void workShiftClickOnTheSaveButton() {
        AddWorkShiftModalWindow addWorkShiftModalWindow = WORK_SHIFT_MODAL_WINDOW.get();
        addWorkShiftModalWindow.clickOnTheSafeButton();
    }

    @Step
    public String messageUnderWorkShift() {
        AddWorkShiftModalWindow addWorkShiftModalWindow = WORK_SHIFT_MODAL_WINDOW.get();
        return addWorkShiftModalWindow.getAddWorkShiftModal().find(By.xpath("//div[contains(@class,'input-field col s12 m12 l12')]//span[text() = 'Required']")).getText();
    }


}
