package rokpec.gpstrackanalyzer.tools;

public class Converters {

    // Speed
    public static double toKmh(double metersPerSecond) {
        return metersPerSecond * 3.6;
    }

    public static double toMs(double kilometersPerHour) {
        return kilometersPerHour / 3.6;
    }

    // Pace
    public static double kmhToPace(double kilometersPerHour) {
        return 1 / (kilometersPerHour / 60.0);
    }

    public static double paceToKmh(double minutesPerKm) {
        return 60.0 * (1 / minutesPerKm);
    }

}
