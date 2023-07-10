package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignIn_page;
import pages.SignUpPage;

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
    public void verifySignUpFields2() throws InterruptedException {

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
    }
