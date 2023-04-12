package edu.neu.coe.info6205.model;

import java.util.ArrayList;
import java.util.List;

public class Edge implements Comparable<Edge> {
    private Vertex v1;
    private Vertex v2;
    private double weight;
    private List<Vertex> path;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = v1.distance(v2);
        this.path = new ArrayList<>();
        path.add(v1);
        path.add(v2);
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public double getWeight() {
        return weight;
    }

    public List<Vertex> getPath() {
        return path;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(weight, other.weight);
    }
}