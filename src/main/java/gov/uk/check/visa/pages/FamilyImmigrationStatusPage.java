package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyImmigrationStatusPage extends Utility {
    public FamilyImmigrationStatusPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    WebElement yesButton;
    @FindBy(xpath = "//label[contains(text(),'No')]")
    WebElement noButton;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//h2[contains(text(),'You’ll need a visa to join your family or partner ')]")
    WebElement needVisaToJoinFamilyText;

    public void selectImmigrationStatus(String status){
        switch (status){
            case "yes":
                clickOnElement(yesButton);
                break;
            case "no":
                clickOnElement(noButton);
                break;
            default:
                System.out.println("not select any immigration status");

        }

    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public String getNeedVisaToJoinFamilyText(){
        return getTextFromElement(needVisaToJoinFamilyText);
    }
}
