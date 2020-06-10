package rokpec.gpstrackanalyzer.data;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackSegment> segments;

    public Track() {
        this.segments = new ArrayList<TrackSegment>();
    }

    public Track(List<TrackSegment> segments) {
        this.segments = segments;
    }

    public void addTrackSegment(TrackSegment segment) {
        segments.add(segment);
    }

    public void removeTrackSegment(int index) {
        segments.remove(index);
    }

    public void clearTrackSegments() {
        segments.clear();
    }

    public List<TrackSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<TrackSegment> segments) {
        this.segments = segments;
    }
}
