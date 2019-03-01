package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends BaseClass {

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "identifierId")
    public static WebElement identifierInput;

    @FindBy(how = How.CSS, using = ".U26fgb.O0WRkf.zZhnYe")
    public  static WebElement nextBtn;

    public static class GmailConfirmation {
        @FindBy(how = How.CSS, using = ".wRNPwe.S7pdP")
        public static WebElement passwordVisibleIcon;

        @FindBy(how = How.CSS, using = ".whsOnd.zHQkBf")
        public static WebElement passwordInput;

        @FindBy(how = How.ID, using = "passwordNext")
        public static WebElement confirmationPasswdBtn;

        @FindBy(how = How.CSS, using = ".xgOPLd")
        public static WebElement errorMessage;
    }
}
