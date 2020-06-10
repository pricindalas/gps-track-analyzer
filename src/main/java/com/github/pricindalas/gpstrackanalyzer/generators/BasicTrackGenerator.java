package com.github.pricindalas.gpstrackanalyzer.generators;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import com.github.pricindalas.gpstrackanalyzer.data.TrackPoint;
import com.github.pricindalas.gpstrackanalyzer.data.TrackSegment;

import java.util.Date;
import java.util.Random;

public class BasicTrackGenerator extends TrackGenerator {

    private double minAngleOffset;
    private double maxAngleOffset;

    private double minTimeOffset;
    private double maxTimeOffset;

    private double minElevationOffset;
    private double maxElevationOffset;

    public BasicTrackGenerator() { }

    public BasicTrackGenerator(double minAngleOffset, double maxAngleOffset, double minTimeOffset, double maxTimeOffset, double minElevationOffset, double maxElevationOffset) {
        this.minAngleOffset = minAngleOffset;
        this.maxAngleOffset = maxAngleOffset;
        this.minTimeOffset = minTimeOffset;
        this.maxTimeOffset = maxTimeOffset;
        this.minElevationOffset = minElevationOffset;
        this.maxElevationOffset = maxElevationOffset;
    }

    public BasicTrackGenerator(double maxAngleOffset, double maxTimeOffset, double maxElevationOffset) {
        this.maxAngleOffset = maxAngleOffset;
        this.maxTimeOffset = maxTimeOffset;
        this.maxElevationOffset = maxElevationOffset;
    }


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

    public double getMinAngleOffset() {
        return minAngleOffset;
    }

    public void setMinAngleOffset(double minAngleOffset) {
        this.minAngleOffset = minAngleOffset;
    }

    public double getMaxAngleOffset() {
        return maxAngleOffset;
    }

    public void setMaxAngleOffset(double maxAngleOffset) {
        this.maxAngleOffset = maxAngleOffset;
    }

    public double getMinTimeOffset() {
        return minTimeOffset;
    }

    public void setMinTimeOffset(double minTimeOffset) {
        this.minTimeOffset = minTimeOffset;
    }

    public double getMaxTimeOffset() {
        return maxTimeOffset;
    }

    public void setMaxTimeOffset(double maxTimeOffset) {
        this.maxTimeOffset = maxTimeOffset;
    }

    public double getMinElevationOffset() {
        return minElevationOffset;
    }

    public void setMinElevationOffset(double minElevationOffset) {
        this.minElevationOffset = minElevationOffset;
    }

    public double getMaxElevationOffset() {
        return maxElevationOffset;
    }

    public void setMaxElevationOffset(double maxElevationOffset) {
        this.maxElevationOffset = maxElevationOffset;
    }

    public static class BasicTrackGeneratorBuilder {
        private final BasicTrackGenerator generator;

        public BasicTrackGeneratorBuilder() {
            generator = new BasicTrackGenerator();
        }

        public BasicTrackGeneratorBuilder distanceOffset(double min, double max) {
            generator.minAngleOffset = min;
            generator.maxAngleOffset = max;

            return this;
        }

        public BasicTrackGeneratorBuilder timeOffset(double min, double max) {
            generator.minTimeOffset = min;
            generator.maxTimeOffset = max;

            return this;
        }

        public BasicTrackGeneratorBuilder elevationOffset(double min, double max) {
            generator.minElevationOffset = min;
            generator.maxElevationOffset = max;

            return this;
        }

        public BasicTrackGenerator build() {
            return generator;
        }
    }
}
