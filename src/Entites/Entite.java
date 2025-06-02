package Entites;

import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Personnages.Joueurs.Joueur;

import Entites.Personnages.Monstres.Monstre;
import java.util.ArrayList;
import java.util.List;

public abstract class Entite {

    private int m_x;
    private int m_y;
    private static List<Entite> m_entites = new ArrayList<>();

    public boolean estCiblePourJoueur() {
        return false;
    }

    public boolean estCiblePourMonstre() {
        return false;
    }
    public boolean isJoueur() {
        return false;
    }
    public boolean isMonstre() {
        return false;
    }
    public Entite(int x, int y) {
        this.m_x = x;
        this.m_y = y;
        m_entites.add(this);
    }

    public int getM_x() {
        return m_x;
    }

    public int getM_y() {
        return m_y;
    }

    public static List<Entite> getM_entites() {return m_entites;}

    public void setPosition(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }
    public String getDisplaySymbol() {
        return " * "; // default symbol
    }

    public boolean estBloquant() {
        return true; // Par défaut, une entité est bloquante
    }

    public static boolean caseOccupee(int x, int y) {
        for (Entite e : m_entites) {
            if (e.getM_x() == x && e.getM_y() == y && e.estBloquant()) {
                return true;
            }
        }
        return false;
    }
    public void ramasser(Joueur joueur) {
        // Par défaut : ne fait rien
    }

    public static void setM_entites(List<Entite> m_entites) {
        Entite.m_entites = m_entites;
    }
    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass();
    }
}