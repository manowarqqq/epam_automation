package cloudPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static waiters.Waiter.clickElementWithJS;
import static waiters.Waiter.waitVisibility;

public class CloudCalculatorResultPage extends AbstractPage {

    private final By iframePath = By.xpath("//devsite-iframe/iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement estimatedCost;

    @FindBy(xpath = "//div[contains(text(),'VM class')]")
    private WebElement vmClass;

    @FindBy(xpath = "//div[contains(text(),'Instance type')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[contains(text(),'Region')]")
    private WebElement region;

    @FindBy(xpath = "//div[contains(text(),'Total available local SSD space')]")
    private WebElement localSSD;

    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;


    CloudCalculatorResultPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return this;
    }

    public String getVMclass() {
        return vmClass.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getLocalSSD() {
        return localSSD.getText();
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getEstimatedCost() {
        return estimatedCost.getText();
    }


    public CloudCalculatorResultPage getEmailEstimateForm() {
        clickElementWithJS(driver, emailEstimateButton);
        waitVisibility(driver, emailField);
        return new CloudCalculatorResultPage(driver);
    }

    public CloudCalculatorResultPage sendEmailWithEstimate() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(myFramePath));
        waitVisibility(driver, emailField).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        clickElementWithJS(driver, sendEmailButton);
        return new CloudCalculatorResultPage(driver);
    }

}
