package com.ilcarro.qa.test;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class CreateAccountTest extends TestBase {



    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isSignUpTabPresentInHeader()) {  //   sign up on not present
            app.getUser().logOut();
        }
    }

    @Test
    public void testSignUp() {

        //click on SignUp Button
        app.getHeader().openRegistrationFormFromHeader();

        app.getUser().isRegistrationFormOpened();

        // fill registration form

        app.getUser().fillRegistrationForm(new User()
                .withFirstName("Max")
                .withSecondName( "Smitt")
                .withEmail( "MaxSmitt24@gmail.com")
                .withPassword("MaxSmitt1"));


        app.getUser().selectPolisyCheckBox();

        //click Submit button
        app.getUser().submitForm();

        //check login form displayed


        Assert.assertTrue(app.getUser().isLoginFormPresent());
    }

    @Test (dataProvider = "validUser",dataProviderClass =  DataProviders.class)
    public void testSignUpFromDateProvider(String fName, String sName, String email, String password) {

        //click on SignUp Button
        app.getHeader().openRegistrationFormFromHeader();

        app.getUser().isRegistrationFormOpened();

        // fill registration form

        app.getUser().fillRegistrationForm(new User()
                .withFirstName(fName)
                .withSecondName( sName)
                .withEmail(email)
                .withPassword(password));


        app.getUser().selectPolisyCheckBox();

        //click Submit button
        app.getUser().submitForm();

        logger.info("Login from present. actual result: " + app.getUser().isLoginFormPresent() +" expected result is: true");

        //check login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());
    }

    @Test (enabled = false, dataProvider = "validUserFromCSV" , dataProviderClass =  DataProviders.class)
    public void testSignUpFromCSVFromDateProvider(User user) {

        app.getHeader().openRegistrationFormFromHeader();

        app.getUser().isRegistrationFormOpened();

        app.getUser().fillRegistrationForm(user);

        app.getUser().selectPolisyCheckBox();

        //click Submit button
        app.getUser().submitForm();

        logger.info("Login from present. actual result: " + app.getUser().isLoginFormPresent() +" expected result is: true");

        //check login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());
    }


    @Test(enabled = false)
    public void testSignUpWithoutPassword() {
        //click on SignUp Button
        app.getHeader().openRegistrationFormFromHeader();

        app.getUser().isRegistrationFormOpened();

        // fill registration form

        app.getUser().fillRegistrationForm(new User()
                .withFirstName("Max")
                .withSecondName( "Smitt")
                .withEmail( "MaxSmitt23@gmail.com")
                .withPassword("MaxSmitt1"));

        app.getUser().selectPolisyCheckBox();

        //click Submit button
        app.getHeader().submitForm();

        //check login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());
    }

}