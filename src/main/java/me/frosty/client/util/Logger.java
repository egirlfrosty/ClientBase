package me.frosty.client.util;

public class Logger {

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void info(Object message) {
        System.out.println("[CLIENT] " + message);
    }

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void warning(Object message) {
        System.out.println("[CLIENT] " + message);
    }

    /**
     * Prints anything out with a tag.
     *
     * @param message The object you wish to print.
     * @author frosty
     */
    public static void error(Object message) {
        System.err.println("[CLIENT] " + message);
    }
}
