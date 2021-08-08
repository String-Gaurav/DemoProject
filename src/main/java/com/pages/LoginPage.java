package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.UUID;



public class LoginPage {
    private WebDriver driver;
    String randomEmailAddress = randomEmail();
    private final static Logger log = LogManager.getLogger(Connection.class);

    private By name = By.xpath("//input[@id='name']");
    private By workEmail = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password']");
    private By signupTerms = By.xpath("//label[@for='signup-terms']");
    private By signupSubscribe = By.xpath("//label[@for='signup-subscribe']");
    private By getStartedBtn = By.xpath("//button[normalize-space()='Get started now']");
    private By confirmationEmailAddress = By.xpath("//*[text()='" + randomEmailAddress + "']");
    private By errorValEnterPassword = By.xpath("//*[contains(text(),'Please enter your password.')]");
    private By errorValSecurePassword = By.xpath("//*[text()='Please use 8+ characters for secure password']");
    private By errorValEmailAlreadyRegistered = By.xpath("//div[@id='emailnotunique']");
    private By errorInvalidEmailAddress = By.xpath("//*[contains(text(),'This doesn’t look like an email address. Please check it for typos and try again.')]");
    private By errorValEmptyName = By.xpath("//div[@id='signup-error-emptyname']");
    private By errorValMiroTerms = By.xpath("//div[@id='signup-error-emptyterms']");
    private By errorValTermsMsg = By.xpath("//*[contains(text(),'Please agree with the Terms to sign up.')]");
    private By errorBlankEmail = By.xpath("//*[contains(text(),'Please enter your email address.')]");
    private List<WebElement> socialMediaLink;
    private By googleSigUpButton = By.xpath("//*[@id='a11y-signup-with-google']");
    private By popupCloseButton = By.xpath("//button[@class='socialtos__close js__socialtos-close']//*[local-name()='svg']");
    private By checkYourEmail = By.xpath("//h1[text()='Check your email']");




    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    public String getLoginPageTitle() {

        return driver.getTitle();
    }

    public void enterUsername(String username) {

        driver.findElement(name).sendKeys(username);

    }

    public void enterWorkEmail() {

        driver.findElement(workEmail).sendKeys(randomEmailAddress);

    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);

    }

    public void clickTermsBox() {

        driver.findElement(signupTerms).click();
        driver.findElement(signupSubscribe).click();

    }

    public void clickGetStarted() {

        driver.findElement(getStartedBtn).click();


    }

    public void confirmEmailAddress(String emailVerificationMsg) {

        System.out.println("Email Address :-" + randomEmailAddress);
        String actualEmail = driver.findElement(confirmationEmailAddress).getAttribute("innerText");
        System.out.println("Actual Email address :-" + actualEmail);

String actualEmailText= driver.findElement(checkYourEmail).getText();
log.info("Actual Email Text after signup :-"+actualEmailText );
        Assert.assertEquals(randomEmailAddress, actualEmail);
        Assert.assertEquals(emailVerificationMsg, actualEmailText);





    }

    public String errorMessageSecurePassword() {


        return driver.findElement(errorValSecurePassword).getAttribute("innerText");


    }

    public String errorMessagePassword() {

        return driver.findElement(errorValEnterPassword).getText();


    }

    public String errorMessageEmail() {

        return driver.findElement(errorBlankEmail).getText();


    }

    public String errorInvalidMessageEmail() {

        return driver.findElement(errorInvalidEmailAddress).getText();


    }

    public String errorMessageName() {

        return driver.findElement(errorValEmptyName).getText();


    }

    public String errorMiroTermsCheckbox() {

        return driver.findElement(errorValTermsMsg).getText();


    }

    public String randomEmail() {

        return "test-" + UUID.randomUUID().toString() + "@gmail.com";

    }

    public void enterInvalidEmail(String email) {

        driver.findElement(workEmail).sendKeys(email);

    }


    public void popupTermsAndSubscribe() {

        socialMediaLink = driver.findElements(By.xpath("(//div[@class='signup__social-container']//following::button)[position() <= 4]"));


        for (int i = 0; i < socialMediaLink.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");

            socialMediaLink.get(i).click();
            driver.findElement(popupCloseButton).click();

            log.info("Checking the social media links");


        }


    }

}
