package com.blogspot.minborgsjavapot.builder._6extend;

/**
 * Автомобиль с электронным двигателем построен на базе обычного автомобиля,
 * здесь добавляется ноыый параметр - емкость батареи
 */
public class ElectricCarBuilder {
    // тип автомобиля
    private final Car car;
    // емкость батареи
    private final int batteryCapacity;

    // только такой конструктор помогает реализвать паттерн билдера...этот конструктор уже только в самом конце строит объект по тем полям которые были перечислены в иннициализации
    public ElectricCarBuilder(Builder builder) {
        this.car = builder.carBuilder
                .build();
        this.batteryCapacity = builder.batteryCapacity;
    }

    public Car getCar() {
        return car;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }


    public static class Builder {
        private final CarBuilder carBuilder;
        private final int batteryCapacity;

        /**
         * Обязательные параметры
         */
        public Builder(CarBuilder carBuilder, int batteryCapacity) {
            this.carBuilder = carBuilder;
            this.batteryCapacity = batteryCapacity;
        }

        public ElectricCarBuilder build() {
            return new ElectricCarBuilder(this);
        }
    }
}
