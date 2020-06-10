package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

public abstract class TrackFileWriter {
    public abstract void writeData(Track track);
}
