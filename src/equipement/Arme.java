package equipement;

import utils.DeDegats;

public class Arme {

  private TypeArme m_typeArme;
  private String m_nomArme;
  private DeDegats m_degats;
  private int m_portee;

  public Arme(TypeArme type, String nom, DeDegats degats, int portee) {
    this.m_typeArme = type;
    this.m_nomArme = nom;
    this.m_degats = degats;
    this.m_portee = portee;
  }
  public TypeArme getM_typeArme()
  {
    return m_typeArme;
  }
  public String getM_nomArme()
  {
    return m_nomArme;
  }
  public DeDegats getM_degats()
  {
    return m_degats;
  }
  public int getM_portee()
  {
    return m_portee;
  }

  @Override
  public String toString() {
    return m_nomArme + " (" + m_typeArme + "), Dégâts: " + m_degats + ", Portée: " + m_portee + " cases";
  }
}
