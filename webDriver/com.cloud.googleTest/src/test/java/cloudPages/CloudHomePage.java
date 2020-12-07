package cloudPages;

import cloudPages.AbstractPage;
import cloudPages.CloudSearchResultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiter;


import static waiters.Waiter.waitTimeout;

public class CloudHomePage extends AbstractPage {

    private final static String HOME_URL = "https://cloud.google.com";

    @FindBy(xpath = "//*[@project-name]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;


    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CloudHomePage openPage() {
        driver.get(HOME_URL);
        waitTimeout(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public CloudSearchResultPage getSearchResult(String term) {
        Waiter.waitVisibility(driver, searchButton);
        searchButton.click();
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
        return new CloudSearchResultPage(driver);


    }

}
