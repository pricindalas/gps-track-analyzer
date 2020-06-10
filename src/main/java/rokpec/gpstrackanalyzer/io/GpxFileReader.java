package rokpec.gpstrackanalyzer.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import rokpec.gpstrackanalyzer.data.Track;
import rokpec.gpstrackanalyzer.data.TrackPoint;
import rokpec.gpstrackanalyzer.data.TrackSegment;

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

public class GpxFileReader extends TrackFileReader {

    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private final File gpxFile;

    public GpxFileReader(String path) {
        gpxFile = new File(path);

        if (!gpxFile.exists()) {
            throw new RuntimeException("File " + path + "does not exist.");
        } else if (gpxFile.isDirectory()) {
            throw new RuntimeException("The given file is a directory.");
        }
    }

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

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return track;
    }

    private static List<Node> toNodeList(NodeList nodeList) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }

        return nodes;
    }

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
