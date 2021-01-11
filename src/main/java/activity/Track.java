package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Track {

    public static final int LATITUDE_BEGIN_INDEX = 24;
    public static final int LATITUDE_END_INDEX = 34;
    public static final int LONGITUDE_BEGIN_INDEX = 41;
    public static final int LONGITUDE_END_INDEX = 51;
    public static final int ELEVATION_BEGIN_INDEX = 21;
    public static final int ELEVATION_END_INDEX = 26;
    private final List<TrackPoint> trackPoints = new ArrayList<>();

    public void loadFromGpx(InputStream is) {
        Coordinate coordinate = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.strip().startsWith("<trkpt")) {
                    double latitude = Double.parseDouble(line.substring(LATITUDE_BEGIN_INDEX, LATITUDE_END_INDEX));
                    double longitude = Double.parseDouble(line.substring(LONGITUDE_BEGIN_INDEX, LONGITUDE_END_INDEX));
                    coordinate = new Coordinate(latitude, longitude);
                }
                if (line.strip().startsWith("<ele")) {
                    double elevation = Double.parseDouble(line.substring(ELEVATION_BEGIN_INDEX, ELEVATION_END_INDEX));
                    trackPoints.add(new TrackPoint(coordinate, elevation));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public double getDistance() {
        double distance = 0;
        TrackPoint prevTrackPoint = null;

        for (TrackPoint trackPoint : trackPoints) {
            if (prevTrackPoint != null) {
                distance += trackPoint.getDistanceFrom(prevTrackPoint);
            }
            prevTrackPoint = trackPoint;
        }

        return distance;
    }

    public double getFullDecrease() {
        double decrease = 0;
        TrackPoint prevTrackPoint = null;

        for (TrackPoint trackPoint : trackPoints) {
            if (prevTrackPoint != null && prevTrackPoint.getElevation() > trackPoint.getElevation()) {
                decrease += prevTrackPoint.getElevation() - trackPoint.getElevation();
            }
            prevTrackPoint = trackPoint;
        }

        return decrease;
    }

    public double getFullElevation() {
        double elevation = 0;
        TrackPoint prevTrackPoint = null;

        for (TrackPoint trackPoint : trackPoints) {
            if (prevTrackPoint != null && prevTrackPoint.getElevation() < trackPoint.getElevation()) {
                elevation += trackPoint.getElevation() - prevTrackPoint.getElevation();
            }
            prevTrackPoint = trackPoint;
        }
        return elevation;
    }

    public double getRectangleArea() {
        Coordinate maxCoord = findMaximumCoordinate();
        Coordinate minCoord = findMinimumCoordinate();

        return (maxCoord.getLatitude() - minCoord.getLatitude()) * (maxCoord.getLongitude() - minCoord.getLongitude());
    }

    public Coordinate findMaximumCoordinate() {
        double xCoordMax = Double.MIN_VALUE;
        double yCoordMax = Double.MIN_VALUE;

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() > xCoordMax) {
                xCoordMax = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() > yCoordMax) {
                yCoordMax = trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(xCoordMax, yCoordMax);
    }

    public Coordinate findMinimumCoordinate() {
        double xCoordMin = Double.MAX_VALUE;
        double yCoordMin = Double.MAX_VALUE;

        for (TrackPoint trackPoint : trackPoints) {
            if (trackPoint.getCoordinate().getLatitude() < xCoordMin) {
                xCoordMin = trackPoint.getCoordinate().getLatitude();
            }
            if (trackPoint.getCoordinate().getLongitude() < yCoordMin) {
                yCoordMin = trackPoint.getCoordinate().getLongitude();
            }
        }

        return new Coordinate(xCoordMin, yCoordMin);
    }

    public List<TrackPoint> getTrackPoints() {
        return new ArrayList<>(trackPoints);
    }
}
