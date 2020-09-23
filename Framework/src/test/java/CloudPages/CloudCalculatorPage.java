package CloudPages;

import model.ComputeEngine;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ComputeEngineDataCreator;

import static waiters.Waiter.waitVisibility;

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

    @FindBy(xpath = "//md-option[@value=1]/div[text()=1]")     //*[@id='select_option_430']/div
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
    //*[@id='select_option_181']/div
    private WebElement datacenterLocationInctance;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageDropList;

//   @FindBy(xpath = "//*[@id='select_option_90']/div[1]")
//    private WebElement commitedUsageInstance;

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
        return numberOfGPUDropList.findElement(By.xpath("//md-option[@value=" + computeEngine.getNumberOfGPUInput() + "]/div[text()=" + computeEngine.getNumberOfGPUInput() + "]"));
    }

    private WebElement getGpuTypeInstance() {
        return gpuTypeDropList.findElement(By.xpath("//div[contains(text(),'" + computeEngine.getGpuTypeInstance() + "')]"));
    }

    private WebElement getLocalSSDInstance() {
        return localSSDDropList.findElement(By.xpath("//div[contains(text(),'" + computeEngine.getLocalSSDInstance() + "')]"));
    }

    private WebElement getDatacenterLocationInctance() {
        //return datacenterLocationDropList.findElement(By.xpath("//div[text()='"+computeEngine.getDatacenterLocationInctance()+"']/ancestor::md-option"));
        return datacenterLocationDropList.findElement(By.xpath("//md-select-menu[@class='md-overflow']/md-content//div[contains(text(),'" + computeEngine.getDatacenterLocationInctance() + "')]"));


    }

    private WebElement getCommitedUsageInstance() {
        return commitedUsageDropList.findElement(By.xpath("//div[@id='select_container_96']//div[contains(text(),'" + computeEngine.getCommitedUsageInstance() + "')]/ancestor::md-option"));
    }


    public CloudCalculatorResultPage fillInstanceForm() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(myFramePath));
        waitVisibility(driver, numberOfInstanceField).sendKeys(computeEngine.getNumberOfInstanceField());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, addCPUCheckBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, machineTypeDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getMachineTypeInstance()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, numberOfGPUDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getNumberOfGPUInput()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, gpuTypeDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getGpuTypeInstance()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, localSSDDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getLocalSSDInstance()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, datacenterLocationDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getDatacenterLocationInctance()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, commitedUsageDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, getCommitedUsageInstance()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, addToEstimateButton));
        logger.info("Form is filled");
        return new CloudCalculatorResultPage(driver);
    }

}
