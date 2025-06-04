package Entites.Personnages;

import static Entites.Entite.caseOccupee;

import Entites.Entite;
import Entites.Obstacle;
import deroulement.Donjon;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import utils.De;

public class MaitreJeu {
  private Scanner scanner = new Scanner(System.in);

  public Personnage choisirPersonnage(ArrayList<Personnage> initiativeOrder) {
    System.out.println("Qui voulez-vous choisir ?");
    affichagePersonnage(initiativeOrder); // Affiche la liste
    System.out.print("Entrez votre choix : ");

    while (true) {
      String choix = scanner.nextLine().trim();

      try {
        int index = Integer.parseInt(choix);

        if (index >= 1 && index <= initiativeOrder.size()) {
          return initiativeOrder.get(index - 1);
        } else {
          System.out.println("Choix incorrect, veuillez choisir un élément de la liste affichée.");
          System.out.print("Entrez votre choix : ");
        }
      } catch (NumberFormatException e) {
        System.out.println("Entrée invalide, veuillez entrer un nombre.");
        System.out.print("Entrez votre choix : ");
      }
    }
  }


  public void DeplacerJoueurMonstre(ArrayList<Personnage> initiativeOrder, Donjon donjon) {
    System.out.println("Hahaha j'interviens pour donner des avantages injustifiés");
    Personnage choisi = choisirPersonnage(initiativeOrder);
    seDeplacerParMaitreDeJeu(donjon, choisi);
    donjon.display();
  }

  public void infligerDegatsParMaitreDeJeu(ArrayList<Personnage> initiativeOrder, Donjon donjon) {
    System.out.println("Hahaha j'interviens pour vous infliger des dégâts !");
    Personnage cible = choisirPersonnage(initiativeOrder);

    int nbDes = 0;
    int nbFaces = 0;

    while (nbDes <= 0) {
      System.out.print("Combien de dés voulez-vous lancer ? ");
      try {
        nbDes = Integer.parseInt(scanner.nextLine());
        if (nbDes <= 0) {
          System.out.println("Le nombre de dés doit être supérieur à zéro.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
      }
    }

    while (nbFaces <= 0) {
      System.out.print("Combien de faces par dé ? ");
      try {
        nbFaces = Integer.parseInt(scanner.nextLine());
        if (nbFaces <= 0) {
          System.out.println("Le nombre de faces doit être supérieur à zéro.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
      }
    }

    De de = new De(nbDes, nbFaces);
    int total = de.lanceDe();

    cible.setM_pv(cible.getM_pv() - total);
    System.out.println("Total des dégâts infligés à " + cible.getM_nom() + " : " + total + " PV");

    if (cible.getM_pv() <= 0) {
      System.out.println(cible.getM_nom() + " est mort et a été retiré !");
      initiativeOrder.remove(cible);
      cible.retirerDuDonjon(donjon);
    }

    donjon.display();
  }
  public void ajouterObstacle(Donjon donjon) {
    System.out.println("Ajout d’un obstacle dans le donjon…");

    while (true) {
      int[] coords = demanderCoordonnees(donjon);
      int x = coords[0];
      int y = coords[1];

      if (caseOccupee(y, x, donjon)) {
        System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
        continue;
      }

      Obstacle o = new Obstacle(y, x);
      donjon.addObstacleOnGround(o);  // Supposé que tu as cette méthode dans Donjon
      System.out.println("Obstacle ajouté en " + (char) ('A' + x) + (y + 1));
      break;
    }
    donjon.display();
  }
  public int[] demanderCoordonnees(Donjon donjon) {
    int x = -1;
    int y = -1;
    boolean positionValide = false;

    while (!positionValide) {
      System.out.print("Donner la position à laquelle vous voulez vous déplacer (exemple : A2 ou E16) : ");
      String input = scanner.nextLine().trim().toUpperCase();

      if (input.length() < 2) {
        System.out.println("Entrée trop courte. Réessayez.");
        continue;
      }

      char lettre = input.charAt(0);
      String chiffres = input.substring(1);

      if (lettre < 'A' || lettre > 'Z') {
        System.out.println("Lettre invalide. Utilisez une lettre entre A et Z.");
        continue;
      }

      try {
        y = Integer.parseInt(chiffres) - 1;  // y est en chiffre (vertical), donc -1 pour index 0-based
        x = lettre - 'A'; // A = 0, B = 1, etc.
      } catch (NumberFormatException e) {
        System.out.println("Numéro invalide. Entrez un nombre après la lettre.");
        continue;
      }

      if (x >= 0 && x < donjon.getM_longueur() && y >= 0 && y < donjon.getM_largeur()) {
        positionValide = true;
      } else {
        System.out.println("Position hors limites du donjon (" + donjon.getM_longueur() + " x " + donjon.getM_largeur() + ").");
      }
    }

    return new int[] { x, y }; // [x, y] format
  }
  public int demanderInterventionMaitreDejeu() {
    System.out.print("Le maître du jeu souhaite-t-il intervenir ? (oui/non) : ");
    String reponse = scanner.nextLine().trim().toLowerCase();

    while (!reponse.equals("oui") && !reponse.equals("non")) {
      System.out.println("Réponse invalide. Veuillez répondre par 'oui' ou 'non'.");
      System.out.print("Le maître du jeu souhaite-t-il intervenir ? (oui/non) : ");
      reponse = scanner.nextLine().trim().toLowerCase();
    }

    if (reponse.equals("non")) {
      return 0; // aucune intervention
    }

    // Afficher les options
    System.out.println("Choisissez une action :");
    System.out.println("1 - Déplacer un joueur ou un monstre");
    System.out.println("2 - Infliger des dégâts");
    System.out.println("3 - Ajouter des obstacles dans le donjon");

    int choix = -1;
    while (choix < 1 || choix > 3) {
      System.out.print("Entrez votre choix (1, 2 ou 3) : ");
      try {
        choix = Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Veuillez entrer un nombre valide.");
      }
    }

    return choix;
  }


  public void seDeplacerParMaitreDeJeu(Donjon donjon, Personnage p) {
    while (true) {
      int[] coords = demanderCoordonnees(donjon);
      int x = coords[0]; // colonne (lettre)
      int y = coords[1]; // ligne (chiffre)

      if (caseOccupee(y, x, donjon)) { // y = ligne, x = colonne
        System.out.println("Cette case est déjà occupée.");
        continue;
      }

      // Case libre → on déplace
      System.out.println("DEBUG: x = " + x + ", y = " + y);
      p.setPosition(y, x);
      System.out.println("Déplacement effectué en " + (char) ('A' + x) + (y + 1));
      break;
    }
  }



  public void affichagePersonnage(ArrayList<Personnage> initiativeOrder) {
    for(int i = 0; i < initiativeOrder.size(); i++)
    {
      System.out.println("[" + (i + 1) + "] : " + initiativeOrder.get(i).getM_nom());
    }
  }

  @Override
  public String toString()
  {
    return "To string de maitre de jeu";
  }
}
