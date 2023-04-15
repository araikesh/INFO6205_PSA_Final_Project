package edu.neu.coe.info6205.tactical;

import edu.neu.coe.info6205.model.Vertex;

import java.util.List;

public class TwoOptOptimization {

    public static List<Vertex> twoOpt(List<Vertex> tour) {
        // Use the two-opt heuristic to improve the tour
        boolean improvement = true;
        while (improvement) {
            improvement = false;
            for (int i = 0; i < tour.size() - 2; i++) {
                for (int j = i + 2; j < tour.size(); j++) {
                    double d1 = tour.get(i).distance(tour.get(i+1));
                    double d2 = tour.get(j).distance(tour.get((j+1)%tour.size()));
                    double d3 = tour.get(i).distance(tour.get(j));
                    double d4 = tour.get((i+1)%tour.size()).distance(tour.get((j+1)%tour.size()));
                    if (d1 + d2 > d3 + d4) {
                        reverseSublist(tour, i+1, j);
                        improvement = true;
                    }
                }
            }
        }
        return tour;
    }

    public static void reverseSublist(List<Vertex> list, int start, int end) {
        // Reverse the sublist from start to end (inclusive)
        while (start < end) {
            Vertex temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}
