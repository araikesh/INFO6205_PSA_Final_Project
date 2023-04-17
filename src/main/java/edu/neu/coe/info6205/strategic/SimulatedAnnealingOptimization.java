package edu.neu.coe.info6205.strategic;

import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.tactical.TwoOptOptimization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealingOptimization {
    private final List<Vertex> vertices;
    private final Random random;
    private final double initialTemperature;
    private final double coolingRate;

    public SimulatedAnnealingOptimization(List<Vertex> vertices, double initialTemperature, double coolingRate) {
        this.vertices = vertices;
        this.random = new Random();
        this.initialTemperature = initialTemperature;
        this.coolingRate = coolingRate;
    }

    public List<Vertex> optimize() {
        List<Vertex> currentSolution = new ArrayList<>(vertices);
        double currentEnergy = calculateEnergy(currentSolution);
        double temperature = initialTemperature;

        while (temperature > 1) {
            List<Vertex> neighborSolution;
            //Collections.swap(neighborSolution, random.nextInt(vertices.size()), random.nextInt(vertices.size()));
            neighborSolution = TwoOptOptimization.twoOpt(currentSolution);
            double neighborEnergy = calculateEnergy(neighborSolution);

            if (acceptanceProbability(currentEnergy, neighborEnergy, temperature) > random.nextDouble()) {
                currentSolution = neighborSolution;
                currentEnergy = neighborEnergy;
            }

            temperature *= coolingRate;
        }
        return currentSolution;
    }

    public double calculateEnergy(List<Vertex> solution) {
        double energy = 0;
        for (int i = 0; i < solution.size() - 1; i++) {
            energy += solution.get(i).distance(solution.get(i + 1));
        }
        return energy;
    }

    public double acceptanceProbability(double currentEnergy, double neighborEnergy, double temperature) {
        if (neighborEnergy < currentEnergy) {
            return 1.0;
        }
        return Math.exp((currentEnergy - neighborEnergy) / temperature);
    }
}
