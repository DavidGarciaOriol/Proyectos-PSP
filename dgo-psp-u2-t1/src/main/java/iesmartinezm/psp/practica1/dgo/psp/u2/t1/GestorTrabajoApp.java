/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

public class GestorTrabajoApp {
    final static int NUMERO_TRABAJADORES = 10, M = NUMERO_TRABAJADORES;
    final static int NUMERO_JEFES = 1, N = NUMERO_JEFES;
    public static void main(String[] args) {

        int jefes = 0;
        int trabajadores = 0;

        Trabajo trabajo = new Trabajo();

        while (jefes < NUMERO_JEFES){
            new Jefe(trabajo).run();
        }
        while (trabajadores < NUMERO_TRABAJADORES){
            new Trabajador(trabajo).run();
        }
    }
}
