package test;

import CloudPages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputeEngineDataCreator;
import utils.RegexCreator;

import java.util.ArrayList;


public class CloudTest extends BaseTest {


    @Test
    public void testOpenCalculatorPage() {
        CloudHomePage page = new CloudHomePage(driver).openPage();
        CloudSearchResultPage searchPage = page.getSearchResult("Google Cloud Platform Pricing Calculator");
        CloudCalculatorPage calc = searchPage.getCalculatorPage();
        Assert.assertEquals(driver.getTitle(), "Google Cloud Platform Pricing Calculator");

    }


    @Test
    public void checkTotalEstimatedCostInEmail()  {
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
        Assert.assertTrue(estimatedInEmail.matches(RegexCreator.estimatedCostRegex));
    }
}
