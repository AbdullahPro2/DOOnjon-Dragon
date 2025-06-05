package Entites.Personnages.Joueurs;

import Entites.Entite;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Personnage;
import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import deroulement.Donjon;
import utils.De;
import utils.Utils;

import java.util.*;

public class Joueur extends Personnage {

    private Arme m_arme;
    private Armure m_armure;
    private Race m_race;
    private ClasseJoueur m_classe;

    public Joueur(String nom, Race race, ClasseJoueur classe, int x, int y){
        super(nom, 100000,x,y); //super(nom, classe.getM_pv(),x,y);
        m_race=race;
        m_classe=classe;
        super.setM_force(super.getM_force()+race.getM_BonusForce());
        super.setM_dexterite(super.getM_dexterite()+race.getM_BonusDexterite());
        super.setM_vitesse(super.getM_vitesse()+race.getM_BonusVitesse());
        m_arme = null;
        m_armure = null;
    }
    @Override
    public String getDisplaySymbol() {
        String nom = getM_nom();
        return nom.length() >= 3 ? nom.substring(0, 3).toUpperCase() : nom.toUpperCase();
    }

    public Armure getM_armure(){
        return m_armure;
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }


    public void equiper(String choix)
    {
        Scanner scanner = new Scanner(System.in);
        if (choix.equals("1"))
        {
            ArrayList<Arme> armes = m_classe.getM_armes();
            for (int i=0; i<armes.size();i++)
            {
                System.out.println(String.valueOf(i+1) + ") " +  armes.get(i).toString());
            }
            int indice = -1;
            boolean valide = false;

            while (!valide) {
                System.out.print("Mettre le numero de l'arme que vous voulez equiper: ");
                String indiceStr = scanner.nextLine();  // Lit une ligne de texte

                try {
                    indice = Integer.parseInt(indiceStr) - 1;
                    if (indice >= 0 && indice < armes.size()) {
                        valide = true;  // On sortira de la boucle au prochain test
                    } else {
                        System.out.println("Veuillez entrer un numéro valide");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ce n'est pas un nombre valide. Essayez encore.");
                }
            }

            // À ce stade, indice est un entier valide entre 0 et armes.size() - 1
            System.out.println("Vous avez choisi l'arme : " + armes.get(indice).getM_nom());
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
            System.out.print("Veuillez equiper une armure\n");
            ArrayList<Armure> armures = m_classe.getM_armures();
            int lenArmures = armures.size();
            if (lenArmures > 0) {
                System.out.print("Veuillez equiper une armure\n");
                for (int i = 0; i < lenArmures; i++) {
                    System.out.println(String.valueOf(i + 1) + ") " + armures.get(i).toString());
                }
                int indice = -1;
                boolean valide = false;

                while (!valide) {
                    System.out.print("Mettre le numero de l'armure que vous voulez equiper: ");
                    String indiceStr = scanner.nextLine();  // Lit une ligne de texte

                    try {
                        indice = Integer.parseInt(indiceStr) - 1;
                        if (indice >= 0 && indice < armures.size()) {
                            valide = true;  // On sortira de la boucle au prochain test
                        } else {
                            System.out.println("Veuillez entrer un numéro valide");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ce n'est pas un nombre valide. Essayez encore.");
                    }
                }
                // À ce stade, indice est un entier valide entre 0 et armes.size() - 1
                System.out.println("Vous avez choisi l'armure : " + armures.get(indice).getM_nom());
                if (m_armure != null) {
                    if (m_armure.getM_typeArmure() == TypeArmure.LOURDE) {
                        super.setM_vitesse(super.getM_vitesse() + 4);
                    }

                }
                m_armure = armures.get(indice);
                if (m_armure.getM_typeArmure() == TypeArmure.LOURDE) {
                    super.setM_vitesse(super.getM_vitesse() - 4);
                }
            }
        }

    }

    @Override
    public void equiperChoix() {
        System.out.println("Joueur : " + this.getM_nom());
        Scanner scanner = new Scanner(System.in);  // Crée un scanner lié au terminal
        System.out.print("Veux-tu equiper une arme (1) ou une armure (2) ? ");
        String choix = scanner.nextLine();  // Lit une ligne de texte
        while (!Objects.equals(choix, "1") && !Objects.equals(choix, "2"))
        {
            System.out.print("Veuillez répondre \"1\" pour une équiper une arme et \"2\" pour une armure: ");
            choix = scanner.nextLine();  // Lit une ligne de texte
        }
        equiper(choix);
    }

    public void equiperDepart() {
        System.out.println("Joueur : " + this.getM_nom());
        System.out.print("Veuillez equiper une arme\n");
        equiper("1");
        equiper("2");
    }

    @Override
    public void attaquer(Donjon donjon) {
        if (m_arme == null) {
            System.out.println("Vous ne pouvez pas attaquer sans arme !");
            return;
        }

        int portee = m_arme.getM_portee();
        List<Monstre> cibles = new ArrayList<>();

        // Filtrage des monstres à portée
        for (Monstre m : donjon.getM_monstreOnGround()) {
            int distance = Math.abs(this.getM_x() - m.getM_x()) + Math.abs(this.getM_y() - m.getM_y());
            if (distance <= portee) {
                cibles.add(m);
            }
        }

        if (cibles.isEmpty()) {
            System.out.println("Aucun monstre à portée (" + portee + "). Vous ne pouvez pas attaquer");
            return;
        }

        // Affichage des cibles
        System.out.println("Cibles à portée (" + portee + ") :");
        for (int i = 0; i < cibles.size(); i++) {
            System.out.println(i + " - " + cibles.get(i).getM_nom() + " " + cibles.get(i).getM_pv() + "/" + cibles.get(i).getM_pvMax());
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
            int pv = cible.getM_pv();
            cible.setM_pv(pv-degats);
            if (cible.getM_pv() <= 0)
            {
                System.out.println("Le monstre " + cible.getM_nom() + " a été tuée !");

                // Retirer la cible de la liste des entités
                boolean removed = donjon.getM_monstreOnGround().remove(cible);
                if (!removed) {
                    System.out.println("Échec de la suppression du monstre : " + cible.getM_nom());
                }
            }
            else
            {
                System.out.println("Le " + nomMonstre + " subit " + degats + " degats");
                System.out.println("Il lui reste " + cible.getM_pv() + " PV");
            }
        }
        else{
            System.out.println("Votre attaque ne perce pas l'armure de " + nomMonstre + "(" + classeArmure + ")");
            System.out.println(nomMonstre + " ne subit aucun degats");
        }
    }

    @Override
    public void ramasser(Donjon donjon) {
        boolean ramasse = false;

        // On parcourt la liste normalement
        for (int i = 0; i < donjon.getM_equipementOnGround().size(); i++) {
            Entite e = donjon.getM_equipementOnGround().get(i);
            if (e.getM_x() == this.getM_x() && e.getM_y() == this.getM_y()) {
                e.ramasser(this);  // Appelle Arme/Armure via le polymorphisme
                donjon.getM_equipementOnGround().remove(i);  // Suppression SANS erreur car on sort juste après
                ramasse = true;
                break;  // Sortir immédiatement : on évite la ConcurrentModificationException
            }
        }

        if (!ramasse) {
            System.out.println("Il n'y a rien à ramasser ici.");
        }
    }


    public ClasseJoueur getM_classe() {
        return m_classe;
    }



    public boolean droitlanceSort()
    {
        //retourne false si le joueur n'a pas accès à des sorts
        //retourne true si le joueur peut au moins lancer un sort
        if (!m_classe.getM_nomClass().equals("Clercs") || !m_classe.getM_nomClass().equals("Magiciens"))
        {
            return false;
        }
        else {
            return true;
        }
    }

    public void lanceSort(Donjon donjon){
        //retourne 1 si le joueur lance Guérison
        //retourne 2 si le joueur lance Boogie Woogie
        //retourne 3 si le joueur lance Arme Magique
        String sortLance="1";
        if (m_classe.getM_nomClass().equals("Magiciens"))
        {
            sortLance = demandeSort();
        }
        String nomSort;
        switch(sortLance)
        {
            case "1":
                nomSort = "Guerison";
                afficherSort(nomSort);
                sortGuerison(donjon);
                break;
            case "2":
                nomSort = "Boogie Woogie";
                afficherSort(nomSort);
                sortBoogieWoogie(donjon);
                break;
            case "3":
                nomSort = "Arme Magique";
                afficherSort(nomSort);
                sortArmeMagique();
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    public void sortGuerison(Donjon donjon){

    }

    public void sortBoogieWoogie(Donjon donjon){

    }

    public void sortArmeMagique(){

    }

    public void afficherSort(String nom)
    {
        System.out.println("Vous lancez " + nom);
    }

    public String demandeSort() {
        Scanner scanner = new Scanner(System.in);
        String numSort = scanner.nextLine().trim();

        while (!numSort.equals("1") && !numSort.equals("2") && !numSort.equals("3")) {
            System.out.println("Quel sort voulez-vous lancer : \n 1) Guérison    2) Boogie Woogie    3) Arme magique");
            System.out.println("Veuillez entrer un nombre valide : 1, 2 ou 3.");
            numSort = scanner.nextLine().trim();
        }

        // Ici on est sûr que numSort est "1", "2", ou "3"
        return numSort;
    }


    public Race getM_race() {
        return m_race;
    }


    public String afficheApresTour()
    {
        return getM_nom() + '\n' +
            "    Vie : " + getM_pv()+"/"+getM_pvMax() + '\n' +
            "    Armure : " + (this.m_armure != null ? this.m_arme.toString() : " Aucun ") + '\n' +
            "    Arm : " + (this.m_arme != null ? this.m_arme.toString() : " Aucun ") + '\n' +
            "    Inventaire  " + inventaireAffichage() + '\n' +
            "    force : " + getM_force() + '\n' +
            "    dexterite : " + getM_dexterite() + '\n' +
            "    vitesse : " + getM_vitesse() + '\n';
    }
    public String inventaireAffichage() {
        StringBuilder str = new StringBuilder();

        // Affichage de l'arme équipée
        if (m_arme != null) {
            str.append("Arme équipée : ").append(m_arme.getM_nom()).append("\n");
        } else {
            str.append("Aucune arme équipée.\n");
        }

        // Affichage des autres armes
        List<Arme> armes = m_classe.getM_armes();
        if (!armes.isEmpty()) {
            str.append("Armes dans l'inventaire :\n");
            int i = 1;
            for (Arme arme : armes) {
                if (m_arme == null || !Objects.equals(arme.getM_nom(), m_arme.getM_nom())) {
                    str.append("  [").append(i++).append("] ").append(arme.getM_nom()).append("\n");
                }
            }
            if (i == 1) str.append("  (aucune autre arme)\n");
        } else {
            str.append("Aucune arme dans l'inventaire.\n");
        }

        // Affichage de l'armure équipée
        if (m_armure != null) {
            str.append("Armure équipée : ").append(m_armure.getM_nom()).append("\n");
        } else {
            str.append("Aucune armure équipée.\n");
        }

        // Affichage des autres armures
        List<Armure> armures = m_classe.getM_armures();
        if (!armures.isEmpty()) {
            str.append("Armures dans l'inventaire :\n");
            int j = 1;
            for (Armure armure : armures) {
                if (m_armure == null || !Objects.equals(armure.getM_nom(), m_armure.getM_nom())) {
                    str.append("  [").append(j++).append("] ").append(armure.getM_nom()).append("\n");
                }
            }
            if (j == 1) str.append("  (aucune autre armure)\n");
        } else {
            str.append("Aucune armure dans l'inventaire.\n");
        }

        return str.toString();
    }
    @Override
    public String toString() {
        return super.getM_nom() + '\n' +
            "Vie : " + getM_pv() + '\n' +
            "Armure : " + (this.m_arme != null ? this.m_arme.toString() : " ") + '\n' +
            "race : " + m_race.toString() + '\n' +
            "classe : " + m_classe.toString() + '\n' +
            "force : " + getM_force() + '\n' +
            "dexterite : " + getM_dexterite() + '\n' +
            "vitesse : " + getM_vitesse() + '\n';
    }

    @Override
    public void actionAffichage(int actionsRestantes)
    {
        System.out.println("Actions restantes : " + actionsRestantes);
        System.out.println("Choisissez une action :");
        System.out.println("1 - Se déplacer");
        System.out.println("2 - Attaquer");
        System.out.println("3 - S'équiper");
        System.out.println("4 - Ramasser un équipement");
        if (droitlanceSort())
        {
            System.out.println("5 - lancer un sort");
        }
    }
    @Override
    public void executerTour(Donjon donjon) {
        Scanner scanner = new Scanner(System.in);
        int actionsRestantes = 3;

        System.out.println("\n=== Tour de " + getM_nom() + " ===");

        while (actionsRestantes > 0 && getM_pv() > 0 && !Utils.joueurEstMort(donjon.getM_joueurOnGround())) {
            actionAffichage(actionsRestantes);
            System.out.print("Votre choix : ");
            String choix = scanner.nextLine().trim();
            switch (choix) {
                case "1":
                    System.out.println("Déplacement possible pour " + getM_nom() + " " + getM_vitesse() / 3 + " cases");
                    SeDeplacer(donjon);
                    break;
                case "2":
                    attaquer(donjon);
                    break;
                case "3":
                    equiperChoix();
                    break;
                case "4":
                    ramasser(donjon);
                    break;
                case "5":
                    lanceSort(donjon);
                default:
                    System.out.println("Choix invalide.");
                    continue;
            }


            actionsRestantes--;
            donjon.display();
            System.out.println(afficheApresTour());
        }
        System.out.println("Fin du tour de " + getM_nom());
    }

    public String afficheTourInformation()
    {
       return " " + getM_nom() + " ( " + getM_race().getM_nomRace() + " " + getM_classe()
            .getM_nomClass() + ", " + getM_pv() + "/" + getM_pvMax() + " ) ";
    }
    @Override
    public void retirerDuDonjon(Donjon donjon) {
        donjon.getM_joueurOnGround().remove(this);
    }
}