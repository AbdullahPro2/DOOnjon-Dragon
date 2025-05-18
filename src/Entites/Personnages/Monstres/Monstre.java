package Entites.Personnages.Monstres;

import Entites.Personnages.Personnage;

public class Monstre extends Personnage {
    private RaceMonstre m_race;
    private int m_numero;

    public Monstre(RaceMonstre race, int numero, int x, int y)
    {
        super(race.getM_nom()+" "+numero, race.getM_pv(),x,y);
        m_race = race;
        m_numero = numero;
    }
    @Override
    public String toString() {
        return "Monstre{" +
            "nom='" + super.getM_nom() + '\'' +
            ", numero=" + m_numero +
            ", race=" + m_race +
            ", position=(" + getX() + ", " + getY() + ")" +
            ", pv=" + getM_pv() +
            '}';
    }

}
