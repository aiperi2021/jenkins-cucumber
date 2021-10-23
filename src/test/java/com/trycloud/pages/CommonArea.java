package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonArea {

    @FindBy(xpath = "(//li[@data-id='dashboard'])[1]")
    public WebElement dashboardModule;

    @FindBy(xpath = "(//a[@aria-label = 'Files'])[1]")
    public WebElement filesModule;

    @FindBy(xpath = "(//a[@aria-label='Photos'])[1]")
    public WebElement photosModule;

    @FindBy(xpath = "(//a[@aria-label='Activity'])[1]")
    public WebElement activityModule;

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkModule;

    @FindBy(xpath = "(//a[@aria-label='Contacts'])[1]")
    public WebElement contactsModule;

    @FindBy(xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendarModule;

    @FindBy(xpath = "(//a[@aria-label='Deck'])[1]")
    public WebElement deckModule;

    @FindBy(xpath = "//span[@aria-label = 'Magnify icon']")
    public WebElement magnifierIcon;

    @FindBy(xpath = "//input [@type = 'search']")
    public WebElement searchBox;

    @FindBy(xpath = "//span/h3[@title]")
    public WebElement searchResult;

    public CommonArea() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickModule(String moduleName){
        WebElement modules = Driver.getDriver().findElement(By.xpath("(//a[@aria-label = '"+moduleName+"'])[1]"));
        modules.click();
    }
    public void navigateToTab(String tabName){


        WebElement ModuleName =Driver.getDriver().findElement(By.
                xpath("//ul//li//a//span[normalize-space(.)='"+tabName+"']"));

        Actions action =new Actions(Driver.getDriver()) ;
        action.moveToElement(ModuleName).doubleClick().perform();
    }

}
