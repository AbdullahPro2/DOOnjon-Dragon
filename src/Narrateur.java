public class Narrateur {
  private final StringBuilder m_histoire;

  public Narrateur()
  {
    this.m_histoire= new StringBuilder();
  }

  public void ajouterLignes(String texte)
  {
    this.m_histoire.append(texte).append("\n");
  }

  public void raconterHistoire()
  {
    System.out.println(this.m_histoire);
  }

}
