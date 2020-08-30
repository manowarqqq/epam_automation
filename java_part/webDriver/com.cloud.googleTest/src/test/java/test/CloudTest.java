package test;

import CloudPages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class CloudTest extends BaseTest {


    @Test
    public void checkVMclass() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String vmClass = calc.fillInstanceForm().getVMclass();
        Assert.assertTrue(vmClass.matches("(?i).*Regular.*"));
    }

    @Test
    public void checkInstanceType() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String instanceType = calc.fillInstanceForm().getInstanceType();
        Assert.assertTrue(instanceType.matches("(?i).*n1-standard-8.*"));
    }

    @Test
    public void checkRegion() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String region = calc.fillInstanceForm().getRegion();
        Assert.assertTrue(region.matches("(?i).*Frankfurt.*"));
    }

    @Test
    public void checkLocalSSD() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String localSSD = calc.fillInstanceForm().getLocalSSD();
        Assert.assertTrue(localSSD.matches("(?i).*2x375.*"));
    }

    @Test
    public void checkCommitmentTerm() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String commitmentTerm = calc.fillInstanceForm().getCommitmentTerm();
        Assert.assertTrue(commitmentTerm.matches("(?i).*1 Year.*"));
    }


    @Test
    public void checkTotalEstimatedCost() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        String estimatedCost = calc.fillInstanceForm().getEstimatedCost();
        Assert.assertTrue(estimatedCost.equalsIgnoreCase("total estimated cost: usd 1,082.77 per 1 month"));
    }


    @Test
    public void checkTotalEstimatedCostInEmail() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        CloudCalculatorResultPage ccrp = calc.fillInstanceForm().getEmailEstimateForm();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        TenMinutesEmailPage tenMinutesEmailPage = new TenMinutesEmailPage(driver).openPage();
        tenMinutesEmailPage.copyTenMinuteEmail();
        driver.switchTo().window(tab.get(0));
        ccrp.sendEmailWithEstimate();
        driver.switchTo().window(tab.get(1));
        String estimatedInEmail = tenMinutesEmailPage.openEmail().getEstimatedCostInTheMail();
        Assert.assertTrue(estimatedInEmail.matches("(?i).*1,082.77.*"));
    }
}
