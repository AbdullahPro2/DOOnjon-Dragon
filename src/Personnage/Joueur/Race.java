package Personnage.Joueur;

public class Race {
  private String m_nomRace;
  private int m_bonusForce;
  private int m_bonusDexterite;
  private int m_bonusVitesse;

  private Race(String nom, int force, int dex, int vitesse) {
    this.m_nomRace = nom;
    this.m_bonusForce = force;
    this.m_bonusDexterite = dex;
    this.m_bonusVitesse = vitesse;
  }
  public String getM_nomRace(){ return m_nomRace; }
  public int getM_BonusForce() { return m_bonusForce; }
  public int getM_BonusDexterite() { return m_bonusDexterite; }
  public int getM_BonusVitesse() { return m_bonusVitesse; }

  public static Race Elfe() {
    return new Race("Elfe", 0, 6, 0);
  }

  public static Race Halfelin() {
    return new Race("Halfelin", 0, 4, 2);
  }

  public static Race Humain() {
    return new Race("Humain", 2, 2, 2);
  }

  public static Race Nain() {
    return new Race("Nain", 6, 0, 0);
  }

}
