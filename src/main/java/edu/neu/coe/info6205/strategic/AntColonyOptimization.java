package edu.neu.coe.info6205.strategic;

import edu.neu.coe.info6205.model.Vertex;

import java.util.*;

public class AntColonyOptimization {

    public static List<Integer> optimizeWithAntColony(List<Integer> tour, List<Vertex> vertices) {

        int n = tour.size();
        int numberOfAnts = 100;
        int maxIterations = 100;
        double alpha = 1;
        double beta = 5;
        double evaporationRate = 0.5;


        // Calculate distance matrix
        double[][] distanceMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = vertices.get(i).distance(vertices.get(j));
            }
        }

        double initialPheromone = 1.0 / (n * tourLength(tour, distanceMatrix));
        double[][] pheromoneMatrix = new double[n][n];
        double[][] visibilityMatrix = new double[n][n];

        // Initialize pheromone and visibility matrices

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pheromoneMatrix[i][j] = initialPheromone;
                visibilityMatrix[i][j] = (i == j) ? 0 : 1 / distanceMatrix[i][j];
            }
        }

        List<Integer> bestTour = new ArrayList<>(tour);
        double bestCost = tourLength(tour, distanceMatrix);

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            List<List<Integer>> solutions = new ArrayList<>();
            for (int ant = 0; ant < numberOfAnts; ant++) {
                List<Integer> currentTour = buildAntTour(distanceMatrix.length, pheromoneMatrix, visibilityMatrix,
                        alpha, beta);

                currentTour.add(currentTour.get(0)); // complete the cycle
                solutions.add(currentTour);

                double currentCost = tourLength(currentTour, distanceMatrix);

                if (currentCost < bestCost) {
                    bestTour = new ArrayList<>(currentTour);
                    bestCost = currentCost;
                }
            }

            // Evaporate pheromone
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pheromoneMatrix[i][j] *= evaporationRate;
                }
            }

            // Deposit pheromone
            for (List<Integer> solution : solutions) {
                double currentCost = tourLength(solution, distanceMatrix);
                for (int i = 0; i < n; i++) {

                    int cityA = solution.get(i);
                    int cityB = solution.get(i + 1);

                    pheromoneMatrix[cityA][cityB] += 1 / currentCost;
                    pheromoneMatrix[cityB][cityA] += 1 / currentCost;
                }
            }
        }
        return bestTour;
    }

    public static List<Integer> buildAntTour(int n, double[][] pheromoneMatrix, double[][] visibilityMatrix,
                                             double alpha, double beta) {

        List<Integer> tour = new ArrayList<>();
        Set<Integer> unvisitedCities = new HashSet<>();

        for (int i = 0; i < n; i++) {
            unvisitedCities.add(i);
        }

        int currentCity = new Random().nextInt(n);
        tour.add(currentCity);
        unvisitedCities.remove(currentCity);

        while (!unvisitedCities.isEmpty()) {
            double totalProbability = 0;

            for (int city : unvisitedCities) {
                totalProbability += Math.pow(pheromoneMatrix[currentCity][city], alpha) *
                        Math.pow(visibilityMatrix[currentCity][city], beta);

            }

            double randomValue = new Random().nextDouble() * totalProbability;
            double cumulativeProbability = 0;
            int nextCity = -1;

            for (int city : unvisitedCities) {
                cumulativeProbability += Math.pow(pheromoneMatrix[currentCity][city], alpha) *
                        Math.pow(visibilityMatrix[currentCity][city], beta);

                if (randomValue <= cumulativeProbability) {
                    nextCity = city;
                    break;
                }
            }
            tour.add(nextCity);
            unvisitedCities.remove(nextCity);
            currentCity = nextCity;
        }
        return tour;
    }

    public static double tourLength(List<Integer> tour, double[][] distanceMatrix) {

        double length = 0.0;

        for (int i = 0; i < tour.size() - 1; i++) {
            length += distanceMatrix[tour.get(i)][tour.get(i + 1)];
        }
        length += distanceMatrix[tour.get(tour.size() - 1)][tour.get(0)]; // Complete the cycle
        return length;
    }
}