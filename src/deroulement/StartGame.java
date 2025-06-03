package deroulement;

import Entites.Entite;
import Entites.Personnages.Joueurs.ClasseJoueur;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Joueurs.Race;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StartGame {

  Donjon m_donjon;
  private ArrayList<Joueur> m_joueurs = new ArrayList<>();
  private ArrayList<Monstre> m_monstres = new ArrayList<>();
  private ArrayList<Personnage> m_initiativeOrder = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);


  public void startGame() {
    int[] difficulties = {1, 2, 3}; // 1: Easy, 2: Medium, 3: Hard
    int tour = 1;
    createPlayers(4);
    for (int difficulty : difficulties) {
      System.out.println("\n===Donjon " + difficulty + " ===");
      launchDonjon(difficulty);
      m_donjon.createDonjon();
      ajouterJoueurs();
      m_donjon.display();

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
//          if (p.getM_pv() <= 0)
//            continue; // skip dead ones
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
  private void ajouterJoueurs() {
    for(int i = 0; i < m_joueurs.size(); i++)
    {
      int pos[] = m_donjon.getStartingCoordinates(i);
      m_joueurs.get(i).setPosition(pos[0], pos[1]);
      m_donjon.addEntityOnGround(m_joueurs.get(i));
    }
  }
  private void printTourInformation(int difficulty, int tour, Personnage courant) {
    System.out.println();
    System.out.println();
    System.out.println();

    for (int i = 0; i < m_donjon.m_largeur; i++)
      System.out.print("***");
    System.out.println();
    System.out.println("Donjon : " + difficulty);
    System.out.println();
    for (int i = 0; i < m_donjon.m_largeur; i++)
      System.out.print("***");
    System.out.println();
    System.out.println("Tour: " + tour);
    for (Personnage p : m_initiativeOrder) {
      if (p.isJoueur()) {
        Joueur j = (Joueur) p;
        if (Objects.equals(courant.getM_nom(), j.getM_nom())) {
          System.out.println(
              "-> " + j.getM_nom() + " ( " + j.getM_race().getM_nomRace() + " " + j.getM_classe()
                  .getM_nomClass() + ", " + j.getM_pv() + "/" + j.getM_pvMax() + " )");
        } else
          System.out.println(
              "   " + j.getM_nom() + " ( " + j.getM_race().getM_nomRace() + " " + j.getM_classe()
                  .getM_nomClass() + ", " + j.getM_pv() + "/" + j.getM_pvMax() + " )");
      } else if (p.isMonstre()) {
        Monstre m = (Monstre) p;
        if (Objects.equals(courant.getM_nom(), m.getM_nom())) {
          System.out.println(
              "-> " + m.getM_nom() + " " + m.getM_race().getM_nom() + " (" + m.getM_pv() + "/"
                  + m.getM_pvMax() + " )");
        } else
          System.out.println(
              "   " + m.getM_nom() + " " + m.getM_race().getM_nom() + " (" + m.getM_pv() + "/"
                  + m.getM_pvMax() + " )");
      }
    }
  }
  private boolean joueurEstMort() {
    for (Joueur j : m_joueurs) {
      if (j.getM_pv() <= 0) {
        return true;
      }
    }
    return false;
  }
  private boolean tousMonstresMorts() {
    for (Monstre m : m_monstres) {
      if (m.getM_initiative() > 0) {
        return false;
      }
    }
    return true;
  }
  private void loadCharactersFromDonjon() {
    for (Entite e : m_donjon.getM_entityOnGround()) {
     if (e.isMonstre()) {
        m_monstres.add((Monstre) e);
      }
    }
  }
  private void sortInitiativeOrder() {
    for (int i = 0; i < m_initiativeOrder.size() - 1; i++) {
      for (int j = 0; j < m_initiativeOrder.size() - 1 - i; j++) {
        if (m_initiativeOrder.get(j).getM_initiative() < m_initiativeOrder.get(j + 1)
            .getM_initiative()) {
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

    while (actionsRestantes > 0 && (!joueurEstMort() && !tousMonstresMorts())) {
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
          System.out.println("Déplacement possible pour " + p.getM_nom() + " " + p.getM_vitesse() / 3 + " cases");
          p.SeDeplacer(m_donjon);
          break;

        case "2":
          p.attaquer();
          break;

        case "3":
          p.equiperChoix(); // Ne fait rien pour les monstres
          break;

        case "4":
          p.ramasser(); // Ne fait rien pour les monstres
          break;

        default:
          System.out.println("Choix invalide.");
          continue;
      }

      actionsRestantes--;
      m_donjon.display();
      System.out.println(p.afficheApresTour());

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

// Jouer cree les joueurs

  // Ajouter nouveau joueur
  public void createPlayers(int nbJoueurs) {
    for (int i = 0; i < nbJoueurs; i++) {
      String nom = askPlayerName(i);
      Race race = askRace(nom);
      ClasseJoueur classe = askClass(nom);
      Joueur j = new Joueur(nom, race, classe, 0, 0);
      m_joueurs.add(j);
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

}