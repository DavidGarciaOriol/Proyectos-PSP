/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciclot
 */
public class JugadorClient {

    private static final int PUERTO = 6000;
    private static final String SERVER = "localhost";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nombre_cliente = scanner.nextLine();
        Acreditacion acreditacion;

        Socket clientSocket = new Socket();
        InetSocketAddress addr = new InetSocketAddress(SERVER, PUERTO);
        try {
            clientSocket.connect(addr);

            DataOutputStream flujo_salida = new DataOutputStream(clientSocket.getOutputStream());
            flujo_salida.writeUTF(nombre_cliente);

            ObjectInputStream flujo_entrada_objeto = new ObjectInputStream(clientSocket.getInputStream());
            try {
                acreditacion = (Acreditacion) flujo_entrada_objeto.readObject();
                
                if (acreditacion.isParticipacionValida()){
                    
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JugadorClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(JugadorClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
