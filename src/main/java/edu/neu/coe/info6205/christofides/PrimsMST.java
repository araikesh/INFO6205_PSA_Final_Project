package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PrimsMST {

    public static List<Edge> findMinimumSpanningTree(List<Vertex> vertices) {

        double mstWeight = 0.0;
        List<Edge> minimumSpanningTree = new ArrayList<>();

        if (vertices.isEmpty()) {
            return minimumSpanningTree;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Vertex start = vertices.get(0);
        for (int i = 0; i < vertices.size(); i++) {
            Vertex current = vertices.get(i);
            if(start.getId().equals(current.getId()))
                continue;
            edges.offer(new Edge(start, current));
        }

        List<Vertex> visited = new ArrayList<>();
        visited.add(start);
        while (!edges.isEmpty() && visited.size() < vertices.size()) {
            Edge shortestEdge = edges.poll();
            Vertex nextVertex = getUnvisitedVertex(visited, shortestEdge);
            if (nextVertex != null) {
                minimumSpanningTree.add(shortestEdge);
                mstWeight += shortestEdge.getWeight();
                visited.add(nextVertex);
                for (Vertex v : vertices) {
                    if (!visited.contains(v)) {
                        edges.offer(new Edge(nextVertex, v));
                    }
                }
            }
        }

        System.out.println("MST Weight: " + mstWeight);
        System.out.println("MST Size: " + minimumSpanningTree.size());
        return minimumSpanningTree;
    }

    private static Vertex getUnvisitedVertex(List<Vertex> visited, Edge edge) {
        if (visited.contains(edge.getV1()) && !visited.contains(edge.getV2())) {
            return edge.getV2();
        } else if (visited.contains(edge.getV2()) && !visited.contains(edge.getV1())) {
            return edge.getV1();
        } else {
            return null;
        }
    }
}
