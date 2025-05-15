package Personnage.Monstre;

public class RaceMonstre {
    private String m_nom;
    private int m_pv;
    private int m_classeArmure;
    private RaceMonstre(String nom, int pv, int classeArmure)
    {
        m_nom = nom;
        m_pv = pv;
        m_classeArmure = classeArmure;
    }
    public int getM_pv() { return m_pv; }
    public String getM_nom() {return m_nom; }

    public static RaceMonstre Dragon() {
        return new RaceMonstre(
                "Dragon",
                50,
                20
        );
    }
    public static RaceMonstre Demogorgon() {
        return new RaceMonstre(
                "Demogorgon",
                45,
                18
        );
    }
}
