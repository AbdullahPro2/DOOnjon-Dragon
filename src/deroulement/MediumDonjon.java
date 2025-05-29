package deroulement;

import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import Entites.Obstacle;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Monstres.RaceMonstre;
import utils.De;

public class MediumDonjon extends Donjon {
  public MediumDonjon() {
    super(20,20);
  }

  @Override
  protected int[] getStartingCoordinates(int i) {
    return switch (i) {
      case 0 -> new int[]{14, 3};
      case 1 -> new int[]{14, 16};
      case 2 -> new int[]{17,5};
      default -> new int[]{17, 13};
    };
  }
  public void createDonjon()
  {
    // Monsters - par default
    Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 2, 3);
    Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 2, 12);
    Monstre m3 = new Monstre(RaceMonstre.Demogorgon(), 3, 6, 5);
    Monstre m4 = new Monstre(RaceMonstre.Dragon(), 3, 7, 11);
    Monstre m5 = new Monstre(RaceMonstre.Dragon(), 3, 11, 7);

    // Obstacles - par default
    Obstacle o1 = new Obstacle(3, 4);
    Obstacle o2 = new Obstacle(3, 5);
    Obstacle o3 = new Obstacle(3, 9);
    Obstacle o4 = new Obstacle(3, 10);
    Obstacle o5 = new Obstacle(3, 14);
    Obstacle o6 = new Obstacle(3, 16);
    Obstacle o7 = new Obstacle(4, 4);
    Obstacle o8 = new Obstacle(4, 5);
    Obstacle o9 = new Obstacle(4, 6);
    Obstacle o10 = new Obstacle(4, 7);
    Obstacle o11 = new Obstacle(4, 8);
    Obstacle o12 = new Obstacle(4, 9);
    Obstacle o13 = new Obstacle(4, 10);
    Obstacle o14 = new Obstacle(4, 14);
    Obstacle o15 = new Obstacle(4, 15);
    Obstacle o16 = new Obstacle(4, 16);
    Obstacle o17 = new Obstacle(7, 2);
    Obstacle o18 = new Obstacle(7, 3);
    Obstacle o19 = new Obstacle(7, 7);
    Obstacle o20 = new Obstacle(8, 13);
    Obstacle o21 = new Obstacle(8, 7);
    Obstacle o22 = new Obstacle(8, 9);
    Obstacle o23 = new Obstacle(8, 10);
    Obstacle o24 = new Obstacle(8, 11);
    Obstacle o25 = new Obstacle(4, 6);
    Obstacle o26 = new Obstacle(9, 7);
    Obstacle o27 = new Obstacle(11, 10);
    Obstacle o28 = new Obstacle(11, 11);
    Obstacle o29 = new Obstacle(11, 12);
    Obstacle o30 = new Obstacle(11, 13);
    Obstacle o31 = new Obstacle(11, 14);
    Obstacle o32 = new Obstacle(13, 4);
    Obstacle o33 = new Obstacle(13, 5);
    Obstacle o34 = new Obstacle(13, 16);
    Obstacle o35 = new Obstacle(13, 17);
    Obstacle o36 = new Obstacle(14, 4);
    Obstacle o37 = new Obstacle(14, 5);
    Obstacle o38 = new Obstacle(14, 16);
    Obstacle o39 = new Obstacle(14, 17);
    Obstacle o40 = new Obstacle(15, 4);
    Obstacle o41 = new Obstacle(15, 5);
    Obstacle o42 = new Obstacle(15, 10);
    Obstacle o43 = new Obstacle(15, 11);
    Obstacle o44 = new Obstacle(15, 12);
    Obstacle o45 = new Obstacle(15, 13);
    Obstacle o46 = new Obstacle(17, 7);
    Obstacle o47 = new Obstacle(18, 7);
    Obstacle o48 = new Obstacle(18, 8);
    Obstacle o49 = new Obstacle(18, 9);
    Obstacle o50 = new Obstacle(18, 10);

    // Armes sur la carte - par default
    Arme rapiere = new Arme(TypeArme.GUERRE, "rapière", new De(1, 8), 1, 3, 15);
    Arme arbaleteLegere = new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16, 2, 2);
    Arme fronde = new Arme(TypeArme.DISTANCE, "fronde", new De(1, 4), 6, 19, 19);

    // Armure sur la carte - par default
    Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 17, 1);
    Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles", 11, 17, 8);

    // Ajout sur la carte
    addEntityOnGround(m1);
    addEntityOnGround(m2);
    addEntityOnGround(m3);
    addEntityOnGround(m4);
    addEntityOnGround(m5);
    addEntityOnGround(o1);
    addEntityOnGround(o2);
    addEntityOnGround(o3);
    addEntityOnGround(o4);
    addEntityOnGround(o5);
    addEntityOnGround(o6);
    addEntityOnGround(o7);
    addEntityOnGround(o8);
    addEntityOnGround(o9);
    addEntityOnGround(o10);
    addEntityOnGround(o11);
    addEntityOnGround(o12);
    addEntityOnGround(o13);
    addEntityOnGround(o14);
    addEntityOnGround(o15);
    addEntityOnGround(o16);
    addEntityOnGround(o17);
    addEntityOnGround(o18);
    addEntityOnGround(o19);
    addEntityOnGround(o20);
    addEntityOnGround(o21);
    addEntityOnGround(o22);
    addEntityOnGround(o23);
    addEntityOnGround(o24);
    addEntityOnGround(o25);
    addEntityOnGround(o26);
    addEntityOnGround(o27);
    addEntityOnGround(o28);
    addEntityOnGround(o29);
    addEntityOnGround(o30);
    addEntityOnGround(o31);
    addEntityOnGround(o32);
    addEntityOnGround(o33);
    addEntityOnGround(o34);
    addEntityOnGround(o35);
    addEntityOnGround(o36);
    addEntityOnGround(o37);
    addEntityOnGround(o38);
    addEntityOnGround(o39);
    addEntityOnGround(o40);
    addEntityOnGround(o41);
    addEntityOnGround(o42);
    addEntityOnGround(o43);
    addEntityOnGround(o44);
    addEntityOnGround(o45);
    addEntityOnGround(o46);
    addEntityOnGround(o47);
    addEntityOnGround(o48);
    addEntityOnGround(o49);
    addEntityOnGround(o50);
    addEntityOnGround(rapiere);
    addEntityOnGround(arbaleteLegere);
    addEntityOnGround(fronde);
    addEntityOnGround(armureEcailles);
    addEntityOnGround(cotteMailles);
  }
  @Override
  public void display() {
    System.out.println("=== Medium Donjon ===");
    super.display();
  }
}
