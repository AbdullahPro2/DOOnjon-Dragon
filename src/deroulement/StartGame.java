package deroulement;

import Entites.Entite;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import utils.De;

public class StartGame {

  Donjon m_donjon;
  private ArrayList<Joueur> m_joueurs = new ArrayList<>();
  private ArrayList<Monstre> m_monstres = new ArrayList<>();
  private ArrayList<Personnage> m_initiativeOrder = new ArrayList<>();

  public void startGame() {
    int[] difficulties = {1, 2, 3}; // 1: Easy, 2: Medium, 3: Hard
    int tour = 1;
    for (int difficulty : difficulties) {
      System.out.println("\n===Donjon " + difficulty + " ===");
      launchDonjon(difficulty);
      m_donjon.createDonjon();
      m_donjon.display();

      m_joueurs.clear();
      m_monstres.clear();
      m_initiativeOrder.clear();

      loadCharactersFromDonjon();
      m_initiativeOrder.addAll(m_joueurs);
      m_initiativeOrder.addAll(m_monstres);
      sortInitiativeOrder();

      for (Joueur j : m_joueurs) {
        j.equiperDepart();
      }

      boolean joueurMort = false;

      while (!joueurEstMort() && !tousMonstresMorts()) {
        for (Personnage p : m_initiativeOrder) {
          if (p.getM_initiative() <= 0) continue; // skip dead ones
          if (p.isJoueur()) {
            Joueur j = (Joueur) p;
            printTourInformation(difficulty, tour, j);
            m_donjon.display();
            executerTour(j);
          } else if (p.isMonstre()) {
            Monstre m = (Monstre) p;
            printTourInformation(difficulty, tour, m);
            m_donjon.display();
            executerTour(m);
          }

          if (joueurEstMort()) {
            joueurMort = true;
            break;
          }
          tour++;
        }

        if (joueurMort) {
          break;
        }
      }

      if (joueurMort) {
        System.out.println("\nUn joueur est mort. Fin du jeu !");
        return;
      } else {
        System.out.println("\nTous les monstres ont été vaincus ! Passage au niveau suivant.");
      }
    }

    System.out.println("\nFélicitations ! Vous avez terminé tous les donjons !");
  }
  private void printTourInformation(int difficulty, int tour, Personnage courant)
  {
    System.out.println();
    System.out.println();
    System.out.println();

    for(int i = 0; i < m_donjon.m_largeur; i++)
      System.out.print("***");
    System.out.println();
    System.out.println("Donjon : " +  difficulty);
    System.out.println();
    for(int i = 0; i < m_donjon.m_largeur; i++)
      System.out.print("***");
    System.out.println();
    System.out.println("Tour: " + tour);
    for(Personnage p : m_initiativeOrder)
    {
      if (p.isJoueur()) {
        Joueur j = (Joueur) p;
        if(Objects.equals(courant.getM_nom(), j.getM_nom()))
        {
          System.out.println("-> " +j.getM_nom() + " ( " + j.getM_race().getM_nomRace() +  " " + j.getM_classe().getM_nomClass() + ", " + j.getM_pv() + "/" + j.getM_pvMax() +" )");
        }
        else
          System.out.println("   " + j.getM_nom() + " ( " + j.getM_race().getM_nomRace() +  " " + j.getM_classe().getM_nomClass() + ", " + j.getM_pv() + "/" + j.getM_pvMax() +" )");
        } else if (p.isMonstre()) {
        Monstre m = (Monstre) p;
        if(Objects.equals(courant.getM_nom(), m.getM_nom()))
        {
          System.out.println("-> " +m.getM_nom() + " " + m.getM_race().getM_nom() + " (" + m.getM_pv() + "/" + m.getM_pvMax() +" )");
        }
        else
          System.out.println("   " + m.getM_nom() + " " + m.getM_race().getM_nom() + " (" + m.getM_pv() + "/" + m.getM_pvMax() +" )");
      }
    }
  }

  private boolean joueurEstMort() {
    for (Joueur j : m_joueurs) {
      if(j.getM_initiative() <= 0)
      {
        return true;
      }
    }
    return false;
  }
  private boolean tousMonstresMorts() {
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
            ((Joueur)p).equiperChoix();
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
  private void launchDonjon(int choice) {
    switch (choice) {
      case 1 -> {
       this.m_donjon = new EasyDonjon();
      }
      case 2 -> {
        this.m_donjon = new MediumDonjon();
      }
      case 3 -> {
        this.m_donjon = new HardDonjon();
      }
    }
  }


}
