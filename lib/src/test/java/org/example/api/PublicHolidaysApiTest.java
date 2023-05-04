package org.example.api;

import java.io.IOException;
import java.util.List;

import org.example.model.Country;
import org.example.model.HolidaysResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PublicHolidaysApiTest {
    
    // Run tests:
    // API_KEY="YOUR_API_KEY" ./gradlew clean test --info

    @Test
    void createApiObject() {
        var apiKey = System.getenv("API_KEY");

        var api = new PublicHolidaysApi(apiKey);

        Assertions.assertNotNull(api);
    }

    @Test
    void listHolidays_BR_2021() throws IOException, InterruptedException {
        var apiKey = System.getenv("API_KEY");
        var api = new PublicHolidaysApi(apiKey);

        HolidaysResponse holidaysResponse = api.listHolidays("BR", "2022");

        Assertions.assertEquals(200, holidaysResponse.getStatus());
        Assertions.assertEquals("BR", holidaysResponse.getQuery().getCountry());
        Assertions.assertEquals("2022", holidaysResponse.getQuery().getYear());
        System.out.println(holidaysResponse);
    }

    @Test
    void listCountries() throws IOException, InterruptedException {
        var apiKey = System.getenv("API_KEY");
        var api = new PublicHolidaysApi(apiKey);

        List<Country> countries = api.listCountries();

        System.out.println(countries);
        Assertions.assertFalse(countries.isEmpty());
    }
}
