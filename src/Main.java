import Personnage.Joueur.ClassePersonnage;
import Personnage.Joueur.Joueur;
import Personnage.Joueur.Race;
import equipement.Arme;
import equipement.Armure;
import equipement.TypeArme;
import equipement.TypeArmure;
import java.sql.SQLOutput;
import utils.De;
import utils.Donjon;

public class Main {
    public static void main(String args[]){
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        // toutes les possibilite de ARME:
        Arme baton = new Arme(TypeArme.COURANTECORPS,"baton",new De(1,6),1);
        Arme masseArmes = new Arme(TypeArme.COURANTECORPS,"masse d'armes",new De(1,6),1);
        Arme epeeLongue = new Arme(TypeArme.COURANTEGUERRE,"épée longue,",new De(1,8),1);
        Arme rapiere = new Arme(TypeArme.COURANTEGUERRE,"rapière",new De(1,8),1);
        Arme arbaleteLegere = new Arme(TypeArme.DISTANCE,"arbalète légère",new De(1,8),16);
        Arme fronde = new Arme(TypeArme.DISTANCE,"fronde",new De(1,4),6);
        Arme arcCourt = new Arme(TypeArme.DISTANCE,"arc court",new De(1,6),16);
        // toutes les possibilite de ARMURE:
        Armure armureEcailles = new Armure(TypeArmure.LEGERE, "armure d'écailles",9);
        Armure demiPlate = new Armure(TypeArmure.LEGERE, "demi-plate",9);
        Armure cotteMailles = new Armure(TypeArmure.LOURDE, "cotte de mailles",11);
        Armure harnois = new Armure(TypeArmure.LOURDE, "harnois",12);

        Narrateur narrateur = new Narrateur();
        Donjon Donjon1 = new Donjon();
        Joueur joueur1 = new Joueur(10, 10,10,"Thomas",10,baton,armureEcailles, Race.Elfe(),
            ClassePersonnage.Clercs());
        Joueur joueur2 = new Joueur(20, 20,20,"Abdullah",20,masseArmes,demiPlate, Race.Humain(),
            ClassePersonnage.Guerriers());
        Joueur joueur3 = new Joueur(30, 30,30,"Valentin",30,epeeLongue,cotteMailles, Race.Nain(),
            ClassePersonnage.Magiciens());
        Joueur joueur4 = new Joueur(40, 40,40,"Wilson",40,rapiere,harnois, Race.Halfelin(),
            ClassePersonnage.Roublards());
    }
}