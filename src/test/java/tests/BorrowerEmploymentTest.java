package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BorrowerEmploymentPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class BorrowerEmploymentTest extends TestBase {


//Borrower Gross Monthly Employment Income section:
//    oThe section should contain fields for GROSS MONTHLY INCOME,
//    MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS,
//    MONTHLY DIVIDENDS/INTEREST, and Borrower Total Monthly Income.
//    oAll fields in this section should only accept numeric input (digits and
//decimal points) with a maximum of two decimal places. The maximum
//    character limit for the fields should be 12 characters.
//    oGROSS MONTHLY INCOME should be a required input field.
//            oThe "Borrower Total Monthly Income" field should be automatically
//    calculated based on the other fields.
//            Additional Gross Monthly Income section:
//    oThe section should contain three sets of INCOME SOURCE dropdowns
//    and Amount fields.
//    oINCOME SOURCE dropdown should have Alimony/Child Support, Social
//    Security/Disability Income, Unemployment Benefits, Interest and
//    Dividends, VA Compensation, Royalty Payments and Other Types of
//    Income options.
//            Previous and Next Buttons:
//    oThe user should be able to navigate to other sections using the
//"Previous" and "Next" buttons.
//            oThe "Previous" button should take the user to the previous section.
//            oThe "Next" button should take the user to the next section only if all
//    required fields are filled in.
//    oIf a required field is not filled in, the "Next" button should not navigate
//    to the next section and display an error message indicating which field
//    needs to be filled in.


    @Test
    public void MorgageAplicationFildIn() throws InterruptedException {
        //            Borrower Employment Information:
//    It should contain fields for EMPLOYER NAME, POSITION, CITY, and a
//    dropdown box for STATE, and a date picker for START DATE and END
//    DATE.


        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getEmployerName().isDisplayed();
        borrowerEmploymentPage.getPOSITION().isDisplayed();
        borrowerEmploymentPage.getCITY().isDisplayed();
        borrowerEmploymentPage.getSTATE().isDisplayed();
        borrowerEmploymentPage.getSTARTDATE().isDisplayed();
        borrowerEmploymentPage.getENDDATE().isDisplayed();

    }

    @Test
    public void EmploymentAndIncome_EmployerNameFild() throws InterruptedException {
//    EMPLOYER NAME should be a required input field.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getNext().click();
        Assert.assertTrue(borrowerEmploymentPage.getTHIS_FIELD_IS_REQUIRED().isDisplayed());

    }


    @Test
    public void EmploymentAndIncome_StateFild() throws InterruptedException {

//    STATE should be as dropdown list with all 50 US states and their two-
//    letter abbreviations.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();


        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//select[@id='state1']"));


        String expected = "[                                                                    Select One\n" +
                "                                                                     Alabama (AL)\n" +
                "  Alaska (AK)\n" +
                "  Arizona (AZ)\n" +
                "  Arkansas (AR)\n" +
                "  California (CA)\n" +
                "  Colorado (CO)\n" +
                "  Connecticut (CT)\n" +
                "  Delaware (DE)\n" +
                "  Florida (FL)\n" +
                "  Georgia (GA)\n" +
                "  Hawaii (HI)\n" +
                "  Idaho (ID)\n" +
                "  Illinois (IL)\n" +
                "  Indiana (IN)\n" +
                "  Iowa (IA)\n" +
                "  Kansas (KS)\n" +
                "  Kentucky (KY)\n" +
                "  Louisiana (LA)\n" +
                "  Maine (ME)\n" +
                "  Maryland (MD)\n" +
                "  Massachusetts (MA)\n" +
                "  Michigan (MI)\n" +
                "  Minnesota (MN)\n" +
                "  Mississippi (MS)\n" +
                "  Missouri (MO)\n" +
                "  Montana (MT)\n" +
                "  Nebraska (NE)\n" +
                "  Nevada (NV)\n" +
                "  New Hampshire (NH)\n" +
                "  New Jersey (NJ)\n" +
                "  New Mexico (NM)\n" +
                "  New York (NY)\n" +
                "  North Carolina (NC)\n" +
                "  North Dakota (ND)\n" +
                "  Ohio (OH)\n" +
                "  Oklahoma (OK)\n" +
                "  Oregon (OR)\n" +
                "  Pennsylvania (PA)\n" +
                "  Rhode Island (RI)\n" +
                "  South Carolina (SC)\n" +
                "  South Dakota (SD)\n" +
                "  Tennessee (TN)\n" +
                "  Texas (TX)\n" +
                "  Utah (UT)\n" +
                "  Vermont (VT)\n" +
                "  Virginia (VA)\n" +
                "  Washington (WA)\n" +
                "  West Virginia (WV)\n" +
                "  Wisconsin (WI)\n" +
                "  Wyoming (WY)\n" +
                "                                                                   \n" +
                "                                                                ]";

        List<String> actual = new ArrayList<>();
        for (WebElement element : elements) {

            actual.add(element.getText());
        }

        System.out.println(actual);

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void EmploymentAndIncome_currentJob() throws InterruptedException {
        //    oThe checkbox labeled "This is my current job" should be checked by
//    default.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        Assert.assertTrue(borrowerEmploymentPage.getThis_is_my_current_job().isSelected());

    }

    @Test
    public void EmploymentAndIncome_EndDate() throws InterruptedException {
        //    oIf the user checks the checkbox labeled "This is my current job", end
//    date for the job should be not displayed.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        Assert.assertFalse(borrowerEmploymentPage.getENDDATE().isDisplayed());

    }

    @Test
    public void EmploymentAndIncome_Clear() throws InterruptedException {
        //    oThe section should have a "Clear" option that displays a warning pop-
//    up about clearing the information.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getClear().isDisplayed();


//            oThe "Clear" option should only clear the information in that section, not
//    any other sections.
        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.name().firstName());
        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("45000");


        borrowerEmploymentPage.getClear().click();
        SeleniumUtils.jsClick(borrowerEmploymentPage.getYes());
        borrowerEmploymentPage.getNext().click();

        Assert.assertTrue(borrowerEmploymentPage.getTHIS_FIELD_IS_REQUIRED().isDisplayed());
        Assert.assertFalse((borrowerEmploymentPage.getTHIS_FIELD_IS_REQUIRED_MONTHLY_INCOME()).isDisplayed());

    }

    @Test
    public void BorrowerEmploymentInformation_invalid_fild_Test() throws InterruptedException {//passing
//    oThe user should be able to enter only valid information in each field.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();


        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("10000", Keys.TAB, "600"
                , Keys.TAB, "1000", Keys.TAB, "800", Keys.TAB, "24");


        borrowerEmploymentPage.getNext().click();

    }

    @Test
    public void BorrowerGrossMonthlyEmploymentIncome_invalid_fild_Test() throws InterruptedException { //not passing


        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();


        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid());

        borrowerEmploymentPage.getNext().click();

        Assert.assertTrue(borrowerEmploymentPage.getPLEASE_ENTER_A_VALID_NUMBER_INCOME().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getPLEASE_ENTER_A_VALID_NUMBER_OVERTIME().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getPLEASE_ENTER_A_VALID_NUMBER_BONUSES().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getPLEASE_ENTER_A_VALID_NUMBER_COMMISSIONS().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getPLEASE_ENTER_A_VALID_NUMBER_DIVIDENTS_INTEREST().isDisplayed());


    }


    @Test
    public void AnotherEmployerFildIn() throws InterruptedException {//passing
//            oThe "Add another employer" button should let the user add a new
//    section for another employer's information.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        SeleniumUtils.jsClick(borrowerEmploymentPage.getAdd_Another_Employer());
        Assert.assertTrue(borrowerEmploymentPage.getEmployer2_fild().isDisplayed());


    }


    @Test
    public void Test_Employer1_Employer2_Fild() throws InterruptedException {
        //    oEach new section should contain the same fields as the first section.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();
        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();
        List<String> expected = SeleniumUtils.getElementsText(borrowerEmploymentPage.getEmployer1());
        SeleniumUtils.jsClick(borrowerEmploymentPage.getAdd_Another_Employer());
        List<String> actual = SeleniumUtils.getElementsText(borrowerEmploymentPage.getEmployer2());

        Assert.assertEquals(actual, expected);

        System.out.println(expected);
        System.out.println(actual);

    }

    @Test
    public void AnotherEmployerFildIn_Clear_Remove() throws InterruptedException {

        //    oThe section should have a "Clear" option that displays a warning pop-
//    up about clearing the information.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        SeleniumUtils.jsClick(borrowerEmploymentPage.getAdd_Another_Employer());
        borrowerEmploymentPage.getClear2().click();
        Assert.assertTrue(borrowerEmploymentPage.getPop_up_clear().isDisplayed());

    }

    @Test
    public void AnotherEmployerFildIn_Clear() throws InterruptedException {

        //            oThe "Clear" option should only clear the information in that section, not
//    any other sections.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        SeleniumUtils.jsClick(borrowerEmploymentPage.getAdd_Another_Employer());

        borrowerEmploymentPage.getEmployer2NameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("10000", Keys.TAB, "600"
                , Keys.TAB, "1000", Keys.TAB, "800", Keys.TAB, "24");


        SeleniumUtils.jsClick(borrowerEmploymentPage.getClear2());
        borrowerEmploymentPage.getYes().click();


        borrowerEmploymentPage.getNext().click();
//       Assert.assertFalse( borrowerEmploymentPage.getTHIS_FIELD_IS_REQUIRED().isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(borrowerEmploymentPage.getPreApproval_Inquiry().isDisplayed());

    }

    @Test
    public void AnotherEmployerFildIn_Remove() throws InterruptedException {

        //    oThe user should be able to remove a section using the "Remove"
//    option.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        SeleniumUtils.jsClick(borrowerEmploymentPage.getAdd_Another_Employer());
        Assert.assertTrue(borrowerEmploymentPage.getEmployer2_fild().isDisplayed());

        borrowerEmploymentPage.getRemove().click();
        borrowerEmploymentPage.getYes().click();
        Assert.assertFalse(borrowerEmploymentPage.getEmployer2_fild().isDisplayed());

    }
}