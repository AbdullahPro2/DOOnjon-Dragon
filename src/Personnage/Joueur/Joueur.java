package Personnage.Joueur;

import Personnage.Personnage;
import equipement.Arme;
import equipement.Armure;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void Equiper()
    {
        Scanner scanner = new Scanner(System.in);  // Crée un scanner lié au terminal
        System.out.print("Veux-tu equiper une arme (1) ou une armue (2) ? ");
        String choix = scanner.nextLine();  // Lit une ligne de texte
        while (choix != "1" || choix != "2")
        {
            System.out.print("Veuillez répondre \"1\" pour une équiper une arme et \"2\" pour une armure");
            choix = scanner.nextLine();  // Lit une ligne de texte
        }
        if (choix == "1")
        {
            ArrayList<Arme> armes = m_classe.getM_armes();
            for (int i=0; i<armes.size();i++)
            {
                System.out.println(String.valueOf(i+1) + ") " +  armes.get(i).toString());
            }
            int indice = -1;
            System.out.print("Mettre le numero de l'arme que vous voulez equiper");
            String indiceStr = scanner.nextLine();  // Lit une ligne de texte
            try {
                indice = Integer.parseInt(indiceStr)-1;
            }
            catch(NumberFormatException e){
                while(indice == -1) {
                    System.out.print("Mettez s'il vous plait un numero valide");
                    indiceStr = scanner.nextLine();  // Lit une ligne de texte
                    indice = Integer.parseInt(indiceStr)-1;
                }
            }
            m_arme = armes.get(indice);
        }
        else
        {
            ArrayList<Armure> armures = m_classe.getM_armures();
            for (int i=0; i<armures.size();i++)
            {
                System.out.println(String.valueOf(i+1) + ") " +  armures.get(i).toString());
            }
            int indice = -1;
            System.out.print("Mettre le numero de l'armure que vous voulez equiper");
            String indiceStr = scanner.nextLine();  // Lit une ligne de texte
            try {
                indice = Integer.parseInt(indiceStr)-1;
            }
            catch(NumberFormatException e){
                while(indice == -1) {
                    System.out.print("Mettez s'il vous plait un numero valide");
                    indiceStr = scanner.nextLine();  // Lit une ligne de texte
                    indice = Integer.parseInt(indiceStr)-1;
                }
            }
            m_armure = armures.get(indice);
        }

    }

    public void commenter()
    {

    }

    public void commenterMj()
    {

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