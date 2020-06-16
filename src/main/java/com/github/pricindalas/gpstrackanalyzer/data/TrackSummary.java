package com.github.pricindalas.gpstrackanalyzer.data;

/**
 * This class holds a summary data of the GPS track record.
 */
public class TrackSummary {

    private double distance;
    private double duration;
    private double avgSpeed;
    private double maxSpeed;
    private double avgPace;
    private double maxPace;
    private double ascent;
    private double descent;
    private double minHeight;
    private double maxHeight;
    private double tripEfficiency;

    /**
     * Creates a new track summary with no defined data.
     */
    public TrackSummary() { }

    /**
     * Creates a new track summary with defined data.
     * @param distance Distance in meters.
     * @param duration Duration in seconds.
     * @param avgSpeed Average speed in meters per second.
     * @param maxSpeed Maximum speed in meters per second.
     * @param avgPace Average pace in minutes per kilometer.
     * @param maxPace Maximum pace in minutes per kilometer.
     * @param ascent Total ascent in meters.
     * @param descent Total descent in meters.
     * @param minHeight Minimum track height in meters.
     * @param maxHeight Maximum track height in meters.
     * @param tripEfficiency Trip efficiency from 0.0 to 1.0.
     */
    public TrackSummary(double distance, double duration, double avgSpeed,
                        double maxSpeed, double avgPace, double maxPace,
                        double ascent, double descent, double minHeight,
                        double maxHeight, double tripEfficiency) {
        this.distance = distance;
        this.duration = duration;
        this.avgSpeed = avgSpeed;
        this.maxSpeed = maxSpeed;
        this.avgPace = avgPace;
        this.maxPace = maxPace;
        this.ascent = ascent;
        this.descent = descent;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.tripEfficiency = tripEfficiency;
    }

    /**
     * Adds distance to total distance.
     * @param distance Distance in meters.
     */
    public void addDistance(double distance) {
        this.distance += distance;
    }

    /**
     * Adds duration to total duration.
     * @param duration Duration in seconds.
     */
    public void addDuration(double duration) {
        this.duration += duration;
    }

    /**
     * Adds ascent to total ascent.
     * @param ascent Ascent in meters.
     */
    public void addAscent(double ascent) {
        this.ascent += ascent;
    }

    /**
     * Adds descent to total descent.
     * @param descent Descent in meters.
     */
    public void addDescent(double descent) {
        this.descent += descent;
    }


    /**
     * Returns total distance in meters.
     * @return Distance in meters.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets total distance in meters.
     * @param distance Distance in meters.
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Returns total duration in seconds/
     * @return Duration in seconds.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets total distance in meters.
     * @param duration Duration in seconds.
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Returns average speed in meters per second.
     * @return Average speed in meters per second.
     */
    public double getAvgSpeed() {
        return avgSpeed;
    }

    /**
     * Sets average speed in meters per second.
     * @param avgSpeed Average speed in meters per second.
     */
    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    /**
     * Returns maximum speed in meters per second.
     * @return Maximum speed in meters per second.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets average speed in meters per second.
     * @param maxSpeed Maximum speed in meters per second.
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Returns average speed in meters per second.
     * @return Average speed in meters per second.
     */
    public double getAvgPace() {
        return avgPace;
    }

    /**
     * Sets average speed in meters per second.
     * @param avgPace Average speed in meters per second.
     */
    public void setAvgPace(double avgPace) {
        this.avgPace = avgPace;
    }

    /**
     * Returns maximum pace in minutes per kilometer.
     * @return Maximum pace in minutes per kilometer.
     */
    public double getMaxPace() {
        return maxPace;
    }

    /**
     * Sets maximum pace in minutes per kilometer.
     * @param maxPace Maximum pace in minutes per kilometer.
     */
    public void setMaxPace(double maxPace) {
        this.maxPace = maxPace;
    }

    /**
     * Returns total ascent in meters.
     * @return Total ascent in meters.
     */
    public double getAscent() {
        return ascent;
    }

    /**
     * Sets total ascent in meters.
     * @param ascent Total ascent in meters.
     */
    public void setAscent(double ascent) {
        this.ascent = ascent;
    }

    /**
     * Returns total descent in meters.
     * @return Total descent in meters.
     */
    public double getDescent() {
        return descent;
    }

    /**
     * Sets total descent in meters.
     * @param descent Total descent in meters.
     */
    public void setDescent(double descent) {
        this.descent = descent;
    }

    /**
     * Returns minimum height in meters.
     * @return Minimum height in meters.
     */
    public double getMinHeight() {
        return minHeight;
    }

    /**
     * Sets minimum height in meters.
     * @param minHeight Minimum height in meters.
     */
    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    /**
     * Returns maximum height in meters.
     * @return Maximum height in meters.
     */
    public double getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets maximum height in meters.
     * @param maxHeight Maximum height in meters.
     */
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * Returns trip efficiency from 0.0 to 1.0.
     * @return Trip efficiency from 0.0 to 1.0.
     */
    public double getTripEfficiency() {
        return tripEfficiency;
    }

    /**
     * Sets trip efficiency from 0.0 to 1.0.
     * @param tripEfficiency Trip efficiency from 0.0 to 1.0.
     */
    public void setTripEfficiency(double tripEfficiency) {
        this.tripEfficiency = tripEfficiency;
    }
}
