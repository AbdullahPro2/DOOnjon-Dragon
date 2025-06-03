package Entites.Personnages;

import java.util.ArrayList;
import java.util.Scanner;

public class MaitreJeu {
  private Scanner scanner = new Scanner(System.in);

  public void DeplacerJoueurMonstre(ArrayList<Personnage> initiativeOrder) {
    System.out.println("Qui voulez-vous déplacer ? Monstre [0] ou Joueur [1] : ");
    String choix = scanner.nextLine().trim();

    while (!choix.equals("0") && !choix.equals("1")) {
      System.out.println("Choisir soit Monstre [0] ou Joueur [1] : ");
      choix = scanner.nextLine().trim();
    }

    System.out.println("Les entités sélectionnées :");
    for (Personnage p : initiativeOrder) {
      if (p.shouldBeMoved(choix)) {
        System.out.println(p.getM_nom());
      }
    }
  }


}
