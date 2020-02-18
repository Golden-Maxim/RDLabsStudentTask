package pages;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.IterableUtil.sizeOf;


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

    private By countOfNews = By.xpath("//div[contains(@id,'newsOnDashboard')]//ul/li");

    @FindBy(xpath = "//*[@id=\"dashboard__viewNewsOnDashboard\"]/div[2]/div[2]")
    private WebElementFacade showingNumberNews;

    @FindBy(xpath = "//div[@id = 'panel_draggable_2_8']//div[@class = 'dashboardCard-title-for-card']")
    private WebElementFacade headerOfSectionDocuments;

    private By countOfDocuments = By.xpath("//div[contains(@id,'documentsOnDashboard')]//ul/li");

    @FindBy(xpath = "//*[@id=\"dashboard__viewDocumentsOnDashboard\"]/div[2]/div[2]")
    private WebElementFacade showingNumberOfDocuments;

    public void clickOnHideMenuButton() {
        log.info("Clicking on the [Hide menu] button");
        hideMenuButton.waitUntilVisible().waitUntilClickable().click();
    }

    public int getRealCountOf(String newsOrDocuments) {
        List<String> container = new ArrayList<>();
        switch (newsOrDocuments) {
            case "News":
                for (WebElement element : getDriver().findElements(countOfNews)) {
                    container.add(element.getText());
                }
                break;
            case "Documents":
                for (WebElement element : getDriver().findElements(countOfDocuments)) {
                    container.add(element.getText());
                }
                break;
        }
        return sizeOf(container);
    }
}
