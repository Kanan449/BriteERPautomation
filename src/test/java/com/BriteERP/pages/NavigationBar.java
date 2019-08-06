package com.BriteERP.pages;

import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class NavigationBar {
    public NavigationBar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public WebElement getTab(String tab){
        String xpath = "//span[contains(text(),'"+tab+"')]";
        return BrowserUtils.waitForClickablility(Driver.getDriver().findElement(By.xpath(xpath)),5);
    }


}