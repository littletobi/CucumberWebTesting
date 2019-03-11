//package managers;
//
//import org.openqa.selenium.WebDriver;
//import pageObjects.GmailPage;
//import pageObjects.GooglePage;
//
//public class PageObjectManager {
//
//    private WebDriver driver;
//
//    private GooglePage googlePage;
//
//    private GmailPage gmailPage;
//
//    public PageObjectManager(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public GooglePage getGooglePage() {
//
//        return (googlePage == null) ? googlePage = new GooglePage(driver) : googlePage;
//
//    }
//
//    public GmailPage getProductListingPage() {
//        return (gmailPage == null) ? gmailPage = new GmailPage(driver) : gmailPage;
//    }
//}