package com.blogspot.minborgsjavapot.builder._6extend;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @see http://minborgsjavapot.blogspot.com/2014/08/creating-objects-using-builder-pattern.html
 *      ***************************************************************************************
 *      Пример работы с разными билдерами...
 *
 * 1. Работает с бинами, то есть важно использовать только поля И поэтому интерфейсы здесь неинтересны...
 * 2. В одном случае, в зависимости от типа нужно выборочно заполнить поля
 * 3. В другом случае все поля должны быть обязательно заполнены
 * .. и напоследок - уже в самы последний момент (когда уже все готово) вызывается конструктор который все строит...
 *
 * (Wrapper - нужно применять в том случае когда когда используются все поля...но они конвертируются, например в случае обмена данными между слоями WEB-сервисом и DAO...)
 * (а Builder - нужно применять в том случае когда выборочно используются поля..., например при создании другого объекта, производного от первого...)
 * Такой Builder полезен тем что он будет держать только полезную информацию:
 * - иннициализировтаь только те поля которые будут использоваться
 * - и исключать остальные поля, которые НЕиспользуются
 */
public class BuilderTest {

    private Car car;
    private ElectricCar electricCar;

    @Before
    public void setUp() {
        car = new Car.Builder("BMW", "1 Series")
                .power(208)
                .torque(280)
                .gears(6)
                .color("White")
                .build();
        electricCar = new ElectricCar.Builder("Tessla", "S")
                .build();
    }

    @After
    public void tearDown() {
    }

    /**
     * (пускай есть полностью укомплектованный автомобиль И очень дорогой...)
     * на базе такого автомобиля можно построить другие автомобили которые с урезанной комплектаций И будут более дешевые:
     */
    @Test
    public void testCarBuilder() {
        PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
        Car bmv = new CarBuilder(car, "2 Series")
                .build();
        PrintUtil.format(bmv);
    }

    /*
     * теперь я хочу построить новый тип автомобиля в котором не зависимо от старого функционала будет добавлен гибридный двигатель...:
     */
    @Ignore
    @Test
    public void testElectricCar1() {
        Car bmv = new CarBuilder(car, "1 Series")
                .build();

        PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
        ElectricCar tessla =
                new ElectricCar.Builder(bmv.getBrand(), bmv.getType())
                        .power(bmv.getPower())
                        .torque(bmv.getTorque())
                        .gears(bmv.getGears())
                        .color(bmv.getColor())
                        .batteryCapacity(85)
                        .build();
        PrintUtil.format(tessla);
    }

    @Ignore
    @Test
    public void testElectricCar2() {
        Car bmv = new CarBuilder(car, "1 Series")
                .build();

        PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
        ElectricCar tessla =
                electricCar.toBuilder()
                        .power(bmv.getPower())
//                        .torque(bmv.getTorque())
//                        .gears(bmv.getGears())
//                        .color(bmv.getColor())
                        .batteryCapacity(85)
                        .build();
        PrintUtil.format(tessla);
    }

    /**
     * 1. на базе стандартного автомобиля можно построить другие типы-автомобили с урезанной комплектаций И которые будут более дешевые
     *    (здесь будут выборочные поля...)
     * 2. теперь делаем автомобиль в котором, не зависимо от старого функционала, будет добавлен гибридный двигатель...
     * 3. и уже только после того как выборочно закончили инициализировать комплектацию - в самом конце выполняется тяжеловестная операция-создает конечный объект...
     */
    @Test
    public void testElectricCarBuilder() {
        PrintUtil.format(new String[]{"БРЕНД", "МАРКА", "МОЩНОСТЬ", "КРУТЯЩИЙ МОМЕНТ", "КОЛ-О ПЕРЕДАЧ", "ЦВЕТ", "ЕМКОСТЬ БАТАРЕИ"});
        ElectricCarBuilder tessla =
                new ElectricCarBuilder.Builder(new CarBuilder(car, "2 Series"), 85)
                        .build();
        PrintUtil.format(tessla);
    }
}
