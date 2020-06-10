package rokpec.gpstrackanalyzer.io;

import rokpec.gpstrackanalyzer.data.Track;

public abstract class TrackFileWriter {
    public abstract void writeData(Track track);
}
