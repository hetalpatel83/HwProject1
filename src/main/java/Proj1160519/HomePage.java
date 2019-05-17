package Proj1160519;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    private By _registerLink = By.linkText("Register");

    public void clickOnRegisterButton(){
        clickElementBy(_registerLink);
    }
    public void verifyUserIsOnRegistrationPage(){

    }
}
