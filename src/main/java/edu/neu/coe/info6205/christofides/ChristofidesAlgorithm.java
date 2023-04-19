package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.ChristofidesTour;

import java.util.*;

public class ChristofidesAlgorithm {

    public static List<Vertex> christofides(List<Vertex> vertices) {

        //Build the minimum spanning tree of the graph
        List<Edge> mst = PrimsMST.findMinimumSpanningTree(vertices);

        //Build the subgraph of odd-degree vertices
        List<Vertex> oddVertices = findOddDegreeVertices(vertices, mst);

        //Find the minimum weight perfect matching of the subgraph
        List<Edge> matching = findMinimumWeightPerfectMatching(oddVertices);

        //Combine the matching of the minimum spanning tree and the matching of the subgraph
        // to obtain a minimum weight perfect matching of the original graph
        List<Edge> edges = new ArrayList<>();
        edges.addAll(mst);
        edges.addAll(matching);

        //Find an Eulerian circuit in the new graph.
        // An Eulerian circuit is a path that visits every edge exactly once
        List<Vertex> eulerianPath = findEulerianPath(vertices, edges);
        System.out.println("Eulerian Path Cost: " + ChristofidesTour.getTourCost(eulerianPath));

        // Find all Hamiltonian paths in the graph and use the shortest Hamiltonian path
        List<Vertex> hamiltonianPath = HamiltonianPath.findShortestHamiltonianPath(eulerianPath);
        System.out.println("Hamiltonian Path Cost: " + ChristofidesTour.getTourCost(hamiltonianPath));

        return hamiltonianPath;
    }

    public static List<Vertex> findOddDegreeVertices(List<Vertex> vertices, List<Edge> edges) {
        Map<Vertex, Integer> degree = new HashMap<>();
        for (Vertex v : vertices) {
            degree.put(v, 0);
        }
        for (Edge e : edges) {
            degree.put(e.getV1(), degree.get(e.getV1()) + 1);
            degree.put(e.getV2(), degree.get(e.getV2()) + 1);
        }
        List<Vertex> result = new ArrayList<>();
        for (Vertex v : degree.keySet()) {
            if (degree.get(v) % 2 != 0) {
                result.add(v);
            }
        }
        return result;
    }

    public static List<Edge> findMinimumWeightPerfectMatching(List<Vertex> oddVertices) {
        List<Edge> result = new ArrayList<>();
        if (oddVertices.size() <= 1) {
            return result;
        }
        int n = oddVertices.size();
        double[][] distance = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Vertex v1 = oddVertices.get(i);
                Vertex v2 = oddVertices.get(j);
                distance[i][j] = v1.distance(v2);
                distance[j][i] = distance[i][j];
            }
        }

        Integer[] integers = new Integer[n];

        boolean[] used = new boolean[n];
        Arrays.fill(integers, -1);
        List<Integer> matching =  Arrays.asList(integers);

        for (int i = 0; i < n; i++) {
            used[i] = true;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (matching.get(i) == -1
                        || distance[i][j] < distance[i][matching.get(i)])) {
                    matching.set(i, j);
                    matching.set(j, i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (matching.get(i) == -1) {
                findAugmentingPath(i, matching, vis, oddVertices, distance);
            }
        }
        for (int i = 0; i < n; i++) {
            if (matching.get(i) != -1) {
                result.add(new Edge(oddVertices.get(i), oddVertices.get(matching.get(i))));
            }
        }
        return result;
    }

    private static boolean findAugmentingPath(int u, List<Integer> matching, boolean[] vis, List<Vertex> oddVertices, double[][] distance) {
        vis[u] = true;
        for (int v = 0; v < oddVertices.size(); v++) {
            if (!vis[v] && matching.get(u) != v && distance[u][v] == 0) {
                if (matching.get(v) == -1 || findAugmentingPath(matching.get(v), matching, vis, oddVertices, distance)) {
                    matching.set(u, v);
                    matching.set(v, u);
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Vertex> findEulerianPath(List<Vertex> vertices, List<Edge> edges) {
        List<Vertex> result = new ArrayList<>();
        if (vertices.isEmpty() || edges.isEmpty()) {
            return result;
        }
        Map<Vertex, List<Edge>> graph = new HashMap<>();
        for (Vertex v : vertices) {
            graph.put(v, new ArrayList<>());
        }
        for (Edge e : edges) {
            graph.get(e.getV1()).add(e);
            graph.get(e.getV2()).add(e);
        }
        Vertex start = vertices.get(0);
        Deque<Vertex> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex current = stack.peek();
            List<Edge> currentEdges = graph.get(current);
            if (currentEdges.isEmpty()) {
                result.add(stack.pop());
            } else {
                Edge e = currentEdges.remove(0);
                Vertex next = e.getV1().equals(current) ? e.getV2() : e.getV1();
                if (graph.get(next).remove(e)) {
                    stack.push(next);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

}