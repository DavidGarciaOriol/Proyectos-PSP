package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class JugadorClient {

    private static final int PUERTO = 5555;
    private static final String SERVER = "localhost";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de jugador: ");
        String nombreJugador = scanner.nextLine();

        try (Socket clientSocket = new Socket()) {
            InetSocketAddress addr = new InetSocketAddress(SERVER, PUERTO);
            clientSocket.connect(addr);

            DataOutputStream flujoSalida = new DataOutputStream(clientSocket.getOutputStream());
            flujoSalida.writeUTF(nombreJugador);

            Token tokenManager = new Token();
            String token = tokenManager.generateToken(nombreJugador);
            flujoSalida.writeUTF(token);

            DataInputStream flujoEntrada = new DataInputStream(clientSocket.getInputStream());
            String mensaje;
            while ((mensaje = flujoEntrada.readUTF()) != null) {
                System.out.println("SERVIDOR: " + mensaje);

                if (mensaje.startsWith("Intenta adivinar")) {
                    System.out.print("Ingrese su intento: ");
                    int intento = scanner.nextInt();
                    DataOutputStream flujoSalidaNumero = new DataOutputStream(clientSocket.getOutputStream());
                    flujoSalidaNumero.writeInt(intento);
                } else if (mensaje.startsWith("¡¡Enhorabuena!!")) {
                    break; 
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
