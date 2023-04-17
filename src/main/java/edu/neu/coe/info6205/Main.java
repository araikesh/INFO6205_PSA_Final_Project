package edu.neu.coe.info6205;


import edu.neu.coe.info6205.christofides.ChristofidesAlgorithm;
import edu.neu.coe.info6205.model.Edge;
import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.strategic.AntColonyOptimization;
import edu.neu.coe.info6205.strategic.SimulatedAnnealingOptimization;
import edu.neu.coe.info6205.tactical.RandomSwappingOptimization;
import edu.neu.coe.info6205.tactical.TwoOptOptimization;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.CSVReader;
import edu.neu.coe.info6205.util.ChristofidesTour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        List<Vertex> vertices = CSVReader.getVertices();

        Benchmark benchmark = new Benchmark();
        benchmark.startMark();
        List<Vertex> tsp = ChristofidesAlgorithm.christofides(vertices);
        benchmark.endMark();

        System.out.print("\n Christofides Algorithm Time: " + benchmark.resultTime() + "ms");
        System.out.println("\n Hamiltonian Path: " + ChristofidesTour.getTour(tsp));
        System.out.println(" Christofides cost: " + ChristofidesTour.getTourCost(tsp) + " meters");

        // Random Swapping Optimization
        benchmark.startMark();
        List<Vertex> rsoTsp = RandomSwappingOptimization.optimize(tsp.stream().collect(Collectors.toList()));
        benchmark.endMark();
        System.out.print("\n RandomSwappingOptimization Time: " + benchmark.resultTime() + "ms");
        System.out.println("\n Random Swapping Optimization Path: " + ChristofidesTour.getTour(rsoTsp));
        System.out.println(" Random Swapping Cost: " + ChristofidesTour.getTourCost(rsoTsp) + " meters");

        //Two-Opt Optimization
        benchmark.startMark();
        List<Vertex> twoOptTsp = TwoOptOptimization.twoOpt(tsp.stream().collect(Collectors.toList()));
        benchmark.endMark();
        System.out.print("\n TwoOpt Time: " + benchmark.resultTime() + "ms");
        System.out.println("\n TwoOpt Path: " + ChristofidesTour.getTour(twoOptTsp));
        System.out.println(" TwoOpt Optimization Cost: " + ChristofidesTour.getTourCost(twoOptTsp) + " meters");

        //Simulated Annealing Optimization
        benchmark.startMark();
        SimulatedAnnealingOptimization sa = new SimulatedAnnealingOptimization(tsp.stream().collect(Collectors.toList()),
                1000, 0.99);
        List<Vertex> saTsp = sa.optimize();
        benchmark.endMark();
        System.out.print("\n Simulated Annealing Optimization Time: " + benchmark.resultTime() + "ms");
        System.out.println("\n Simulated Annealing Optimization Path: " + ChristofidesTour.getTour(saTsp));
        System.out.println(" Simulated Annealing Optimization Cost: " + ChristofidesTour.getTourCost(saTsp) + " meters");

        //Ant Colony Optimization
        List<Integer> tour = tsp.stream().map(vertex -> vertex.getNumericId()).collect(Collectors.toList());
        benchmark.startMark();
        List<Integer> aopIdTsp = AntColonyOptimization.optimizeWithAntColony(tour,tsp);
        benchmark.endMark();

        List<Vertex> aopTsp = new ArrayList<>();
        double aopCost = 0;
        for (int i = 0; i < aopIdTsp.size() - 1; i++) {
            Vertex v1 = tsp.get(aopIdTsp.get(i));
            Vertex v2 = tsp.get(aopIdTsp.get(i+1));
            Edge edge = new Edge(v1, v2);
            aopCost += edge.getWeight();
            aopTsp.add(v1);
        }
        aopTsp.add(tsp.get(aopIdTsp.get(aopIdTsp.size() - 1)));

        System.out.print("\n AntColonyOptimization Time: " + benchmark.resultTime() + "ms");
        System.out.println("\n Ant Colony Optimization Path: " + ChristofidesTour.getTour(aopTsp));
        System.out.println(" AntColonyOptimization Cost: " + aopCost + " meters");
    }
}
