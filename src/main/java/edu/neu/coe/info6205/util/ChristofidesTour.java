package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;

import java.util.List;

public class ChristofidesTour {

    public static String getTour(List<Vertex> finalTour) {

        StringBuilder tour = new StringBuilder("[ ");
        for (Vertex v : finalTour) {
            String crimeId = v.getId();
            tour.append(crimeId.substring(crimeId.length() - 5) + ", ");
        }
        tour.append(" ]");

        return tour.toString();
    }

    public static double getTourCost(List<Vertex> finalTour) {
        double tourCost = 0;
        for (int i = 0; i < finalTour.size() - 1; i++) {
            Vertex v1 = finalTour.get(i);
            Vertex v2 = finalTour.get(i + 1);
            Edge edge = new Edge(v1, v2);
            tourCost += edge.getWeight();
        }
        return tourCost;
    }

}