package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.JsonSerializer;
import helpers.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.GooglePage;

import javax.jws.soap.SOAPBinding;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefs_GooglePage {

    private static WebDriver driver;

    public StepDefs_GooglePage() {
        driver = Hooks.driver;
        PageFactory.initElements(driver, GooglePage.class);
    }

    @When("^I open Google Homepage$")
    public void i_open_Google_Homepage() throws Exception {
        //PageFactory.initElements(driver, GooglePage.class);
        driver.get("http://google.pl");
      //  driver.manage().window().fullscreen();
        assertTrue(driver.getCurrentUrl().contains("www.google.com"));
    }

    @Then("^I verify that the page displays search text box$")
    public void i_verify_that_the_page_displays_search_text_box() throws Exception {
        assertTrue(GooglePage.searchTextBox.isDisplayed());
    }

    @Then("^the page displays Google Search button$")
    public void the_page_displays_Google_Search_button() throws Exception {
        assertTrue(GooglePage.searchButton.isDisplayed());
    }

    @Then("^the page displays Im Feeling Lucky button$")
    public void the_page_displays_Im_Feeling_Lucky_button() throws Exception {
        assertTrue(GooglePage.luckyButton.isDisplayed());
    }

    @And("^I search for information about my favorite football club (.*)$")
    public void iSearchForInformationAboutMyFavoriteFootballClub(String clubName) {
        GooglePage.searchTextBox.sendKeys(clubName);
        GooglePage.searchTextBox.sendKeys((Keys.ENTER));
    }

    @Then("^I should get wiki page about the club (.*)$")
    public void iShouldGetWikiPageAboutTheClub(String clubName) {
        PageFactory.initElements(driver, GooglePage.SearchResults.class);
        if (clubName.equals("Barcelona")) {
            assertTrue(GooglePage.SearchResults.barcaWikiPage.isDisplayed());
        } else if (clubName.equals("Real Madryt")) {
            assertTrue((GooglePage.SearchResults.realWikiPage.isDisplayed()));
        }
    }

    @And("^Official web page of the club (.*)$")
    public void officialWebPageOfTheClub(String clubName) {
        if (clubName.equals("Barcelona")) {
            assertTrue(GooglePage.SearchResults.barcaOfficialPage.isDisplayed());
        } else if (clubName.equals("Real Madryt")) {
            assertTrue((GooglePage.SearchResults.realOfficialPage.isDisplayed()));
        }
    }

    //Background
    @Given("^I have user credentials$")
    public void iHaveUserCredentials() {
        try {
            List<User> a = JsonSerializer.deserializeFromJson(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\settings.json");
        } catch (Exception e) {
            System.out.println("Exception while deserializing data from file");
        }
    }
}
