package cloudPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

public class CloudSearchResultPage  extends  AbstractPage {


    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement GoogleCloudPlatformPricingCalculatorLink;

    CloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return null;
    }


    public CloudCalculatorPage getCalculatorPage() {
        Waiter.waitVisibility(driver,GoogleCloudPlatformPricingCalculatorLink);
        GoogleCloudPlatformPricingCalculatorLink.click();
        logger.info("CalculatorPage is opened");
        return new CloudCalculatorPage(driver);
    }
}