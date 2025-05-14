package Personnage.Joueur;

import Personnage.Personnage;
import equipement.Arme;
import equipement.Armure;

public class Joueur extends Personnage {

    private Arme m_arme;
    private Armure m_armure;
    private Race m_race;
    private ClassePersonnage m_classe;

    public Joueur(int force, int dexterite, int vitesse, String nom, int initiative, Arme arme, Armure armure, Race race, ClassePersonnage classe ){
        super(nom, classe.getM_pv(), force, dexterite, vitesse, initiative);
        m_arme = arme;
        m_armure = armure;
        m_race=race;
        m_classe=classe;
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