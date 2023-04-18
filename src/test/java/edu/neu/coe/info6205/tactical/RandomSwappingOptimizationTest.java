package edu.neu.coe.info6205.tactical;

import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomSwappingOptimizationTest {

    @Test
    public void testOptimizeWithEmptyList() {
        List<Vertex> vertices = new ArrayList<>();
        List<Vertex> result = RandomSwappingOptimization.optimize(vertices);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOptimizeWithOneVertex() {
        Vertex v1 = new Vertex(0,"A", 51.5074, -0.1278);
        List<Vertex> vertices = Arrays.asList(v1);
        List<Vertex> result = RandomSwappingOptimization.optimize(vertices);
        assertEquals(vertices, result);
    }

    @Test
    public void testOptimizeWithTwoVertices() {
        Vertex v1 = new Vertex(1, "B", 37.7749, -0.4194);
        Vertex v2 = new Vertex(2, "C", 48.8566, 2.3522);
        List<Vertex> vertices = Arrays.asList(v1, v2);
        List<Vertex> result = RandomSwappingOptimization.optimize(vertices);
        assertEquals(vertices, result);
    }

    @Test
    public void testOptimizeWithManyVertices() {
        Vertex v1 = new Vertex(0, "A", 51.5074, -0.1278);
        Vertex v2 = new Vertex(1, "B", 37.7749, -0.4194);
        Vertex v3 = new Vertex(2, "C", 48.8566, 2.3522);
        Vertex v4 = new Vertex(3, "D", 51.483548, -0.009691);
        List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4);
        List<Vertex> result = RandomSwappingOptimization.optimize(vertices);
        assertEquals(4, result.size());
    }

    @Test
    public void testSwapVertices() {
        Vertex v1 = new Vertex(0, "A", 51.5074, -0.1278);
        Vertex v2 = new Vertex(1, "B", 37.7749, -0.4194);
        Vertex v3 = new Vertex(2, "C", 48.8566, 2.3522);
        List<Vertex> vertices = Arrays.asList(v1, v2, v3);
        List<Vertex> result = RandomSwappingOptimization.swapVertices(vertices, 0, 2);
        assertEquals(3, result.size());
        assertEquals(v3, result.get(0));
        assertEquals(v2, result.get(1));
        assertEquals(v1, result.get(2));
    }
}
