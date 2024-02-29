package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import iesmartinezm.psp.practica1.dgo.psp.u3.p1.Token;
import io.jsonwebtoken.Claims;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;

public class SalonJuegosServer {

    private static final int PUERTO = 5555;
    private static final int NUMERO_SECRETO = new Random().nextInt(100) + 1;
    private static final int MAX_INTENTOS = 10;

    public static void main(String[] args) {

        HashMap<String, String> jugadores = new HashMap<>();
        Token tokenManager = new Token();

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("SERVIDOR: Escuchando por el puerto " + PUERTO + " ...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("SERVIDOR: Cliente conectado desde " + clientSocket.getInetAddress());

                DataInputStream flujoEntrada = new DataInputStream(clientSocket.getInputStream());
                String nombreJugador = flujoEntrada.readUTF();
                String token = flujoEntrada.readUTF();

                if (!jugadores.containsKey(nombreJugador)) {
                    // Nuevo jugador
                    Claims claims = tokenManager.verifyToken(token);
                    if (claims != null && claims.get("user").equals(nombreJugador)) {
                        jugadores.put(nombreJugador, token);
                        System.out.println("SERVIDOR: Nuevo jugador acreditado - " + nombreJugador);
                    } else {
                        System.out.println("SERVIDOR: Acceso denegado para el usuario - " + nombreJugador);
                        continue;
                    }
                } else {
                    // Jugador existente
                    if (!token.equals(jugadores.get(nombreJugador))) {
                        System.out.println("SERVIDOR: Token inválido para el usuario - " + nombreJugador);
                        continue;
                    }
                }

                int intentos = 0;
                boolean adivinado = false;
                while (intentos < MAX_INTENTOS && !adivinado) {
                    DataOutputStream flujoSalida = new DataOutputStream(clientSocket.getOutputStream());
                    flujoSalida.writeUTF("Intenta adivinar el número entre 1 y 100:");

                    int intento = flujoEntrada.readInt();
                    intentos++;

                    if (intento == NUMERO_SECRETO) {
                        flujoSalida.writeUTF("¡¡Enhorabuena!! Has acertado el número secreto.");
                        System.out.println("SERVIDOR: " + nombreJugador + " ha ganado en " + intentos + " intentos.");
                        adivinado = true;
                    } else {
                        flujoSalida.writeUTF(intento < NUMERO_SECRETO ? "El número es mayor." : "El número es menor.");
                    }
                }

                if (!adivinado) {
                    DataOutputStream flujoSalida = new DataOutputStream(clientSocket.getOutputStream());
                    flujoSalida.writeUTF("Se han agotado los intentos. El número secreto era: " + NUMERO_SECRETO);
                }

                if (adivinado) {
                    flujoEntrada.close();
                    clientSocket.close();
                    serverSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
