package Entites;

import java.util.ArrayList;
import java.util.List;

public abstract class Entite {

    private int m_x;
    private int m_y;
    private static List<Entite> m_entites = new ArrayList<>();

    public Entite(int x, int y) {
        this.m_x = x;
        this.m_y = y;
        m_entites.add(this);
    }


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

}