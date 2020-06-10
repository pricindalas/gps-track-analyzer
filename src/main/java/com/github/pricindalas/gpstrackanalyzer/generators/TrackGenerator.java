package com.github.pricindalas.gpstrackanalyzer.generators;

import com.github.pricindalas.gpstrackanalyzer.data.Track;

public abstract class TrackGenerator {
    public abstract Track generateFromTrack(Track track);
}
