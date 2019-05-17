package Proj1160519;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    AbleToChangeCurrency productlistPage = new AbleToChangeCurrency();


    @Test
    public void useRegistration()
    {
        homePage.clickOnRegisterButton();
        System.out.println("TestSuit");
        registrationPage.userShouldBeRegisterSuccessfully();
        homePage.clickOnRegisterButton();
        AbleToChangeCurrency.priceCurrency();
        SortProductHighToLow.priceHighToLow();

    }

    // public void userShouldBeAbleToRegisterSuccessfully(){
    //   homePage.clickOnRegisterButton();
}
