package com.github.pricindalas.gpstrackanalyzer.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a segment of a GPS record.
 */
public class TrackSegment {

    private List<TrackPoint> points;

    /**
     * Creates a new segment with empty track point list.
     */
    public TrackSegment() {
        this.points = new ArrayList<>();
    }

    /**
     * Creates a new segment with given track point list.
     * @param points Track point list to set.
     */
    public TrackSegment(List<TrackPoint> points) {
        this.points = points;
    }

    /**
     * Adds a track point to the segment.
     * @param point The track point to add.
     */
    public void addTrackPoint(TrackPoint point) {
        points.add(point);
    }

    /**
     * Removes a track point from the segment at given index.
     * @param index Index of a track point to remove.
     */
    public void removeTrackPoint(int index) {
        points.remove(index);
    }

    /**
     * Clears all the track points from the segment object.
     */
    public void clearTrackPoints() {
        points.clear();
    }

    /**
     * Returns a list of track points of the track segment.
     * @return A list of the track points.
     */
    public List<TrackPoint> getPoints() {
        return points;
    }

    /**
     * Sets a list of track points to the segment object.
     * @param points A list of track points.
     */
    public void setPoints(List<TrackPoint> points) {
        this.points = points;
    }
}
