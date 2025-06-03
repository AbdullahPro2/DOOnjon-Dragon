package deroulement;

import Entites.Entite;
import Entites.Obstacle;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Monstres.Monstre;
import java.util.ArrayList;

public abstract class Donjon {

  protected int m_longueur;
  protected int m_largeur;
  protected ArrayList<Entite> m_equipementOnGround;
  protected ArrayList<Joueur> m_joueurOnGround;
  protected ArrayList<Monstre> m_monstreOnGround;
  protected ArrayList<Obstacle> m_obstacleOnGround;

  public Donjon(int longueur, int largeur, ArrayList<Joueur> joueurs) {
    this.m_longueur = longueur;
    this.m_largeur = largeur;
    this.m_equipementOnGround = new ArrayList<>();
    this.m_monstreOnGround = new ArrayList<>();
    this.m_joueurOnGround = joueurs;
    this.m_obstacleOnGround = new ArrayList<>();
  }

  public void addEquipementOnGround(Entite ent) {
    m_equipementOnGround.add(ent);
  }

  public void addMonstreOnGround(Monstre ent) {
    m_monstreOnGround.add(ent);
  }
  public void addObstacleOnGround(Obstacle o){
    m_obstacleOnGround.add(o);
  }

  public ArrayList<Joueur> getM_joueurOnGround() {
    return m_joueurOnGround;
  }

  public ArrayList<Monstre> getM_monstreOnGround() {
    return m_monstreOnGround;
  }

  public ArrayList<Entite> getM_equipementOnGround() {
    return m_equipementOnGround;
  }

  public ArrayList<Obstacle> getM_obstacleOnGround() {
    return m_obstacleOnGround;
  }

  public int getM_largeur() {
    return m_largeur;
  }

  public int getM_longueur() {
    return m_longueur;
  }


  private void printLine() {
    System.out.print("   *");
    for (int i = 0; i < m_longueur; i++) {
      System.out.print("───");
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
      System.out.printf("%2d │", i + 1);
      for (int j = 0; j < m_longueur; j++) {
        Joueur joueur = null;
        for (Joueur player : m_joueurOnGround) {
          if (player.getM_x() == i && player.getM_y() == j) {
            joueur = player;
            break;
          }
        }

        Monstre monstre = null;
        if (joueur == null) {
          for (Monstre monster : m_monstreOnGround) {
            if (monster.getM_x() == i && monster.getM_y() == j) {
              monstre = monster;
              break;
            }
          }
        }
        Entite autre = null;
        if (joueur == null && monstre == null) {
          for (Entite equipement : m_equipementOnGround) {
            if (equipement.getM_x() == i && equipement.getM_y() == j) {
              autre = equipement;
              break;
            }
          }
        }

        if (joueur != null) {
          System.out.print(joueur.getDisplaySymbol());
        } else if (monstre != null) {
          System.out.print(monstre.getDisplaySymbol());
        } else if (autre != null) {
          System.out.print(autre.getDisplaySymbol());
        } else {
          System.out.print(" . ");
        }
      }
      System.out.println("│");
    }
    printLine();
  }

  protected abstract int[] getStartingCoordinates(int i);
  public abstract void createDonjon();

}





















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