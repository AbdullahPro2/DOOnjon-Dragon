package Entites.Personnages.Monstres;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonstreTest {

  @Test
  public void testMonsterInitializationAndPlacement() {
    Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 2, 2);
    Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 2, 7);

    // Basic identity and display tests
    assertEquals("Dragon 1", m1.getM_nom());
    assertEquals("X(1", m1.getDisplaySymbol());
    assertEquals(2, m1.getM_x());
    assertEquals(2, m1.getM_y());

    assertEquals("Demogorgon 1", m2.getM_nom());
    assertEquals("X^1", m2.getDisplaySymbol());

  }

  @Test
  public void assertMonster1StatsValid() {
    Monstre monster = new Monstre(RaceMonstre.Dragon(), 1, 2, 2);
    RaceMonstre race = monster.getM_race();

    // PV should match the race PV exactly
    assertEquals(race.getM_pvRace(), monster.getM_pv(), "Le PV doit correspondre au PV de Race");

    // Other stats should be in correct ranges
    assertBetween(1004, 1016, monster.getM_force());        // 4d4 + 1000
    assertBetween(7, 19, monster.getM_dexterite());         // 4d4 + 3
    assertBetween(1004, 1016, monster.getM_vitesse());      // 4d4 + 1000
    assertBetween(7, 19, monster.getM_initiative());        // 4d4 + 3

    // Race-specific values
    assertTrue(race.getM_portee() > 0, "Portée doit etre > 0");
    assertNotNull(race.getM_deDegats(), "Dé de dégâts ne doit pas etre");
    assertTrue(race.getM_degats() >= 0, "Dégâts doit etre >= 0");
  }


  @Test
  public void assertMonster2StatsValid() {
    Monstre monster = new Monstre(RaceMonstre.Demogorgon(), 1, 2, 7);
    RaceMonstre race = monster.getM_race();

    // PV should match the race PV exactly
    assertEquals(race.getM_pvRace(), monster.getM_pv(), "Le PV doit correspondre au PV de Race");

    // Other stats should be in correct ranges
    assertBetween(1004, 1016, monster.getM_force());        // 4d4 + 1000
    assertBetween(7, 19, monster.getM_dexterite());         // 4d4 + 3
    assertBetween(1004, 1016, monster.getM_vitesse());      // 4d4 + 1000
    assertBetween(7, 19, monster.getM_initiative());        // 4d4 + 3

    // Race-specific values
    assertTrue(race.getM_portee() > 0, "Portée doit etre > 0");
    assertNotNull(race.getM_deDegats(), "Dé de dégâts ne doit pas etre");
    assertTrue(race.getM_degats() >= 0, "Dégâts doit etre >= 0");
  }



  private void assertBetween(int min, int max, int actual) {
    assertTrue(actual >= min, "Value " + actual + " devrait etre >= " + min);
    assertTrue(actual <= max, "Value " + actual + " devrait etre <= " + max);
  }
}
