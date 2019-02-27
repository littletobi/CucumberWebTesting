package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BaseClass {

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "csi")
    private WebElement searchTextBox;

    @FindBy(how = How.NAME, using = "btnk")
    private WebElement searchButton;

    @FindBy(how = How.NAME, using = "btnI")
    private WebElement luckyButton;

    @FindBy(how = How.CLASS_NAME, using = "gb_P")
    private WebElement gmailLink;
}
