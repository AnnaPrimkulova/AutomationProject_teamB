package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "inputfirstname4")
    private WebElement firstName;

    @FindBy(id = "inputlastname4")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "exampleInputPassword1")
    private WebElement password;

    @FindBy(id = "register")
    private WebElement signUpButton;


    @FindBy(xpath = "//div[@class='card-title']//h4")
    private WebElement signUpMessage;


    public WebElement getSignUpMessage() {
        return signUpMessage;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }
}

