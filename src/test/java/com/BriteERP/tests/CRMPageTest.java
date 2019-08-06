package com.BriteERP.tests;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.pages.LoginPage;
import com.BriteERP.utilities.TestBase;
import com.BriteERP.utilities.BriteERPUtils;
import com.BriteERP.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CRMPageTest extends TestBase {

    @BeforeMethod
    public void startingTest(){
        extentLogger = report.createTest("Confirming Totals");
        driver.manage().window().maximize();
        extentLogger.info("Getting URL");
        driver.get(ConfigurationReader.getProperty("erpURL"));
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Getting credentials");
        loginPage.username.sendKeys(ConfigurationReader.getProperty("erpUserName"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("erpPassword"));
        loginPage.submit.click();
    }

    @Test
    public void revenueTotalTest(){
        extentLogger.info("Navigating to CRM module");
        pages.crmpage().getTab("CRM").click();
        extentLogger.info("Clicking on \"ListView\"");
        pages.crmpage().listView.click();
        extentLogger.info("Getting revenue total");
        double total1 = BriteERPUtils.getRevenueTotal(pages.crmpage().revenueList);
        extentLogger.info("Clicking on \"PivotView\"");
        pages.crmpage().pivotView.click();
        double total2 = BriteERPUtils.convertNums(pages.crmpage().expectedRevenueTotalPivot.getText());
        extentLogger.info("Confirming totals from List & Pivot view are equal.");
        Assert.assertEquals(total1, total2);
        extentLogger.info("Clicking new button in pivot view table");
        pages.crmpage().newButtonPivotTable.click();
        extentLogger.info("CLicking on to arrange accoding to opportunities");
        pages.crmpage().newListByDesired("Opportunity").click();
        extentLogger.info("Getting first opportunity total");
        double firstCustomerPivotTotal = BriteERPUtils.convertNums(pages.crmpage().firstCustPivotRevTotal().getText());
        extentLogger.info("Getting first opportunity customer name");
        String firstCustomerName = pages.crmpage().firstCustPivotName().getText();
        extentLogger.info("Clicking on ListView");
        pages.crmpage().listView.click();
        extentLogger.info("Getting the total for the person with same name in ListView");
        double specifiedCustomerListTotal = BriteERPUtils.convertNums(pages.crmpage().specifiedCusListTotal(firstCustomerName).getText());
        extentLogger.info("Confirming if totals match");
        Assert.assertEquals(firstCustomerPivotTotal,specifiedCustomerListTotal);
        extentLogger.info("Clicking on PivotView again");
        pages.crmpage().pivotView.click();
        extentLogger.info("Getting the total of Opportunities");
        double pivotListTotal = BriteERPUtils.convertNums(pages.crmpage().pivotViewTableTotal.getText());
        extentLogger.info("Getting the total for the list of Opportunities");
        double pivotListCustsTotal = pages.crmpage().returnPivotTableCustsTotal(pages.crmpage().pivotTableListRevenues);
        extentLogger.info("Confirming if totals match");
        Assert.assertEquals(pivotListTotal,pivotListCustsTotal);
    }
}
