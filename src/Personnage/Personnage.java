package Personnage;

import utils.De;

public abstract class Personnage {
    private String m_nom;
    private int m_pv;
    private int m_force;
    private int m_dexterite;
    private int m_vitesse;
    private int m_initiative;

    public Personnage(String nom, int pv)
    {
        De de = new De(4,4);
        m_nom = nom;
        m_pv = pv;
        m_force = de.lanceDe()+3;
        m_dexterite = de.lanceDe()+3;
        m_vitesse = de.lanceDe()+3;
        m_initiative = de.lanceDe()+3;
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
