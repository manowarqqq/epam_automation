package test;

import driver.DriverSingelton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {

   protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingelton.getDriver();


    }


    @AfterMethod
    public  void  tierDown() {
        DriverSingelton.closeDriver();
    }

}
