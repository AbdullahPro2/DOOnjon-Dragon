package utils;

public class Utils {
    public static int lanceDe(int n, int f){
        int somme=0;
        for (int i=0; i<n;i++)
        {
            int random = (int)(Math.random() * f) + 1;
            System.out.print(random +"\t");
            somme+=random;
        }
        return somme;
    }
}
