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


//import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudCalculatorPage extends AbstractPage {

    private final By iframePath = By.xpath("//devsite-iframe/iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");
    private ComputeEngine computeEngine = ComputeEngineDataCreator.engineFromProperties();
    private final String M_T = computeEngine.getMachineTypeInstance();

    @FindBy(xpath = "//input[@id='input_60']")
    private WebElement numberOfInstanceField;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addCPUCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropList;

    @FindBy(xpath = "//*[@id='select_option_236']/div")
    private WebElement machineTypeInstance;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUDropList;

    @FindBy(xpath = "//md-option[@value=1]/div[text()=1]")
    private WebElement numberOfGPUInput;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeDropList;

    @FindBy(xpath = "//div[contains(text(),'NVIDIA Tesla V100')]")
    private WebElement gpuTypeInstance;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropList;

    @FindBy(xpath = "//div[contains(text(),'2x375 GB')]")
    private WebElement localSSDInstance;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location'][@id='select_88']")
    private WebElement datacenterLocationDropList;

    @FindBy(xpath = "//md-option[@value='europe-west3']/div[text()='Frankfurt (europe-west3)']")
    private WebElement datacenterLocationInctance;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
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
        return commitedUsageDropList.findElement(By.xpath("//div[@id='select_container_96']//div[contains(text(),'" + computeEngine.getCommitedUsageInstance() + "')]/ancestor::md-option"));
    }


    public CloudCalculatorResultPage fillInstanceForm() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(myFramePath));
        waitVisibility(driver, numberOfInstanceField).sendKeys("4");
        clickElementWithJS(driver, waitVisibility(driver, addCPUCheckBox));
        clickElementWithJS(driver, waitVisibility(driver, machineTypeDropList));
        clickElementWithJS(driver, waitVisibility(driver, machineTypeInstance));
        clickElementWithJS(driver, waitVisibility(driver, numberOfGPUDropList));
        clickElementWithJS(driver, waitVisibility(driver, numberOfGPUInput));
        clickElementWithJS(driver, waitVisibility(driver, gpuTypeDropList));
        clickElementWithJS(driver, waitVisibility(driver, gpuTypeInstance));
        clickElementWithJS(driver, waitVisibility(driver, localSSDDropList));
        clickElementWithJS(driver, waitVisibility(driver, localSSDInstance));
        clickElementWithJS(driver, waitVisibility(driver, datacenterLocationDropList));
        clickElementWithJS(driver, waitVisibility(driver, datacenterLocationInctance));
        clickElementWithJS(driver, waitVisibility(driver, commitedUsageDropList));
        clickElementWithJS(driver, waitVisibility(driver, commitedUsageInstance));
        clickElementWithJS(driver, waitVisibility(driver, addToEstimateButton));
        return new CloudCalculatorResultPage(driver);
    }
}
