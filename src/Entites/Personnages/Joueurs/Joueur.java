package Entites.Personnages.Joueurs;

import Entites.Entite;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import utils.De;

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

    public Armure getM_armure(){
        return m_armure;
    }

    @Override
    public boolean estCiblePourMonstre() {
        return true;
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
                if (m_armure.getM_typeArmure() == TypeArmure.LOURDE)
                {
                    super.setM_vitesse(super.getM_vitesse()+4);
                }

            }
            m_armure = armures.get(indice);
            if (m_armure.getM_typeArmure() == TypeArmure.LOURDE)
            {
                super.setM_vitesse(super.getM_vitesse()-4);
            }
        }

    }

    @Override
    public void attaquer() {
        if (m_arme == null) {
            System.out.println("Vous ne pouvez pas attaquer sans arme !");
            return;
        }

        int portee = m_arme.getM_portee();
        List<Monstre> cibles = new ArrayList<>();

        // Filtrage des monstres à portée
        for (Entite e : Entite.getM_entites()) {
            if (e != this && e.estCiblePourJoueur()) {
                int distance = Math.abs(this.getM_x() - e.getM_x()) + Math.abs(this.getM_y() - e.getM_y());
                if (distance <= portee) {
                    cibles.add((Monstre) e);
                }
            }
        }

        if (cibles.isEmpty()) {
            System.out.println("Aucun monstre à portée (" + portee + "). Vous ne pouvez pas attaquer");
            return;
        }

        // Affichage des cibles
        System.out.println("Cibles à portée (" + portee + ") :");
        for (int i = 0; i < cibles.size(); i++) {
            System.out.println(i + " - " + cibles.get(i).getM_nom() + " " + cibles.get(i).getM_race().getM_pv() + "/" + cibles.get(i).getM_pvMax());
        }

        // Saisie du choix de l'utilisateur
        int taille = cibles.size();
        int choix;
        if (taille == 1)
        {
            choix = 0;
        }
        else {
            Scanner scanner = new Scanner(System.in);
            choix = -1;
            while (choix < 0 || choix >= taille) {
                System.out.print("Choisissez une cible à attaquer (0 à " + (taille - 1) + ") : ");
                if (scanner.hasNextInt()) {
                    choix = scanner.nextInt();
                } else {
                    scanner.next(); // Consomme l'entrée invalide
                }
            }
        }
        Monstre cible = cibles.get(choix);
        String nomMonstre = cible.getM_nom();
        System.out.println("Vous attaquez le monstre : " + nomMonstre);

        // Phase d'attaque

        De deAttaque = new De(1,20);
        int degatsArmure;
        int resultDe = deAttaque.lanceDePrint();
        if (m_arme.getM_typeArme()==TypeArme.DISTANCE)
        {
            degatsArmure = resultDe + getM_dexterite();
            System.out.println("Votre attaque est de " + resultDe + " + " + getM_dexterite() + "(dexterite) = " + degatsArmure);
        }
        else{
            degatsArmure = resultDe + getM_force();
            System.out.println("Votre attaque est de " + resultDe + " + " + getM_force() + "(force) = " + degatsArmure);
        }
        int classeArmure = cible.getM_race().getM_classeArmure();
        if (degatsArmure > classeArmure)
        {
            System.out.println("Votre attaque perce l'armure de " + nomMonstre + "(" + classeArmure + ")");
            System.out.println("Vous lancez votre dé de dégats");
            int degats = m_arme.getM_degats().lanceDePrint();

            cible.setM_pv(cible.getM_pv()-degats);
            if (cible.getM_pv() <= 0)
            {
                System.out.println("La cible " + cible + " a été tuée !");

                // Retirer la cible de la liste des entités
                Entite.getM_entites().remove(cible);
            }
            else
            {
                System.out.println("Le " + nomMonstre + " subit " + degats + " degats");
                System.out.println("Il lui reste " + cible.getM_race().getM_pv() + " PV");
            }
        }
        else{
            System.out.println("Votre attaque ne perce pas l'armure de " + nomMonstre + "(" + classeArmure + ")");
            System.out.println(nomMonstre + "ne subit aucun degats");
        }
    }

    public void ramasser() {
        Iterator<Entite> iterator = Entite.getM_entites().iterator();

        // Parcours de toutes les entités dans le jeu
        while (iterator.hasNext()) {
            Entite e = iterator.next();

            // Vérifie si l'entité est une Arme ou une Armure et si elle se trouve aux mêmes coordonnées
            if ((e instanceof Arme || e instanceof Armure) && e.getM_x() == this.getM_x() && e.getM_y() == this.getM_y()) {

                // Si c'est une Arme, l'ajouter à l'inventaire du joueur
                if (e instanceof Arme) {
                    this.m_classe.getM_armes().add((Arme) e);
                    System.out.println("Arme ramassée : " + e);
                }

                // Si c'est une Armure, l'ajouter à l'inventaire du joueur
                if (e instanceof Armure) {
                    this.m_classe.getM_armures().add((Armure) e);
                    System.out.println("Armure ramassée : " + e);
                }

                // Une fois ramassée, on peut retirer l'arme ou l'armure du jeu
                iterator.remove(); // Supprimer l'élément de la liste de manière sécurisée
                break; // On sort de la boucle après avoir ramassé un objet
            }
        }

        // Si aucun objet n'a été ramassé
        System.out.println("Il n'y a pas d'arme à ramasser");
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