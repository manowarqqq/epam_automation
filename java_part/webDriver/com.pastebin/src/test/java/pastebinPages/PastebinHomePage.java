package pastebinPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static waiters.Waiter.*;


public class PastebinHomePage extends AbstractPage {


    @FindBy(xpath = "//textarea")
    private WebElement pastField;

    @FindBy(xpath = "//select[@name='paste_format']")
    private WebElement syntaxHighlighting;


    @FindBy(xpath = "//select[@name='paste_expire_date']")
    private WebElement pastExpirationDropList;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement pastNameTitle;

    @FindBy(xpath = "//input[@type='submit']")
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

    public PastebinCreatedPastPage createPast(String code, int syntaxHighlightingIndex, int pastexpirationDropListIndex, String titile) throws InterruptedException {
        Select selectSyntaxHiglighting = new Select(syntaxHighlighting);
        Select selectPastexpiration = new Select(pastExpirationDropList);
        pastField.sendKeys(code);
        selectSyntaxHiglighting.selectByIndex(syntaxHighlightingIndex);
        selectPastexpiration.selectByIndex(pastexpirationDropListIndex);
        pastNameTitle.sendKeys(titile);
        waitVisibility(driver, createNewPaste);
        createNewPaste.click();
        Thread.sleep(2000);
        return new PastebinCreatedPastPage(driver);
    }
}
