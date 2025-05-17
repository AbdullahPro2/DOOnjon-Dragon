package utils;

import java.util.List;

public abstract class Entite {

    private int m_x;
    private int m_y;
    private static List<Entite> m_entites;

    public Entite(int x, int y) {
        this.m_x = x;
        this.m_y = y;
        m_entites.add(this);
    }

    public String getSymbol(String nom){return nom;} // For drawing

    public int getX() {
        return m_x;
    }

    public int getY() {
        return m_y;
    }

    public void setPosition(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }


    public static boolean caseOccupee(int x, int y) {
        for (Entite e : m_entites) {
            if (e.getX() == x && e.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public List<Entite> getM_entites() {
        return m_entites;
    }

    public void addEntite(Entite ent)
    {
        m_entites.add(ent);
    }

}