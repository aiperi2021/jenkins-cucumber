package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class VerifyAllModules {

LoginPage loginPage=new LoginPage();
CommonArea commonArea=new CommonArea();

    @When("we provide valid credentials")
    public void we_provide_valid_credentials() {
loginPage.login(ConfigReader.read("username1"),ConfigReader.read("password"));
        BrowserUtil.waitFor(2);
    }
    @Then("verify the user see the following modules")
    public void verify_the_user_see_the_following_modules(List<String>expectedModules) {
        System.out.println("expectedModules = " + expectedModules);
        System.out.println(commonArea.getAllElement());
    }

}
