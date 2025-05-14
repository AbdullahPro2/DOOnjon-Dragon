package Personnage;

public abstract class Personnage {
    private String m_nom;
    private int m_pv;
    private int m_force;
    private int m_dexterite;
    private int m_vitesse;
    private int m_initiative;

    public Personnage(String nom, int pv, int force, int dexterite, int vitesse, int initiative)
    {
        m_nom = nom;
        m_pv = pv;
        m_force = force;
        m_dexterite = dexterite;
        m_vitesse = vitesse;
        m_initiative = initiative;
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

}
