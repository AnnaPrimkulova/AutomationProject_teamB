package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInFildsPage;
import pages.SignInPage;
import pages.SignUpFildsPage;
import utils.ConfigReader;
import utils.Driver;

public class SignInTest extends TestBase {

    public void MoveSignUp() {

    }

    @Test
    public void SignInPage() {

//        SignInFildsPage signInFildsPage = new SignInFildsPage();
//        signInFildsPage.getMovesigninpage().click();

        SignInPage signInPage = new SignInPage();
        signInPage.SignInCredentials();

    }

    @Test
    public void SignInPagetest() {

        SignInFildsPage signInFildsPage = new SignInFildsPage();

        Assert.assertTrue(signInFildsPage.getWellcomeText().isDisplayed());
        Assert.assertTrue(signInFildsPage.getSigninbutton().isEnabled());// signin button  should not be able
    }
@Test
    public void negativeSigntest(){

        SignInPage signInPage = new SignInPage();
        signInPage.SignIn("Invalid", ConfigReader.getProperty("password"));
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");

    }
    @Test
   public void negativeSignInPasswordtest() throws InterruptedException {

        SignInPage signInPage = new SignInPage();
        signInPage.SignIn(ConfigReader.getProperty("email"),"invalid");
        Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php");


        SignUpFildsPage signUpFildsPage =new SignUpFildsPage();
        Assert.assertTrue(signUpFildsPage.getDontHaveAccountText().isDisplayed());// "don't have an account?" is displayed
        Assert.assertTrue(signUpFildsPage.getSignUpWord().isDisplayed());// "sign up " is displayed




   }
}