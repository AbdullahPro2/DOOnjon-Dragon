package utils;

import Personnage.Personnage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Donjon {
  private int m_longueur;
  private int m_largeur;
  private ArrayList<Personnage> m_playerssOnGround;

  public void addEntityOnGround(Personnage pers)
  {
    m_playerssOnGround.add(pers);
  }
  public Donjon() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Entrez la longueur souhaité pour le donjon: ");
    m_longueur = Integer.parseInt(myObj.nextLine());
    System.out.print("Entrez la largeur souhaité pour le donjon: ");
    m_largeur = Integer.parseInt(myObj.nextLine());
    m_playerssOnGround = new ArrayList<>();

  }
  public void printLine(int longueur){
    System.out.print("   *");
    for(int i = 0; i < longueur; i++)
    {
      System.out.print("---");
    }
    System.out.print("--*");
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

        for (Personnage entity : m_playerssOnGround) {
          if (entity.getX() == i && entity.getY() == j) {
            System.out.print(entity.getM_nom().substring(0,3));
            entityPrinted = true;
            break;
          }
        }

        if (!entityPrinted) {
          System.out.print(" . ");
        }
      }

      System.out.print("  |");
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
