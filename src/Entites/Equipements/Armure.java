package Entites.Equipements;

import Entites.Entite;
import Entites.Personnages.Joueurs.Joueur;

public class Armure extends Entite {
  private TypeArmure m_typeArmure;
  private String m_nom;
  private int m_classeArmure;

  public Armure(TypeArmure typeArmure, String nom, int classeArmure, int x, int y) {
    super(x,y);
    this.m_typeArmure = typeArmure;
    this.m_nom = nom;
    this.m_classeArmure = classeArmure;
  }

  @Override
  public void ramasser(Joueur joueur) {
    joueur.getM_classe().getM_armures().add(this);
    System.out.println("Armure ramassée : " + m_nom);
  }

  public int getM_classeArmure() {
    return m_classeArmure;
  }

  public String getM_nom() {
    return m_nom;
  }

  public TypeArmure getM_typeArmure() {
    return m_typeArmure;
  }

  @Override
  public String toString() {
    return m_nom + " (" + m_typeArmure + ") - CA: " + m_classeArmure;
  }
}

