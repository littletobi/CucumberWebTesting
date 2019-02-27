package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDefs_GooglePage {

    private static WebDriver driver;

    public StepDefs_GooglePage() {
        driver = Hooks.driver;
    }

    @Given("^I launch the browser (.*)$")
    public void i_launch_the_browser(String browser) throws Exception { //Browsers browser
        //  googleHomepage.launchBrowser(browser);
    }

    @When("^I open Google Homepage$")
    public void i_open_Google_Homepage() throws Exception {
        driver.get("http://google.com");
        Assert.assertTrue(false);
        //   googleHomepage.openGoogleURL();
    }

    @Then("^I verify that the page displays search text box$")
    public void i_verify_that_the_page_displays_search_text_box() throws Exception {
        //    googleHomepage.checkSearchBoxIsDisplayed();
    }

    @Then("^the page displays Google Search button$")
    public void the_page_displays_Google_Search_button() throws Exception {
        //  googleHomepage.checkGoogleSearchButtonIsDisplayed();
    }

    @Then("^the page displays Im Feeling Lucky button$")
    public void the_page_displays_Im_Feeling_Lucky_button() throws Exception {
        //   googleHomepage.checkImFeelingLuckyButtonIsDisplayed();
    }
}
