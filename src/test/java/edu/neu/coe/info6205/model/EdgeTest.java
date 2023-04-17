package edu.neu.coe.info6205.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EdgeTest {

    @Test
    public void testConstructor() {
        Vertex v1 = new Vertex(1, "v1", 0, 0);
        Vertex v2 = new Vertex(2, "v2", 1, 1);
        Edge edge = new Edge(v1, v2);
        assertEquals(v1, edge.getV1());
        assertEquals(v2, edge.getV2());
        assertEquals(v1.distance(v2), edge.getWeight(), 0.01);
        assertEquals(Arrays.asList(v1, v2), edge.getPath());
    }

    @Test
    public void testCompareTo() {
        Vertex v1 = new Vertex(1, "v1", 0, 0);
        Vertex v2 = new Vertex(2, "v2", 1, 1);
        Vertex v3 = new Vertex(3, "v3", 2, 2);
        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);
        Edge e3 = new Edge(v2, v3);
        assertEquals(-1, e1.compareTo(e2));
        assertEquals(1, e2.compareTo(e1));
        assertEquals(0, e1.compareTo(e1));
        assertEquals(1, e1.compareTo(e3));
        assertEquals(-1, e3.compareTo(e1));
    }
}