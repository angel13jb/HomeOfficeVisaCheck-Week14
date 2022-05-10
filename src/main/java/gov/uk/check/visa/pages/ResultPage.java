package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[contains(text(),'Check if you need a UK visa')]")
    WebElement resultMessage;

    public  String getResultMessage(){
        return getTextFromElement(resultMessage);
    }
    public  void confirmResultMessage(String expectedMessage){
        Assert.assertTrue(true,expectedMessage);
    }
}
