package com.github.pricindalas.gpstrackanalyzer.data;

import java.util.Date;

/**
 * This class represents a track point of the GPS track.
 * It contains a latitude, longitude, elevation and time of the point.
 */
public class TrackPoint {
    private double latitude;
    private double longitude;
    private Double elevation;
    private Date time;

    /**
     * Creates an empty track point with no defined data.
     */
    public TrackPoint() { }

    /**
     * Creates a new track point with given parameters.
     * @param latitude Latitude of the point in degrees.
     * @param longitude Longitude of the point in degrees.
     * @param elevation Altitude of the point from the sea level in meters.
     * @param time Time when the point was recorded.
     */
    public TrackPoint(double latitude, double longitude, Double elevation, Date time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.time = time;
    }

    /** Returns the latitude in degrees.
     * @return Latitude in degrees.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude in degrees
     * @param latitude Latitude in degrees.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /** Returns the longitude in degrees.
     * @return Longitude in degrees.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude in degrees.
     * @param longitude Longitude in degrees.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the altitude of the point in meters.
     * @return Altitude in meters.
     */
    public Double getElevation() {
        return elevation;
    }

    /**
     * Sets the altitude of the point in meters.
     * @param elevation Altitude in meters.
     */
    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    /**
     * Returns the time of the point.
     * @return Time of the point.
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets the time of th point.
     * @param time Time of the point.
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * Calculates the distance to the given point in meters.
     * @param point Point to measure the distance to.
     * @return Distance in meters.
     */
    public double distanceTo(TrackPoint point) {
        final int r = 6371;

        double latDistance = Math.toRadians(point.latitude - latitude);
        double lonDistance = Math.toRadians(point.longitude - longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(point.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = r * c * 1000;

        if (point.elevation != null && elevation != null) {
            double height = point.elevation - elevation;
            distance = Math.pow(distance, 2) + Math.pow(height, 2);
        }

        return Math.sqrt(distance);
    }
}
