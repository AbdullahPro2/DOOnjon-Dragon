package Personnage.Joueur;

import equipement.*;
import java.util.ArrayList;
import java.util.List;
import utils.De;

public class ClassePersonnage {
  private String m_nomClass;
  private int m_pv;
  private ArrayList<Arme> m_armes;
  private ArrayList<Armure> m_armures;

  private ClassePersonnage(String nom, int pv, ArrayList<Arme> armes, ArrayList<Armure> armures) {
    this.m_nomClass = nom;
    this.m_pv = pv;
    this.m_armes = armes;
    this.m_armures = armures;
  }

  public int getM_pv() {
    return m_pv;
  }

  public ArrayList<Arme> getM_armes() {
    return m_armes;
  }

  public ArrayList<Armure> getM_armures() {
    return m_armures;
  }

  public String getM_nomClass() {
    return m_nomClass;
  }

  public static ClassePersonnage Clercs() {
    return new ClassePersonnage(
        "Clercs",
        16,
        new ArrayList<>(List.of(
            new Arme(TypeArme.COURANTECORPS, "masse d'armes", new De(1, 6), 1),
            new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16)
        )),
        new ArrayList<>(List.of(
            new Armure(TypeArmure.LEGERE, "armure d'écailles", 9)
        ))
    );
  }
  public static ClassePersonnage Guerriers() {
    return new ClassePersonnage(
        "Guerriers",
        20,
        new ArrayList<>(List.of(
            new Arme(TypeArme.GUERRE, "épée longue", new De(1, 8), 1),
            new Arme(TypeArme.DISTANCE, "arbalète légère", new De(1, 8), 16)
        )),
        new ArrayList<>(List.of(
            new Armure(TypeArmure.LOURDE, "cotte de mailles", 11)
        ))
    );
  }
  public static ClassePersonnage Magiciens() {
    return new ClassePersonnage(
        "Magiciens",
        12,
        new ArrayList<>(List.of(
            new Arme(TypeArme.COURANTECORPS, "bâton", new De(1, 6), 1),
            new Arme(TypeArme.DISTANCE, "fronde", new De(1, 4), 6)
        )),
        new ArrayList<>(List.of())
    );
  }
  public static ClassePersonnage Roublards() {
    return new ClassePersonnage(
        "Roublards",
        16,
        new ArrayList<>(List.of(
            new Arme(TypeArme.GUERRE, "rapière", new De(1, 8), 1),
            new Arme(TypeArme.DISTANCE, "arc court", new De(1, 6), 16)
        )),
        new ArrayList<>(List.of())
    );
  }

}
