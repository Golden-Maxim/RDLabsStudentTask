package steps;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.NoSuchFrameException;

import java.time.Duration;
import java.util.regex.Pattern;

@Getter
@Slf4j
public class EmployeeTimeSheetsSteps extends DefaultStepsData {

    @Step
    public void searchByEmployeeName(String name) {
        try {
            employeeTimeSheetsPage.switchToIframe();
        }catch (NoSuchFrameException exception){
            System.out.println("Iframe is not found!");
        }
        employeeTimeSheetsPage.getSearchInputField().waitUntilEnabled().click();
        employeeTimeSheetsPage.getSearchInputField().clear();
        log.info("Searching by name: " + name);
        employeeTimeSheetsPage.getSearchInputField().sendKeys(name);
    }

    @Step
    public String getTextFromAutoCompleteNameField() {
        return employeeTimeSheetsPage.getEmployeeNameAutoCompleteElement().withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().getText();
    }
}
