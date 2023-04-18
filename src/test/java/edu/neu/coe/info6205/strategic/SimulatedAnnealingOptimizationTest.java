package edu.neu.coe.info6205.strategic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.ChristofidesTour;
import org.junit.Before;
import org.junit.Test;

public class SimulatedAnnealingOptimizationTest {

private List<Vertex> vertices;
private double initialTemperature;
private double coolingRate;

@Before
public void setUp() {
// Create a list of vertices for testing
Vertex v1 = new Vertex(0, "A", 51.5074, -0.1278);
Vertex v2 = new Vertex(1, "B", 37.7749, -0.4194);
Vertex v3 = new Vertex(2, "C", 48.8566, 2.3522);
Vertex v4 = new Vertex(3, "D", 51.483548, -0.009691);
vertices = Arrays.asList(v1, v2, v3, v4);

// Set up initial temperature and cooling rate
initialTemperature = 100.0;
coolingRate = 0.95;
}

@Test
public void testOptimizeReturnsSameListIfOnlyOneVertex() {
Vertex v = new Vertex(4, "E", 51.513075, -0.118888);
List<Vertex> oneVertex = Arrays.asList(v);

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(oneVertex, initialTemperature, coolingRate);
List<Vertex> optimized = sao.optimize();

assertEquals(oneVertex, optimized);
}

@Test
public void testOptimizeReturnsSameListIfAlreadyOptimal() {
// Arrange vertices in optimal order: v1-v2-v3-v4
List<Vertex> optimalOrder = new ArrayList<>(vertices);

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(optimalOrder, initialTemperature, coolingRate);
List<Vertex> optimized = sao.optimize();

assertEquals(optimalOrder, optimized);
}

@Test
public void testOptimizeReturnsDifferentOrderIfNotOptimal() {
// Arrange vertices in non-optimal order: v1-v3-v4-v2
List<Vertex> nonOptimalOrder = Arrays.asList(vertices.get(0), vertices.get(2), vertices.get(3), vertices.get(1));

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(nonOptimalOrder, initialTemperature, coolingRate);
List<Vertex> optimized = sao.optimize();

System.out.println(nonOptimalOrder);
System.out.println(optimized);

// Check that the optimized list is different from the original list
assertTrue(!nonOptimalOrder.equals(optimized));
}

@Test
public void testCalculateEnergyReturnsCorrectValue() {
// Arrange vertices in optimal order: v1-v4-v3-v2
List<Vertex> optimalOrder = Arrays.asList(vertices.get(0), vertices.get(3), vertices.get(2), vertices.get(1));
double expectedEnergy = ChristofidesTour.getTourCost(optimalOrder); // distance between each pair of vertices

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(optimalOrder, initialTemperature, coolingRate);
double energy = sao.calculateEnergy(optimalOrder);

System.out.println(energy);
assertEquals(expectedEnergy, energy, 0.0001);
}

@Test
public void testAcceptanceProbabilityReturnsOneIfNeighborEnergyIsLower() {
double currentEnergy = 10.0;
double neighborEnergy = 5.0;
double temperature = 100.0;

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(vertices, initialTemperature, coolingRate);
double acceptanceProbability = sao.acceptanceProbability(currentEnergy, neighborEnergy, temperature);

assertEquals(1, acceptanceProbability, 0.0001);
}

@Test
public void testAcceptanceProbabilityReturnsCorrectValueIfNeighborEnergyIsHigher() {
double currentEnergy = 5.0;
double neighborEnergy = 10.0;
double temperature = 100.0;
double expectedProbability = Math.exp((currentEnergy - neighborEnergy) / temperature);

SimulatedAnnealingOptimization sao = new SimulatedAnnealingOptimization(vertices, initialTemperature, coolingRate);
double acceptanceProbability = sao.acceptanceProbability(currentEnergy, neighborEnergy, temperature);

assertEquals(expectedProbability, acceptanceProbability, 0.0001);
}
}
