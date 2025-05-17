package Personnage;

import utils.De;
import utils.Entity;
import utils.Utils;

import java.util.Scanner;

public abstract class Personnage extends Entity {
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

    public void SeDeplacer() {
        Scanner scanner = new Scanner(System.in);
        int x = -1;
        int y = -1;

        while (x == -1 || y == -1) {
            System.out.print("Donner la position à laquelle vous voulez vous déplacer (exemple : A2 ou E6) : ");
            String pos = scanner.nextLine().trim();

            if (pos.length() < 2) {
                System.out.println("Entrée invalide. Veuillez utiliser le format \"lettre\"\"chiffre\" (ex : A2).");
                continue;
            }

            char lettre = pos.charAt(0);
            char chiffre = pos.charAt(1);

            // Vérifie la lettre
            if (Utils.dico.containsKey(lettre)) {
                x = Utils.dico.get(lettre);
            } else {
                System.out.println("Lettre invalide. Elle doit être comprise entre A et Y.");
                x = -1;  // On s'assure de rester dans la boucle
            }

            // Vérifie le chiffre
            if (Character.isDigit(chiffre)) {
                y = chiffre - '0';  // Convertit '2' → 2, etc.
            } else {
                System.out.println("Chiffre invalide. Veuillez entrer un chiffre entre 0 et 9.");
                y = -1;
            }
        }
        setPosition(x,y);
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

    public void setM_dexterite(int m_dexterite) {this.m_dexterite = m_dexterite;}

    public void setM_force(int m_force) {this.m_force = m_force;}

    public void setM_initiative(int m_initiative) {this.m_initiative = m_initiative;}

    public void setM_nom(String m_nom) {this.m_nom = m_nom;}

    public void setM_pv(int m_pv) {this.m_pv = m_pv;}

    public void setM_vitesse(int m_vitesse) {this.m_vitesse = m_vitesse;}
}
