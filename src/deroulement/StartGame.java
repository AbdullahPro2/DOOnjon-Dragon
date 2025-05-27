package deroulement;

import Entites.Entite;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import utils.De;

public class StartGame {

  Donjon m_donjon;
  private ArrayList<Joueur> m_joueurs = new ArrayList<>();
  private ArrayList<Monstre> m_monstres = new ArrayList<>();
  private ArrayList<Personnage> m_initiativeOrder = new ArrayList<>();
  public  void startGame() {
    String userChoice = promptDonjonSelection();
    launchDonjon(userChoice);
    m_donjon.createDonjon();
    m_donjon.display();
    loadCharactersFromDonjon();;
    m_initiativeOrder.addAll(m_joueurs);
    m_initiativeOrder.addAll(m_monstres);
    sortInitiativeOrder();
    for(Joueur j: m_joueurs)
    {
      j.EquiperDepart();
    }
    int i = 0;
    while(!jouerEstMort() && !tousMonstresMorts()) {
      for (Personnage p : m_initiativeOrder) {
        if (p.isJoueur()) {
          Joueur j = (Joueur) p;
          executerTour(j);
        } else if (p.isMonstre()) {
          Monstre m = (Monstre) p;
          executerTour(m);
        }
      }
    }
  }
  private boolean jouerEstMort()
  {
    for (Joueur j : m_joueurs) {
      if(j.getM_initiative() <= 0)
      {
        return true;
      }
    }
    return false;
  }
  private boolean tousMonstresMorts()
  {
    for (Monstre m : m_monstres) {
      if(m.getM_initiative() > 0)
      {
        return false;
      }
    }
    return true;
  }
    private void loadCharactersFromDonjon() {
      for (Entite e : m_donjon.getM_entityOnGround()) {
        if (e.isJoueur()) {
          m_joueurs.add((Joueur)e);
        } else if (e.isMonstre()) {
          m_monstres.add((Monstre) e);
        }
      }
    }

  private void sortInitiativeOrder() {
    for (int i = 0; i < m_initiativeOrder.size() - 1; i++) {
      for (int j = 0; j < m_initiativeOrder.size() - 1 - i; j++) {
        if (m_initiativeOrder.get(j).getM_initiative() < m_initiativeOrder.get(j + 1).getM_initiative()) {
          Personnage temp = m_initiativeOrder.get(j);
          m_initiativeOrder.set(j, m_initiativeOrder.get(j + 1));
          m_initiativeOrder.set(j + 1, temp);
        }
      }
    }
  }
  private void executerTour(Personnage p) {
    Scanner scanner = new Scanner(System.in);
    int actionsRestantes = 3;

    System.out.println("\n=== Tour de " + p.getM_nom() + " ===");

    while (actionsRestantes > 0) {
      System.out.println("Actions restantes : " + actionsRestantes);
      System.out.println("Choisissez une action :");
      System.out.println("1 - Se déplacer");
      System.out.println("2 - Attaquer");

      if (p.isJoueur()) {
        System.out.println("3 - S'équiper");
        System.out.println("4 - Ramasser un équipement");
      }

      System.out.print("Votre choix : ");
      String choix = scanner.nextLine().trim();

      switch (choix) {
        case "1":
          p.SeDeplacer(m_donjon); // méthode à définir dans Joueur/Monstre
          break;
        case "2":
          p.attaquer(); // méthode à définir dans Joueur/Monstre
          break;
        case "3":
          if (p.isJoueur()) {
            ((Joueur)p).EquiperChoix();
          } else {
            System.out.println("Action non valide.");
            continue;
          }
          break;
        case "4":
          if (p.isJoueur()) {
            ((Joueur)p).ramasser();
          } else {
            System.out.println("Action non valide.");
            continue;
          }
          break;
        default:
          System.out.println("Choix invalide.");
          continue; // ne consomme pas d'action
      }

      actionsRestantes--;
      m_donjon.display();
    }

    System.out.println("Fin du tour de " + p.getM_nom());
  }


  /**
   * Demander l'utilisateur à choisir une difficulté de Donjon jusqu'à ce qu'un choix valide soit donné.
   * @return Donjon Valide : "1", "2", or "3".
   */
  private static String promptDonjonSelection() {
    Scanner scanner = new Scanner(System.in);
    String choice;
    System.out.println("Entrez le numéro du donjon dans lequel vous voulez entrer :");
    System.out.print("Donjon1 (facile)     Donjon2 (moyen)     Donjon3 (difficile) : ");
    choice = scanner.nextLine().trim();

    while (!isValidChoice(choice)) {
      System.out.print("Veuillez répondre \"1\", \"2\" ou \"3\" : ");
      choice = scanner.nextLine().trim();
    }
    return choice;
  }

  /**
   * Vérifie si la saisie utilisateur est un numéro de donjon valide.
   * @param choice La saisie de l'utilisateur.
   * @return  vrai si c'est "1", "2" ou "3", faux sinon.
   */
  private static boolean isValidChoice(String choice) {
    return Objects.equals(choice, "1") ||
        Objects.equals(choice, "2") ||
        Objects.equals(choice, "3");
  }

  private void launchDonjon(String choice) {
    switch (choice) {
      case "1" -> {
       this.m_donjon = new EasyDonjon();
      }
      case "2" -> {
        this.m_donjon = new MediumDonjon();
      }
      case "3" -> {
        this.m_donjon = new HardDonjon();
      }
    }
  }

//  public void determineInitiativeOrder() {
//    De de = new De(1,20);
//    for (Entite e : m_donjon.getM_entityOnGround()) {
//      int roll = de.lanceDe();
//      if (e.isPersonnage()) {
//        int initiative = ((Personnage) e).getM_initiative();
//        System.out.println(initiative + roll);
//      }
//    }
//  }
}
