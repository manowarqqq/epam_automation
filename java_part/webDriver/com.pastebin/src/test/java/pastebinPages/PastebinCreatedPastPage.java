package pastebinPages;

import org.openqa.selenium.WebDriver;

public class PastebinCreatedPastPage extends AbstractPage {


    protected PastebinCreatedPastPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return this;
    }
}
