package utils;

import java.util.Random;

public class De {
  private int m_nombreDes;
  private int m_facesParDe;

  public De(int nombreDes, int facesParDe) {
    this.m_nombreDes = nombreDes;
    this.m_facesParDe = facesParDe;
  }
  public int lanceDe() {
    Random rand = new Random();
    int total = 0;
    for (int i = 0; i < m_nombreDes; i++) {
      total += rand.nextInt(m_facesParDe) + 1;
    }
    return total;
  }

  public int lanceDePrint() {
    Random rand = new Random();
    int total = 0;
    for (int i = 0; i < m_nombreDes; i++) {
      total += rand.nextInt(m_facesParDe) + 1;
    }
    System.out.println("Vous lancez " + m_nombreDes + " dé de " + m_facesParDe + " faces");
    System.out.println("Vous avez fait " + total);
    return total;
  }

  public int getM_facesParDe() {
    return m_facesParDe;
  }

  public int getM_nombreDes() {
    return m_nombreDes;
  }

  @Override
  public String toString() {
    return m_nombreDes + "d" + m_facesParDe;
  }
}
