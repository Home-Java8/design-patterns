package com.blogspot.minborgsjavapot.builder_flwup.change.interf;


public class Main {

    /**
     * @see https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
     *      http://easy-code.ru/lesson/formatting-numeric-output-java
     *      http://crypto.pp.ua/2010/06/formatirovanie-strok-java | http://www.javaprogrammingforums.com/java-theory-questions/18443-how-make-console-output-bold.html | https://stackoverflow.com/questions/29109678/java-print-in-bold
     */
    public static void main(String[] args) {
        PrintUtil.format(new String[]{"COLOR", "BRAND", "GEARS", "POWER", "TORQUE", "TYPE"});

        final Car toyota =
                new Car.Builder("Toyota", "Avensis")
//                        .power(108)
//                        .torque(180)
//                        .gears(6)
                        .build();
        PrintUtil.format(toyota);

        final Car toyotaWhite =
                new Car.Builder("Toyota-2", "Avensis-2")
                        .power(109)
                        .torque(181)
                        .gears(7)
                        .color("White")
                        .build();
        PrintUtil.format(toyotaWhite);
    }
}