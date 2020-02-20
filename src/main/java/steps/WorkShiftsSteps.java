package steps;

import grids.WorkShiftGrid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import pageComponents.AddWorkShiftModalWindow;
import pageComponents.TimePicker;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static utils.SessionVariables.TIME_PICKER;
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


    @Step
    public void clickOnTheTimePickerIcon(){
        AddWorkShiftModalWindow addWorkShiftModalWindow = WORK_SHIFT_MODAL_WINDOW.get();
        addWorkShiftModalWindow.clickOnTheTimePicker();
    }

    @Step
    public void clickOnTheBottomTimePickerIcon(){
        AddWorkShiftModalWindow addWorkShiftModalWindow = WORK_SHIFT_MODAL_WINDOW.get();
        addWorkShiftModalWindow.clickOnTheBottomButtonTimePicker();
    }


    @Step
    public void setTimeFrom(String hours, String minutes){

        List<WebElementFacade> listHours = getTimePickerElement().getHoursBoard();
        for(WebElementFacade hour: listHours){
           if(hour.getText().equals(hours)){
               hour.waitUntilEnabled().waitUntilClickable().click();
           }
        }

        List<WebElementFacade> listMinutes = getTimePickerElement().getMinutesBoard();
        for(WebElementFacade m:listMinutes){
            if(m.waitUntilVisible().getText().equals(minutes)){
                m.waitUntilVisible().waitUntilClickable().click();
            }
        }


        TIME_PICKER.put(new TimePicker(workShiftPage.getTimePickerLocator()));
        TimePicker timePicker = TIME_PICKER.get();
        timePicker.clickToOkButton();

    }


}
