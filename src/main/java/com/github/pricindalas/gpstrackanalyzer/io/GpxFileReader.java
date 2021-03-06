package com.github.pricindalas.gpstrackanalyzer.io;

import com.github.pricindalas.gpstrackanalyzer.data.Track;
import com.github.pricindalas.gpstrackanalyzer.data.TrackPoint;
import com.github.pricindalas.gpstrackanalyzer.data.TrackSegment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * This class is used for reading GPX format files to GPS track records.
 */
public class GpxFileReader extends TrackFileReader {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private final File gpxFile;

    /**
     * Creates a new GPX file reader object with given GPX file path.
     * @param path The path to GPX file.
     */
    public GpxFileReader(String path) {
        gpxFile = new File(path);

        if (!gpxFile.exists()) {
            throw new RuntimeException("File " + path + "does not exist.");
        } else if (gpxFile.isDirectory()) {
            throw new RuntimeException("The given file is a directory.");
        }
    }

    /**
     * Reads the file and creates a GPS track object from read data.
     * @return GPS track object with data.
     */
    public Track readData() {

        Track track = new Track();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(gpxFile);

            NodeList trk = document.getElementsByTagName("trk");

            for (int i = 0; i < trk.getLength(); i++) {
                Node trkItem = trk.item(i);

                if (trkItem.getNodeName().equals("trk")) {

                    NodeList trkSegments = trkItem.getChildNodes();

                    for (int j = 0; j < trkSegments.getLength(); j++) {
                        Node trkSegment = trkSegments.item(j);

                        if (trkSegment.getNodeName().equals("trkseg")) {

                            TrackSegment segment = new TrackSegment();
                            track.addTrackSegment(segment);

                            NodeList trkPts = trkSegment.getChildNodes();

                            for (int k = 0; k < trkPts.getLength(); k++) {
                                Node trkPt = trkPts.item(k);

                                String nodename = trkPt.getNodeName();

                                if (trkPt.getNodeName().equals("trkpt")) {

                                    Element element = (Element) trkPt;

                                    double lat = Double.parseDouble(element.getAttribute("lat"));
                                    double lon = Double.parseDouble(element.getAttribute("lon"));
                                    Double ele = null;
                                    String time = null;

                                    List<Node> nodes = toNodeList(element.getChildNodes());

                                    Optional<Node> elev = nodes.stream().filter(e -> e.getNodeName().equals("ele")).findFirst();

                                    if (elev.isPresent()) {
                                        ele = Double.parseDouble(elev.get().getTextContent());
                                    }

                                    Optional<Node> timeNode = nodes.stream().filter(e -> e.getNodeName().equals("time")).findFirst();

                                    if (timeNode.isPresent()) {
                                        time = timeNode.get().getTextContent();
                                    }

                                    segment.addTrackPoint(new TrackPoint(lat, lon, ele, parseDate(time)));
                                }
                            }
                        }
                    }
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return track;
    }

    /**
     * This method creates a NodeList to actual iterable Node list for easier iteration while reading GPX file data.
     * @param nodeList the NodeList object to be read.
     * @return Iterable list of the Node objects.
     */
    private static List<Node> toNodeList(NodeList nodeList) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }

        return nodes;
    }

    /**
     * Parses data from string. There might be different date formats in GPX file so we have to have these defined.
     * @param value String of a date value.
     * @return Date object or null if the parse is failed.
     */
    private Date parseDate(String value) {
        Date date = null;

        try {
            date = sdf1.parse(value);
        } catch (ParseException ignored) {

        }

        if (date == null) {
            try {
                date = sdf2.parse(value);
            } catch (ParseException ignored) {

            }
        }

        return date;
    }
}
