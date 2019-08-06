package com.BriteERP.pages;


import com.BriteERP.utilities.BriteERPUtils;
import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRMPage extends NavigationBar{
    public CRMPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//button[@data-original-title='List']")
    public WebElement listView;

    @FindBy(xpath ="//button[@data-original-title='Kanban']")
    public WebElement kanbanView;

    @FindBy(xpath = "//table[contains(@class,'o_list_view')]/tbody/tr/td[9]")
    public List<WebElement>revenueList;

    @FindBy(xpath = "//button[@data-original-title='Pivot']")
    public WebElement pivotView;

    @FindBy(xpath = "//table[contains(@class,'table-hover table-condensed table-bordered')]//td[2]")
    public WebElement expectedRevenueTotalPivot;

    @FindBy(xpath = "//table[contains(@class,'table-hover')]//tr[2]/td[1]")
    public WebElement newButtonPivotTable;

    @FindBy(xpath = "//table[contains(@class,'table-hover')]//td[2]")
    public List<WebElement> pivotTableListRevenues;

    @FindBy(xpath = "//table[contains(@class,'table-hover')]//tr[1]/td[2]")
    public WebElement pivotViewTableTotal;

    public WebElement newListByDesired(String desired){
        String xpath = "//ul[contains(@class,'dropdown-menu o_pivot_field_menu')]//a[contains(text(),'"+desired+"')]";
        return BrowserUtils.waitForClickablility(By.xpath(xpath),5);
    }

    public WebElement specifiedCusPivotViewExpRev(String cusName){
        String xpath = "//table[contains(@class,'table-hover')]//td[contains(text(),'"+cusName+"')]/../td[2]";
        return BrowserUtils.waitForVisibility(By.xpath(xpath),5);
    }

    public WebElement firstCustPivotRevTotal(){
        String xpath = "//table[contains(@class,'table-hover')]//tr[3]/td[2]";
        return BrowserUtils.waitForVisibility(By.xpath(xpath),5);
    }

    public WebElement firstCustPivotName(){
        String xpath = "//table[contains(@class,'table-hover')]//tr[3]/td[1]";
        return BrowserUtils.waitForVisibility(By.xpath(xpath),5);
    }

    public WebElement specifiedCusListTotal(String name){
        String xpath ="//table[contains(@class,'o_list_view table')]//td[contains(text(),'"+name+"')]/..//td[9]";
        return BrowserUtils.waitForVisibility(By.xpath(xpath),5);
    }

    public double returnPivotTableCustsTotal(List<WebElement>elements){
        List<String>stringElements= BrowserUtils.getElementsText(elements);
        double revTotal = 0;
        for(int i = 2; i < stringElements.size(); i++){
            revTotal+= BriteERPUtils.convertNums(stringElements.get(i));
        }
        return revTotal;
    }





}