package edu.neu.coe.info6205.model;

public class Vertex {

    private final int numericId;
    private final String id;
    private final double latitude;
    private final double longitude;

    public Vertex(int numericId, String id, double latitude, double longitude) {
        this.numericId = numericId;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getNumericId() {
        return numericId;
    }

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public double distance(Vertex v) {
        double dLat = Math.toRadians(v.latitude - latitude);
        double dLon = Math.toRadians(v.longitude - longitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(v.latitude))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6371000 * c; // Earth's radius in meters
    }

    @Override
    public String toString() {
        return id;
    }
}