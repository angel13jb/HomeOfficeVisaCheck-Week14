package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorkTypePage extends Utility {
    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/main[1]/div[1]/div[1]/form[1]/div[1]/div[1]/fieldset[1]/div[1]")
    List<WebElement> jobTypeList;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//h2[contains(text(),'You need a visa to work in health and care')]")
    WebElement needVisaToWorkText;

    public void selectJobType(String job) {
        List<WebElement> allLists = jobTypeList;
        for (WebElement options : allLists) {
            if (options.getText().contains(job)) {
                options.click();
            }

        }
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public String getNeedVisaToWorkText() {
        return getTextFromElement(needVisaToWorkText);
    }

}