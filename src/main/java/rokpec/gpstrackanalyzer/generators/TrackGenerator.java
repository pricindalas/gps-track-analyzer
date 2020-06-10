package rokpec.gpstrackanalyzer.generators;

import rokpec.gpstrackanalyzer.data.Track;

public abstract class TrackGenerator {
    public abstract Track generateFromTrack(Track track);
}
