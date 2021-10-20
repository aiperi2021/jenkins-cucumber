package com.trycloud.pages;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(id = "user")
   public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement login;


    @FindBy(xpath = "//p[normalize-space(.)='Wrong username or password.']")
    public WebElement errorMsg;

    @FindBy()
    public List<WebElement> modules;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
Driver.getDriver().get(ConfigReader.read("trycloud_url"));
    }

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.click();
    }


}
