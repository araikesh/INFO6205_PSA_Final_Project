package edu.neu.coe.info6205;


import edu.neu.coe.info6205.christofides.ChristofidesAlgorithm;
import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.CSVReader;
import edu.neu.coe.info6205.util.ChristofidesTour;

import java.util.List;


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
    }
}
