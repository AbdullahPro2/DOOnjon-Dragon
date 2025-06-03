package deroulement;

import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import Entites.Obstacle;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Monstres.RaceMonstre;
import java.util.ArrayList;
import utils.De;

public class EasyDonjon extends Donjon {
  public EasyDonjon(ArrayList<Joueur> joueurs) {
    super(25,25, joueurs);
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

    // Ajout sur la carte
    addMonstreOnGround(m1);
    addMonstreOnGround(m2);
    addMonstreOnGround(m3);
    addMonstreOnGround(m4);
    addObstacleOnGround(o1);
    addObstacleOnGround(o2);
    addObstacleOnGround(o3);
    addObstacleOnGround(o4);
    addObstacleOnGround(o5);
    addObstacleOnGround(o6);
    addObstacleOnGround(o7);
    addObstacleOnGround(o8);
    addObstacleOnGround(o9);
    addObstacleOnGround(o10);
    addObstacleOnGround(o11);
    addObstacleOnGround(o12);
    addObstacleOnGround(o13);
    addObstacleOnGround(o14);
    addObstacleOnGround(o15);
    addObstacleOnGround(o16);
    addObstacleOnGround(o17);
    addObstacleOnGround(o18);
    addObstacleOnGround(o19);
    addObstacleOnGround(o20);
    addObstacleOnGround(o21);
    addObstacleOnGround(o22);
    addObstacleOnGround(o23);
    addObstacleOnGround(o24);
    addObstacleOnGround(o25);
    addObstacleOnGround(o26);
    addObstacleOnGround(o27);
    addObstacleOnGround(o28);
    addObstacleOnGround(o29);
    addObstacleOnGround(o30);
    addObstacleOnGround(o31);
    addObstacleOnGround(o32);
    addObstacleOnGround(o33);
    addObstacleOnGround(o34);
    addObstacleOnGround(o35);
    addObstacleOnGround(o36);
    addObstacleOnGround(o37);
    addObstacleOnGround(o38);
    addObstacleOnGround(o39);
    addObstacleOnGround(o40);
    addObstacleOnGround(o41);
    addObstacleOnGround(o42);
    addObstacleOnGround(o43);
    addObstacleOnGround(o44);
    addObstacleOnGround(o45);
    addObstacleOnGround(o46);
    addObstacleOnGround(o47);
    addObstacleOnGround(o48);
    addObstacleOnGround(o49);
    addObstacleOnGround(o50);
    addObstacleOnGround(o51);
    addObstacleOnGround(o52);
    addObstacleOnGround(o53);
    addObstacleOnGround(o54);
    addObstacleOnGround(o55);
    addObstacleOnGround(o56);
    addObstacleOnGround(o57);
    addObstacleOnGround(o58);
    addObstacleOnGround(o59);
    addObstacleOnGround(o60);
    addObstacleOnGround(o61);
    addObstacleOnGround(o62);
    addObstacleOnGround(o63);
    addObstacleOnGround(o64);
    addObstacleOnGround(o65);
    addObstacleOnGround(o66);
    addObstacleOnGround(o67);
    addObstacleOnGround(o68);
    addObstacleOnGround(o69);
    addObstacleOnGround(o70);
    addObstacleOnGround(o71);
    addObstacleOnGround(o72);
    addObstacleOnGround(o73);
    addEquipementOnGround(masseArmes);
    addEquipementOnGround(epeeLongue);
    addEquipementOnGround(rapiere);
    addEquipementOnGround(arbaleteLegere);
    addEquipementOnGround(armureEcailles);
    addEquipementOnGround(demiPlate);
    addEquipementOnGround(cotteMailles);
    addEquipementOnGround(armureEcailles1);
    addEquipementOnGround(cotteMailles1);
    addEquipementOnGround(demiPlate1);
  }

  @Override
  public void display() {
    System.out.println("=== Easy Donjon ===");
    super.display();
  }
}
