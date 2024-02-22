/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author ciclot
 */
public class SalonJuegosServer {

    private static final int PUERTO = 5555;

    public static void main(String[] args) {

        int numeroSecreto;
        HashMap<String, Integer> jugadores = new HashMap<>();

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("SERVIDOR: Escuchando por el puerto " + PUERTO
                    + " ...");

            while (true) {
                // 1. Espera/escucha del cliente (LISTEN) y aceptación de
                // conexión (ACCEPT)
                Socket clientSocket = serverSocket.accept();

                DataInputStream flujo_entrada = new DataInputStream(clientSocket.getInputStream());
                String nombre_jugador = flujo_entrada.readUTF();

                if (jugadores.containsKey(nombre_jugador)) {
                    Acreditacion acreditacion = new Acreditacion();
                    if (jugadores.get(nombre_jugador) <= 3 && jugadores.get(nombre_jugador) >= 0) {
                        acreditacion.validarAcreditacion();
                        acreditacion.getMensaje();
                    }

                    ObjectOutputStream flujo_salida_objeto = new ObjectOutputStream(clientSocket.getOutputStream());
                    flujo_salida_objeto.writeObject(acreditacion);
                }
            }

            // Cierre de conexión principal del servidor
            // serverSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
