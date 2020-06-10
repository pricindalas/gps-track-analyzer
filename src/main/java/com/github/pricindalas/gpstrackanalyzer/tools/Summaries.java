package com.github.pricindalas.gpstrackanalyzer.tools;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import com.github.pricindalas.gpstrackanalyzer.data.TrackPoint;
import com.github.pricindalas.gpstrackanalyzer.data.TrackSummary;

public class Summaries {

    public static TrackSummary generateTrackSummary(Track track) {

        TrackSummary summary = new TrackSummary();

        double maxSpeed = 0;
        double minHeight = Double.MAX_VALUE;
        double maxHeight = Double.MIN_VALUE;

        TrackPoint first = null;
        TrackPoint last = null;

        for (int i = 0; i < track.getSegments().size(); i++) {

            if (track.getSegments().get(i).getPoints().size() < 2) {
                continue;
            }

            for (int j = 1; j < track.getSegments().get(i).getPoints().size(); j++) {
                TrackPoint tp1 = track.getSegments().get(i).getPoints().get(j);
                TrackPoint tp2 = track.getSegments().get(i).getPoints().get(j - 1);

                double distance = tp1.distanceTo(tp2);
                double duration = (tp1.getTime().getTime() - tp2.getTime().getTime()) / 1000.0;

                if (tp1.getElevation() != null && tp2.getElevation() != null) {
                    double heightDiff = tp1.getElevation() - tp2.getElevation();

                    if (heightDiff > 0) {
                        summary.addAscent(heightDiff);
                    } else {
                        summary.addDescent(heightDiff);
                    }
                }

                double speed = distance / duration;

                if (speed > maxSpeed) {
                    maxSpeed = speed;
                }

                summary.addDistance(distance);
                summary.addDuration(duration);

                last = tp1;

                if (last.getElevation() < minHeight) {
                    minHeight = last.getElevation();
                }

                if (last.getElevation() > maxHeight) {
                    maxHeight = last.getElevation();
                }

                if (first == null) {
                    first = last;
                }
            }

        }

        if (first != null) {
            double tripEff = last.distanceTo(first) / summary.getDistance();
            summary.setTripEfficiency(tripEff);
        }

        summary.setAvgSpeed(summary.getDistance() / summary.getDuration());
        summary.setMaxSpeed(maxSpeed);

        summary.setAvgPace(Converters.kmhToPace(Converters.toKmh(summary.getAvgSpeed())));
        summary.setMaxPace(Converters.kmhToPace(Converters.toKmh(summary.getMaxSpeed())));

        summary.setMinHeight(minHeight);
        summary.setMaxHeight(maxHeight);

        return summary;
    }

}
