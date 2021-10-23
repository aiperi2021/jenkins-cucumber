package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import com.trycloud.pages.ContactPage;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ContactStepDefs {
    //CommonArea commonArea=new CommonArea();
    DashboardPage dashboardPage=new DashboardPage();
    ContactPage contactPage=new ContactPage();
    @When("click {string} button")
    public void click_button(String module) {

       // commonArea.clickModule("Contacts");
        contactPage.clickOnNewContactButton();
        BrowserUtil.waitFor(1);
    }

    @When("Fill out the contact info")
    public void fill_out_the_contact_info() {
        contactPage.contactInfo();
        BrowserUtil.waitFor(2);
    }

    @Then("Verify the contact name is added to the contact list")
    public void verify_the_contact_name_is_added_to_the_contact_list() {

        assertTrue(contactPage.companyNameText().contains("apple@online.com"));
        //assertTrue(contactPage.companyNameText().startsWith("AI"));

    }

    @Then("Verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {

       // System.out.println(contactPage.getAllFolder());
boolean result=false;
        for (String eachFolder : contactPage.getAllFolder()) {
            if(eachFolder.equals("New contact")){
                result=true;
                break;
            }else{
                result=false;
            }
        }
assertFalse(result);
    }

}
