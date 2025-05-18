package utils;

import Entites.Entite;
import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Obstacle;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import java.util.ArrayList;
import java.util.Scanner;

public class Donjon {
  private int m_longueur;
  private int m_largeur;
  private ArrayList<Entite> m_entityOnGround;

  public void addEntityOnGround(Entite ent)
  {
    m_entityOnGround.add(ent);
  }
  public Donjon() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Entrez la longueur souhaité pour le donjon: ");
    m_longueur = Integer.parseInt(myObj.nextLine());
    System.out.print("Entrez la largeur souhaité pour le donjon: ");
    m_largeur = Integer.parseInt(myObj.nextLine());
    m_entityOnGround = new ArrayList<>();
  }

  public Donjon(int longueur, int largeur) {
    m_longueur = longueur;
    m_largeur = largeur;
    m_entityOnGround = new ArrayList<>();
  }

  public void printLine(int longueur){
    System.out.print("   *");
    for(int i = 0; i < longueur; i++)
    {
      System.out.print("---");
    }
    System.out.print("*");
    System.out.println();
  }

  public void DonjonGround() {
    // Print column headers (A, B, C, ...)
    System.out.print("    ");
    for (char c = 'A'; c < 'A' + m_longueur; ++c) {
      System.out.print(" " + c + " ");
    }
    System.out.println();
    printLine(m_longueur); // Top border

    // Print grid rows
    for (int i = 0; i < m_largeur; i++) {
      // Print row number with alignment
      if (i >= 9) {
        System.out.print((i + 1) + " |");
      } else {
        System.out.print((i + 1) + "  |");
      }

      for (int j = 0; j < m_longueur; j++) {
        boolean entityPrinted = false;

        for (Entite entity : m_entityOnGround) {
          if (entity.getM_x() == i && entity.getM_y() == j) {
            if (entity instanceof Joueur) {
              System.out.print(((Joueur) entity).getM_nom().substring(0, 3));
            } else if (entity instanceof Monstre) {
              System.out.print("X^ ");
            } else if (entity instanceof Obstacle) {
              System.out.print("[ ]");
            } else {
              System.out.print(" * ");
            }
            entityPrinted = true;
            break; // stop looking at other entities for this cell
          }
        }
        if (!entityPrinted) {
          System.out.print(" . ");
        }
      }
      System.out.print("|"); // right border
      System.out.println();
    }
    printLine(m_longueur); // Bottom border

  }

  public int getM_largeur() {
    return m_largeur;
  }

  public int getM_longueur() {
    return m_longueur;
  }
}
