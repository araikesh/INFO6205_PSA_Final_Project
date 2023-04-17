package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChristofidesTourTest {

    @Test
    public void testGetTour() {
        // Test case with an empty list
        String expected = "[  ]";
        String actual = ChristofidesTour.getTour(new ArrayList<>());
        assertEquals(expected, actual);
        
        // Test case with a single vertex
        expected = "[ abcde,  ]";
        actual = ChristofidesTour.getTour(Collections.singletonList(new Vertex(0,"abcde", 51.5074, -0.1278)));
        assertEquals(expected, actual);
        
        // Test case with multiple vertices
        List<Vertex> vertices = Arrays.asList(new Vertex(0,"abcde", 51.5074, -0.1278), new Vertex(0,"ABCDE", 51.5074, -0.1278));
        expected = "[ abcde, ABCDE,  ]";
        actual = ChristofidesTour.getTour(vertices);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTourCost() {
        // Test case with an empty list
        double expected = 0;
        double actual = ChristofidesTour.getTourCost(new ArrayList<>());
        assertEquals(expected, actual, 0.0);
        
        // Test case with multiple vertices
        List<Vertex> vertices = new ArrayList<>();
        Vertex v1 = new Vertex(0,"A", 51.5074, -0.1278);
        Vertex v2 = new Vertex(1,"B", 37.7749, -0.4194);
        vertices = Arrays.asList(v1, v2);
        expected = v1.distance(v2);
        actual = ChristofidesTour.getTourCost(vertices);
        assertEquals(expected, actual, 0.0);
        
        // Test case with three vertices
        Vertex v3 = new Vertex(2,"C", 48.8566, 2.3522);
        vertices = Arrays.asList(v1, v2, v3);
        expected = v1.distance(v2) + v2.distance(v3);
        actual = ChristofidesTour.getTourCost(vertices);
        assertEquals(expected, actual, 0.0);
    }
}
