package steps;

import emuns.ItemsContainer;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import sun.awt.windows.WEmbeddedFrame;

@Slf4j
public class DashboardPageSteps extends DefaultStepsData {

    @Step
    public String getDashBoardPageTitle() {
        return dashboardPage.getTitle();
    }

    @Step
    public String getAccountNameFromDashboard() {
        return dashboardPage.getAccountNameLabel().getText();
    }

    @Step
    public void clickOnHideMenuButton() {
        dashboardPage.clickOnHideMenuButton();
    }

    @Step
    public void expandContainerClickingOnThreeDots(String sectionName) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        switch (itemsContainer) {
            case EMPLOYEE_DISTRIBUTION:
                dashboardPage.getThreeDotsButtonEmployee().waitUntilEnabled().click();
                break;
            case LEAVE_TAKEN:
                dashboardPage.getThreeDotsButtonLeaves().waitUntilEnabled().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }
    @Step
    public boolean checkThatLegendAppearsIn(String sectionName) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(sectionName);
        switch (itemsContainer) {
            case EMPLOYEE_DISTRIBUTION:
                return dashboardPage.getEmployeeLegend().isVisible();
            case LEAVE_TAKEN:
                return dashboardPage.getLeavesLegend().isVisible();
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }
    @Step
    public String getHeaderOfNewSection(){
       return dashboardPage.getHeaderOfSectionNews().getText();
    }

    @Step
    public String getHeaderOfDocuments(){
        return dashboardPage.getHeaderOfSectionDocuments().getText();
    }
    @Step
    public int getCountItemsListOfNews() {
        int count = 0;
        for (WebElement element:dashboardPage.getCountOfNews()){
            count++;
        }
        return count;
    }
    @Step
    public int getCountItemsListOfDocuments() {
        int count = 0;
        for (WebElement element:dashboardPage.getCountOfDocuments()){
            count++;
        }
        return count;
    }
    @Step
    public int getValueUnderNews(){
        String number = dashboardPage.getShowingNumber().getText().split("/")[1].trim();
        return Integer.parseInt(number);
    }

    @Step
    public int getValueUnderDocuments(){
        String number = dashboardPage.getShowingNumberOfDocuments().getText().split("/")[1].trim();
        return Integer.parseInt(number);
    }



}
