package steps;

import grids.UsersGrid;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pageComponents.FilterUsersModalWindow;
import pages.BasePage;

import java.util.List;

import static utils.SessionVariables.FILTER_USERS_WINDOW;

@Slf4j
public class UsersSteps extends DefaultStepsData {

    @Step
    public void openFilterWindow() {
        log.info("Opens Filter Users window");
        usersPage.clickOnFilterButton();
        FILTER_USERS_WINDOW.put(new FilterUsersModalWindow(usersPage.getFilterUsersModalWindow()));
    }

    @Step
    public FilterUsersModalWindow getFiltetUsersWindow() {
        return new FilterUsersModalWindow(usersPage.getFilterUsersModalWindow());
    }

    @Step
    public void clickOnTheSearchButton() {
        log.info("Clicking on the Search button");
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        filterUsersModalWindow.clickOnSearchButton();
    }

    @Step
    public void filterUsersByEmployeeName(String employeeName) {
        FilterUsersModalWindow filterUsersModalWindow = FILTER_USERS_WINDOW.get();
        log.info("Filtering by Employee Name: " + employeeName);
        log.info("Typing employee name into [Employee Name] input field");
        filterUsersModalWindow.getEmployeeNameField().waitUntilEnabled().sendKeys(employeeName);
        WebElementFacade employeeDropDown = filterUsersModalWindow.getEmployeeNameField().find(By.xpath("./..//div[contains(@class,'angucomplete-row')]"));
        log.info("Clicking on the autocomplete search result");
        employeeDropDown.waitUntilVisible().waitUntilClickable().click();
        employeeDropDown.waitUntilNotVisible();
    }

    @Step
    public List<UsersGrid> getUsersGrid() {
        log.info("Getting [Users] grid");
        return new UsersGrid().getAllItems(usersPage.getDriver());
    }

    @Step
    public void showListFilterStatusAndSwitchToDisabled(){
        log.info("Show list of status filter and Switch to Disabled");
        usersPage.clickOnFilterStatusButton();
        usersPage.getSelectFilterStatus().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

}

