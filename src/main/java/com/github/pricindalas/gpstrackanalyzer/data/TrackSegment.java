package com.github.pricindalas.gpstrackanalyzer.data;

import java.util.ArrayList;
import java.util.List;

public class TrackSegment {

    private List<TrackPoint> points;

    public TrackSegment() {
        this.points = new ArrayList<TrackPoint>();
    }

    public TrackSegment(List<TrackPoint> points) {
        this.points = points;
    }

    public void addTrackPoint(TrackPoint point) {
        points.add(point);
    }

    public void removeTrackPoint(int index) {
        points.remove(index);
    }

    public void clearTrackPoints() {
        points.clear();
    }

    public List<TrackPoint> getPoints() {
        return points;
    }

    public void setPoints(List<TrackPoint> points) {
        this.points = points;
    }
}
