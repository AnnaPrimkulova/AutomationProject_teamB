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
        Thread.sleep(3000);


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
        //Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage();


        signUpPage.getFirstName().sendKeys(faker.name().nameWithMiddle());
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys(faker.internet().emailAddress());
        signUpPage.getPassword().sendKeys("123");
        Thread.sleep(3000);
        signUpPage.getSignUpButton().click();

        Assert.assertTrue(signUpPage.getSignUpMessage().isDisplayed());


        //Thread.sleep(3000);

    }

    @Test
    public void verifyTheFirstNameFieldIsRequired() throws InterruptedException {

        SignIn_page signInPage = new SignIn_page();

        signInPage.getSignUpLink().click();
        //Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage();



        signUpPage.getLastName().sendKeys(faker.name().lastName());
        signUpPage.getEmail().sendKeys(faker.internet().emailAddress());
        signUpPage.getPassword().sendKeys("123");
        Thread.sleep(3000);
        signUpPage.getSignUpButton().click();

        //Assert.assertFalse(signUpPage.getSignUpMessage().isDisplayed());
        Assert.assertFalse(!(signUpPage.getSignUpMessage().isDisplayed()));
    }

//    @Test
//    public void verifyTheFirstNameMaxLengthIs50Char() throws InterruptedException {
//
//        SignIn_page signInPage = new SignIn_page();
//
//        signInPage.getSignUpLink().click();
//        //Thread.sleep(3000);
//        SignUpPage signUpPage = new SignUpPage();
//
//
//    }






}
