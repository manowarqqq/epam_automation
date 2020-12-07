package pastebinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import waiters.Waiter;

import java.util.List;
import java.util.stream.Collectors;

import static waiters.Waiter.*;


public class PastebinHomePage extends AbstractPage {


    @FindBy(xpath = "//textarea")
    private WebElement pastField;


//    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
//    private WebElement syntaxContainer;
//
//    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
//    private WebElement expirationContainer;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-format-container']")
    private WebElement syntaxHighlightingDroplist;

    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']/li")
    private List<WebElement> highlightingValues;

    @FindBy(xpath = "//span[@aria-labelledby='select2-postform-expiration-container']")
    private WebElement pastExpirationDropList;



    @FindBy(xpath = "//ul[@id='select2-postform-expiration-results']/li")
    private List<WebElement> pastExpirationValues;

    @FindBy(xpath = "//input[@name='PostForm[name]']")
    private WebElement pastNameTitle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPaste;

    private final static String HOMEPAGE_URL = "https://pastebin.com";

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }


    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        waitAjaxIsFinished(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public PastebinCreatedPastPage createPast(String code,String highlighting, String expiration, String titile) {
        waitAjaxIsFinished(driver,5);
        waitVisibility(driver,pastField).sendKeys(code);

        if(!highlighting.equals("None")) {
            waitVisibility(driver,syntaxHighlightingDroplist).click();
            WebElement highlightingValue = highlightingValues.stream().filter(x -> x.getText().equals(highlighting)).collect(Collectors.toList()).get(0);
            waitVisibility(driver,highlightingValue).click();
        }

        waitVisibility(driver,pastExpirationDropList).click();
        WebElement pastExpirationValue =pastExpirationValues.stream().filter(x -> x.getText().equals(expiration)).collect(Collectors.toList()).get(0);
        waitVisibility(driver,pastExpirationValue).click();
        waitVisibility(driver,pastNameTitle).sendKeys(titile);
        waitVisibility(driver, createNewPaste).click();
        while( !waitAjaxIsFinished(driver,10))
        {}

        return new PastebinCreatedPastPage(driver);

    }
}
