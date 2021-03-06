package steps;

import emuns.ItemsContainer;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;

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
    public String getTextFromHeader(String nameHeader) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(nameHeader);
        switch (itemsContainer) {
            case NEWS:
                return dashboardPage.getHeaderOfSectionNews().getText();
            case DOCUMENTS:
                return dashboardPage.getHeaderOfSectionDocuments().getText();
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }

    @Step
    public int getCountItemsList(String listOf) {
        return dashboardPage.getRealCountOf(listOf);
    }

    @Step
    public int getValueUnderSection(String section) {
        String countText;
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(section);
        switch (itemsContainer) {
            case NEWS:
                countText = dashboardPage.getShowingNumberNews().getText().split("/")[1].trim();
                return Integer.parseInt(countText);
            case DOCUMENTS:
                countText = dashboardPage.getShowingNumberOfDocuments().getText().split("/")[1].trim();
                return Integer.parseInt(countText);
            default:
                throw new IllegalStateException("Unexpected value: " + itemsContainer);
        }
    }


}
