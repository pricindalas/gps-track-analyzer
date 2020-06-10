package com.github.pricindalas.gpstrackanalyzer.data;

import java.util.Date;

public class TrackPoint {
    private double latitude;
    private double longitude;
    private Double elevation;
    private Date time;

    public TrackPoint() { }

    public TrackPoint(double latitude, double longitude, Double elevation, Date time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

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
