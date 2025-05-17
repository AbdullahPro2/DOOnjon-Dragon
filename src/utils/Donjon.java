package utils;

import Personnage.Personnage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Donjon {
  private int m_longeur;
  private int m_largeur;
  private ArrayList<Personnage> m_playerssOnGround;

  public void addEntityOnGround(Personnage pers)
  {
    m_playerssOnGround.add(pers);
  }
  public Donjon() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Entrez longueur : ");
    m_longeur = Integer.parseInt(myObj.nextLine());
    System.out.print("Entrez largeur : ");
    m_largeur = Integer.parseInt(myObj.nextLine());
    m_playerssOnGround = new ArrayList<>();

  }
  public void printLine(int lar){
    System.out.print("   *");
    for(int i = 0; i < lar; i++)
    {
      System.out.print("---");
    }
    System.out.print("--*");
    System.out.println();
  }

  public void DonjonGround() {
    // Print column headers (A, B, C, ...)
    System.out.print("    ");
    for (char c = 'A'; c < 'A' + m_largeur; ++c) {
      System.out.print(" " + c + " ");
    }
    System.out.println();
    printLine(m_largeur); // Top border

    // Print grid rows
    for (int i = 0; i < m_longeur; i++) {
      // Print row number with alignment
      if (i >= 9) {
        System.out.print((i + 1) + " |");
      } else {
        System.out.print((i + 1) + "  |");
      }

      for (int j = 0; j < m_largeur; j++) {
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

    printLine(m_largeur); // Bottom border
  }
}
