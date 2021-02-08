package com.ilcarro.qa.test;

import com.ilcarro.qa.model.Car;
import com.ilcarro.qa.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

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


    @DataProvider
    public Iterator<Object[]> validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader
                (new FileReader("src/test/resources/AddCar.csv"));
        String line = reader.readLine();
        while (line != null){
            String[] split =line.split(",");
            list.add(new Object[]{
                    new Car()
                            .withCountry(split[0])
                            .withAddress(split[1])
                            .withDistanceIncluded(split[2])
                            .withSerialNumber(split[3])
                            .withBrand(split[4])
                            .withModel(split[5])
                            .withYear(split[6])
                            .withEngine(split[7])
                            .withFuel_consumption(split[8])
                            .withFuel(split[9])
                            .withTransmission(split[10])
                            .withWd(split[11])
                            .withHorsePower(split[12])
                            .withTorque(split[13]).
                            withDoors(split[14])
                            .withSeats(split[15]).
                            withCarClass(split[16])
                            .withAbout(split[17])
                            .withTypeFeature(split[18])
                            .withPrice(split[19])});

            line = reader.readLine();
        }

        return list.iterator();
    }
}
