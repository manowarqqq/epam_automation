package pastebinPages;

import org.openqa.selenium.WebDriver;

public class PastebinCreatedPastPage extends AbstractPage {


    PastebinCreatedPastPage(WebDriver driver) {
        super(driver);
    }

    protected AbstractPage openPage() {
        return this;
    }
}
