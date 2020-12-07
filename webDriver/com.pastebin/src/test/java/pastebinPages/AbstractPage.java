package pastebinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage{

    WebDriver driver;


    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     protected abstract AbstractPage openPage();
    final int WAIT_TIMEOUT_SECONDS=10;



}
