package cloudPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public abstract class AbstractPage {

    final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected  Logger logger = LogManager.getRootLogger();

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected abstract AbstractPage openPage();




}

