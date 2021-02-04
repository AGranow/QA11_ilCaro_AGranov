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

    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName1","sName1","fName22@gmail.com","firstName1"});
        list.add(new Object[]{"fName2","sName2","fName23@gmail.com","firstName2"});
        list.add(new Object[]{"fName3","sName3","fName24@gmail.com","firstName3"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader
                (new FileReader("src/test/resources/tests_newUser.csv"));
        String line = reader.readLine();
        while (line != null){
            String[] split =line.split(",");
            list.add(new Object[]{
                    new User().withFirstName(split[0]).withSecondName(split[1]).withEmail(split[2]).withPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }

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

    @Test (dataProvider = "validUser")
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

    @Test (dataProvider = "validUserFromCSV")
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


    @Test
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