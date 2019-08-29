package utils;

import Constants.ValidStates;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Commons {

    static Faker faker = new Faker(new Locale("en-US"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomStreetName() {
        return faker.address().streetAddress();
    }

    public static String getRandomCity() {
        return faker.address().cityName();
    }

    public static String getrandomState() {
        return ValidStates.abbrv.get(new Random().nextInt(ValidStates.abbrv.size()));
    }

    public static String getrandomZipCode() {
        return faker.address().zipCode();
    }

    public static String getRandomEmail() {
        return faker.bothify("candidate######@upgrade-challenge.com");
    }

    public static String getRandomPassword() {
        return faker.bothify("Pass@#######");
    }

    public static String getRandomDOB() {
        String startDate = "01012000";
        String endDate = "01011930";
        Date start = null;
        Date end = null;
        SimpleDateFormat df = new SimpleDateFormat("MMddyyyy");
        try {
            start = new SimpleDateFormat("MMddyyyy").parse(startDate);
            end = new SimpleDateFormat("MMddyyyy").parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df.format(faker.date().between(end, start));

    }

    public static String getRandomNumber() {
        return String.valueOf(faker.number().numberBetween(120000, 200000));
    }

    public static String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
