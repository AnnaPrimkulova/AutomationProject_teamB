package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BorrowerEmploymentPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class BorrowerEmploymentTest extends TestBase {

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

    @Test  //1
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


        List<WebElement> elements = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state1']"))).getOptions();


        String expected = "[Select One, Alabama (AL), Alaska (AK), Arizona (AZ), Arkansas (AR), California (CA), Colorado (CO), Connecticut (CT)" +
                ", Delaware (DE), Florida (FL), Georgia (GA), Hawaii (HI), Idaho (ID), Illinois (IL), Indiana (IN), Iowa (IA), Kansas (KS)" +
                ", Kentucky (KY), Louisiana (LA), Maine (ME), Maryland (MD), Massachusetts (MA), Michigan (MI), Minnesota (MN), Mississippi (MS), Missouri (MO)" +
                ", Montana (MT), Nebraska (NE), Nevada (NV), New Hampshire (NH), New Jersey (NJ), New Mexico (NM), New York (NY), North Carolina (NC), North Dakota (ND)" +
                ", Ohio (OH), Oklahoma (OK), Oregon (OR), Pennsylvania (PA), Rhode Island (RI), South Carolina (SC), South Dakota (SD), Tennessee (TN), Texas (TX), Utah (UT)" +
                ", Vermont (VT), Virginia (VA), Washington (WA), West Virginia (WV), Wisconsin (WI), Wyoming (WY)]";

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
        //    If the user checks the checkbox labeled "This is my current job", end
//    date for the job should be not displayed.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        Assert.assertFalse(borrowerEmploymentPage.getENDDATE().isDisplayed());

    }

    @Test   //2
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

    @Test  //3
    public void AnotherEmployerFildIn_Clear() throws InterruptedException {

        //      The "Clear" option should only clear the information in that section, not
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
        Assert.assertTrue(borrowerEmploymentPage.getPreApproval_Inquiry().isDisplayed());

    }

    @Test //3
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

    @Test
    public void BorrowerGrossMonthlyEmploymentIncome() throws InterruptedException {

        //Borrower Gross Monthly Employment Income section:
//    oThe section should contain fields for GROSS MONTHLY INCOME,
//    MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS,
//    MONTHLY DIVIDENDS/INTEREST, and Borrower Total Monthly Income.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        Assert.assertTrue(borrowerEmploymentPage.getGross_Monthly_Income_text().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getMonthly_Overtime_text().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getMonthly_Bonuses_text().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getMonthly_Commissions_text().isDisplayed());
        Assert.assertTrue(borrowerEmploymentPage.getMONTHLY_DIVIDENTS_INTEREST_text().isDisplayed());
    }

    @Test
    public void negativeBorrowerGrossMonthlyEmploymentIncome() throws InterruptedException {

        //    oAll fields in this section should only accept numeric input (digits and
//decimal points) with a maximum of two decimal places.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("10000", Keys.TAB, "600"
                , Keys.TAB, "1000", Keys.TAB, "800", Keys.TAB, "24");

        borrowerEmploymentPage.getNext().click();


        Thread.sleep(2000);
        Assert.assertFalse(borrowerEmploymentPage.getPreApproval_Inquiry().isDisplayed());


    }

    @Test
    public void negative2BorrowerGrossMonthlyEmploymentIncome() throws InterruptedException {

//   The maximum character limit for the fields should be 12 characters.
//    oGROSS MONTHLY INCOME should be a required input field.
//            oThe "Borrower Total Monthly Income" field should be automatically
//    calculated based on the other fields.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("1000002020120", Keys.TAB, "600"
                , Keys.TAB, "100056213566411", Keys.TAB, "8002311635435", Keys.TAB, "24");

        borrowerEmploymentPage.getNext().click();


        Thread.sleep(2000);
        Assert.assertFalse(borrowerEmploymentPage.getPreApproval_Inquiry().isDisplayed());


    }

    @Test  //4
    public void negative3BorrowerGrossMonthlyEmploymentIncome() throws InterruptedException {


//              The "Borrower Total Monthly Income" field should be automatically
//    calculated based on the other fields.

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();
        borrowerEmploymentPage.getThisIsMyCurrentJob().click();

        borrowerEmploymentPage.getEmployerNameFild().sendKeys(faker.idNumber().invalid(), Keys.TAB, faker.idNumber().invalid()
                , Keys.TAB, faker.idNumber().invalid(), Keys.TAB, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);

        borrowerEmploymentPage.getGROSS_MONTHLY_INCOME().sendKeys("1000002020120", Keys.TAB, "600"
                , Keys.TAB, "100056213566411", Keys.TAB, "8002311635435", Keys.TAB, "24");


        System.out.println(borrowerEmploymentPage.getBorrower_Total_Monthly_Income().getText());
        Thread.sleep(2000);
        borrowerEmploymentPage.getNext().click();


        Thread.sleep(2000);
        Assert.assertTrue(borrowerEmploymentPage.getPreApproval_Inquiry().isDisplayed());


    }

    @Test  //4
    public void AdditionalGrossMonthlyIncome() throws InterruptedException {

        MorgageAplicationTest morgageAplicationTest = new MorgageAplicationTest();
        morgageAplicationTest.MorgageAlication();

//        BorrowerEmploymentPage borrowerEmploymentPage = new BorrowerEmploymentPage();

//        final List<String> elementsText = SeleniumUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//select[@id='incomesource1']")));
//        System.out.println(elementsText);

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//select[@id='incomesource1']//option"));

        System.out.println(elements.size());
        List<String> actual = new ArrayList<>();
        for (WebElement element : elements) {

            System.out.println(actual.add(element.getText()));
        }


    }
}