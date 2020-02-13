package pages;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class EmployeeTimeSheetsPage extends BasePage{

    @FindBy(css = "#x_report_employeeId_empName")
    private WebElementFacade searchInputField;

    @FindBy(css = ".ac_results li")
    private WebElementFacade employeeNameAutoCompleteElement;

    /*public void switchToIframe(){
      getDriver().switchTo().frame("noncoreIframe");
    }
*/
}
