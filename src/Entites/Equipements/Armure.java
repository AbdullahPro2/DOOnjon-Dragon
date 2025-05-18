package Entites.Equipements;

import Entites.Entite;

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

