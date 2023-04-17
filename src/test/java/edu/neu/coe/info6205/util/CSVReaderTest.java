package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.model.Vertex;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVReaderTest {
  
  @Test
  public void testGetVertices() {
    List<Vertex> vertices = CSVReader.getVertices();
    assertNotNull(vertices);
    assertTrue(vertices.size() > 0);
    
    // Check the properties of the first vertex
    Vertex v = vertices.get(0);
    assertEquals(0, v.getNumericId());
    assertNotNull(v.getId());
    assertTrue(v.getLatitude() >= -90.0 && v.getLatitude() <= 90.0);
    assertTrue(v.getLongitude() >= -180.0 && v.getLongitude() <= 180.0);
  }

  @Test
  public void testVertexCreation() {
    Vertex vertex = new Vertex(0, "test", 42.3601, -71.0589);
    assertEquals(vertex.getNumericId(), 0);
    assertEquals(vertex.getId(), "test");
    assertEquals(vertex.getLatitude(), 42.3601,0.0001);
    assertEquals(vertex.getLongitude(), -71.0589,0.0001);
  }

}
