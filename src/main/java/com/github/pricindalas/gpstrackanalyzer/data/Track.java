package com.github.pricindalas.gpstrackanalyzer.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a track data structure from GPS record. It contains a list of segments which make
 * the track.
 */
public class Track {

    private List<TrackSegment> segments;

    /**
     * Creates a Track object with empty list of track segments.
     */
    public Track() {
        this.segments = new ArrayList<>();
    }

    /**
     * Creates a Track object with given list of segments.
     * @param segments List of segments.
     */
    public Track(List<TrackSegment> segments) {
        this.segments = segments;
    }

    /**
     * Adds a segment to track segments list.
     * @param segment A segment to add to the list.
     */
    public void addTrackSegment(TrackSegment segment) {
        segments.add(segment);
    }

    /**
     * Removes the selected segment from segment list by given index.
     * @param index index of a segment to remove.
     */
    public void removeTrackSegment(int index) {
        segments.remove(index);
    }

    /**
     * Clears all the segments from the track object.
     */
    public void clearTrackSegments() {
        segments.clear();
    }

    /**
     * Returns the segment list of a track object.
     * @return The segment list of a track object.
     */
    public List<TrackSegment> getSegments() {
        return segments;
    }

    /**
     * Sets the segment list to the track object.
     * @param segments Segment list to set to track object.
     */
    public void setSegments(List<TrackSegment> segments) {
        this.segments = segments;
    }
}
