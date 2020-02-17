package pages;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class DashboardPage extends BasePage {

    public static final String PAGE_TITLE = "OrangeHRM";

    @FindBy(css = "#account-name")
    private WebElementFacade accountNameLabel;

    @FindBy(xpath = "//a[@id='side-menu-hamburger']")
    private WebElementFacade hideMenuButton;

    @FindBy(css = "#dashboard__viewNewsOnDashboard")
    private WebElementFacade newsContainer;

    @FindBy(css = "#dashboard__viewDocumentsOnDashboard")
    private WebElementFacade documentsContainer;

    @FindBy(css = ".card-content .material-icons")
    private WebElementFacade threeDotsButtonEmployee;

    @FindBy(xpath = "//div[contains(@class,'card-content')]//i[contains(@class,'material-icons right')]")
    private WebElementFacade threeDotsButtonLeaves;

    @FindBy(css = "#task-list-group-panel-menu_holder-legend")
    private WebElementFacade employeeLegend;

    @FindBy(css = "#legend")
    private WebElementFacade leavesLegend;

    @FindBy(xpath = "//div[@id = 'panel_draggable_2_9']//div[@class = 'dashboardCard-title-for-card']")
    private WebElementFacade headerOfSectionNews;

    @FindBy(xpath = "//div[contains(@id,'newsOnDashboard')]//ul/li")
    private List<WebElementFacade> countOfNews;

    @FindBy(xpath = "//*[@id=\"dashboard__viewNewsOnDashboard\"]/div[2]/div[2]")
    private WebElementFacade showingNumber;

    public void clickOnHideMenuButton() {
        log.info("Clicking on the [Hide menu] button");
        hideMenuButton.waitUntilVisible().waitUntilClickable().click();
    }


}
