package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

/**
 * This is an abstract class for GPS track file writers.
 */
public abstract class TrackFileWriter {

    /**
     * Writes track data to file.
     * @param track Track data structure.
     */
    public abstract void writeData(Track track);

}
