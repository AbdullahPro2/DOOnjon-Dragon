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
        Main.creerDonjon1();
        Main.creerDonjon2();
        Main.creerDonjon3();
    }

    public static void creerDonjon1()
    {
        Donjon Donjon1 = new Donjon(20, 20); // 20x20 grid

        // Players - Bottom side of center
        Joueur joueur1 = new Joueur("Thomas", Race.Elfe(), ClasseJoueur.Clercs(), 9, 7);
        Joueur joueur2 = new Joueur("Abdullah", Race.Humain(), ClasseJoueur.Guerriers(), 9, 8);
        Joueur joueur3 = new Joueur("Valentin", Race.Nain(), ClasseJoueur.Magiciens(), 10, 7);
        Joueur joueur4 = new Joueur("Wilson", Race.Halfelin(), ClasseJoueur.Roublards(), 10, 8);

        // Monsters - Top side of center
        Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 9, 11);
        Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 1, 10, 11);

        // Obstacles - Middle surrounding combat zone
        Obstacle o1 = new Obstacle(8, 9);
        Obstacle o2 = new Obstacle(8, 10);
        Obstacle o3 = new Obstacle(11, 9);
        Obstacle o4 = new Obstacle(11, 10);

        // Weapons on sides and corners
        Arme baton = new Arme(TypeArme.COURANTE, "baton", new De(1, 6), 1, 0, 0);
        Arme masseArmes = new Arme(TypeArme.COURANTE, "masse d'armes", new De(1, 6), 1, 0, 19);
        Arme epeeLongue = new Arme(TypeArme.GUERRE, "épée longue", new De(1, 8), 1, 19, 0);
        Arme rapiere = new Arme(TypeArme.GUERRE, "rapière", new De(1, 8), 1, 19, 19);
        Arme arbaleteLegere = new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16, 0, 10);
        Arme fronde = new Arme(TypeArme.DISTANCE, "fronde", new De(1, 4), 6, 19, 10);
        Arme arcCourt = new Arme(TypeArme.DISTANCE, "arc court", new De(1, 6), 16, 10, 0);

        // Armor on diagonals
        Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles", 9, 1, 1);
        Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate", 9, 1, 18);
        Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles", 11, 18, 1);
        Armure harnois = new Armure(TypeArmure.LOURDE, "harnois", 12, 18, 18);

        // Add everything to map
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
        Donjon1.addEntityOnGround(baton);
        Donjon1.addEntityOnGround(masseArmes);
        Donjon1.addEntityOnGround(epeeLongue);
        Donjon1.addEntityOnGround(rapiere);
        Donjon1.addEntityOnGround(arbaleteLegere);
        Donjon1.addEntityOnGround(fronde);
        Donjon1.addEntityOnGround(arcCourt);
        Donjon1.addEntityOnGround(armureEcailles);
        Donjon1.addEntityOnGround(demiPlate);
        Donjon1.addEntityOnGround(cotteMailles);
        Donjon1.addEntityOnGround(harnois);

        // Show map
        Donjon1.DonjonGround();
    }

    public static void creerDonjon2() {
        Donjon Donjon2 = new Donjon(20, 20);

        // Players more spread out
        Joueur j1 = new Joueur("Thomas", Race.Elfe(), ClasseJoueur.Clercs(), 18, 5);
        Joueur j2 = new Joueur("Abdullah", Race.Humain(), ClasseJoueur.Guerriers(), 18, 8);
        Joueur j3 = new Joueur("Valentin", Race.Nain(), ClasseJoueur.Magiciens(), 18, 11);
        Joueur j4 = new Joueur("Wilson", Race.Halfelin(), ClasseJoueur.Roublards(), 18, 14);

        // Monsters closer & stronger
        Donjon2.addEntityOnGround(new Monstre(RaceMonstre.Dragon(), 2, 10, 7));
        Donjon2.addEntityOnGround(new Monstre(RaceMonstre.Dragon(), 2, 10, 9));
        Donjon2.addEntityOnGround(new Monstre(RaceMonstre.Demogorgon(), 2, 10, 11));
        Donjon2.addEntityOnGround(new Monstre(RaceMonstre.Demogorgon(), 2, 10, 13));

        // Maze-like Obstacles
        for (int i = 5; i <= 15; i++) {
            if (i % 2 == 0) Donjon2.addEntityOnGround(new Obstacle(i, 10));
            if (i % 3 == 0) Donjon2.addEntityOnGround(new Obstacle(i, 12));
        }

        // Better Weapons
        Donjon2.addEntityOnGround(new Arme(TypeArme.GUERRE, "épée magique", new De(2, 6), 1, 2, 2));
        Donjon2.addEntityOnGround(new Arme(TypeArme.DISTANCE, "arbalète lourde", new De(1, 10), 20, 2, 17));

        // Better Armor
        Donjon2.addEntityOnGround(new Armure(TypeArmure.LOURDE, "armure magique", 13, 17, 2));
        Donjon2.addEntityOnGround(new Armure(TypeArmure.LEGERE, "cuir renforcé", 10, 17, 17));

        // Add players
        Donjon2.addEntityOnGround(j1);
        Donjon2.addEntityOnGround(j2);
        Donjon2.addEntityOnGround(j3);
        Donjon2.addEntityOnGround(j4);

        Donjon2.DonjonGround();
    }
    public static void creerDonjon3() {
        Donjon Donjon3 = new Donjon(20, 20);

        // Players surrounded!
        Joueur j1 = new Joueur("Thomas", Race.Elfe(), ClasseJoueur.Clercs(), 10, 10);
        Joueur j2 = new Joueur("Abdullah", Race.Humain(), ClasseJoueur.Guerriers(), 10, 11);
        Joueur j3 = new Joueur("Valentin", Race.Nain(), ClasseJoueur.Magiciens(), 11, 10);
        Joueur j4 = new Joueur("Wilson", Race.Halfelin(), ClasseJoueur.Roublards(), 11, 11);

        // Monsters from all sides
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Dragon(), 3, 9, 9));
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Dragon(), 3, 9, 12));
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Demogorgon(), 3, 12, 9));
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Demogorgon(), 3, 12, 12));
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Demogorgon(), 3, 10, 8));
        Donjon3.addEntityOnGround(new Monstre(RaceMonstre.Dragon(), 3, 11, 13));

        // Obstacle trap area
        for (int i = 8; i <= 13; i++) {
            Donjon3.addEntityOnGround(new Obstacle(8, i));
            Donjon3.addEntityOnGround(new Obstacle(13, i));
            Donjon3.addEntityOnGround(new Obstacle(i, 8));
            Donjon3.addEntityOnGround(new Obstacle(i, 13));
        }

        // Powerful gear in dangerous corners
        Donjon3.addEntityOnGround(new Arme(TypeArme.GUERRE, "épée légendaire", new De(2, 8), 1, 1, 1));
        Donjon3.addEntityOnGround(new Arme(TypeArme.DISTANCE, "arc elfique", new De(2, 6), 30, 18, 1));
        Donjon3.addEntityOnGround(new Armure(TypeArmure.LOURDE, "harnois sacré", 15, 1, 18));
        Donjon3.addEntityOnGround(new Armure(TypeArmure.LEGERE, "robe enchantée", 12, 18, 18));

        // Add players
        Donjon3.addEntityOnGround(j1);
        Donjon3.addEntityOnGround(j2);
        Donjon3.addEntityOnGround(j3);
        Donjon3.addEntityOnGround(j4);

        Donjon3.DonjonGround();
    }


}