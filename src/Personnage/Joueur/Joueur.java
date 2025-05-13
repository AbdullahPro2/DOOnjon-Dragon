package Personnage.Joueur;

import Personnage.Personnage;
import equipement.Arme;
import equipement.Armure;

public class Joueur extends Personnage {

    private Arme m_arme;
    private Armure m_armure;

    public Joueur(int force, int dexterite, int vitesse, int initiative, Arme arme, Armure armure){
        super(force, dexterite, vitesse, initiative);
        m_arme = arme;
        m_armure = armure;
    }

    public Arme getM_arme() {
        return m_arme;
    }

    public Armure getM_armure() {
        return m_armure;
    }

    public void setM_arme(Arme m_arme) {
        this.m_arme = m_arme;
    }

    public void setM_armure(Armure m_armure) {
        this.m_armure = m_armure;
    }


}