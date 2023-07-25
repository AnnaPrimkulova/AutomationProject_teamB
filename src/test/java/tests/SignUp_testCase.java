package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInFildsPage;
import pages.SignInPage;
import pages.SignIn_page;
import pages.SignUpPage;
import utils.Driver;

public class SignUp_testCase extends TestBase{
    //	The Sign Up page should include input fields for the user's First Name, Last Name, Email Address, and Password.

    @Test
    public void verifySignUpFields() throws InterruptedException {

        SignIn_page signInPage = new SignIn_page();

        signInPage.getSignUpLink().click();
//        Thread.sleep(3000);


        SignUpPage signUpPage = new SignUpPage();

        Assert.assertTrue(signUpPage.getFirstName().isDisplayed());
        Assert.assertTrue(signUpPage.getLastName().isDisplayed());
        Assert.assertTrue(signUpPage.getEmail().isDisplayed());
        Assert.assertTrue(signUpPage.getPassword().isDisplayed());
        Assert.assertTrue(signUpPage.getSignUpButton().isDisplayed());

    }


    @Test
    public void verifyValidInputForTheFirstNameField() throws InterruptedException{

        SignIn_page signInPage = new SignIn_page();

        signInPage.getSignUpLink().click();
        SignUpPage signUpPage = new SignUpPage();


        signUpPage.getFirstName().sendKeys(faker.name().nameWithMiddle());
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys(faker.internet().emailAddress());
        signUpPage.getPassword().sendKeys("123456Ak");
        signUpPage.getSignUpButton().click();
        Assert.assertTrue(signUpPage.getSignUpMessage().isDisplayed());


    }

    @Test
    public void verifyTheFirstNameFieldIsRequired() throws InterruptedException {

        SignIn_page signInPage = new SignIn_page();

        signInPage.getSignUpLink().click();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys(faker.internet().emailAddress());
        signUpPage.getPassword().sendKeys("123456Ak");
//        Thread.sleep(3000);
        signUpPage.getSignUpButton().click();

        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
    }


}
