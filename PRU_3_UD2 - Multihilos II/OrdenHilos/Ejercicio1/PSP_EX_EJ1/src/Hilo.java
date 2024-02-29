
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class Hilo extends Thread {

    private int id;
    private int cantidad;
    private Taquilla b;

    public Hilo(int id, Taquilla b, int cantidad) {
        this.setName("HILO_" + id);
        this.id = id;
        this.b = b;
        this.cantidad = cantidad;
    }

    public void run() {
        try {
            System.out.println("Inicio hilo " + Thread.currentThread().getName() + " que quiere comprar " + cantidad + " entradas");
            b.esperarTurno(id);
            //Thread.sleep(500);
            b.finTurno(cantidad);
            System.out.println("Fin ejecuta " + Thread.currentThread().getName() + " Siguiente turno");
        } catch (Exception ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
