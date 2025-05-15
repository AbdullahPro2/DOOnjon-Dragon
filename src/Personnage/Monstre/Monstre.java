package Personnage.Monstre;

import Personnage.Personnage;

public class Monstre extends Personnage {
    private RaceMonstre m_race;
    private int m_numero;

    public Monstre(RaceMonstre race, int numero)
    {
        super(race.getM_nom()+" "+numero, race.getM_pv());
        m_race = race;
        m_numero = numero;
    }
}
