package com.blogspot.minborgsjavapot.builder._6extend;

public class CarBuilder {
    private Car.Builder builder;

    private CarBuilder() {
    }

    // (здесь хорошо-бы использовать декоратор, но он неработает...потому-что объект Builder должен быть чистым чтобы можно было заново его иннициализировтаь)
    public CarBuilder(Car car, String type) {
        switch (type) {
            case "1 Series": {
//                builder = new Car.Builder(car.getBrand(), car.getType()) // это когда я создаю тип из новых данных
                builder = car.toBuilder()                                  // а это когда уже данные есть и на базе их я пытаюсь создать (копировать) новый тип
                        .power(car.getPower())
                        .torque(car.getTorque())
                        .gears(car.getGears())
                        .color(car.getColor());
                break;
            }
            case "2 Series": {
//                builder = new Car.Builder(car.getBrand(), car.getType()) // это когда я создаю тип из новых данных
                builder = car.toBuilder()                                  // а это когда уже данные есть и на базе их я пытаюсь создать (копировать) новый тип
                        .power(car.getPower())
                        .torque(car.getTorque());
                break;
            }
        }
    }

    public Car build() {
        return builder.build();
    }
}
