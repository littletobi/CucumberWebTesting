package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends BaseClass {

    public GmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "gmail-nav__nav-link gmail-nav__nav-link__sign-in")
    private WebElement logInButton;

    @FindBy(how = How.CLASS_NAME, using = "gmail-nav__nav-link gmail-nav__nav-link__create-account")
    private WebElement createAccountButton;
}
