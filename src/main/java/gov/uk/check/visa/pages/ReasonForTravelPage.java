package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='govuk-radios']")
    List<WebElement> reasonForVisitListLocators;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;
    @FindBy(xpath = "//h2[contains(text(),'You will not need a visa to come to the UK')]")
    WebElement notNeedVisaMessage;

    public void selectReasonForVisit(String reason) {
        List<WebElement> allLists = reasonForVisitListLocators;
        for (WebElement options : allLists) {
            if (options.getText().contains(reason)) {
                options.click();
            }
        }
    }
    public void clickOnContinueButton(){
        clickOnElement(nextStepButton);
    }
    public String getNotNeedVisaMessage(){
        return getTextFromElement(notNeedVisaMessage);
    }
}