package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[contains(text(),'6 months or less')]")
    WebElement lessThanSixMonths;
    @FindBy(xpath="//label[contains(text(),'longer than 6 months')]")
    WebElement moreThanSixMonths;
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    public void selectLengthOfStay(String moreOrLess){
        switch (moreOrLess){
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 months":
                clickOnElement(moreThanSixMonths);
                break;
            default:
                System.out.println("not select any stay time");

        }

    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
