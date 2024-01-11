package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

public class Jefe implements Runnable{

    Trabajo trabajo = new Trabajo();

    @Override
    public void run() {
        trabajo.agregarTareaListaPendientes();
    }
}
