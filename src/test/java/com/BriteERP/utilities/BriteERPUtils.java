package com.BriteERP.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BriteERPUtils {

    public static void waitForLoading(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.o_loading")));
    }


    // converts BriteERP numsTo Int
    public static double convertNums(String num){
        while(num.contains(",")){
            num = num.replace(",","");
        }
        double newNum = 0;
        newNum = Double.parseDouble(num);
        return  newNum;
    }

    //gets Total from WebElement list of Nums
    public static double getRevenueTotal(List<WebElement>numList){
        List<String> revenueListString = BrowserUtils.getElementsText(numList);
        double total =0;
        for(String n:revenueListString){
            total += convertNums(n);
        }
        return total;
    }

}