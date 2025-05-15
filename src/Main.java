import Personnage.Joueur.ClassePersonnage;
import Personnage.Joueur.Joueur;
import Personnage.Joueur.Race;
import Personnage.Monstre.Monstre;
import Personnage.Monstre.RaceMonstre;
import equipement.Arme;
import equipement.Armure;
import equipement.TypeArme;
import equipement.TypeArmure;
import utils.De;
import utils.Donjon;

public class Main {
    public static void main(String args[]){
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        // toutes les possibilite de ARME:
        Arme baton = new Arme(TypeArme.COURANTECORPS,"baton",new De(1,6),1,-1,-1);
        Arme masseArmes = new Arme(TypeArme.COURANTECORPS,"masse d'armes",new De(1,6),1,-1,-1);
        Arme epeeLongue = new Arme(TypeArme.COURANTEGUERRE,"épée longue,",new De(1,8),1,-1,-1);
        Arme rapiere = new Arme(TypeArme.COURANTEGUERRE,"rapière",new De(1,8),1,-1,-1);
        Arme arbaleteLegere = new Arme(TypeArme.DISTANCE,"arbalète légère",new De(1,8),16,-1,-1);
        Arme fronde = new Arme(TypeArme.DISTANCE,"fronde",new De(1,4),6,-1,-1);
        Arme arcCourt = new Arme(TypeArme.DISTANCE,"arc court",new De(1,6),16,-1,-1);
        // toutes les possibilite de ARMURE:
        Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles",9,-1,-1);
        Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate",9,-1,-1);
        Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles",11,-1,-1);
        Armure harnois = new Armure(TypeArmure.LOURDE, "harnois",12,-1,-1);

        Narrateur narrateur = new Narrateur();
        Donjon Donjon1 = new Donjon();
        Joueur joueur1 = new Joueur("Thomas",Race.Elfe(),ClassePersonnage.Clercs(),10,10);
        Joueur joueur2 = new Joueur("Abdullah",Race.Humain(), ClassePersonnage.Guerriers(),12,12);
        Joueur joueur3 = new Joueur("Valentin",Race.Nain(), ClassePersonnage.Magiciens(),14,14);
        Joueur joueur4 = new Joueur("Wilson",Race.Halfelin(), ClassePersonnage.Roublards(),16,16);

        // Monstres
        Monstre m1 = new Monstre(RaceMonstre.Dragon(), 1, 5,5);
        Monstre m2 = new Monstre(RaceMonstre.Demogorgon(), 2, 20,20);

        Donjon1.addEntityOnGround(joueur1);
        Donjon1.addEntityOnGround(joueur2);
        Donjon1.addEntityOnGround(joueur3);
        Donjon1.addEntityOnGround(joueur4);
        Donjon1.addEntityOnGround(m1);
        Donjon1.addEntityOnGround(m2);

        Donjon1.DonjonGround();

        joueur1.setPosition(7,7);
        Donjon1.DonjonGround();

        System.out.println(joueur1.toString());
        System.out.println(joueur2.toString());
        System.out.println(joueur3.toString());
        System.out.println(joueur4.toString());

        System.out.println(m1.toString());
        System.out.println(m2.toString());


    }
}