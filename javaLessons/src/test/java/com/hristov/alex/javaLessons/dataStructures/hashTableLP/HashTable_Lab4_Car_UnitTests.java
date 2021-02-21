package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * Car class - Unit tests
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alex Hristov
 * @version 1.0
 * @since 2/20/2021
 */
@RunWith(Parameterized.class)
public class HashTable_Lab4_Car_UnitTests {

    @Parameterized.Parameter(0)
    public String vin;

    @Parameterized.Parameter(1)
    public int year;

    @Parameterized.Parameter(2)
    public String make;

    @Parameterized.Parameter(3)
    public String country;

    @Test
    public void RunTest() {
        Car car = new Car(vin, year, make, country);

        Assertions.assertEquals(new VIN(vin), car.getVIN());
        Assertions.assertEquals(vin, car.getVIN().toString());
        Assertions.assertEquals(year, car.getYear());
        Assertions.assertEquals(make, car.getMake());
        Assertions.assertEquals(country, car.getCountry());
    }

    @Parameterized.Parameters(
            name = "{index}: VIN={0}, Year={1}, Make={2}, Country={3}"
    )
    public static Iterable<Object[]> testData() {
        return Arrays.asList(
                new Object[][] {
                        { "WMWVY77HPUW874138", 1997 , "MINI", "Germany" },
                        { "SBMWK75WGPG171430", 2010 , "McLaren", "UK" },
                }
        );
    }
}
