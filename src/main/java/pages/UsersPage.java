package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

@Getter
@Slf4j
public class UsersPage extends BasePage {

    @FindBy(xpath = "//a[@data-tooltip='Filter']")
    private WebElementFacade filterButton;
    @FindBy(xpath = "//*[@id=\"status_inputfileddiv\"]/div/input")
    WebElementFacade selectFilterStatus;


    public void clickOnFilterButton() {
        log.info("Clicking on the [Filter button]");
        filterButton.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible();
        waitUntilSpinnerGone(3);
        filterButton.withTimeoutOf(Duration.ofSeconds(15)).waitUntilVisible().waitUntilEnabled().waitUntilClickable().click();
    }

    public void clickOnFilterStatusButton(){
        log.info("Clicking on the [Filter Status]");
        selectFilterStatus.click();
        //((JavascriptExecutor)getDriver()).executeScript("document.querySelectorAll('#status > option:nth-child(3)')[2]");

    }
}
