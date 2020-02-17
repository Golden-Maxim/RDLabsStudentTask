package steps;

import com.google.inject.internal.asm.$AnnotationVisitor;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalDetailsSteps extends DefaultStepsData {

    @Step
    public String getValueFromDateOfBirthField() {
        return personalDetailsPage.getDateOfBirthInputField().getAttribute("value");
    }

    @Step
    public void enterDateIntoDateBirthField(String date) {
        personalDetailsPage.getDateOfBirthInputField().clear();
        personalDetailsPage.enterDateOfBirth(date);
    }

    @Step
    public List<String> getOptionsFromNationalitySelect() {
        List<String> nationalityOptions = personalDetailsPage.getNationalitySelect().thenFindAll(By.xpath("./..//li//span"))
                .stream().map(we -> we.getAttribute("innerText")).collect(Collectors.toList());
        return nationalityOptions;
    }
    @Step
    public boolean getFemaleButtonBooleanAttribute(){
        System.out.println("Attribute from Female: " + personalDetailsPage.getFemaleRadioButton().waitUntilEnabled().getAttribute("checked"));
        return Boolean.parseBoolean(personalDetailsPage.getFemaleRadioButton().waitUntilEnabled().getAttribute("checked"));
    }
    @Step
    public boolean getMaleButtonBooleanAttribute(){
        return Boolean.parseBoolean(personalDetailsPage.getMaleRadioButton().waitUntilEnabled().getAttribute("checked"));
    }
    @Step
    public boolean getDefaultEEORaceAndEthnicityStatus(){
        return Boolean.parseBoolean(personalDetailsPage.getEEORaceAndEthnicity().getAttribute("checked"));
    }
    @Step
    public String getMessageFromEEORaceAndEthnicity(){
        return personalDetailsPage.getEEORaceAndEthnicityMessage().getText();
    }

}
