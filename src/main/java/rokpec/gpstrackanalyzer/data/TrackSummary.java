package rokpec.gpstrackanalyzer.data;

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

    public TrackSummary() { }

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

    public void addDistance(double distance) {
        this.distance += distance;
    }

    public void addDuration(double duration) {
        this.duration += duration;
    }

    public void addAscent(double ascent) {
        this.ascent += ascent;
    }

    public void addDescent(double descent) {
        this.descent += descent;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAvgPace() {
        return avgPace;
    }

    public void setAvgPace(double avgPace) {
        this.avgPace = avgPace;
    }

    public double getMaxPace() {
        return maxPace;
    }

    public void setMaxPace(double maxPace) {
        this.maxPace = maxPace;
    }

    public double getAscent() {
        return ascent;
    }

    public void setAscent(double ascent) {
        this.ascent = ascent;
    }

    public double getDescent() {
        return descent;
    }

    public void setDescent(double descent) {
        this.descent = descent;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getTripEfficiency() {
        return tripEfficiency;
    }

    public void setTripEfficiency(double tripEfficiency) {
        this.tripEfficiency = tripEfficiency;
    }
}
