package waiters;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static WebDriverWait waitTimeout(WebDriver driver,int timeout) {
        return  new WebDriverWait(driver,timeout);
    }

    public static WebElement waitVisibility(WebDriver driver, WebElement element) {
        return  new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean waitAjaxIsFinished(WebDriver driver, int time) {
        return new WebDriverWait(driver,time).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery != null) && (jQuery.active ===0);");
            }
        });
    }

}
