package tests;

import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    protected Faker faker;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        faker = new Faker();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult){


        Driver.quitDriver();
    }


}
