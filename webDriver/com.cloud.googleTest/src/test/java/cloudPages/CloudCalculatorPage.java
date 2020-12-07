package cloudPages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static waiters.Waiter.waitVisibility;

public class CloudCalculatorPage extends AbstractPage {

    private final By iframePath = By.xpath("//devsite-iframe/iframe");
    private final By myFramePath = By.xpath("//*[@id='myFrame']");


    @FindBy(xpath = "//input[@id='input_58']")
    private WebElement numberOfInstanceField;

    @FindBy(xpath = "//div//label[text()='Machine type']/following-sibling::md-select//span[@class = 'md-select-icon']")
    private WebElement machineTypeDropList;

    @FindBy(xpath = "//*[@id='select_option_213']/div")
    private WebElement machineTypeInstance;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addCPUCheckBox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUDropList;

    @FindBy(xpath = "//*[@id='select_option_342']")
    private WebElement numberOfGPUInput;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeDropList;

    @FindBy(xpath = "//*[@id='select_option_349']/div")
    private WebElement gpuTypeInstance;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropList;

    @FindBy(xpath = "//*[@id='select_option_234']/div")
    private WebElement localSSDInstance;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationDropList;

    @FindBy(xpath = "//*[@id='select_option_181']/div")
    private WebElement datacenterLocationInctance;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageDropList;

    @FindBy(xpath = "//*[@id='select_option_90']/div[1]")
    private WebElement commitedUsageInstance;

    @FindBy(xpath = "//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;


    CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected AbstractPage openPage() {
        return this;
    }


    public CloudCalculatorResultPage fillInstanceForm() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframePath));
        new WebDriverWait(driver, 5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(myFramePath));
        waitVisibility(driver, numberOfInstanceField).sendKeys("4");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, addCPUCheckBox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, machineTypeDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, machineTypeInstance));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, numberOfGPUDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, numberOfGPUInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, gpuTypeDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, gpuTypeInstance));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, localSSDDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, localSSDInstance));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, datacenterLocationDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, datacenterLocationInctance));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, commitedUsageDropList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, commitedUsageInstance));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", waitVisibility(driver, addToEstimateButton));
        return new CloudCalculatorResultPage(driver);
    }
}
