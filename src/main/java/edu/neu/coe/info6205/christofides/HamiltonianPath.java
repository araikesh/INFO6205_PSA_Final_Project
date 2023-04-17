package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Vertex;

import java.util.*;

public class HamiltonianPath {

    public static List<Vertex> findShortestHamiltonianPath(List<Vertex> eulerianPath) {
        Set<Vertex> visited = new HashSet<>();
        List<Vertex> hamiltonianPath = new ArrayList<>();
        for (Vertex vertex : eulerianPath) {
            if (!visited.contains(vertex)) {
                hamiltonianPath.add(vertex);
                visited.add(vertex);
            }
        }
        return hamiltonianPath;
    }
}
