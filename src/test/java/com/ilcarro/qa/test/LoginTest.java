package com.ilcarro.qa.test;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        //goto login page
          if (!app.getUser().isLoginFormPresent()) {  //   sign up on not present
            // click on logout form
        }
        // if user logged in, click logout, go to login
        if (app.getUser().userLoggedIn()) {
            app.getUser().logOut();
        }
        app.getHeader().clickLoginTabOnHeader();
    }

    @Test
    public void loginRegisteredUserPositivTest() throws InterruptedException {
        app.getHeader().pause(3000);
        //fill login form
        app.getUser().fillLoginForm(new User().withEmail("MaxSmitt7@gmail.com").withPassword("MaxSmitt1"));
        //submit login
        app.getHeader().submitForm();
        //Assert userLoggedIn
        Assert.assertTrue(app.getUser().userLoggedIn());
        String email = app.getHeader().getEmailTextFromHeader();
        System.out.println(email);
        Assert.assertEquals(email,"MaxSmitt7@gmail.com");
    }

     @Test
    public void loginRegisteredUserPositivTestProbe() {

        app.getUser().logIn();
        //submit login
        Assert.assertTrue(app.getUser().userLoggedIn());
//        String email = app.getHeader().getEmailTextFromHeader();
//        System.out.println(email);
//        Assert.assertEquals(email,"MaxSmitt7@gmail.com");
    }


}


