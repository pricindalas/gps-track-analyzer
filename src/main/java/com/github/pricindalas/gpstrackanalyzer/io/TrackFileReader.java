package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

/**
 * This is an abstract class for GPS track file readers.
 */
public abstract class TrackFileReader {

    /**
     * Reads data from file to track data structure.
     * @return Track data structure.
     */
    public abstract Track readData();

}
