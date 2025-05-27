package deroulement;

import Entites.Entite;
import Entites.Obstacle;
import Entites.Personnages.Joueurs.ClasseJoueur;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Joueurs.Race;
import Entites.Personnages.Monstres.Monstre;

import Entites.Personnages.Monstres.RaceMonstre;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Donjon {

  protected int m_longueur;
  protected int m_largeur;
  protected ArrayList<Entite> m_entityOnGround;
  Scanner scanner = new Scanner(System.in);

  public Donjon(int longueur, int largeur) {

    // Functionality pour choisir map pour future amelioration
//    int longueur = 0;
//    int largeur = 0;
//
//    // Input longueur
//    while (longueur < 15 || longueur > 25) {
//      System.out.print("Entrez la longueur du donjon (entre 15 et 25): ");
//      try {
//        longueur = Integer.parseInt(scanner.nextLine());
//      } catch (NumberFormatException e) {
//        System.out.println("Veuillez entrer un nombre valide !");
//      }
//    }
//
//    // Input largeur
//    while (largeur < 15 || largeur > 25) {
//      System.out.print("Entrez la largeur du donjon (entre 15 et 25): ");
//      try {
//        largeur = Integer.parseInt(scanner.nextLine());
//      } catch (NumberFormatException e) {
//        System.out.println("Veuillez entrer un nombre valide !");
//      }
//    }

    this.m_longueur = longueur;
    this.m_largeur = largeur;
    this.m_entityOnGround = new ArrayList<>();
  }

  public void addEntityOnGround(Entite ent) {
    m_entityOnGround.add(ent);
  }

  public ArrayList<Entite> getM_entityOnGround() {
    return m_entityOnGround;
  }

  public int getM_largeur() {
    return m_largeur;
  }

  public int getM_longueur() {
    return m_longueur;
  }

  private boolean isOccupied(int x, int y) {
    for (Entite entity : m_entityOnGround) {
      if (entity.getM_x() == x && entity.getM_y() == y) {
        return true;
      }
    }
    return false;
  }

  // Pour placer les entité sur carte aleatoirement
//  public void spawnEntityAtFreeLocation(Entite entity) {
//    int x, y;
//    do {
//      x = (int)(Math.random() * m_largeur);
//      y = (int)(Math.random() * m_longueur);
//    } while (isOccupied(x, y));
//
//    entity.setPosition(x,y);
//    addEntityOnGround(entity);
//  }


  private void printLine() {
    System.out.print("   *");
    for (int i = 0; i < m_longueur; i++) {
      System.out.print("---");
    }
    System.out.println("*");
  }
  public abstract void createDonjon();
  public void display() {
    System.out.print("    ");
    for (char c = 'A'; c < 'A' + m_longueur; ++c) {
      System.out.print(" " + c + " ");
    }
    System.out.println();
    printLine();

    for (int i = 0; i < m_largeur; i++) {
      System.out.printf("%2d |", i + 1);
      for (int j = 0; j < m_longueur; j++) {
        boolean printed = false;
        for (Entite entity : m_entityOnGround) {
          if (entity.getM_x() == i && entity.getM_y() == j) {
            System.out.print(entity.getDisplaySymbol());
            printed = true;
            break;
          }
        }
        if (!printed) {
          System.out.print(" . ");
        }
      }
      System.out.println("|");
    }
    printLine();
  }

  // Ajouter nouveau joueur
  public void createPlayers(int nbJoueurs) {
    for (int i = 0; i < nbJoueurs; i++) {
      String nom = askPlayerName(i);
      Race race = askRace(nom);
      ClasseJoueur classe = askClass(nom);
      int[] pos = getStartingCoordinates(i);
      Joueur j = new Joueur(nom, race, classe, pos[0], pos[1]);
      addEntityOnGround(j);
    }
  }

  // Demander joueur nom
  protected String askPlayerName(int i) {
    String nom = "";
    do {
      System.out.print("Entrez le nom du joueur " + (i + 1) + " : ");
      nom = scanner.nextLine().trim();
      if (nom.length() < 3) {
        System.out.println("Le nom doit contenir au moins 3 caractères.");
      }
    } while (nom.length() < 3);
    return nom.toUpperCase();
  }

  // Demander joueur RACE
  protected Race askRace(String nom) {
    int index = 0;
    while (index < 1 || index > 4) {
      System.out.println("Choisir la race de " + nom + " (entrez l'index) :");
      System.out.println("1 : Elfe");
      System.out.println("2 : Halfelin");
      System.out.println("3 : Humain");
      System.out.println("4 : Nain");
      try {
        System.out.print("Race : ");
        index = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Veuillez entrer un nombre valide !");
      }
    }
    return switch (index) {
      case 1 -> Race.Elfe();
      case 2 -> Race.Halfelin();
      case 3 -> Race.Humain();
      default -> Race.Nain();
    };
  }

  // Demander Joueur Class
  protected ClasseJoueur askClass(String nom) {
    int index = 0;
    while (index < 1 || index > 4) {
      System.out.println("Choisir la classe de " + nom + " (entrez l'index) :");
      System.out.println("1 : Clercs");
      System.out.println("2 : Guerriers");
      System.out.println("3 : Magiciens");
      System.out.println("4 : Roublards");
      try {
        System.out.print("Classe : ");
        index = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Veuillez entrer un nombre valide !");
      }
    }

    return switch (index) {
      case 1 -> ClasseJoueur.Clercs();
      case 2 -> ClasseJoueur.Guerriers();
      case 3 -> ClasseJoueur.Magiciens();
      default -> ClasseJoueur.Roublards();
    };
  }

  // Position par défaut
  protected int[] getStartingCoordinates(int playerIndex) {
    return switch (playerIndex) {
      case 0 -> new int[]{19, 8};
      case 1 -> new int[]{19, 16};
      case 2 -> new int[]{15, 3};
      default -> new int[]{15, 21};
    };
  }
}
