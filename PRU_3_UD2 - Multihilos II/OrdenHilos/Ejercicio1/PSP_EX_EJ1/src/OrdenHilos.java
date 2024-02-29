
import java.util.Random;
import java.util.Scanner;

public class OrdenHilos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el número de entradas disponibles");
        int numEntradasEnVenta = sc.nextInt();
        System.out.println("Dime el número de personas");
        int numPersonas = sc.nextInt();
        
        Taquilla taquilla = new Taquilla(numEntradasEnVenta);
        
        for (int i = 1; i <= numPersonas; i++) {
            int numEntradasAComprar = aleatorio(1,5);
            new Hilo(i, taquilla, numEntradasAComprar).start();
        }
    }
    
    
    private static int aleatorio(int min, int max) {
		Random r = new Random();
		return min + r.nextInt(max - min + 1); 
    }
    
    
}
