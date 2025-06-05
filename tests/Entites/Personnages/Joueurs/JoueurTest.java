package Entites.Personnages.Joueurs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JoueurTest {

  @Test
  public void testPlayerCreation() {
    Joueur player = new Joueur("TestPlayer", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);

    assertEquals("TestPlayer", player.getM_nom());
    assertEquals(100000, player.getM_pv()); // FAUT CHANGER THOMAS
    assertEquals("Humain", player.getM_race().getM_nomRace());
    assertEquals("Guerriers", player.getM_classe().getM_nomClass());
  }

  @Test
  public void testGetDisplaySymbol() {
    Joueur shortName = new Joueur("Bob", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);
    assertEquals("BOB", shortName.getDisplaySymbol());
    Joueur longName = new Joueur("Alexander", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);
    assertEquals("ALE", longName.getDisplaySymbol());
  }

  @Test
  public void testEquipWeapon() {
    Joueur player = new Joueur("TestPlayer", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);
    assertNull(player.getM_armure());
    assertEquals(2, player.getM_classe().getM_armes().size());
  }

  @Test
  public void testEquipArmor() {
    Joueur player = new Joueur("TestPlayer", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);
    assertNull(player.getM_armure());
    assertEquals(1, player.getM_classe().getM_armures().size());
  }
  @Test
  public void testInitialStatsWithDiceRolls() {
    Joueur player = new Joueur("TestPlayer", Race.Humain(), ClasseJoueur.Guerriers(), 0, 0);
    assertTrue(player.getM_force() >= 1002 + 4 && player.getM_force() <= 1000 + 16 + 2);
    assertTrue(player.getM_dexterite() >= 3 + 4 + 2 && player.getM_dexterite() <= 3 + 16 + 2);
    assertTrue(player.getM_vitesse() >= 1000 + 4 + 2 && player.getM_vitesse() <= 1000 + 16 + 2);
    assertTrue(player.getM_initiative() >= 3 + 4 && player.getM_initiative() <= 3 + 16);
  }

  @Test
  public void testNainStatsWithDiceRolls() {
    Joueur player = new Joueur("NainPlayer", Race.Nain(), ClasseJoueur.Guerriers(), 0, 0);
    assertTrue(player.getM_force() >= 1000 + 4 + 6 && player.getM_force() <= 1000 + 16 + 6);
    assertTrue(player.getM_dexterite() >= 3 + 4 && player.getM_dexterite() <= 3 + 16);
  }
  @Test
  public void testGuerreWeaponEffect() {
    Joueur player = new Joueur("Warrior", Race.Nain(), ClasseJoueur.Guerriers(), 0, 0);
    int initialForce = player.getM_force();
    int initialVitesse = player.getM_vitesse();
    player.setM_force(initialForce + 4);
    player.setM_vitesse(initialVitesse - 2);
    assertEquals(initialForce + 4, player.getM_force());
    assertEquals(initialVitesse - 2, player.getM_vitesse());
  }

  @Test
  public void testHeavyArmorEffect() {
    Joueur player = new Joueur("Warrior", Race.Nain(), ClasseJoueur.Guerriers(), 0, 0);
    int initialVitesse = player.getM_vitesse();
    player.setM_vitesse(initialVitesse - 4);
    assertEquals(initialVitesse - 4, player.getM_vitesse());
  }

  @Test
  public void testEquipmentCombination() {
    Joueur player = new Joueur("Warrior", Race.Nain(), ClasseJoueur.Guerriers(), 0, 0);
    int initialForce = player.getM_force();
    int initialVitesse = player.getM_vitesse();
    player.setM_force(initialForce + 4);
    player.setM_vitesse(initialVitesse - 2 - 4);
    assertEquals(initialForce + 4, player.getM_force());
    assertEquals(initialVitesse - 6, player.getM_vitesse());
  }
}

