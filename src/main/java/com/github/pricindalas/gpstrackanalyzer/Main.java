package com.github.pricindalas.gpstrackanalyzer;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import com.github.pricindalas.gpstrackanalyzer.data.TrackSummary;
import com.github.pricindalas.gpstrackanalyzer.io.GpxFileReader;
import com.github.pricindalas.gpstrackanalyzer.io.TrackFileReader;
import com.github.pricindalas.gpstrackanalyzer.io.TrackFileWriter;
import com.github.pricindalas.gpstrackanalyzer.tools.Summaries;
import com.github.pricindalas.gpstrackanalyzer.generators.BasicTrackGenerator;
import com.github.pricindalas.gpstrackanalyzer.io.GpxFileWriter;

public class Main {
    public static void main(String[] args) {

        TrackFileReader reader = new GpxFileReader("test.gpx");

        Track track = reader.readData();

        TrackFileWriter writer = new GpxFileWriter("result.gpx");

        writer.writeData(track);

        TrackSummary trackSummary = Summaries.generateTrackSummary(track);

        Track genTrack = new BasicTrackGenerator(0.0001, 3 * 1000, 1).generateFromTrack(track);

        TrackSummary genSummary = Summaries.generateTrackSummary(genTrack);

        System.out.println(trackSummary);
        System.out.println(genSummary);

    }
}
