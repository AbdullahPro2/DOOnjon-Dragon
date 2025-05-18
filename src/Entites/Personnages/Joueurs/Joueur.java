package Entites.Personnages.Joueurs;

import Entites.Personnages.Personnage;
import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;

import java.util.*;

public class Joueur extends Personnage {

    private Arme m_arme;
    private Armure m_armure;
    private Race m_race;
    private ClasseJoueur m_classe;

    public Joueur(String nom, Race race, ClasseJoueur classe, int x, int y){
        super(nom, classe.getM_pv(),x,y);
        m_race=race;
        m_classe=classe;
        super.setM_force(super.getM_force()+race.getM_BonusForce());
        super.setM_dexterite(super.getM_dexterite()+race.getM_BonusDexterite());
        super.setM_vitesse(super.getM_vitesse()+race.getM_BonusVitesse());
        m_arme = null;
        m_armure = null;
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }


    public void Equiper()
    {
        Scanner scanner = new Scanner(System.in);  // Crée un scanner lié au terminal
        System.out.print("Veux-tu equiper une arme (1) ou une armue (2) ? ");
        String choix = scanner.nextLine();  // Lit une ligne de texte
        while (!Objects.equals(choix, "1") && !Objects.equals(choix, "2"))
        {
            System.out.print("Veuillez répondre \"1\" pour une équiper une arme et \"2\" pour une armure");
            choix = scanner.nextLine();  // Lit une ligne de texte
        }
        if (choix.equals("1"))
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
            if (m_arme!=null)
            {
                if (m_arme.getM_typeArme() == TypeArme.GUERRE)
                {
                    super.setM_force(super.getM_force()-4);
                    super.setM_vitesse(super.getM_vitesse()+2);
                }

            }
            m_arme = armes.get(indice);
            if (m_arme.getM_typeArme() == TypeArme.GUERRE)
            {
                super.setM_force(super.getM_force()+4);
                super.setM_vitesse(super.getM_vitesse()-2);
            }
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
            if (m_armure!=null)
            {
                if (m_armure.getTypeArmure() == TypeArmure.LOURDE)
                {
                    super.setM_vitesse(super.getM_vitesse()+4);
                }

            }
            m_armure = armures.get(indice);
            if (m_armure.getTypeArmure() == TypeArmure.LOURDE)
            {
                super.setM_vitesse(super.getM_vitesse()-4);
            }
        }

    }

    public void attaquer(){

    }

    public void ramasser(){

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