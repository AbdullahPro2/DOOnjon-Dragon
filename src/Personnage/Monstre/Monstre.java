package Personnage.Monstre;

import Personnage.Personnage;

public class Monstre extends Personnage {
    private RaceMonstre m_race;
    private int m_numero;
    private int m_classeArmure;

    public Monstre(int force, int dexterite, int vitesse, int initiative, RaceMonstre race, int numero, int classeArmure)
    {
        super(force, dexterite, vitesse, initiative);
        m_race = race;
        m_numero = numero;
        m_classeArmure = classeArmure;
    }
}
