package edu.neu.coe.info6205.strategic;

import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class AntColonyOptimizationTest {

@Test
public void testOptimizeWithAntColony() {
List<Vertex> vertices = new ArrayList<>();
vertices.add(new Vertex(0,"A", 51.5074, -0.1278));
vertices.add(new Vertex(1,"B", 37.7749, -0.4194));
vertices.add(new Vertex(2,"C", 48.8566, 2.3522));
vertices.add(new Vertex(3, "D", 51.483548,-0.009691));
vertices.add(new Vertex(4, "E", 51.513075,-0.118888));

List<Integer> tour = Arrays.asList(0, 1, 2, 3, 4);
List<Integer> optimizedTour = AntColonyOptimization.optimizeWithAntColony(tour, vertices);

assertEquals(5, optimizedTour.size());
assertEquals(0, (int) optimizedTour.get(0));
assertEquals(1, (int) optimizedTour.get(1));
assertEquals(2, (int) optimizedTour.get(2));
assertEquals(3, (int) optimizedTour.get(3));
assertEquals(4, (int) optimizedTour.get(4));
}

@Test
public void testBuildAntTour() {

// Create a small test case with 4 vertices
double[][] pheromoneMatrix = new double[][] {
{0, 1, 1, 1},
{1, 0, 1, 1},
{1, 1, 0, 1},
{1, 1, 1, 0}
};
double[][] visibilityMatrix = new double[][] {
{0, 1, 1, 1},
{1, 0, 1, 1},
{1, 1, 0, 1},
{1, 1, 1, 0}
};
List<Integer> tour = AntColonyOptimization.buildAntTour(4, pheromoneMatrix, visibilityMatrix, 1, 5);

// Verify that the tour has the correct number of vertices and is a valid permutation
assertEquals(4, tour.size());
assertTrue(new HashSet<>(tour).size() == tour.size());
}

@Test
public void testTourLength() {
double[][] distanceMatrix = new double[][] {
{0, 1, 2},
{1, 0, 3},
{2, 3, 0}
};

List<Integer> tour = Arrays.asList(0, 1, 2);
double tourLength = AntColonyOptimization.tourLength(tour, distanceMatrix);

assertEquals(6.0, tourLength, 0.001);
}
}