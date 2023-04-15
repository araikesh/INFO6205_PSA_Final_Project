package edu.neu.coe.info6205.tactical;

import edu.neu.coe.info6205.model.Vertex;
import edu.neu.coe.info6205.util.ChristofidesTour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSwappingOptimization {

    public static List<Vertex> optimize(List<Vertex> vertices) {

        if(vertices.size() == 0)
            return vertices;

        List<Vertex> bestPath = vertices;
        double bestCost = ChristofidesTour.getTourCost(vertices);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int index1 = random.nextInt(vertices.size());
            int index2 = random.nextInt(vertices.size());
            if (index1 == index2) {
                continue;
            }

            List<Vertex> newPath = swapVertices(bestPath, index1, index2);
            double newCost = ChristofidesTour.getTourCost(newPath);

            if (newCost < bestCost) {
                bestPath = newPath;
                bestCost = newCost;
            }
        }

        return bestPath;
    }

    public static List<Vertex> swapVertices(List<Vertex> vertices, int index1, int index2) {
        List<Vertex> newPath = new ArrayList<>(vertices);
        Collections.swap(newPath, index1, index2);
        return newPath;
    }
}
