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
            if (entity instanceof Joueur) {
              System.out.print(((Joueur) entity).getM_nom().substring(0, 3));
            } else if (entity instanceof Monstre) {
              RaceMonstre rm = ((Monstre) entity).getM_race();
              if(rm.getM_nom() == "Dragon")
              {
                System.out.print(" X(");
              }
              else
                System.out.print(" X^");
            } else if (entity instanceof Obstacle) {
              System.out.print("[ ]");
            } else {
              System.out.print(" * ");
            }
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
}
