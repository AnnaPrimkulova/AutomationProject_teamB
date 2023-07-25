package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignIn_page {

    public WebElement getSignUpLink() {

        return signUpLink;
    }

    public SignIn_page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@href='register.php']")
    private WebElement signUpLink;
}
