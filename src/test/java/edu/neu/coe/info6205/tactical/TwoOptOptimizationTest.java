package edu.neu.coe.info6205.tactical;

import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TwoOptOptimizationTest {

    @Test
    public void testTwoOpt() {
        // Test that twoOpt returns a valid tour
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0,"A", 51.5074, -0.1278));
        vertices.add(new Vertex(1,"B", 37.7749, -0.4194));
        vertices.add(new Vertex(2,"C", 48.8566, 2.3522));
        List<Vertex> tour = TwoOptOptimization.twoOpt(vertices);
        assertEquals(tour.size(), 3);
    }

    @Test
    public void testReverseSublist() {
        // Test that reverseSublist works correctly
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0,"A", 51.5074, -0.1278));
        vertices.add(new Vertex(1,"B", 37.7749, -0.4194));
        vertices.add(new Vertex(2,"C", 48.8566, 2.3522));
        TwoOptOptimization.reverseSublist(vertices, 1, 2);
        assertEquals(vertices.get(0).getId(), "A");
        assertEquals(vertices.get(1).getId(), "C");
        assertEquals(vertices.get(2).getId(), "B");
    }
}
