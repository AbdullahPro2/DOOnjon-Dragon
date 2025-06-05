package Entites.Equipements;

import Entites.Personnages.Joueurs.Joueur;
import utils.De;
import Entites.Entite;

public class Arme extends Entite {

  private TypeArme m_typeArme;
  private String m_nom;
  private De m_degats;
  private int m_portee;
  private int m_bonusAttaque;

  public Arme(TypeArme type, String nom, De degats, int portee, int x, int y) {
    super(x,y);
    this.m_typeArme = type;
    this.m_nom = nom;
    this.m_degats = degats;
    this.m_portee = portee;
    this.m_bonusAttaque = 0;
  }
  public TypeArme getM_typeArme() {
    return m_typeArme;
  }
  public String getM_nom() {
    return m_nom;
  }
  public De getM_degats()
  {
    return m_degats;
  }
  public int getM_portee() {
    return m_portee;
  }
  public int getM_bonusAttaque(){return m_bonusAttaque;}

  public void setM_bonusAttaque(int m_bonusAttaque) {
    this.m_bonusAttaque = m_bonusAttaque;
  }

  @Override
  public void ramasser(Joueur joueur) {
    joueur.getM_classe().getM_armes().add(this);
    System.out.println("Arme ramassée : " + m_nom);
  }

  @Override
  public String toString() {
    return m_nom + " (" + m_typeArme + "), Dégâts: " + m_degats + ", Portée: " + m_portee + " cases";
  }
}
