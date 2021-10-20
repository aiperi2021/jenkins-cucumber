package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletedPage {

    public DeletedPage() {
       PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//tr[@data-path='Selenium_methods.pdf']//span[.='Selenium_methods']")
    public WebElement deletedFile;


    @FindBy (xpath = "//tr[@data-path='Selenium_methods.pdf']//a[@class='action action-restore permanent']")
    public WebElement restore;







}