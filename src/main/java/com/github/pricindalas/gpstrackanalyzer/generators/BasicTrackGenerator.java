package com.github.pricindalas.gpstrackanalyzer.generators;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import com.github.pricindalas.gpstrackanalyzer.data.TrackPoint;
import com.github.pricindalas.gpstrackanalyzer.data.TrackSegment;

import java.util.Date;
import java.util.Random;

/**
 * This is a simple track generator to create a new GPS track record from the given with given deviations.
 */
public class BasicTrackGenerator extends TrackGenerator {

    private double minAngleOffset;
    private double maxAngleOffset;

    private double minTimeOffset;
    private double maxTimeOffset;

    private double minElevationOffset;
    private double maxElevationOffset;

    /**
     * Creates a new basic track generator object with no initial parameters.
     */
    public BasicTrackGenerator() { }

    /**
     * Creates a new basic track generator with given parameters.
     * @param minAngleOffset Minimum angle offset of latitude and longitude in degrees.
     * @param maxAngleOffset Maximum angle offset of latitude and longitude in degrees.
     * @param minTimeOffset Minimum time offset of a track point in seconds.
     * @param maxTimeOffset Maximum time offset of a track point in seconds.
     * @param minElevationOffset Minimum elevation offset of a track point in meters.
     * @param maxElevationOffset Maximum elevation offset of a track point in meters.
     */
    public BasicTrackGenerator(double minAngleOffset, double maxAngleOffset, double minTimeOffset, double maxTimeOffset, double minElevationOffset, double maxElevationOffset) {
        this.minAngleOffset = minAngleOffset;
        this.maxAngleOffset = maxAngleOffset;
        this.minTimeOffset = minTimeOffset;
        this.maxTimeOffset = maxTimeOffset;
        this.minElevationOffset = minElevationOffset;
        this.maxElevationOffset = maxElevationOffset;
    }

    /**
     * Creates a new basic track generator with given parameters.
     * @param maxAngleOffset Maximum angle offset of latitude and longitude in degrees.
     * @param maxTimeOffset Maximum time offset of a track point in seconds.
     * @param maxElevationOffset Maximum elevation offset of a track point in meters.
     */
    public BasicTrackGenerator(double maxAngleOffset, double maxTimeOffset, double maxElevationOffset) {
        this.maxAngleOffset = maxAngleOffset;
        this.maxTimeOffset = maxTimeOffset;
        this.maxElevationOffset = maxElevationOffset;
    }


    /**
     * Generates a new copy of a track with applied deviations. The result track contains the same amount of track
     * points but they are randomized within the specified offsets.
     * @param track Source track object.
     * @return New generated track object from source object.
     */
    public Track generateFromTrack(Track track) {
        Random random = new Random();

        Track resultTrack = new Track();

        track.getSegments().forEach(segment -> {
            TrackSegment trkseg = new TrackSegment();
            resultTrack.addTrackSegment(trkseg);

            segment.getPoints().forEach(point -> {
                TrackPoint trkpt = new TrackPoint();

                double diffLat = minAngleOffset + random.nextDouble() * maxAngleOffset;
                double diffLon = minAngleOffset + random.nextDouble() * maxAngleOffset;


                trkpt.setLatitude(point.getLatitude() + diffLat);
                trkpt.setLongitude(point.getLongitude() + diffLon);

                if (point.getTime() != null) {
                    long diffTime = (long) (minTimeOffset + random.nextDouble() * maxTimeOffset);
                    trkpt.setTime(new Date(point.getTime().getTime() + diffTime));
                }

                if (point.getElevation() != null) {
                    double diffElevation = minElevationOffset + random.nextDouble() * maxElevationOffset;
                    trkpt.setElevation(point.getElevation() + diffElevation);
                }

                trkseg.addTrackPoint(trkpt);
            });

        });

        return resultTrack;
    }

