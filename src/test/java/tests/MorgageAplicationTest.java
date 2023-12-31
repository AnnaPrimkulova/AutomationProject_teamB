package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MortgageAplicationFildsPage;
import pages.SignInPage;
import utils.SeleniumUtils;

public class MorgageAplicationTest extends TestBase{



    @Test
    public void MorgageAlication() throws InterruptedException {

//        SignInFildsPage signInFildsPage = new SignInFildsPage();
//        signInFildsPage.getMovesigninpage().click();

        SignInPage signInPage = new SignInPage();
        signInPage.SignInCredentials();

        MortgageAplicationFildsPage mortgageAplicationFildsPage = new MortgageAplicationFildsPage();
        Thread.sleep(2000);
        mortgageAplicationFildsPage.getMortgageApplication().click();

        mortgageAplicationFildsPage.getEmail().sendKeys("JoneDoe@gmail.com");
        mortgageAplicationFildsPage.getPURCHASEPRICE().sendKeys("350000");
        mortgageAplicationFildsPage.getDOWNPAYMENTAMOUNT().sendKeys("25000");

        mortgageAplicationFildsPage.getNextbuttom().click();

        mortgageAplicationFildsPage.getFIRSTNAME().sendKeys("Jone");
        mortgageAplicationFildsPage.getLASTNAME().sendKeys("Doe",Keys.TAB,Keys.TAB,"JoneDoe@gmail.com",Keys.TAB,"03",
                "20","1991",Keys.TAB,"654161645696");


        Select select =new Select(mortgageAplicationFildsPage.getMARITALSTATUS());
        select.selectByVisibleText("Married");

        mortgageAplicationFildsPage.getCELLPHONE().sendKeys("913-312-4054",Keys.TAB,"913-312-4054");
        mortgageAplicationFildsPage.getNext().click();

        mortgageAplicationFildsPage.getMONTHLYRENTALPAYMENT().sendKeys("2100");
        mortgageAplicationFildsPage.getExpenNext().click();



    }
    @Test
    public void negativeTest1() throws InterruptedException {

//        SignInFildsPage signInFildsPage = new SignInFildsPage();
//        signInFildsPage.getMovesigninpage().click();

        SignInPage signInPage = new SignInPage();
        signInPage.SignInCredentials();

        MortgageAplicationFildsPage mortgageAplicationFildsPage = new MortgageAplicationFildsPage();
        Thread.sleep(2000);
        mortgageAplicationFildsPage.getMortgageApplication().click();

        SeleniumUtils.jsClick(mortgageAplicationFildsPage.getAREYOUWORKINGWITHAREALTOR());

        mortgageAplicationFildsPage.getPURCHASEPRICE().sendKeys("350000");
        mortgageAplicationFildsPage.getDOWNPAYMENTAMOUNT().sendKeys("25000");
        mortgageAplicationFildsPage.getADDITIONALFUNDS().sendKeys("5500");

        mortgageAplicationFildsPage.getNextbuttom().click();
        Assert.assertTrue(mortgageAplicationFildsPage.getPersonalInfoText().isEnabled());

    }

}
