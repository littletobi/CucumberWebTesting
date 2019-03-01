package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage extends BaseClass {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "gLFyf")
    public static WebElement searchTextBox;

    @FindBy(how = How.CSS, using = ".FPdoLc.VlcLAe input:nth-child(1)")
    public static WebElement searchButton;

    @FindBy(how = How.CSS, using = ".FPdoLc.VlcLAe input:nth-child(1)")
    public static WebElement luckyButton;

    @FindBy(how = How.CSS, using = ".gb_e.gb_f")
    public static WebElement gmailLink;

    public static class SearchResults {
        @FindBy(how = How.XPATH, using = "//h3[. = 'Barcelona – Wikipedia, wolna encyklopedia']")
        public static WebElement barcaWikiPage;

        @FindBy(how = How.XPATH, using = "//h3[. = 'Real Madryt – Wikipedia, wolna encyklopedia']")
        public static WebElement realWikiPage;

        @FindBy(how = How.XPATH, using = "//*[contains(@href, 'https://www.fcbarcelona.com/en')]")
        public static WebElement barcaOfficialPage;

        @FindBy(how = How.XPATH, using = "//a[contains(@href, 'https://www.realmadrid.com')]")
        public static WebElement realOfficialPage;
    }

}
