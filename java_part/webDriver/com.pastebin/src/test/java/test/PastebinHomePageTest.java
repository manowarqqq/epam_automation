package test.java.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pastebinPages.PastebinCreatedPastPage;
import test.java.pastebinPages.PastebinHomePage;


public class PastebinHomePageTest extends BaseTest {


    @Test(testName = "I Can Win")
    public void createNewPaste()  {
        String code="Hello from WebDriver";
        int pastexpirationDropListIndex=1;
        String titile="helloweb";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code,0 ,pastexpirationDropListIndex,titile) ;

    }
    @Test(testName = "Bring It On")
    public void  pageTitleequalsPastTitle() {
        String code="git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\"\n)"+
                    "git push origin master --force";
        int syntaxHighlightingindex=0;
        int pastexpirationDropListIndex=1;
        String titile="how to gain dominance among developers";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code,syntaxHighlightingindex ,pastexpirationDropListIndex,titile) ;
        Assert.assertTrue(driver.findElements(By.xpath("//head/title")).get(0).getAttribute("text").contains(titile));
    }

    @Test(testName = "Bring It On")
    public void syntaxHighlightedForBash() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        int syntaxHighlightingindex = 2;
        int pastexpirationDropListIndex = 1;
        String titile = "how to gain dominance among developers";
        PastebinHomePage page = new PastebinHomePage(driver).openPage();
        PastebinCreatedPastPage createdPage = page.createPast(code, syntaxHighlightingindex, pastexpirationDropListIndex, titile);
        String s = driver.findElement(By.xpath("//span[@class='kw2']")).getCssValue("color");
        Assert.assertEquals(s, "rgba(194, 12, 185, 1)");
    }

        @Test(testName = "Bring It On")
        public void  outputCodeEqualsInput()  {
            String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";
            int syntaxHighlightingindex = 2;
            int pastexpirationDropListIndex = 1;
            String titile = "how to gain dominance among developers";
            PastebinHomePage page = new PastebinHomePage(driver).openPage();
            PastebinCreatedPastPage createdPage = page.createPast(code, syntaxHighlightingindex, pastexpirationDropListIndex, titile);
            Assert.assertEquals(code,driver.findElement(By.xpath("//*[@id=\"paste_code\"]")).getText() );

        }
    }
