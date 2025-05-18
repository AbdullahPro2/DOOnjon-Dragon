package Entites.Personnages;

import Entites.Entite;
import utils.De;
import utils.Donjon;
import utils.Utils;

import java.util.Scanner;

public abstract class Personnage extends Entite {
    private String m_nom;
    private int m_pv;
    private int m_force;
    private int m_dexterite;
    private int m_vitesse;
    private int m_initiative;

    public Personnage(String nom, int pv, int x, int y)
    {
        super(x,y);
        De de = new De(4,4);
        m_nom = nom;
        m_pv = pv;
        m_force = de.lanceDe()+3;
        m_dexterite = de.lanceDe()+3;
        m_vitesse = de.lanceDe()+3;
        m_initiative = de.lanceDe()+3;
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

    public void SeDeplacer(Donjon donjon) {
        Scanner scanner = new Scanner(System.in);
        int maxX = donjon.getM_largeur();
        int maxY = donjon.getM_longueur();
        int[] tabCoord = saisirPositionValide(maxX, maxY);
        int x = tabCoord[0];
        int y = tabCoord[1];
        // Vérification que la case n'est pas occupée, sinon demander une nouvelle position
        while (super.caseOccupee(x, y)) {
            System.out.println("La case est déjà occupée. Veuillez choisir une autre position.");
            tabCoord = saisirPositionValide(maxX, maxY);  // Demander une nouvelle position
            x = tabCoord[0];
            y = tabCoord[1];
        }

        // Une fois la position valide et libre, on affecte la nouvelle position
        setPosition(x, y);
    }

    public int[] saisirPositionValide(int maxX, int maxY) {
        Scanner scanner = new Scanner(System.in);
        int x = -1;
        int y = -1;

        // Boucle jusqu'à ce que l'utilisateur entre une position valide
        while (x == -1 || y == -1) {
            System.out.print("Donner la position à laquelle vous voulez vous déplacer (exemple : A2 ou E6) : ");
            String pos = scanner.nextLine().trim();

            // Vérifie que l'entrée est au moins de la forme "lettre" + "chiffre"
            if (pos.length() < 2) {
                System.out.println("Entrée invalide. Veuillez utiliser le format \"lettre\"\"chiffre\" (ex : A2).");
                continue;
            }

            char lettre = pos.charAt(0);
            char chiffre = pos.charAt(1);

            // Vérifie la lettre (doit être une clé valide dans le dictionnaire)
            if (Utils.dico.containsKey(lettre)) {
                x = Utils.dico.get(lettre);
                if (x < 0 || x > maxX) {
                    System.out.println("Lettre invalide. Veuillez entrer une lettre qui se trouve sur la grille.");
                    x = -1;  // Réinitialisation pour continuer la boucle
                }
            } else {
                System.out.println("Lettre invalide. Veuillez entrer une lettre qui se trouve sur la grille.");
                x = -1;  // Réinitialisation pour continuer la boucle
            }

            // Vérifie le chiffre (doit être un nombre entre 0 et nombre de lignes-1)
            if (Character.isDigit(chiffre)) {
                y = chiffre - '0';  // Convertit '2' → 2, etc.
                if (y < 0 || y > maxY) {
                    System.out.println("Chiffre invalide. Veuillez entrer un nombre qui se trouve sur la grille.");
                    y = -1;  // Réinitialisation pour continuer la boucle
                }
            } else {
                System.out.println("Chiffre invalide. Veuillez entrer un nombre qui se trouve sur la grille.");
                y = -1;  // Réinitialisation pour continuer la boucle
            }
        }

        // Retourne les coordonnées valides
        return new int[] { x, y };
    }


    public int getM_dexterite() {
        return m_dexterite;
    }

    public int getM_force() {
        return m_force;
    }

    public int getM_pv() {
        return m_pv;
    }

    public int getM_vitesse() { return m_vitesse;}

    public String getM_nom() { return m_nom;}

    public int getM_initiative() { return m_initiative;}

    public void setM_dexterite(int dexterite) {this.m_dexterite = dexterite;}

    public void setM_force(int force) {this.m_force = force;}

    public void setM_vitesse(int vitesse) {this.m_vitesse = vitesse;}
}
