package parallel;


import com.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.junit.Assert;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;
import java.util.Properties;


public class LoginSteps extends ConfigReader {

    private final static Logger log = LogManager.getLogger(Connection.class);

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    private ConfigReader ConfigReader;
    Properties prop;


    @Given("Enter the url of the MIRO Page")
    public void enter_the_url() {

        ConfigReader = new ConfigReader();

        prop = ConfigReader.init_prop();
        DriverFactory.getDriver().get(prop.getProperty("url"));
        log.info("Url got opened");

    }

    @When("^Enter the name \"([^\"]*)\"$")
    public void enter_the_username(String name) {

        loginPage.enterUsername(name);
        log.info("Entered the username");


    }

    @And("^Enter the password \"([^\"]*)\"$")
    public void enter_the_password(String pass) {

        loginPage.enterPassword(pass);
        log.info("Entered Password");

    }

    @And("^Enter the work email \"([^\"]*)\"$")
    public void enter_the_email(String email) {

        loginPage.enterInvalidEmail(email);
        log.info("Entered invalid Email Address");

    }


    @And("^Enter the work email$")
    public void enter_the_email() {

        loginPage.enterWorkEmail();
        log.info("Entered the Email");
    }

    @When("Verify the title of the page")
    public void verify_heading() {
        String titleActual = loginPage.getLoginPageTitle();
        log.info("The page title :- " + titleActual);
        Assert.assertEquals("Sign up | Miro | Online Whiteboard for Visual Collaboration", titleActual);


    }

    @Then("^Verify the email address after singing up$")
    public void verify_afterConfirmationText() {

        loginPage.confirmEmailAddress();


    }

    @And("click on Miro Terms checkbox")
    public void click_on_miro_terms_checkbox() {

        loginPage.clickTermsBox();

        log.info("Clicked MIRO terms checkbox");

    }


    @Then("^Don't enter any value in name, check the error message \"([^\"]*)\"$")
    public void blankNameTextBox(String nameErrorMessage) {

        log.info("Name error message" + loginPage.errorMessageName());

        Assert.assertEquals(nameErrorMessage, loginPage.errorMessageName());


    }

    @Then("^Don't enter any value in email, check the error message \"([^\"]*)\"$")
    public void blankEmailTextBox(String emailErrorMessage) {

        log.info("Empty Email textbox, error message" + loginPage.errorMessageEmail());
        Assert.assertEquals(emailErrorMessage, loginPage.errorMessageEmail());


    }

    @Then("^Enter invalid value in email textbox, check the error message \"([^\"]*)\"$")
    public void invalidEmailTextBox(String invalidEmailErrorMessage) {

        log.info("Invalid Email Expected Message :-" + invalidEmailErrorMessage + "Invalid Email Actual Error:-" + loginPage.errorInvalidMessageEmail());
        Assert.assertEquals(invalidEmailErrorMessage, loginPage.errorInvalidMessageEmail());


    }

    @Then("^Don't enter any value in password, check the error message \"([^\"]*)\"$")
    public void blankPasswordTextBox(String passwordErrorMessage) throws InterruptedException {

        log.info("Password Expected Message :-" + passwordErrorMessage + "Password Actual Error:-" + loginPage.errorMessagePassword());
        Assert.assertEquals(passwordErrorMessage, loginPage.errorMessagePassword());
    }

    @And("click on Get Started Button")
    public void click_on_GetStartedBtn() {
        loginPage.clickGetStarted();

        log.info("Click on Get Started button");
    }

    @Then("^Enter invalid value in password textbox, check the error message \"([^\"]*)\"$")
    public void invalidPasswordTextBox(String passwordErrorMessage) {

        log.info("Password Expected Message :-" + passwordErrorMessage + "Password Actual Error:-" + loginPage.errorMessageSecurePassword());
        Assert.assertEquals(passwordErrorMessage, loginPage.errorMessageSecurePassword());
    }

    @Then("^Terms should be unselected, check the error message \"([^\"]*)\"$")
    public void termsNotSelected(String termsErrorMessage) {

        log.info("Terms Expected Error Message :-" + termsErrorMessage + "Term Actual Error Message:-" + loginPage.errorMiroTermsCheckbox());
        Assert.assertEquals(termsErrorMessage, loginPage.errorMiroTermsCheckbox());
    }

    @And("click on signup popup page")
    public void click_on_MiroTermsAndSubs() throws InterruptedException {
        loginPage.popupTermsAndSubscribe();

        log.info("Verified the all social media links for sign-up");
    }

}


