package utils;

import java.util.Scanner;

public class Donjon {
  private int m_longeur;
  private int m_largeur;

  public Donjon() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Entrez longueur : ");
    m_longeur = Integer.parseInt(myObj.nextLine());
    System.out.print("Entrez largeur : ");
    m_largeur = Integer.parseInt(myObj.nextLine());
  }
  public static void printLine(int lar, int lon){
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
    printLine(m_largeur, m_longeur); // Top border
    // Print grid rows
    for (int i = 0; i < m_longeur; i++) {
      // Print row number with alignment
      if (i >= 9) {
        System.out.print((i + 1) + " |");
      } else {
        System.out.print((i + 1) + "  |");
      }

      // Loop through each column (dot for now, can add characters later)
      for (int j = 0; j < m_largeur; j++) {
           //You can replace '.' with a character based on grid state
          if(i == 10 && j == 5)
            System.out.print("[ ]");
        else if(i == 5 && j == 6)
          System.out.print("CAE");
        else if(i == 16 && j == 7)
          System.out.print("M^ ");
          else
            System.out.print(" . ");
      }

      System.out.print("  |");
      System.out.println();
    }
    printLine(m_largeur, m_longeur); // Bottom border
  }

}
