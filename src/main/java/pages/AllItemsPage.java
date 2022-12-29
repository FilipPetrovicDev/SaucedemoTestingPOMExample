package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.WebDriver;

public class AllItemsPage extends BasePageClass{
    private final String allItemsPageUrl = CommonStrings.ALL_ITEMS_PAGE_URL;
    public AllItemsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAllItemsPage() {
        return waitForUrlChange(allItemsPageUrl, Time.TIME_SHORTER);
    }
}
