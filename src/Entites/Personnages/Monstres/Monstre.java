package Entites.Personnages.Monstres;

import Entites.Entite;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Personnage;
import utils.De;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            ", position=(" + getM_x() + ", " + getM_y() + ")" +
            ", pv=" + getM_pv() +
            '}';
    }
    @Override
    public String getDisplaySymbol() {
        String nom = getM_race().getM_nom();
        return nom.equals("Dragon") ? " X(" : " X^";
    }

    public RaceMonstre getM_race() {
        return m_race;
    }

    @Override
    public boolean estCiblePourJoueur() {
        return true;
    }

    @Override
    public void attaquer() {
        int portee = m_race.getM_portee();
        List<Joueur> cibles = new ArrayList<>();

        // Filtrage des monstres à portée
        for (Entite e : Entite.getM_entites()) {
            if (e != this && e.estCiblePourMonstre()) {
                int distance = Math.abs(this.getM_x() - e.getM_x()) + Math.abs(this.getM_y() - e.getM_y());
                if (distance <= portee) {
                    cibles.add((Joueur) e);
                }
            }
        }

        if (cibles.isEmpty()) {
            System.out.println("Aucun joueur à portée (" + portee + "). Vous ne pouvez pas attaquer");
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
        Joueur cible = cibles.get(choix);
        String nomJoueur = cible.getM_nom();
        System.out.println("Vous attaquez le joueur : " + nomJoueur);

        // Phase d'attaque

        De deAttaque = new De(1,20);
        int resultDe = deAttaque.lanceDePrint();
        int degatsArmure = resultDe + m_race.getM_degats();
        System.out.println("Votre attaque est de " + resultDe + " + " + getM_race().getM_degats() + " = " + degatsArmure);
        int classeArmure = cible.getM_armure().getM_classeArmure();
        if (degatsArmure > classeArmure)
        {
            System.out.println("Votre attaque perce l'armure de " + nomJoueur + "(" + classeArmure + ")");
            System.out.println("Vous lancez votre dé de dégats");
            int degats = m_race.getM_deDegats().lanceDePrint();
            cible.setM_pv(cible.getM_pv()-degats);
            if (cible.getM_pv() <= 0)
            {
                System.out.println("La cible " + cible + " a été tuée !");

                // Retirer la cible de la liste des entités
                Entite.getM_entites().remove(cible);
            }
            else
            {
                System.out.println("Le " + nomJoueur + " subit " + degats + " degats");
                System.out.println("Il lui reste " + cible.getM_pv() + " PV");
            }
        }
        else{
            System.out.println("Votre attaque ne perce pas l'armure de " + nomJoueur + "(" + classeArmure + ")");
            System.out.println(nomJoueur + "ne subit aucun degats");
        }
    }

    @Override
    public boolean isMonstre() {
        return true;
    }
}
