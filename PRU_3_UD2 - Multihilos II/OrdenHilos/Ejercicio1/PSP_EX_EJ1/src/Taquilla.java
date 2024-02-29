
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro
 */
public class Taquilla {

    private int turnos = 1;
    private int stock;

    public Taquilla(int stock) {
        this.stock = stock;
    }

    public synchronized void esperarTurno(int id) {
        while (turnos != id) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Taquilla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void finTurno(int cantidad) {
        System.out.println("Soy el Hilo " + Thread.currentThread().getName() + " y va a comprar " + cantidad + " entradas");
        if(this.stock>=cantidad){
            this.stock = this.stock - cantidad;
            System.out.println("Soy el Hilo " + Thread.currentThread().getName() + " y he comprado " + cantidad + " entradas");
        }else{
            System.out.println("Soy el Hilo " + Thread.currentThread().getName() + " y no he podido conseguir las entradas que quiero porque sólo quedaban " + this.stock);
        }
        turnos++;
        notifyAll();
    }
}
