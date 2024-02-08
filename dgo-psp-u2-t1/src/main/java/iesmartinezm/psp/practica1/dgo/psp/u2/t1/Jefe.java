package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

public class Jefe implements Runnable{
    private Trabajo trabajo;
    private String nombre;

    @Override
    public void run() {
        trabajo.agregarTareaListaPendientes();
    }

    public Jefe(Trabajo trabajo, String nombre){
        this.trabajo = trabajo;
        this.nombre = nombre;
    }
}
