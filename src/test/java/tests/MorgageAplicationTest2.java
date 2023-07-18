package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.MortgageAplicationFildsPage;

import pages.SignInPage;
import utils.CSVReader;
import utils.Driver;

public class MorgageAplicationTest2 extends TestBase {




     @DataProvider (name = "customers")
        public Object [][] getData(){

            return CSVReader.readFromCSVFile("src/test/resources/customers.csv");
         }


    @Test (dataProvider = "customers")
    public  void placeOrderTest(String FIRSTNAME,
                                String LASTNAME,
                                String email,
                                String SSN,
                                String Cellnumber) throws InterruptedException {

        SignInPage signInPage = new SignInPage();
        signInPage.SignInCredentials();


        MortgageAplicationFildsPage mortgageAplicationFildsPage = new MortgageAplicationFildsPage();
        Thread.sleep(1500);
        mortgageAplicationFildsPage.getMortgageApplication().click();
//        Thread.sleep(1500);
        mortgageAplicationFildsPage.getEmail().sendKeys("JoneDoe@gmail.com");
        mortgageAplicationFildsPage.getPURCHASEPRICE().sendKeys("350000");
        mortgageAplicationFildsPage.getDOWNPAYMENTAMOUNT().sendKeys("25000");

        mortgageAplicationFildsPage.getNextbuttom().click();



        mortgageAplicationFildsPage.getFIRSTNAME().sendKeys(FIRSTNAME);
        mortgageAplicationFildsPage.getLASTNAME().sendKeys(LASTNAME);

        Select select =new Select(mortgageAplicationFildsPage.getSurffixSelect());
        select.selectByVisibleText("Jr.");

        mortgageAplicationFildsPage.getEmailInfoPage().sendKeys(email,Keys.TAB,"03","20","1991");
        mortgageAplicationFildsPage.getSSN().sendKeys(SSN);

        select =new Select(mortgageAplicationFildsPage.getMARITALSTATUS());
        select.selectByVisibleText("Married");

        mortgageAplicationFildsPage.getCELLPHONE().sendKeys(Cellnumber);

        mortgageAplicationFildsPage.getNext().click();


        mortgageAplicationFildsPage.getMONTHLYRENTALPAYMENT().sendKeys("2100");
        mortgageAplicationFildsPage.getSave().click();

//        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");









    }
}
