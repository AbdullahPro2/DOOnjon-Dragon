package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeTest {
  @Test
  public void testConstructor() {
    De de = new De(2, 6);
    assertEquals(2, de.getM_nombreDes());
    assertEquals(6, de.getM_facesParDe());
  }

  @Test
  public void testToString() {
    De de = new De(3, 20);
    assertEquals("3d20", de.toString());
  }
  @Test
  public void testSingleDiceRange() {
    De d6 = new De(1, 6);
    int result = d6.lanceDe();
    assertTrue(result >= 1 && result <= 6,
        "Result should be between 1 and 6, but was " + result);
  }
  @Test
  public void testMultipleDiceRange() {
    De dice = new De(3, 6);
    int result = dice.lanceDe();
    assertTrue(result >= 3 && result <= 18,
        "Result should be between 3 and 18, but was " + result);
  }

  @Test
  public void testLargeDiceRange() {
    De dice = new De(2, 100);
    int result = dice.lanceDe();
    assertTrue(result >= 2 && result <= 200,
        "Result should be between 2 and 200, but was " + result);
  }
}