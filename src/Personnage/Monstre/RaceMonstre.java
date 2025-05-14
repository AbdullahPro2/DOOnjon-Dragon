package Personnage.Monstre;

public class RaceMonstre {
    String m_nom;
    int m_pv;
    private RaceMonstre(String nom, int pv)
    {
        m_nom = nom;
        m_pv = pv;
    }
    public int getM_pv() { return m_pv; }
    public String getM_nom() {return m_nom; }

    public static RaceMonstre Dragon() {
        return new RaceMonstre(
                "Drgon",
                50
        );
    }
    public static RaceMonstre Demogorgon() {
        return new RaceMonstre(
                "Demogorgon",
                45
        );
    }
}
