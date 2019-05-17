package Proj1160519;

import org.openqa.selenium.By;

import javax.rmi.CORBA.Util;

public class RegistrationPage extends Utils
{
    LoadProperties loadProperties = new LoadProperties();
    private By _register = By.linkText("Register");
    private By _email = By.linkText("Computers");
    private By _register_Btn = By.id("register-button");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");

    public void userShouldBeRegisterSuccessfully()
    {
        //Click on the register button
        clickElementBy(_register);
        //Select the male gender option
        clickElementBy(By.id("gender-male"));
        //Enter MyFirstName in First name field
        enterText(_firstName,loadProperties.getProperty("Hetal"));
        //Enter MyLastName in Last name field
        enterText(_lastName,loadProperties.getProperty("Patel"));
        //Select the value 25 for Day field of Date of Birth
        selectByValue(By.name("DateOfBirthday"),loadProperties.getProperty("25"));
        //Select the value March for the Month field Date of Birth
        selectByIndex(By.name("DateOfBirtMonth"), 3);
        //Select the value 1982 for the Year field Date of Birth
        selectByValue(By.name("DateOfYear"),loadProperties.getProperty("1994"));
        emailWithTimeStamp(_email);
        //Enter the value company in the company field
        enterText(By.id("Company"),loadProperties.getProperty("abc"));
        //Enter the value password in the Password field
        enterText(By.id("Password"),loadProperties.getProperty("asd123"));
        //Enter the value password in the Confirm Password field
        enterText(By.id("ConfirmPassword"),loadProperties.getProperty("asd123"));
        //Click on register button
        clickElementBy(_register_Btn);
    }
    public void registrationConfirmation(){
        getActualText(By.xpath("//div[@class='result']"));
        //User should be able to see the message "Your registration completed" if successful
        validation(loadProperties.getProperty("confirmRegistration"));
        //Print Results
        System.out.println(actualResult);


    }
}
