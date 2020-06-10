package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

public abstract class TrackFileReader {
    public abstract Track readData();
}
