package Entites.Personnages.Monstres;

import utils.De;

public class RaceMonstre {
    private String m_nom;
    private int m_pvRace;
    private int m_classeArmure;
    private int m_portee;
    private int m_degats;
    private De m_deDegats;
    private RaceMonstre(String nom, int pv, int classeArmure, int portee, int degats, De de)
    {
        m_nom = nom;
        m_pvRace = pv;
        m_classeArmure = classeArmure;
        m_portee = portee;
        m_degats = degats;
        m_deDegats = de;
    }
    public int getM_pvRace() { return m_pvRace; }
    public String getM_nom() {return m_nom; }

    public int getM_classeArmure() {
        return m_classeArmure;
    }

    public int getM_degats() {
        return m_degats;
    }

    public De getM_deDegats() {
        return m_deDegats;
    }

    public int getM_portee() {
        return m_portee;
    }

    public static RaceMonstre Dragon() {
        return new RaceMonstre(
                "Dragon",
                50,
                20,
                2,
                3,
                new De(1, 8)
        );
    }
    public static RaceMonstre Demogorgon() {
        return new RaceMonstre(
                "Demogorgon",
                45,
                18,
                1,
                5,
                new De(1, 6)
        );
    }
    @Override
    public String toString() {
        return "Race du Monstre : " + m_nom + "\n" +
            "Points de vie max : " + m_pvRace + "\n" +
            "Classe d'armure : " + m_classeArmure;
    }

}
