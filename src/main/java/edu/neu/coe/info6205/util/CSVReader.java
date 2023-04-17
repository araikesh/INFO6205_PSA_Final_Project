package edu.neu.coe.info6205.util;

import com.opencsv.exceptions.CsvValidationException;
import edu.neu.coe.info6205.model.Vertex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Vertex> getVertices() {

        List<Vertex> vertices = new ArrayList<>();

        try (com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new InputStreamReader(
                        com.opencsv.CSVReader.class.getClassLoader().getResourceAsStream("info6205.spring2023.teamproject.csv")))) {
            String[] header = reader.readNext();
            System.out.println(String.join(", ", header));
            String[] data;

            int numericId = 0;

            while ((data = reader.readNext()) != null) {
                String crimeId = data[0];
                double longitude = Double.parseDouble(data[1]);
                double latitude = Double.parseDouble(data[2]);
                System.out.println(String.format("%d %s, %f, %f", numericId, crimeId, latitude, longitude));
                vertices.add(new Vertex(numericId++, crimeId, latitude, longitude));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return vertices;
    }
}
