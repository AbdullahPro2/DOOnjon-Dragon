package utils;

public abstract class Entity {
    private int m_x;
    private int m_y;

    public Entity(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }

    public String getSymbol(String nom){return nom;} // For drawing

    public int getX() {
        return m_x;
    }

    public int getY() {
        return m_y;
    }

    public void setPosition(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }
}