package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.ChristofidesTour;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ChristofidesAlgorithmTest {

private static final double EPSILON = 1e-6;

@Test
public void testEmptyInput() {
List<Vertex> vertices = Collections.emptyList();
List<Vertex> result = ChristofidesAlgorithm.christofides(vertices);
assertTrue(result.isEmpty());
}

@Test
public void testTwoVertices() {
List<Vertex> vertices = Arrays.asList(new Vertex(0,"B", 51.5074, -0.1278),
new Vertex(1,"C", 48.8566, 2.3522));
List<Vertex> result = ChristofidesAlgorithm.christofides(vertices);
assertEquals(2, result.size());
assertEquals(vertices.get(0), result.get(0));
assertEquals(vertices.get(1), result.get(1));
}

@Test
public void testThreeVertices() {
List<Vertex> vertices = Arrays.asList(new Vertex(0,"A", 37.7749, -122.4194),
new Vertex(1,"B", 51.5074, -0.1278),
new Vertex(2,"C", 48.8566, 2.3522));
List<Vertex> result = ChristofidesAlgorithm.christofides(vertices);
assertEquals(3, result.size());
assertEquals(vertices.get(0), result.get(0));
assertEquals(vertices.get(1), result.get(1));
assertEquals(vertices.get(2), result.get(2));
}

@Test
public void testRandomGraph() {
// Test on a randomly generated graph with 10 vertices
List<Vertex> vertices = new ArrayList<>();
vertices.add(new Vertex(0,"A", 37.7749, -122.4194));
for (int i = 1; i < 10; i++) {
double x = Math.random();
double y = Math.random();
vertices.add(new Vertex(i,Integer.toString(65+i), x, y));
}
double weight=0.0;
List<Edge> edges = new ArrayList<>();
for (int i = 0; i < 10; i++) {
for (int j = i + 1; j < 10; j++) {
Edge e = new Edge(vertices.get(i), vertices.get(j));
edges.add(e);
weight += e.getWeight();
}
}
Collections.shuffle(edges);
List<Vertex> result = ChristofidesAlgorithm.christofides(vertices);
double cost = ChristofidesTour.getTourCost(result);
assertTrue(cost < weight + EPSILON);
}
}