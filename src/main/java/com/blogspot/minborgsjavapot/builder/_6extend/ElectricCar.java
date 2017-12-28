package com.blogspot.minborgsjavapot.builder._6extend;

/**
 * Автомобиль с электронным двигателем построен на базе обычного автомобиля,
 * здесь добавляется ноыый параметр - емкость батареи
 */
public class ElectricCar extends Car {
    private final int batteryCapacity;

    public ElectricCar(Builder builder) {
        super(builder);
        this.batteryCapacity = builder.batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }


    public static class Builder extends Car.Builder {
        private int batteryCapacity;

        public Builder(String brand, String type) {
            super(brand, type);
        }

        @Override
        public Builder power(int power) {
            return (Builder) super.power(power);
        }

        @Override
        public Builder torque(int torque) {
            return (Builder) super.torque(torque);
        }

        @Override
        public Builder gears(int gears) {
            return (Builder) super.gears(gears);
        }

        @Override
        public Builder color(String color) {
            return (Builder) super.color(color);
        }

        public Builder batteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        @Override
        public ElectricCar build() {
            return new ElectricCar(this);
        }
    }


    /**
     * Если тип уже полученный и я хочу находу к нему добавить новые параметры (динамически...)
     */
    protected Builder decorate(Builder builder) {
        super.decorate(builder); // (здесь хорошо-бы использовать декоратор, но он неработает ??? <Car.Builder> // builder = (Builder) super.decorate(builder);
        return builder.batteryCapacity(getBatteryCapacity());
    }

    @Override
    public Builder toBuilder() {
        Builder newBuilder = new Builder(getBrand(), getType());
        return decorate(newBuilder);
    }
}
