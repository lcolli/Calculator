package com.calc.lcollins.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", packageName = "com.calc.lcollins.todolist")
public class CalcTest {

    @Test
    public void additionTest()
    {
        Calculator calc = new Calculator();
        double expected = 7;
        double actual = calc.add(3, 4);
        assertEquals(expected, actual, 0.01);
    }

}
