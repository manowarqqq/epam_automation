package cloudPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import model.ComputeEngine;
import service.ComputeEngineDataCreator;

import static waiters.Waiter.clickElementWithJS;
import static waiters.Waiter.waitVisibility;


public class CloudCalculatorPage extends AbstractPage {

    private final By iframePath = By.xpath("//devsite-iframe/iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");
    private ComputeEngine computeEngine = ComputeEngineDataCreator.engineFromProperties();

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/../input")
    private WebElement numberOfInstanceField;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement instanceSeriesDropList;

    @FindBy(xpath = "//md-option[@value='n1']/div[contains(text(),'N1')]")
    private WebElement instanceSeriesValue;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addCPUCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropList;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUDropList;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeDropList;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropList;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location'][@id='select_92']")
    private WebElement datacenterLocationDropList;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage'][@id='select_99']")
    private WebElement commitedUsageDropList;

    @FindBy(xpath = "//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return this;
    }

    private WebElement getMachineTypeInstance() {
        return machineTypeDropList.findElement(By.xpath("//div[contains(text(),'" + computeEngine.getMachineTypeInstance() + "')]"));
    }

    private WebElement getNumberOfGPUInput() {
        return numberOfGPUDropList.findElement(By.xpath("//md-option[@value=" + computeEngine.getNumberOfGPUInput() + "]/div[text()=" +
                computeEngine.getNumberOfGPUInput() + "]"));
    }

    private WebElement getGpuTypeInstance() {
        return gpuTypeDropList.findElement(By.xpath("//div[contains(text(),'" + computeEngine.getGpuTypeInstance() + "')]"));
    }

    private WebElement getLocalSSDInstance() {
        return localSSDDropList.findElement(By.xpath("//div[contains(text(),'" + computeEngine.getLocalSSDInstance() + "')]"));
    }

    private WebElement getDatacenterLocationInctance() {
        return datacenterLocationDropList.findElement(By.xpath("//md-select-menu[@class='md-overflow']/md-content//div[contains(text(),'" +
                computeEngine.getDatacenterLocationInctance() + "')]"));
    }

    private WebElement getCommitedUsageInstance() {
        return commitedUsageDropList.findElement(By.xpath("//div[@id='select_container_100']//div[contains(text(),'" + computeEngine.getCommitedUsageInstance() + "')]/ancestor::md-option"));
    }

    public CloudCalculatorResultPage fillInstanceForm() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(myFramePath));
        waitVisibility(driver, numberOfInstanceField).sendKeys(computeEngine.getNumberOfInstanceField());
        clickElementWithJS(driver, waitVisibility(driver, instanceSeriesDropList));
        clickElementWithJS(driver, waitVisibility(driver, instanceSeriesValue));
        clickElementWithJS(driver, waitVisibility(driver, addCPUCheckBox));
        clickElementWithJS(driver, waitVisibility(driver, machineTypeDropList));
        clickElementWithJS(driver, waitVisibility(driver, getMachineTypeInstance()));
        clickElementWithJS(driver, waitVisibility(driver, numberOfGPUDropList));
        clickElementWithJS(driver, waitVisibility(driver, getNumberOfGPUInput()));
        clickElementWithJS(driver, waitVisibility(driver, gpuTypeDropList));
        clickElementWithJS(driver, waitVisibility(driver, getGpuTypeInstance()));
        clickElementWithJS(driver, waitVisibility(driver, localSSDDropList));
        clickElementWithJS(driver, waitVisibility(driver, getLocalSSDInstance()));
        clickElementWithJS(driver, waitVisibility(driver, datacenterLocationDropList));
        clickElementWithJS(driver, waitVisibility(driver, getDatacenterLocationInctance()));
        clickElementWithJS(driver, waitVisibility(driver, commitedUsageDropList));
        clickElementWithJS(driver, waitVisibility(driver, getCommitedUsageInstance()));
        clickElementWithJS(driver, waitVisibility(driver, addToEstimateButton));
        return new CloudCalculatorResultPage(driver);
    }
}
