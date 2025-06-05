package Entites.Personnages.Joueurs;

import Entites.Personnages.Joueurs.Race;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

  @Test
  public void testElfeCreation() {
    Race elfe = Race.Elfe();
    assertEquals("Elfe", elfe.getM_nomRace());
    assertEquals(0, elfe.getM_BonusForce());
    assertEquals(6, elfe.getM_BonusDexterite());
    assertEquals(0, elfe.getM_BonusVitesse());
  }

  @Test
  public void testHalfelinCreation() {
    Race halfelin = Race.Halfelin();
    assertEquals("Halfelin", halfelin.getM_nomRace());
    assertEquals(0, halfelin.getM_BonusForce());
    assertEquals(4, halfelin.getM_BonusDexterite());
    assertEquals(2, halfelin.getM_BonusVitesse());
  }

  @Test
  public void testHumainCreation() {
    Race humain = Race.Humain();
    assertEquals("Humain", humain.getM_nomRace());
    assertEquals(2, humain.getM_BonusForce());
    assertEquals(2, humain.getM_BonusDexterite());
    assertEquals(2, humain.getM_BonusVitesse());
  }

  @Test
  public void testNainCreation() {
    Race nain = Race.Nain();
    assertEquals("Nain", nain.getM_nomRace());
    assertEquals(6, nain.getM_BonusForce());
    assertEquals(0, nain.getM_BonusDexterite());
    assertEquals(0, nain.getM_BonusVitesse());
  }
}