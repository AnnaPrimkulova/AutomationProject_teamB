package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;


@Getter
public class BorrowerEmploymentPage {

    public BorrowerEmploymentPage() {


        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//label[@for='currentjob1']")
     private WebElement ThisIsMyCurrentJob;


    @FindBy(xpath = "(//label[.='Employer Name'])[1]")
    private WebElement EmployerName;
    @FindBy(xpath = "(//label[.='Position'])[1]")
    private WebElement POSITION;
    @FindBy(xpath = "(//label[.='City'])[1]")
    private WebElement CITY;
    @FindBy(xpath = "(//label[.='State'])[1]")
    private WebElement STATE;
    @FindBy(xpath = "(//label[.='Start Date'])[1]")
    private WebElement STARTDATE;
    @FindBy(xpath = "(//label[.='End Date'])[1]")
    private WebElement ENDDATE;






    @FindBy(xpath = "//input[@id='employername1']//following-sibling::label")
    private WebElement THIS_FIELD_IS_REQUIRED;

    @FindBy(xpath = "//select[@id='state1']")
    private WebElement STATE50;

    @FindBy(xpath = "//li[@aria-disabled='false']//a[.='Next']")
    private WebElement Next;

    @FindBy(xpath = "(//input[@type='checkbox'])[10]")
    private WebElement This_is_my_current_job;


    @FindBy(xpath = "//a[.='Clear ']")
    private WebElement clear;

    @FindBy(xpath = "(//a[@class='clear'])[2]")
    private WebElement clear2;

    @FindBy(xpath = "//a[@id='remove2']")
    private WebElement remove;


    @FindBy(xpath = "//button[.='Cancel']")
    private WebElement cancel;

    @FindBy(xpath = "//button[.='Yes!']")
    private WebElement Yes;


    @FindBy(xpath = "//input[@id='employername1']")
    private WebElement EmployerNameFild;
    @FindBy(xpath = "//input[@id='employername2']")
    private WebElement Employer2NameFild;

    @FindBy(xpath = "(//h6[.='PreApproval Inquiry'])[2]")
    private WebElement PreApproval_Inquiry;




    @FindBy(xpath = "(//div[@class='form-group']//following-sibling::label)[55]")
    private WebElement THIS_FIELD_IS_REQUIRED_MONTHLY_INCOME;
    @FindBy(xpath = "//input[@id='grossmonthlyincome']//following-sibling::label")
    private WebElement PLEASE_ENTER_A_VALID_NUMBER_INCOME;
    @FindBy(xpath = "(//label[.='Please enter a valid number.'])[2]")
    private WebElement PLEASE_ENTER_A_VALID_NUMBER_OVERTIME;
    @FindBy(xpath = "(//label[.='Please enter a valid number.'])[3]")
    private WebElement PLEASE_ENTER_A_VALID_NUMBER_BONUSES;
    @FindBy(xpath = "(//label[.='Please enter a valid number.'])[4]")
    private WebElement PLEASE_ENTER_A_VALID_NUMBER_COMMISSIONS;
    @FindBy(xpath = "//div[@class='form-group']//label[@id='monthlydividents-error']")
    private WebElement PLEASE_ENTER_A_VALID_NUMBER_DIVIDENTS_INTEREST;


    @FindBy(xpath = "//label[.='Gross Monthly Income*']")
    private WebElement Gross_Monthly_Income_text;
    @FindBy(xpath = "//label[.='Monthly Overtime']")
    private WebElement Monthly_Overtime_text;
    @FindBy(xpath = "//label[.='Monthly Bonuses']")
    private WebElement Monthly_Bonuses_text;
    @FindBy(xpath = "//label[.='Monthly Commissions']")
    private WebElement Monthly_Commissions_text;
    @FindBy(xpath = "//label[.='Monthly Dividents/Interest']")
    private WebElement MONTHLY_DIVIDENTS_INTEREST_text;



    @FindBy(xpath = "//input[@id='grossmonthlyincome']")
    private WebElement GROSS_MONTHLY_INCOME;

    @FindBy(xpath = "(//a[@aria-controls='employer2'])[2]")
    private WebElement Employer2_fild;

    @FindBy(xpath = "(//button[.='Add Another Employer'])[1]")
    private WebElement Add_Another_Employer;

    @FindBy(xpath = " (//option[.='Missouri (MO)'])[1]")
    private WebElement State_MO;

    @FindBy(xpath = "//input[@id='start_date1']")
    private WebElement Start_Data_fild;

    @FindBy(xpath = "(//div[@class='cleardiv'])[1]")
    private List<WebElement> Employer1;

    @FindBy(xpath = "(//div[@class='cleardiv'])[2]")
    private List<WebElement> Employer2;

    @FindBy(xpath = "//div[.='This action will clear the form, would you like to continue?']")
    private WebElement Pop_up_clear;

    @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome']//span']")
    private WebElement Borrower_Total_Monthly_Income;


    @FindBy(xpath = "//select[@id='incomesource1']//option")
    private List<WebElement> incomesource1;










}
