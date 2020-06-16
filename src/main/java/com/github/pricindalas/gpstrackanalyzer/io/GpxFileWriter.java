package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This class is for writing GPS track data to GPX file format.
 */
public class GpxFileWriter extends TrackFileWriter {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private final File gpxFile;

    /**
     * Creates a new GPX file writer for a given file path.
     * @param path File path to write the GPX file.
     */
    public GpxFileWriter(String path) {

        gpxFile = new File(path);

        if (gpxFile.isDirectory()) {
            throw new RuntimeException("The given file is a directory.");
        }
    }

    /**
     * Writes the track data to GPX file.
     * @param track GPS track data.
     */
    public void writeData(Track track) {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;

        final String coordsFormat = "%.7f";
        final String eleFormat = "%.1f";

        try {
            docBuilder = dbFactory.newDocumentBuilder();
            Document document = docBuilder.newDocument();

            Element rootElement = document.createElement("gpx");
            document.appendChild(rootElement);

            Element trk = document.createElement("trk");
            rootElement.appendChild(trk);

            track.getSegments().forEach(s -> {
                Element trkseg = document.createElement("trkseg");
                trk.appendChild(trkseg);

                s.getPoints().forEach(p -> {
                    Element trkpt = document.createElement("trkpt");

                    trkpt.setAttribute("lat", String.format(Locale.ROOT, coordsFormat, p.getLatitude()));
                    trkpt.setAttribute("lon", String.format(Locale.ROOT, coordsFormat, p.getLongitude()));

                    if (p.getElevation() != null) {
                        Element ele = document.createElement("ele");
                        ele.setTextContent(String.format(Locale.ROOT, eleFormat, p.getElevation()));
                        trkpt.appendChild(ele);
                    }

                    if (p.getTime() != null) {
                        Element time = document.createElement("time");
                        time.setTextContent(sdf.format(p.getTime()));
                        trkpt.appendChild(time);
                    }

                    trkseg.appendChild(trkpt);
                });
            });

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(document);

            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(gpxFile);

            transformer.transform(source, console);
            transformer.transform(source, file);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }
}
