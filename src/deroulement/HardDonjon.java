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

public class HardDonjon extends Donjon {
  public HardDonjon(ArrayList<Joueur> joueurs) {
    super(15,15, joueurs);
  }

  @Override
  protected int[] getStartingCoordinates(int i) {
    return switch (i) {
      case 0 -> new int[]{5, 6};
      case 1 -> new int[]{5, 8};
      case 2 -> new int[]{7,6};
      default -> new int[]{7, 8};
    };
  }
  public void createDonjon()
  {
    // Monsters - par default
    Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 2, 2);
    Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 2, 7);
    Monstre m3 = new Monstre(RaceMonstre.Demogorgon(), 3, 2, 12);
    Monstre m4 = new Monstre(RaceMonstre.Dragon(), 3, 10, 2);
    Monstre m5 = new Monstre(RaceMonstre.Demogorgon(), 3, 10, 7);
    Monstre m6 = new Monstre(RaceMonstre.Dragon(), 3, 10, 12);

    // Obstacles - par default
    Obstacle o1 = new Obstacle(4,4 );
    Obstacle o2 = new Obstacle(4, 6);
    Obstacle o3 = new Obstacle(4, 8);
    Obstacle o4 = new Obstacle(4, 10);
    Obstacle o5 = new Obstacle(6, 4);
    Obstacle o6 = new Obstacle(6, 10);
    Obstacle o7 = new Obstacle(8, 4);
    Obstacle o8 = new Obstacle(8, 6);
    Obstacle o9 = new Obstacle(8, 8);
    Obstacle o10 = new Obstacle(8, 10);

    // Armes sur la carte - par default
    Arme masseArmes = new Arme(TypeArme.COURANTE, "masse d'armes", new De(1, 6), 1, 0, 3);
    Arme baton = new Arme(TypeArme.COURANTE, "baton", new De(1, 6), 1, 6, 7);

    // Armure sur la carte - par default
    Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 12, 11);
    Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate", 9, 13,1);

    // Ajout sur la carte
    addMonstreOnGround(m1);
    addMonstreOnGround(m2);
    addMonstreOnGround(m3);
    addMonstreOnGround(m4);
    addMonstreOnGround(m5);
    addMonstreOnGround(m6);
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
    addEquipementOnGround(baton);
    addEquipementOnGround(masseArmes);
    addEquipementOnGround(armureEcailles);
    addEquipementOnGround(demiPlate);
  }
@Override
  public void display() {
    System.out.println("=== Hard Donjon ===");
    super.display();
  }
}
