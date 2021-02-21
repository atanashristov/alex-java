package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * VIN class - Unit tests for VIN.equals() and VIN.hashCode().
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alex Hristov
 * @version 1.0
 * @since 2/20/2021
 */
@RunWith(Parameterized.class)
public class HashTable_Lab4_VIN_EqualsAndHashCode_UnitTests {

    @Parameterized.Parameter(0)
    public VIN vin1;

    @Parameterized.Parameter(1)
    public VIN vin2;

    @Parameterized.Parameter(2)
    public boolean expectedEquals;

    @Test
    public void RunTest() {
        Assertions.assertEquals(expectedEquals, vin1.equals(vin2));
        if (vin2 != null) {
            Assertions.assertEquals(expectedEquals, vin1.hashCode() == vin2.hashCode());
        }
    }

    @Parameterized.Parameters(
            name = "{index}: When VIN1 is {0} and VIN2 is {1}, equality is {2}"
    )
    public static Iterable<Object[]> testData() {
        return Arrays.asList(
                new Object[][] {
                        { new VIN(), null, false },
                        { new VIN("WMWVY77HPUW874138"), new VIN(), false },
                        { new VIN("WMWVY77HPUW874138"), new VIN("WAUXH31BLGW104855"), false },
                        { new VIN("WMWVY77HPUW874138"), new VIN("WMWVY77HPUW874138"), true },
                        { new VIN(), new VIN(), true },
                }
        );
    }
}
