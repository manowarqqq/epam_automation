package cloudPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;

public class CloudSearchResultPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")
    private WebElement googleCloudPlatformPricingCalculatorLink;

    public CloudSearchResultPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return null;
    }


    public CloudCalculatorPage getCalculatorPage() {
        Waiter.waitVisibility(driver, googleCloudPlatformPricingCalculatorLink);
        googleCloudPlatformPricingCalculatorLink.click();
        return new CloudCalculatorPage(driver);
    }
}