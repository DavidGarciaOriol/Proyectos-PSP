/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author losad
 */
public class Partido {
    public static void main(String args []){
        int contGanadosEquipo1 = 0;
        int contGanadosEquipo2 = 0;
        int i = 1;
        while( contGanadosEquipo1 < 2 && contGanadosEquipo2 < 2){
            System.out.println("PARTIDO " + i + " INICIO DEL PARTIDO ");
            Equipo equipo1 = new Equipo("Real Madrid");
            Equipo equipo2 = new Equipo("Unicaja");
            equipo1.start();
            equipo2.start();
            try {
                Thread.sleep(15000);
                System.out.println("PARTIDO " + i + " FIN DEL PRIMER CUARTO " + equipo1.getName() + " " + equipo1.getPuntos() + " - " + equipo2.getName() + " " + equipo2.getPuntos());
                Thread.sleep(15000);
                System.out.println("PARTIDO " + i + " FIN DEL SEGUNDO CUARTO " + equipo1.getName() + " " + equipo1.getPuntos() + " - " + equipo2.getName() + " " + equipo2.getPuntos());
                Thread.sleep(15000);
                System.out.println("PARTIDO " + i + " FIN DEL TERCER CUARTO " + equipo1.getName() + " " + equipo1.getPuntos() + " - " + equipo2.getName() + " " + equipo2.getPuntos());
                Thread.sleep(20000);
                System.out.println("PARTIDO " + i + " FIN DEL PARTIDO " + i + " Resultado " + equipo1.getName() + " " + equipo1.getPuntos() + " - " + equipo2.getName() + " " + equipo2.getPuntos());
                if(equipo1.getPuntos() > equipo2.getPuntos()){
                    contGanadosEquipo1++;
                }else{
                    if(equipo2.getPuntos() > equipo1.getPuntos()){
                        contGanadosEquipo2++;
                    }else{
                        System.out.println("El partido ha quedado en empate, la victoria no cuenta para ninguno de los dos ");
                    }   
                }
                equipo1.join();
                equipo2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Partido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            i++;
        }
        
         if(contGanadosEquipo1 > contGanadosEquipo2){
              System.out.println("El ganador de la serie es " + "Real Madrid" + " con un resultado de " + contGanadosEquipo1 + "-" + contGanadosEquipo2) ;
         }else{
             if(contGanadosEquipo2 > contGanadosEquipo1){
               System.out.println("El ganador de la serie es " + "Unicaja" + " con un resultado de " + contGanadosEquipo1 + "-" + contGanadosEquipo2);
             }
         }    
    }
}
