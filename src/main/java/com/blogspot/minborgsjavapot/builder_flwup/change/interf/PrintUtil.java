package com.blogspot.minborgsjavapot.builder_flwup.change.interf;

public class PrintUtil {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_GRAY_BACKGROUND = "\u001B[47m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_FONT_BOLD_ON = "\u001B[1m"; // \u001B[1m  // \033[1m

    private static final String SEPARATOR_OUT = "+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+",
            HEAD_OUT = "| " + ANSI_FONT_BOLD_ON + "%1$-20s" + ANSI_RESET + " | "+ANSI_FONT_BOLD_ON + "%2$-20s" + ANSI_RESET + " | " + ANSI_FONT_BOLD_ON + "%3$-20s" + ANSI_RESET + " | " + ANSI_FONT_BOLD_ON + "%4$-20s" + ANSI_RESET + " | " + ANSI_FONT_BOLD_ON + "%5$-20s" + ANSI_RESET + " | " + ANSI_FONT_BOLD_ON + "%6$-20s" + ANSI_RESET + " |\n",
            DATA_OUT = "| " + ANSI_BLUE + "%1$-20s" + ANSI_RESET + " | " + ANSI_BLUE + "%2$-20s" + ANSI_RESET + " | " + ANSI_BLUE + "%3$-20s" + ANSI_RESET + " | " + ANSI_BLUE + "%4$-20s" + ANSI_RESET + " | " + ANSI_BLUE + "%5$-20s" + ANSI_RESET + " | " + ANSI_BLUE + "%6$-20s" + ANSI_RESET + " |\n";

    static void format(String[] args) {
        System.out.println(PrintUtil.SEPARATOR_OUT);
        System.out.format(PrintUtil.HEAD_OUT, args);
        System.out.println(PrintUtil.SEPARATOR_OUT);
    }

    static void format(Car car) {
        String[] out = new String[]{
                car.getColor(),
                car.getBrand(),
                String.valueOf(car.getGears()),
                String.valueOf(car.getPower()),
                String.valueOf(car.getTorque()),
                car.getType()
        };
        System.out.format(PrintUtil.DATA_OUT, out);
        System.out.println(PrintUtil.SEPARATOR_OUT);
    }
}
