package stepDefs;

import emuns.ItemsContainer;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.CommonSteps;
import steps.DashboardPageSteps;
import steps.DefaultStepsData;

public class DashboardPageStepDef extends DefaultStepsData {

    @Steps
    private DashboardPageSteps dashboardPageSteps;
    @Steps
    private CommonSteps commonSteps;

    @Then("dashboard page opens with account name $userName")
    public void checkThatDashboardPageOpens(String userName) {
        softly.assertThat(dashboardPageSteps.getDashBoardPageTitle())
                .as("Wrong page title")
                .isEqualTo(dashboardPage.getTitle());
        softly.assertThat(dashboardPageSteps.getAccountNameFromDashboard())
                .as("Wrong account name is shown on page")
                .isEqualTo(userName);
    }

    @When("I click on hide menu button")
    @Alias("I click on show menu button")
    public void whenClickOnTheHideMenuButton() {
        dashboardPageSteps.clickOnHideMenuButton();
    }

    @Then("main menu $condition")
    public void mainMenuCondition(String condition) {
        String warningMessage = "Menu not " + condition + " after clicking on the hide/show menu button";
        if (condition.equals("disappear")) {
            softly.assertThat(commonSteps.isMenuAvatarVisibleNow()).as(warningMessage).isFalse();
        }
    }

    @When("I click on the three dots button inside $sectionName section")
    public void clickOnThreeDotsButton(String sectionName) {
        dashboardPageSteps.expandContainerClickingOnThreeDots(sectionName);
    }

    @Then("Legend component appears in $sectionName section")
    public void checkThatLegendAppears(String sectionName) {
        softly.assertThat(dashboardPageSteps.checkThatLegendAppearsIn(sectionName)).as("Legend component not appers").isTrue();
    }

    @Then("I check that $section section is present on Dashboard page with header $name")
    public void sectionIsPresentOnDashboard(String header) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(header);
        switch (itemsContainer){
            case NEWS:
                softly.assertThat(dashboardPageSteps.getTextFromHeader("News")).isEqualTo(header);
                break;
            case DOCUMENTS:
                softly.assertThat(dashboardPageSteps.getTextFromHeader("Documents")).isEqualTo(header);
                break;
            default:
                System.out.println("Is not valid Header!!!");
        }

    }

    @Then("I check that news counter (Showing: number / number) under $name section is same as real amount of news in list")
    public void equalsCountersToList(String section) {
        ItemsContainer itemsContainer = ItemsContainer.getItemsContainerName(section);
        switch (itemsContainer){
            case NEWS:
                softly.assertThat(dashboardPageSteps.getCountItemsList("News")).isEqualTo(dashboardPageSteps.getValueUnderSection("News"));
                break;
            case DOCUMENTS:
                softly.assertThat(dashboardPageSteps.getCountItemsList("Documents")).isEqualTo(dashboardPageSteps.getValueUnderSection("Documents"));
                break;
            default:
                System.out.println("Is not valid section name!!!");
        }

    }

}
