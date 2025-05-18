import Entites.Obstacle;
import Entites.Personnages.Joueurs.ClasseJoueur;
import Entites.Personnages.Joueurs.Joueur;
import Entites.Personnages.Joueurs.Race;
import Entites.Personnages.Monstres.Monstre;
import Entites.Personnages.Monstres.RaceMonstre;
import Entites.Equipements.Arme;
import Entites.Equipements.Armure;
import Entites.Equipements.TypeArme;
import Entites.Equipements.TypeArmure;
import utils.De;
import utils.Donjon;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        // toutes les possibilites d' ARME:
        Arme baton = new Arme(TypeArme.COURANTE,"baton",new De(1,6),1,-1,-1);
        Arme masseArmes = new Arme(TypeArme.COURANTE,"masse d'armes",new De(1,6),1,-1,-1);
        Arme epeeLongue = new Arme(TypeArme.GUERRE,"épée longue,",new De(1,8),1,-1,-1);
        Arme rapiere = new Arme(TypeArme.GUERRE,"rapière",new De(1,8),1,-1,-1);
        Arme arbaleteLegere = new Arme(TypeArme.DISTANCE,"arbalète légère",new De(1,8),16,-1,-1);
        Arme fronde = new Arme(TypeArme.DISTANCE,"fronde",new De(1,4),6,-1,-1);
        Arme arcCourt = new Arme(TypeArme.DISTANCE,"arc court",new De(1,6),16,-1,-1);
        // toutes les possibilites d' ARMURE:
        Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles",9,-1,-1);
        Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate",9,-1,-1);
        Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles",11,-1,-1);
        Armure harnois = new Armure(TypeArmure.LOURDE, "harnois",12,-1,-1);

        System.out.println("Entrez le numero du donjon dans lequel vous voulez entrer : ");
        System.out.println("Donjon1 (facile)     Donjon2 (moyen)     Donjon3 (difficile)");
        Scanner scanner = new Scanner(System.in);  // Crée un scanner lié au terminal
        String choix = scanner.nextLine();  // Lit une ligne de texte
        while (!Objects.equals(choix, "1") && !Objects.equals(choix, "2") && !Objects.equals(choix, "3"))
        {
            System.out.print("Veuillez répondre \"1\", \"2\" ou \"3\"");
            choix = scanner.nextLine();  // Lit une ligne de texte
        }
        // Lancer le donjon correspondant
        switch (choix) {
            case "1":
                creerDonjon1();
                break;
            case "2":
                creerDonjon2();
                break;
            case "3":
                creerDonjon3();
                break;
        }

    }




    public static void creerDonjon1()
    {
        Donjon Donjon1 = new Donjon(20, 20);
        Joueur joueur1 = new Joueur("Thomas",Race.Elfe(), ClasseJoueur.Clercs(),19,10);
        Joueur joueur2 = new Joueur("Abdullah",Race.Humain(), ClasseJoueur.Guerriers(),19,12);
        Joueur joueur3 = new Joueur("Valentin",Race.Nain(), ClasseJoueur.Magiciens(),19,14);
        Joueur joueur4 = new Joueur("Wilson",Race.Halfelin(), ClasseJoueur.Roublards(),19,16);

        // Monstres
        Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 3,3);
        Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 3,13);

        // Obstacles
        Obstacle o1 = new Obstacle(10,9);
        Obstacle o2 = new Obstacle(10,10);
        Obstacle o3 = new Obstacle(9,10);
        Obstacle o4 = new Obstacle(9,9);

        Donjon1.addEntityOnGround(joueur1);
        Donjon1.addEntityOnGround(joueur2);
        Donjon1.addEntityOnGround(joueur3);
        Donjon1.addEntityOnGround(joueur4);
        Donjon1.addEntityOnGround(m1);
        Donjon1.addEntityOnGround(m2);
        Donjon1.addEntityOnGround(o1);
        Donjon1.addEntityOnGround(o2);
        Donjon1.addEntityOnGround(o3);
        Donjon1.addEntityOnGround(o4);
    }

    public static void creerDonjon2()
    {
        Donjon Donjon1 = new Donjon(25, 15);
        Joueur joueur1 = new Joueur("Thomas",Race.Elfe(), ClasseJoueur.Clercs(),10,10);
        Joueur joueur2 = new Joueur("Abdullah",Race.Humain(), ClasseJoueur.Guerriers(),12,12);
        Joueur joueur3 = new Joueur("Valentin",Race.Nain(), ClasseJoueur.Magiciens(),14,14);
        Joueur joueur4 = new Joueur("Wilson",Race.Halfelin(), ClasseJoueur.Roublards(),16,16);

        // Monstres
        Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 5,5);
        Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 20,20);
        Monstre m3 = new Monstre(RaceMonstre.Dragon(), 2, 5,5);

        Donjon1.addEntityOnGround(joueur1);
        Donjon1.addEntityOnGround(joueur2);
        Donjon1.addEntityOnGround(joueur3);
        Donjon1.addEntityOnGround(joueur4);
        Donjon1.addEntityOnGround(m1);
        Donjon1.addEntityOnGround(m2);
    }

}