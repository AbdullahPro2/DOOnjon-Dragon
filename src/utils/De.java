package utils;

import java.util.Random;

public class De {
  private int m_nombreDes;
  private int m_facesParDe;

  public De(int nombreDes, int facesParDe) {
    this.m_nombreDes = nombreDes;
    this.m_facesParDe = facesParDe;
  }
  public int getDegatsAleatoires() {
    Random rand = new Random();
    int total = 0;
    for (int i = 0; i < m_nombreDes; i++) {
      total += rand.nextInt(m_facesParDe) + 1;
    }
    return total;
  }

  @Override
  public String toString() {
    return m_nombreDes + "d" + m_facesParDe;
  }
}
