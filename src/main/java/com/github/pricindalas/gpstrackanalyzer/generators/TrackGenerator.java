package com.github.pricindalas.gpstrackanalyzer.generators;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

/**
 * Abstract class for track generators which generate new tracks from existing tracks.
 */
public abstract class TrackGenerator {

    /**
     * Creates a new GPS record track from the given source track object.
     * @param track Source track object.
     * @return Generated new track object.
     */
    public abstract Track generateFromTrack(Track track);

}
