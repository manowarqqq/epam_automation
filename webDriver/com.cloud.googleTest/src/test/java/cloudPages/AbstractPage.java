package cloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected abstract AbstractPage openPage();




}

