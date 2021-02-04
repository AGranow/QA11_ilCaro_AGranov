package com.ilcarro.qa.test;

import com.ilcarro.qa.model.Car;
import org.testng.annotations.Test;

public class AddCarTest extends TestBase {


   /* @BeforeMethod
    public void ensurePreconditions() {   // ensure  - обеспечивать
        if (!userLoggedIn()) {
            loIn();
        }
}
*/

    @Test
    public void testFormLetTheCarWorkLoggedInUser() throws InterruptedException {

        if (!app.getUser().userLoggedIn()) {
            app.getUser().logIn();
            app.getUser().pause(2000);
            app.getHeader().openAddCarFormFromHeader();

            app.getCar().fillCarForm(new Car().withCountry("Israel").withAddress("Balfur Street").withDistanceIncluded("500").withSerialNumber("123 45 671").withBrand("Volkswagen").withModel("Polo")
                    .withYear("2010").withEngine("V6").withFuel_consumption("8").withFuel("Super").withTransmission("automatic").withWd("4WD")
                    .withHorsepower("250").withTorque("150").withDoors("2").withSeats("2").withCarClass("B")
                    .withAbout("I am a super driver").withTypeFeature("Red color").withPrice("100"));


            app.getHeader().submitForm();
        }
    }

    @Test
    public void negativeTestAddCarWithoutDoors() throws InterruptedException {
        if (!app.getUser().userLoggedIn()) {
            app.getUser().logIn();
        }
        app.getHeader().pause(2000);

        app.getHeader().openAddCarFormFromHeader();

        app.getCar().fillCarForm(new Car().withCountry("Israel").withAddress("Balfur Street").withDistanceIncluded("500").withSerialNumber("12345671").withBrand("Volkswagen").withModel("Polo")
                .withYear("2010").withEngine("V6").withFuel_consumption("8").withFuel("Super").withTransmission("automatic").withWd("4WD")
                .withHorsepower("250").withTorque("150").withSeats("L").withCarClass("B")
                .withAbout("I am a super driver").withTypeFeature("Red color").withPrice("100"));

        app.getHeader().submitForm();
    }

    @Test
    public void negativeTestFromLetTheCarWorkForNotLoggedInUser() throws InterruptedException {

        app.getHeader().openAddCarFormFromHeader();

        app.getCar().fillCarForm(new Car().withCountry("Israel").withAddress("Balfur Street").withDistanceIncluded("500").withSerialNumber("12345671").withBrand("Volkswagen").withModel("Polo")
                .withYear("2010").withEngine("V6").withFuel_consumption("8").withFuel("Super").withTransmission("automatic").withWd("4WD")
                .withHorsepower("250").withTorque("150").withDoors("2").withSeats("4").withCarClass("B")
                .withAbout("I am a super driver").withTypeFeature("Red color").withPrice("100"));


        app.getHeader().submitForm();
    }
}
