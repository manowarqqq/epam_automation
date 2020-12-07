package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pastebinPages.PastebinCreatedPastPage;
import pastebinPages.PastebinHomePage;
import static  waiters.Waiter.waitVisibility;



public class PastebinHomePageTest extends BaseTest {


    private static final String INPUT_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                             "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\"\n)"+
                                             "git push origin master --force";

    @Test(testName = "I Can Win")
    public void createNewPaste()  {
        String code="Hello from WebDriver";
        String titile="helloweb";
        String highlighting ="None";
        String expiration= "10 Minutes";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code,highlighting,expiration,titile) ;

    }


   @Test(testName = "Bring It On")
    public void  pageTitleequalsPastTitle()  {
        String code=INPUT_TEXT;
       String highlighting ="Bash";
       String expiration= "10 Minutes";
        String titile="how to gain dominance among developers";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code,highlighting, expiration, titile) ;
        String actual_titile = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1"))).getText();
        Assert.assertTrue(actual_titile.contains(titile));

    }

    @Test(testName = "Bring It On")
    public void syntaxHighlightedForBash()  {
        String code=INPUT_TEXT;
        String highlighting ="Bash";
        String expiration= "10 Minutes";
        String titile="how to gain dominance among developers";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code,highlighting, expiration, titile) ;
        String actual_color = new WebDriverWait(driver,10).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='kw2']"))).getCssValue("color");
        Assert.assertEquals(actual_color, "rgba(194, 12, 185, 1)");
    }

        @Test(testName = "Bring It On")
        public void  outputCodeEqualsInput() {
            String code=INPUT_TEXT;
            String highlighting ="Bash";
            String expiration= "10 Minutes";
            String titile="how to gain dominance among developers";
            PastebinHomePage page = new PastebinHomePage(driver).openPage();
            PastebinCreatedPastPage createdPage = page.createPast(code,highlighting, expiration, titile) ;
            WebDriverWait wait =new WebDriverWait(driver,10);
            String actual_text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@class='bash']"))).getText();
            Assert.assertEquals(code,actual_text);

        }
    }
