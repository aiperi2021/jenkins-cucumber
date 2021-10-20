package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
LoginPage loginPage=new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        loginPage.goTo();
        BrowserUtil.waitFor(2);
    }
    @When("user use username {string} and password {string}")
    public void user_use_username_and_password(String username, String password) {
        loginPage.login(username,password);

    }
    @When("user click login button")
    public void user_click_login_button() {


    }
    @Then("user should be at dashboard page")
    public void user_should_be_at_dashboard_page() {

assertEquals( "Dashboard - Trycloud",Driver.getDriver().getTitle());
    }

    @When("user provide username {string} and password {string}")
    public void user_provide_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("we should still be at login page")
    public void we_should_still_be_at_login_page() {

    }
    @Then("login error message should be present")
    public void login_error_message_should_be_present() {
assertTrue(loginPage.errorMsg.isDisplayed());
    }


//
//    @When("we provide valid credentials")
//    public void we_provide_valid_credentials() {
//
//    }
//    @Then("verify the user see the following modules")
//    public void verify_the_user_see_the_following_modules(List<String>expectedModules) {
//        System.out.println("expectedModules = " + expectedModules);
//
//        List<String>actualModule=BrowserUtil.getAllText(new CommonArea().allModules);
//        assertEquals(expectedModules,actualModule);
//        BrowserUtil.waitFor(3);
//    }


}
