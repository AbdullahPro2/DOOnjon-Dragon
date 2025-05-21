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

public class MediumDonjon extends Donjon {
  public MediumDonjon() {
    super(20,20);
  }

  public void startGame()
  {
    // Monsters - par default
    Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 9, 11);
    Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 10, 11);
    Monstre m3 = new Monstre(RaceMonstre.Demogorgon(), 3, 12, 9);
    Monstre m4 = new Monstre(RaceMonstre.Dragon(), 3, 11, 13);

    // Obstacles - par default
    Obstacle o1 = new Obstacle(9, 11);
    Obstacle o2 = new Obstacle(10, 12);
    Obstacle o3 = new Obstacle(11, 9);
    Obstacle o4 = new Obstacle(11, 10);
    Obstacle o5 = new Obstacle(11, 9);
    Obstacle o6 = new Obstacle(11, 10);

    // Armes sur la carte - par default
    Arme baton = new Arme(TypeArme.COURANTE, "baton", new De(1, 6), 1, 0, 0);
    Arme masseArmes = new Arme(TypeArme.COURANTE, "masse d'armes", new De(1, 6), 1, 0, 19);
    Arme epeeLongue = new Arme(TypeArme.GUERRE, "épée longue", new De(1, 8), 1, 19, 0);
    Arme rapiere = new Arme(TypeArme.GUERRE, "rapière", new De(1, 8), 1, 19, 19);
    Arme arbaleteLegere = new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16, 0, 10);
    Arme fronde = new Arme(TypeArme.DISTANCE, "fronde", new De(1, 4), 6, 19, 10);

    // Armure sur la carte - par default
    Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 1, 1);
    Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate", 9, 1, 18);
    Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles", 11, 18, 1);

    // Jouer cree les joueurs
    ajouteJouers();

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
    addEntityOnGround(baton);
    addEntityOnGround(masseArmes);
    addEntityOnGround(epeeLongue);
    addEntityOnGround(rapiere);
    addEntityOnGround(arbaleteLegere);
    addEntityOnGround(fronde);
    addEntityOnGround(armureEcailles);
    addEntityOnGround(demiPlate);
    addEntityOnGround(cotteMailles);

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
      Joueur j = new Joueur(nom, r, c, 0, 0); // Temporary x, y values
      addEntityOnGround(j); // Randomize real position
    }


  }
  @Override
  public void display() {
    System.out.println("=== Medium Donjon ===");
    super.display();
  }
}
