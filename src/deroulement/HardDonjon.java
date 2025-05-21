package deroulement;

import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import Entites.Obstacle;
import Entites.Personnages.Joueurs.ClasseJoueur;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Joueurs.Race;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Monstres.RaceMonstre;
import utils.De;

public class HardDonjon extends Donjon {
  public HardDonjon() {
    super(15,15);
  }
  public void startGame()
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
    // Jouer cree les joueurs
    ajouteJouers();

    // Ajout sur la carte
    addEntityOnGround(m1);
    addEntityOnGround(m2);
    addEntityOnGround(m3);
    addEntityOnGround(m4);
    addEntityOnGround(m5);
    addEntityOnGround(m6);
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

    addEntityOnGround(baton);
    addEntityOnGround(masseArmes);

    addEntityOnGround(armureEcailles);
    addEntityOnGround(demiPlate);
    this.display();
  }
  public void ajouteJouers()
  {
    // Input numbre de joueurs
    int nbJouers = 4;
// Functionality pour future si on veut choisir le nombre de joueurs
//    while (nbJouers < 1 || nbJouers > 10) {
//      System.out.print("Entrez le nombre de joueurs (entre 1 et 10) : ");
//      try {
//        nbJouers = Integer.parseInt(scanner.nextLine());
//      } catch (NumberFormatException e) {
//        System.out.println("Veuillez entrer un nombre valide !");
//      }
//    }
    for(int i = 0; i < nbJouers; i++)
    {
      // NOM de joueur
      System.out.print("Enter le nom de jouer " + (i + 1) + " : ");
      String nom = scanner.nextLine();
      // RACE de joueur
      System.out.println("Choisir la race de " + nom + " (entrez l'index) :");
      int indexRace = 0;
      while(indexRace <= 0 || indexRace > 4)
      {
        System.out.println("1 : Elfe");
        System.out.println("2 : Halfelin");
        System.out.println("3 : Humain");
        System.out.println("4 : Elfe");
        try {
          System.out.print("Race : ");
          indexRace = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Veuillez entrer un nombre valide !");
        }
      }
      // CLASS de joueur
      System.out.println("Choisir la Class de " + nom + " (entrez l'index) : ");
      int indexClass = 0;
      while(indexClass <= 0 || indexClass > 4)
      {
        System.out.println("1 : Clercs");
        System.out.println("2 : Guerriers");
        System.out.println("3 : Magiciens");
        System.out.println("4 : Roublards");
        try {
          System.out.print("Class : ");
          indexClass = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
          System.out.println("Veuillez entrer un nombre valide !");
        }
      }
      Race r = indexRace == 1 ? Race.Elfe() :
          indexRace == 2 ? Race.Halfelin() :
              indexRace == 3 ? Race.Humain() : Race.Nain();
      ClasseJoueur c = indexClass == 1 ? ClasseJoueur.Clercs() :
          indexClass == 2 ? ClasseJoueur.Guerriers() :
              indexClass == 3 ? ClasseJoueur.Magiciens() : ClasseJoueur.Roublards();
      int x, y;
      if(i == 0) {
        x = 5;
        y = 6;
      }
      else if(i == 1)
      {
        x = 5;
        y = 8;
      }
      else if(i == 2)
      {
        x = 7;
        y = 6;
      }
      else
      {
        x = 7;
        y = 8;
      }
      Joueur j = new Joueur(nom, r, c, x, y); // Temporary x, y values
      addEntityOnGround(j); // Randomize real position
    }
  }
  @Override
  public void display() {
    System.out.println("=== Hard Donjon ===");
    super.display();
  }
}
