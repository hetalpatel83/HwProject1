package Proj1160519;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbleToChangeCurrency extends Utils
{

    //@Test
    public static void priceCurrency(){
        //To perform hovering task on Apparels
        mouseOverHover(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));

        //Click on Clothing
        clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[2]/a"));

        //Click on Currency
        clickElementBy(By.xpath("//*[@id=\"customerCurrency\"]"));

        //Click on Euro
        selectByText(By.xpath("//*[@id=\"customerCurrency\"]"), "Euro");

        //Click on Sort Currency
        clickElementBy(By.xpath("//*[@id=\"customerCurrency\"]"));

        //Click on USD
        selectByText(By.xpath("//*[@id=\"customerCurrency\"]"), "US Dollar");

        //Check for $ value
        //Get Text of $ value
        boolean present = false;
        List<WebElement> activeList = driver.findElements(By.className("actual-price"));
        //List<WebElement> activeList = driver.findElements(By.cssSelector("span.actual-price"));
        for(WebElement element : activeList){
            String str = element.getText();

            for ( int i =0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '$') {
                    present = true;
                    //index = i;
                }
            }
            if ( present == true){
                System.out.println("$" + " is present in the array list");
                // break;
            }else{
                System.out.println("The $ is not present at the array list");
            }
        }

    }



}
