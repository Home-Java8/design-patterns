package com.blogspot.minborgsjavapot.builder._1bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BeenBuilderTest {


    private Car car;

    @Before
    public void setUp() {
        car = new Car("Toyota", "Avensis");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBuilder() {
        PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ"});
        car.setPower(108);
        car.setTorque(180);
        car.setGears(6);
        PrintUtil.format(car);
    }
}
