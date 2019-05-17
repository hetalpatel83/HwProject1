package Proj1160519;

import org.junit.Test;
import org.openqa.selenium.By;

import javax.rmi.CORBA.Util;

import static Proj1160519.BasePage.driver;
import static Proj1160519.Utils.clickElementBy;
import static Proj1160519.Utils.enterText;

public class ReferProductToFriend extends Utils {

    public void userShouldBeAbleToReferProductToFriend() {
        //Click on Login
        clickElementBy(By.xpath("//a[@class='ico-login']"));

        // Enter Email address
        enterText(By.xpath("//input[@class='email']"), "heta.patel" + "@gmail.com");

        //Enter  Password
        enterText(By.xpath("//input[@class='password']"), "asd123");

        //Click Login button
        clickElementBy(By.xpath("//input[@class='button-1 login-button']"));

        //Click on Apparel
        driver.findElement(By.xpath("//ul[@class='top-menu mobile']//a[contains(text(),'Apparel')]")).click();

        //Click on clothing
        driver.findElement(By.xpath("//ul[@class='top-menu mobile']//a[contains(text(),'Clothing')]")).click();

        //Click on custom T-shirt
        driver.findElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[1]//a[1]//img[1]")).click();

        //Click on Email a friend
        driver.findElement(By.xpath("//input[@class='button-2 email-a-friend-button valid'])")).click();

        //Enter friend's email
        driver.findElement(By.xpath("//input[@id='FriendEmail'])")).sendKeys("hpatel@gmail.com");

        //Enter user's Email address
        driver.findElement(By.xpath("//input[@id='YourEmailAddress'])")).sendKeys("hetal.patel@gamil.com");

        //Enter Text
        driver.findElement(By.xpath("//textarea[@id='PersonalMessage'])")).sendKeys("Good Product");

        //click on send email
        driver.findElement(By.xpath("//input[@name='send-email'])")).click();
    }
}
