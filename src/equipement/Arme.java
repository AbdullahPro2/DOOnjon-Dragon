package equipement;

import utils.De;
import utils.Entite;

public class Arme extends Entite {

  private TypeArme m_typeArme;
  private String m_nomArme;
  private De m_degats;
  private int m_portee;

  public Arme(TypeArme type, String nom, De degats, int portee, int x, int y) {
    super(x,y);
    this.m_typeArme = type;
    this.m_nomArme = nom;
    this.m_degats = degats;
    this.m_portee = portee;
  }
  public TypeArme getM_typeArme() {
    return m_typeArme;
  }
  public String getM_nomArme() {
    return m_nomArme;
  }
  public De getM_degats()
  {
    return m_degats;
  }
  public int getM_portee() {
    return m_portee;
  }

  @Override
  public String toString() {
    return m_nomArme + " (" + m_typeArme + "), Dégâts: " + m_degats + ", Portée: " + m_portee + " cases";
  }
}
