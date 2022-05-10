package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {

StartPage startPage;
SelectNationalityPage selectNationalityPage;
ReasonForTravelPage reasonForTravelPage;
FamilyImmigrationStatusPage familyImmigrationStatusPage;
DurationOfStayPage durationOfStayPage;
WorkTypePage workTypePage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage=new StartPage();
        selectNationalityPage =new SelectNationalityPage();
        reasonForTravelPage=new ReasonForTravelPage();
        familyImmigrationStatusPage= new FamilyImmigrationStatusPage();
        durationOfStayPage=new DurationOfStayPage();
        workTypePage=new WorkTypePage();
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void anAustralianCominToUKForTourism(){
        startPage.clickOnAcceptCookieButton();
        startPage.clickOnStartNowButton();
        selectNationalityPage.selectNationality("Australia");
        selectNationalityPage.clickOnContinueButton();
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");
        reasonForTravelPage.clickOnContinueButton();
        String expectedMessage="You will not need a visa to come to the UK";
        String actualMessage=reasonForTravelPage.getNotNeedVisaMessage();
        Assert.assertEquals(expectedMessage,actualMessage,"Message not displayed");

    }
    @Test(groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        startPage.clickOnAcceptCookieButton();
        startPage.clickOnStartNowButton();
        selectNationalityPage.selectNationality("Chile");
        selectNationalityPage.clickOnContinueButton();
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        reasonForTravelPage.clickOnContinueButton();
        durationOfStayPage.selectLengthOfStay("longer than 6 months");
        durationOfStayPage.clickOnContinueButton();
        workTypePage.selectJobType("Health and care professional");
        workTypePage.clickOnContinueButton();
        String expectedText="You need a visa to work in health and care";
        String actualText= workTypePage.getNeedVisaToWorkText();
       Assert.assertEquals(expectedText,actualText,"Text not displayed");

    }
    @Test(groups = "regression")
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(){
        startPage.clickOnAcceptCookieButton();
        startPage.clickOnStartNowButton();
        selectNationalityPage.selectNationality("Colombia");
        selectNationalityPage.clickOnContinueButton();
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        reasonForTravelPage.clickOnContinueButton();
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        familyImmigrationStatusPage.clickOnContinueButton();
        String expectedText="You’ll need a visa to join your family or partner in the UK";
        String actualText=familyImmigrationStatusPage.getNeedVisaToJoinFamilyText();
       Assert.assertEquals(expectedText,actualText,"Text not match");
    }

}