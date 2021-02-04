package com.ilcarro.qa.fw;

import com.ilcarro.qa.model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase {

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public boolean ifFindCarFromPresent1() {
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form")).size() > 0;
    }

    public void fillCarForm(Car car) {
        type(By.name("country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistanceIncluded());
        type(By.cssSelector(".serial_number"), car.getSerialNumber());
        type(By.cssSelector(".brand"), car.getBrand());
        type(By.cssSelector(".model"), car.getModel());
        type(By.cssSelector(".year"), car.getYear());
        type(By.cssSelector(".engine"), car.getEngine());
        type(By.cssSelector(".fuel_consumption"), car.getFuel_consumption());
        type(By.cssSelector(".fuel"), car.getFuel());
        type(By.cssSelector(".transmition"), car.getTransmission());
        type(By.cssSelector(".wd"), car.getWd());
        type(By.cssSelector(".horsepower"), car.getHorsepower());
        type(By.cssSelector(".torque"), car.getTorque());
        type(By.cssSelector(".doors"), car.getDoors());
        type(By.cssSelector(".seats"), car.getSeats());
        type(By.cssSelector(".class"), car.getCarClass());

        type(By.name("about"), car.getAbout());

        type(By.cssSelector(".type_feature"), car.getTypeFeature());
        type(By.cssSelector(".price"), car.getPrice());
    }
}
