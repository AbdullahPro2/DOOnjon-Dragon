package Personnage.Joueur;

import Personnage.Personnage;
import equipement.Arme;
import equipement.Armure;

public class Joueur extends Personnage {

    private Arme m_arme;
    private Armure m_armure;
    private Race m_race;
    private ClassePersonnage m_classe;

    public Joueur(String nom, Race race, ClassePersonnage classe ){
        super(nom, classe.getM_pv());
        m_race=race;
        m_classe=classe;
        super.setM_force(super.getM_force()+race.getM_BonusForce());
        super.setM_dexterite(super.getM_dexterite()+race.getM_BonusDexterite());
        super.setM_vitesse(super.getM_vitesse()+race.getM_BonusVitesse());
    }

    public Race getM_race() {return m_race;}

    public ClassePersonnage getM_classe() {return m_classe;}

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
    @Override
    public String toString() {
        return "Joueur{" +
            "nom='" + super.getM_nom() + '\'' +
            ", race=" + m_race.toString() +
            ", classe=" + m_classe.toString() +
            ", force=" + getM_force() +
            ", dexterite=" + getM_dexterite() +
            ", vitesse=" + getM_vitesse() +
            ", pv=" + getM_pv() +
            '}';
    }
}