package CloudPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static waiters.Waiter.waitTimeout;
import static waiters.Waiter.waitVisibility;

public class TenMinutesEmailPage extends AbstractPage {

    private final static String HOME_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copyEmailButton;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement estimatedCostInTheMail;


    public TenMinutesEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TenMinutesEmailPage openPage() {
        driver.get(HOME_URL);
        waitTimeout(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }


    public TenMinutesEmailPage copyTenMinuteEmail() {
        waitVisibility(driver, copyEmailButton).click();
        return this;
    }

    public TenMinutesEmailPage openEmail() {
        waitVisibility(driver, email).click();
        return this;
    }

    public String getEstimatedCostInTheMail() {
        return estimatedCostInTheMail.getText();
    }
}