    /**
     * Returns minimum angle offset in degrees.
     * @return Minimum angle offset in degrees.
     */
    public double getMinAngleOffset() {
        return minAngleOffset;
    }

    /**
     * Sets minimum angle offset in degrees.
     * @param minAngleOffset Minimum angle offset in degrees.
     */
    public void setMinAngleOffset(double minAngleOffset) {
        this.minAngleOffset = minAngleOffset;
    }

    /**
     * Returns maximum angle offset in degrees.
     * @return Maximum angle offset in degrees.
     */
    public double getMaxAngleOffset() {
        return maxAngleOffset;
    }

    /**
     * Sets maximum angle offset in degrees.
     * @param maxAngleOffset Maximum angle offset in degrees.
     */
    public void setMaxAngleOffset(double maxAngleOffset) {
        this.maxAngleOffset = maxAngleOffset;
    }

    /**
     * Returns minimum time offset in seconds.
     * @return Minimum time offset in seconds.
     */
    public double getMinTimeOffset() {
        return minTimeOffset;
    }

    /**
     * Sets minimum time offset in seconds.
     * @param minTimeOffset Minimum time offset in seconds.
     */
    public void setMinTimeOffset(double minTimeOffset) {
        this.minTimeOffset = minTimeOffset;
    }

    /**
     * Returns maximum time offset in seconds.
     * @return Maximum time offset in seconds.
     */
    public double getMaxTimeOffset() {
        return maxTimeOffset;
    }

    /**
     * Sets maximum time offset in seconds.
     * @param maxTimeOffset Maximum time offset in seconds.
     */
    public void setMaxTimeOffset(double maxTimeOffset) {
        this.maxTimeOffset = maxTimeOffset;
    }

    /**
     * Returns minimum elevation offset in meters.
     * @return Minimum elevation offset in meters.
     */
    public double getMinElevationOffset() {
        return minElevationOffset;
    }

    /**
     * Sets minimum elevation offset in meters.
     * @param minElevationOffset Minimum elevation offset in meters.
     */
    public void setMinElevationOffset(double minElevationOffset) {
        this.minElevationOffset = minElevationOffset;
    }

    /**
     * Returns maximum elevation offset in meters.
     * @return Maximum elevation offset in meters.
     */
    public double getMaxElevationOffset() {
        return maxElevationOffset;
    }

    /**
     * Sets maximum elevation offset in meters.
     * @param maxElevationOffset Maximum elevation offset in meters.
     */
    public void setMaxElevationOffset(double maxElevationOffset) {
        this.maxElevationOffset = maxElevationOffset;
    }

    /**
     * This is a convenience builder class for the basic track generator.
     */
    public static class Builder {
        private final BasicTrackGenerator generator;

        /**
         * Creates a new builder object.
         */
        public Builder() {
            generator = new BasicTrackGenerator();
        }

        /**
         * Sets minimum and maximum angle offsets in degrees.
         * @param min Minimum angle offset in degrees.
         * @param max Maximum angle offset in degrees.
         */
        public Builder angleOffset(double min, double max) {
            generator.minAngleOffset = min;
            generator.maxAngleOffset = max;

            return this;
        }

        /**
         * Sets minimum and maximum time offsets in seconds.
         * @param min Minimum time offset in seconds.
         * @param max Maximum time offset in seconds.
         */
        public Builder timeOffset(double min, double max) {
            generator.minTimeOffset = min;
            generator.maxTimeOffset = max;

            return this;
        }

        /**
         * Sets minimum and maximum elevation offsets in meters.
         * @param min Minimum elevation offset in meters.
         * @param max Maximum elevation offset in meters.
         */
        public Builder elevationOffset(double min, double max) {
            generator.minElevationOffset = min;
            generator.maxElevationOffset = max;

            return this;
        }

        /**
         * Returns the configured generator object.
         * @return Configured generator object.
         */
        public BasicTrackGenerator build() {
            return generator;
        }
    }
}
