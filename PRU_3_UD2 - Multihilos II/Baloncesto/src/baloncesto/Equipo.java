/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baloncesto;

import java.util.Random;

/**
 *
 * @author losad
 */

public class Equipo extends Thread {
    
    private int puntos = 0;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public Equipo(String nombre){
        this.setName(nombre);
    }
    
    @Override
    public void run() {
        this.puntos = aleatorio(0,3);
        try{
            for(int i=1;i<60;i++){
            
                int lanzamiento = aleatorio(0,3);
                //System.out.println(getName() +" ha anotado " + lanzamiento + " puntos");
                puntos = puntos + lanzamiento;
                Thread.sleep(1000);
            
            }
            
        }
        catch(InterruptedException e){
            System.err.println("Accion Interrumpida " + e);
        }
    }
    
    //Metodo que devuelve un numero Aleatorio entre el minimo y el maximo especificados en los parametros
	private int aleatorio(int min, int max) {
		Random r = new Random();
		return min + r.nextInt(max - min + 1); // Entre min y max -> [min,max];
	}
    
}

