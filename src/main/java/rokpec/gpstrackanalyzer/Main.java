package rokpec.gpstrackanalyzer;

import rokpec.gpstrackanalyzer.data.Track;
import rokpec.gpstrackanalyzer.data.TrackSummary;
import rokpec.gpstrackanalyzer.generators.BasicTrackGenerator;
import rokpec.gpstrackanalyzer.io.GpxFileReader;
import rokpec.gpstrackanalyzer.io.GpxFileWriter;
import rokpec.gpstrackanalyzer.io.TrackFileReader;
import rokpec.gpstrackanalyzer.io.TrackFileWriter;
import rokpec.gpstrackanalyzer.tools.Summaries;

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
