package Proj1160519;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProductHighToLow extends Utils
{
    //@Test
    public static void priceHighToLow(){
        //Mouse hover action is performed
        mouseOverHover(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));

        //Click on Cell Phones
        clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[2]/a"));

        //Click on Sort Order
        clickElementBy(By.xpath("//*[@id=\"products-orderby\"]"));

        //Click High to Low
        selectByText(By.xpath("//*[@id=\"products-orderby\"]"), "Price: High to Low");

        //Get Text of $ value
        ArrayList<Float> priceList = new ArrayList<Float> ();
        ArrayList<Float> sortList = new ArrayList<Float>();

        List<WebElement> activeList = driver.findElements(By.className("actual-price"));
        //List<WebElement> activeList = driver.findElements(By.cssSelector("span.actual-price"));
        for(WebElement element : activeList){
            String str = element.getText();
            str = str.replaceAll("[^\\d.]", "");
            priceList.add(Float.valueOf(str));
            sortList.add(Float.valueOf(str));
        }
        System.out.println(priceList);
        // Sorting in decreasing (descending) order
        Collections.sort(sortList, Collections.reverseOrder());

        //Arrays.sort(priceList);
        System.out.println(sortList);
        System.out.println(priceList.equals(sortList));
    }
}
