package edu.neu.coe.info6205.christofides;

import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class PrimsMSTTest {

@Test
public void testEmptyVertices() {
List<Vertex> vertices = Arrays.asList();
List<Edge> minimumSpanningTree = PrimsMST.findMinimumSpanningTree(vertices);
assertEquals(0, minimumSpanningTree.size());
}

@Test
public void testSingleVertex() {
Vertex v1 = new Vertex(1, "A", 0.0, 0.0);
List<Vertex> vertices = Arrays.asList(v1);
List<Edge> minimumSpanningTree = PrimsMST.findMinimumSpanningTree(vertices);
assertEquals(0, minimumSpanningTree.size());
}

@Test
public void testTwoVertices() {
Vertex v1 = new Vertex(1, "A", 0.0, 0.0);
Vertex v2 = new Vertex(2, "B", 0.0, 1.0);
List<Vertex> vertices = Arrays.asList(v1, v2);
List<Edge> minimumSpanningTree = PrimsMST.findMinimumSpanningTree(vertices);
assertEquals(1, minimumSpanningTree.size());
assertEquals(v1, minimumSpanningTree.get(0).getV1());
assertEquals(v2, minimumSpanningTree.get(0).getV2());
}

@Test
public void testThreeVertices() {
Vertex v1 = new Vertex(1, "A", 51.483548,-0.009691);
Vertex v2 = new Vertex(2, "B", 51.513075,-0.118888);
Vertex v3 = new Vertex(3, "C", 51.540042,0.076327);
List<Vertex> vertices = Arrays.asList(v1, v2, v3);
List<Edge> minimumSpanningTree = PrimsMST.findMinimumSpanningTree(vertices);
assertEquals(2, minimumSpanningTree.size());
}
}