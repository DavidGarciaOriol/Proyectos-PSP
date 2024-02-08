package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

public class Trabajador implements Runnable{

    private Trabajo trabajo;
    private String nombre;

    @Override
    public void run() {
        trabajo.realizarTarea();
    }

    public Trabajador(Trabajo trabajo, String nombre){
        this.trabajo = trabajo;
        this.nombre = nombre;
    }
}
