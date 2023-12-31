package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Getter
@AllArgsConstructor

public class MortgageAplicationFildsPage {

    public MortgageAplicationFildsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[.='Mortgage Application']")
    private WebElement MortgageApplication;


    @FindBy(xpath = "//input[@id='realtorinfo']")
    private WebElement email;


    @FindBy(xpath = "//input[@id='estimatedprice']")
    private WebElement PURCHASEPRICE;


    @FindBy(xpath = "//input[@id='downpayment']")
    private WebElement DOWNPAYMENTAMOUNT;

    @FindBy(xpath = "//input[@id='downpaymentpercentage']")
    private WebElement DOWNPAYMENTPERCENTAGE;



    @FindBy(xpath = "//a[.='Next']")
    private WebElement nextbuttom;



    @FindBy(xpath = "//input[@id='b_firstName']")
    private WebElement FIRSTNAME;



    @FindBy(xpath = "//input[@id='b_lastName']")
    private WebElement LASTNAME;

    @FindBy(xpath = "//select[@id='b_suffix']")
    private WebElement SurffixSelect;

    @FindBy(xpath = "//select[@id='b_marital']")
    private WebElement MARITALSTATUS;


    @FindBy(xpath = "//input[@id='b_ssn']")
    private WebElement SSN;


    @FindBy(xpath = "//input[@id='b_cell']")
    private WebElement CELLPHONE;


    @FindBy(linkText = "Next")
    private WebElement Next;

    @FindBy(xpath = "//input[@id='monthlyrentalpayment']")
    private WebElement MONTHLYRENTALPAYMENT;

    @FindBy(xpath = "(//a[@class='btn btn-light-primary'])[3]")
    private WebElement Save;

    @FindBy(xpath = "(//input[@type='checkbox']/following-sibling::label)[2]")
    private WebElement AREYOUWORKINGWITHAREALTOR;


    @FindBy(xpath = "//input[@id='b_email']")
    private WebElement EmailInfoPage;

    @FindBy(xpath = "//a[.='Save']")
    private WebElement SAVE;


    @FindBy(xpath = "//li[@aria-disabled='false']//a[.='Next']")
    private WebElement ExpenNext;

    @FindBy(xpath = "//input[@id='additionalfunds']")
    private WebElement ADDITIONALFUNDS ;

    @FindBy(xpath = "//fieldset[@id='steps-uid-0-p-1']//h6[.='Personal Information']")
    private WebElement PersonalInfoText ;




}
