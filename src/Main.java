import Entites.*;
import Entites.Equipements.*;
import Entites.Personnages.Joueurs.*;
import Entites.Personnages.Monstres.*;
import deroulement.*;
import utils.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Bienvenue dans DOOnjon et Dragons");
        StartGame sg = new StartGame();
        sg.startGame();
    }
}