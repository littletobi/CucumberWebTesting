package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonSerializer;
import helpers.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.GmailPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class StepDefs_GmailPage {

    private static WebDriver driver;
    WebDriverWait waiter;

    public StepDefs_GmailPage() {
        driver = Hooks.driver;
        PageFactory.initElements(driver, GmailPage.class);
    }

    //Background
    @Given("^User is on gmail page$")
    public void userIsOnGmailPage() {
        driver.get("http://gmail.com");
        assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com"));
    }

    @When("^User try to login with credentials from datatable$")
    public void userTryToLoginWithCredentialsFromDatatable(DataTable loginData) {
        List<String> data = loginData.asList(String.class);
        GmailPage.identifierInput.sendKeys(data.get(0));
        GmailPage.nextBtn.click();
        PageFactory.initElements(driver, GmailPage.GmailConfirmation.class);
        GmailPage.GmailConfirmation.passwordInput.sendKeys(data.get(0));
        GmailPage.GmailConfirmation.confirmationPasswdBtn.click();
    }

    @When("^User try to login with credentials from datatable with headers$")
    public void userTryToLoginWithCredentialsFromDatatableWithHeaders(DataTable loginData) {
        waiter = new WebDriverWait(driver, 15);
        List<Map<String, String>> data = loginData.asMaps(String.class, String.class);
        GmailPage.identifierInput.sendKeys(data.get(0).get("credentials"));
        GmailPage.nextBtn.click();
        PageFactory.initElements(driver, GmailPage.GmailConfirmation.class);
        waiter.until(ExpectedConditions.elementToBeClickable(GmailPage.GmailConfirmation.passwordVisibleIcon));
        GmailPage.GmailConfirmation.passwordVisibleIcon.click();
        GmailPage.GmailConfirmation.passwordInput.sendKeys(data.get(0).get("password"));
        GmailPage.GmailConfirmation.confirmationPasswdBtn.click();
    }

    @Then("^Error message is displayed$")
    public void errorMessageIsDisplayed() {
        waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.visibilityOf(GmailPage.GmailConfirmation.errorMessage));
        assertTrue("Error message was not displayed", GmailPage.GmailConfirmation.errorMessage.isDisplayed());
    }

    @When("^User try to login with incorrect credentials from json \"([^\"]*)\"$")
    public void userTryToLoginWithIncorrectCredentialsFromJson(String jsonFileName) throws Throwable {
        waiter = new WebDriverWait(driver, 15);
        List<User> listOfUsersFromJson = JsonSerializer.deserializeFromJson(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\" + jsonFileName);
        String identyficationData = listOfUsersFromJson.get(0).getEmail();
        GmailPage.identifierInput.sendKeys(identyficationData);
        GmailPage.nextBtn.click();
        PageFactory.initElements(driver, GmailPage.GmailConfirmation.class);
        String password = listOfUsersFromJson.get(0).getUserPassword();
        waiter.until(ExpectedConditions.elementToBeClickable(GmailPage.GmailConfirmation.passwordVisibleIcon));
        GmailPage.GmailConfirmation.passwordVisibleIcon.click();
        GmailPage.GmailConfirmation.passwordInput.sendKeys(password);
        GmailPage.GmailConfirmation.confirmationPasswdBtn.click();
    }
}
