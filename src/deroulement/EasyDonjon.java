package deroulement;

import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import Entites.Obstacle;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Monstres.RaceMonstre;
import utils.De;

public class EasyDonjon extends Donjon {
  public EasyDonjon() {
    super(25,25);
  }

  @Override
  public int[] getStartingCoordinates(int i) {
    return switch (i) {
      case 0 -> new int[]{19, 8};
      case 1 -> new int[]{19, 16};
      case 2 -> new int[]{15,21};
      default -> new int[]{15, 3};
    };
  }
  public void createDonjon() {
    // Monsters - par default
    Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 3, 6);
    Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 3, 17);
    Monstre m3 = new Monstre(RaceMonstre.Dragon(), 2,7, 10);
    Monstre m4 = new Monstre(RaceMonstre.Demogorgon(), 2, 7, 14);

    // Obstacles - par default
    Obstacle o1 = new Obstacle(0, 5);
    Obstacle o2 = new Obstacle(0, 19);
    Obstacle o3 = new Obstacle(1, 5);
    Obstacle o4 = new Obstacle(1, 19);
    Obstacle o5 = new Obstacle(2, 5);
    Obstacle o6 = new Obstacle(2, 19);
    Obstacle o7 = new Obstacle(3, 5);
    Obstacle o8 = new Obstacle(3, 19);
    Obstacle o9 = new Obstacle(4, 5);
    Obstacle o10 = new Obstacle(4, 6);
    Obstacle o11 = new Obstacle(4, 7);
    Obstacle o12 = new Obstacle(4, 8);
    Obstacle o13 = new Obstacle(4, 9);
    Obstacle o14 = new Obstacle(4, 10);
    Obstacle o15 = new Obstacle(4, 11);
    Obstacle o16 = new Obstacle(4, 13);
    Obstacle o17 = new Obstacle(4, 14);
    Obstacle o18 = new Obstacle(4, 15);
    Obstacle o19 = new Obstacle(4, 16);
    Obstacle o20 = new Obstacle(4, 17);
    Obstacle o21 = new Obstacle(4, 18);
    Obstacle o22 = new Obstacle(4, 19);
    Obstacle o23 = new Obstacle(8, 0);
    Obstacle o24 = new Obstacle(8, 1);
    Obstacle o25 = new Obstacle(8, 2);
    Obstacle o26 = new Obstacle(8, 3);
    Obstacle o27 = new Obstacle(8, 4);
    Obstacle o28 = new Obstacle(8, 5);
    Obstacle o29 = new Obstacle(8, 6);
    Obstacle o30 = new Obstacle(8, 18);
    Obstacle o31 = new Obstacle(8, 19);
    Obstacle o32 = new Obstacle(8, 20);
    Obstacle o33 = new Obstacle(8, 21);
    Obstacle o34 = new Obstacle(8, 22);
    Obstacle o35 = new Obstacle(8, 23);
    Obstacle o36 = new Obstacle(8, 24);
    Obstacle o37 = new Obstacle(9, 6);
    Obstacle o38 = new Obstacle(9, 18);
    Obstacle o39 = new Obstacle(10, 10);
    Obstacle o40 = new Obstacle(10, 11);
    Obstacle o41 = new Obstacle(10, 12);
    Obstacle o42 = new Obstacle(10, 13);
    Obstacle o43 = new Obstacle(10, 14);
    Obstacle o44 = new Obstacle(11, 10);
    Obstacle o45 = new Obstacle(11, 14);
    Obstacle o46 = new Obstacle(12, 10);
    Obstacle o47 = new Obstacle(12, 14);
    Obstacle o48 = new Obstacle(13, 10);
    Obstacle o49 = new Obstacle(13, 14);
    Obstacle o50 = new Obstacle(17, 0);
    Obstacle o51 = new Obstacle(17, 1);
    Obstacle o52 = new Obstacle(17, 2);
    Obstacle o53 = new Obstacle(17, 3);
    Obstacle o54 = new Obstacle(17, 4);
    Obstacle o55 = new Obstacle(17, 5);
    Obstacle o56 = new Obstacle(19, 7);
    Obstacle o57 = new Obstacle(20, 7);
    Obstacle o58 = new Obstacle(21, 7);
    Obstacle o59 = new Obstacle(22, 7);
    Obstacle o60 = new Obstacle(23, 7);
    Obstacle o61 = new Obstacle(24, 7);
    Obstacle o62 = new Obstacle(17, 19);
    Obstacle o63 = new Obstacle(17, 20);
    Obstacle o64 = new Obstacle(17, 21);
    Obstacle o65 = new Obstacle(17, 22);
    Obstacle o66 = new Obstacle(17, 23);
    Obstacle o67 = new Obstacle(17, 24);
    Obstacle o68 = new Obstacle(19, 17);
    Obstacle o69 = new Obstacle(20, 17);
    Obstacle o70 = new Obstacle(21, 17);
    Obstacle o71 = new Obstacle(22, 17);
    Obstacle o72 = new Obstacle(23, 17);
    Obstacle o73 = new Obstacle(24, 17);


    // Armes sur la carte - par default
    Arme masseArmes = new Arme(TypeArme.COURANTE, "masse d'armes", new De(1, 6), 1, 11, 11);
    Arme epeeLongue = new Arme(TypeArme.GUERRE, "épée longue", new De(1, 8), 1, 11, 12);
    Arme rapiere = new Arme(TypeArme.GUERRE, "rapière", new De(1, 8), 1, 11, 13);
    Arme arbaleteLegere = new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16, 9, 5);

    // Armure sur la carte - par default
    Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 8, 12);
    Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate", 9, 9, 19);
    Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles", 11, 22, 1);
    Armure armureEcailles1 = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 22, 2);
    Armure demiPlate1 = new Armure(TypeArmure.LEGERE, "demi-plate", 9, 22, 20);
    Armure cotteMailles1 = new Armure(TypeArmure.LOURDE, "cotte de mailles", 11, 22, 21);


    // Jouer cree les joueurs

    // Ajout sur la carte
    addEntityOnGround(m1);
    addEntityOnGround(m2);
    addEntityOnGround(m3);
    addEntityOnGround(m4);
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
    addEntityOnGround(o51);
    addEntityOnGround(o52);
    addEntityOnGround(o53);
    addEntityOnGround(o54);
    addEntityOnGround(o55);
    addEntityOnGround(o56);
    addEntityOnGround(o57);
    addEntityOnGround(o58);
    addEntityOnGround(o59);
    addEntityOnGround(o60);
    addEntityOnGround(o61);
    addEntityOnGround(o62);
    addEntityOnGround(o63);
    addEntityOnGround(o64);
    addEntityOnGround(o65);
    addEntityOnGround(o66);
    addEntityOnGround(o67);
    addEntityOnGround(o68);
    addEntityOnGround(o69);
    addEntityOnGround(o70);
    addEntityOnGround(o71);
    addEntityOnGround(o72);
    addEntityOnGround(o73);
    addEntityOnGround(masseArmes);
    addEntityOnGround(epeeLongue);
    addEntityOnGround(rapiere);
    addEntityOnGround(arbaleteLegere);
    addEntityOnGround(armureEcailles);
    addEntityOnGround(demiPlate);
    addEntityOnGround(cotteMailles);
    addEntityOnGround(armureEcailles1);
    addEntityOnGround(cotteMailles1);
    addEntityOnGround(demiPlate1);
  }

  @Override
  public void display() {
    System.out.println("=== Easy Donjon ===");
    super.display();
  }
}
