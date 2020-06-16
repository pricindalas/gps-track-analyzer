package com.github.pricindalas.gpstrackanalyzer.tools;

/**
 * This is a helper class for converting some units.
 */
public class Converters {

    /**
     * Converts meters per second to kilometers per hour.
     * @param metersPerSecond Speed in meters per second.
     * @return Speed in kilometers per hour.
     */
    public static double toKmh(double metersPerSecond) {
        return metersPerSecond * 3.6;
    }

    /**
     * Converts kilometers per hour to meters per second.
     * @param kilometersPerHour Speed in kilometers per hour.
     * @return Speed in meters per second.
     */
    public static double toMs(double kilometersPerHour) {
        return kilometersPerHour / 3.6;
    }

    /**
     * Converts speed in kilometers per hour to pace in minutes per kilometer.
     * @param kilometersPerHour Speed in kilometers per hour.
     * @return Pace in minutes per kilometer.
     */
    public static double kmhToPace(double kilometersPerHour) {
        return 1 / (kilometersPerHour / 60.0);
    }

    /**
     * Converts pace in minutes per kilometer to speed in kilometers per hour.
     * @param minutesPerKm Pace in minutes per kilometer.
     * @return Speed in kilometers per hour.
     */
    public static double paceToKmh(double minutesPerKm) {
        return 60.0 * (1 / minutesPerKm);
    }

}
