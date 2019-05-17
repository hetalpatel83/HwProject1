package Proj1160519;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddProductToShoppingCart extends Utils
{
    @Test
    //User should be able to add product to shopping cart
    public void addBookToCart()
    {
        //Click the books option by using linktext and perform click
        clickElementBy(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]"));

        //Click the book name and perform click
        clickElementBy(By.xpath("//a[contains(text(),'First Prize Pies')]"));


        //Click the add to cart button and perform click
        clickElementBy(By.xpath("//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]"));


        //Mouse hover action is performed,
        //To identify the sub menu item and click on it
        mouseOverHover(By.xpath("//span[@class='cart-label']"));

        //Compare Expected vs Actual
        getActualText(By.xpath("//div[@id='bar-notification']"));
        validation("The product has been added to your shopping cart");

        System.out.println(BasePage.driver.findElement(By.xpath("//div[@id='bar-notification']")).getText());
    }

    @Test
    public void addCellPhonesInShoppingCart() {
        //Mouse hover action is performed
        mouseOverHover(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));

        //Click on Cell Phones
        clickElementBy(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));

        //Add Product to Sopping Cart
        //Click on ADD TO CART
        clickElementBy(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));

        //Compare Expected vs Actual
        getActualText(By.xpath("//p[@class='content']"));
        validation("The product has been added to your shopping cart");

        System.out.println(BasePage.driver.findElement(By.xpath("//p[@class='content']")).getText());
        }

}
