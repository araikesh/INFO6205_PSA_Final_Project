package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.ChristofidesTour;

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

    /*public static List<Vertex> findShortestHamiltonianPath(List<Vertex> eulerianPath) {
        // Create a graph using the given Eulerian path
        Map<Vertex, List<Edge>> graph = new HashMap<>();
        Vertex prevVertex = null;
        for (Vertex vertex : eulerianPath) {
            if (prevVertex != null) {
                Edge edge = new Edge(prevVertex, vertex);
                List<Edge> edges = graph.getOrDefault(prevVertex, new ArrayList<>());
                edges.add(edge);
                graph.put(prevVertex, edges);
                edges = graph.getOrDefault(vertex, new ArrayList<>());
                edges.add(edge);
                graph.put(vertex, edges);
            }
            prevVertex = vertex;
        }

        // Find all Hamiltonian paths in the graph
        List<List<Vertex>> hamiltonianPaths = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        for (Vertex vertex : eulerianPath) {
            if (!visited.contains(vertex)) {
                List<Vertex> path = new ArrayList<>();
                path.add(vertex);
                findHamiltonianPaths(graph, visited, path, hamiltonianPaths);
            }
        }

        // Calculate the length of each Hamiltonian path
        List<List<Vertex>> shortestPaths = new ArrayList<>();
        double shortestLength = Double.POSITIVE_INFINITY;
        for (List<Vertex> path : hamiltonianPaths) {
            double length = ChristofidesTour.getTourCost(path);
            if (length < shortestLength) {
                shortestPaths.clear();
                shortestPaths.add(path);
                shortestLength = length;
            } else if (length == shortestLength) {
                shortestPaths.add(path);
            }
        }

        // Return the shortest Hamiltonian path
        return shortestPaths.get(0);
    }

    private static void findHamiltonianPaths(Map<Vertex, List<Edge>> graph, Set<Vertex> visited, List<Vertex> path, List<List<Vertex>> hamiltonianPaths) {
        Vertex lastVertex = path.get(path.size() - 1);
        List<Edge> edges = graph.get(lastVertex);
        if (edges == null || edges.isEmpty()) {
            // Reached a dead end, check if we have a Hamiltonian path
            if (path.size() == graph.size()) {
                hamiltonianPaths.add(new ArrayList<>(path));
            }
        } else {
            for (Edge edge : edges) {
                Vertex nextVertex = edge.getV1() == lastVertex ? edge.getV2() : edge.getV1();
                if (!visited.contains(nextVertex)) {
                    visited.add(nextVertex);
                    path.add(nextVertex);
                    findHamiltonianPaths(graph, visited, path, hamiltonianPaths);
                    path.remove(path.size() - 1);
                    visited.remove(nextVertex);
                }
            }
        }
    }*/
}
