package Proj1160519;

import org.openqa.selenium.By;

public class UnRegisterUserCanNotRefer extends Utils
{
    //Test@
    public void unRegisterUserShouldBeAbleToReferProductToFriend() {
        //Enter your Email Address
        driver.findElement(By.xpath("//input[@id='YourEmailAddress'])")).sendKeys("hetal.patel@gamil.com");

        //Click on send Email
        driver.findElement(By.xpath("//input[@name='send-email']")).click();

        getActualText(By.xpath("//li[contains(text(),'Only registered customers can use email a friend f')]"));
    }
}
