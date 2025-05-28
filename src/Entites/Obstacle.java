package Entites;

public class Obstacle extends Entite{

    public Obstacle(int x, int y)
    {
        super(x, y);
    }
    @Override
    public String getDisplaySymbol() {
        return "▓▓▓"; // Bright black background
    }

}
