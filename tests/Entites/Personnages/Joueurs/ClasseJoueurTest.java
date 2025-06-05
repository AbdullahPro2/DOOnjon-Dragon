package Entites.Personnages.Joueurs;

import Entites.Personnages.Joueurs.ClasseJoueur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClasseJoueurTest {

  @Test
  public void testClercsCreation() {
    ClasseJoueur clerc = ClasseJoueur.Clercs();
    assertEquals("Clercs", clerc.getM_nomClass());
    assertEquals(16, clerc.getM_pv());
    assertEquals(2, clerc.getM_armes().size());
    assertEquals(1, clerc.getM_armures().size());
  }

  @Test
  public void testGuerriersCreation() {
    ClasseJoueur guerrier = ClasseJoueur.Guerriers();
    assertEquals("Guerriers", guerrier.getM_nomClass());
    assertEquals(20, guerrier.getM_pv());
    assertEquals(2, guerrier.getM_armes().size());
    assertEquals(1, guerrier.getM_armures().size());
  }

  @Test
  public void testMagiciensCreation() {
    ClasseJoueur magicien = ClasseJoueur.Magiciens();
    assertEquals("Magiciens", magicien.getM_nomClass());
    assertEquals(12, magicien.getM_pv());
    assertEquals(2, magicien.getM_armes().size());
    assertEquals(0, magicien.getM_armures().size());
  }

  @Test
  public void testRoublardsCreation() {
    ClasseJoueur roublard = ClasseJoueur.Roublards();
    assertEquals("Roublards", roublard.getM_nomClass());
    assertEquals(16, roublard.getM_pv());
    assertEquals(2, roublard.getM_armes().size());
    assertEquals(0, roublard.getM_armures().size());
  }
}