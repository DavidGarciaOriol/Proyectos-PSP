package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

public class Trabajador implements Runnable{

    Trabajo trabajo = new Trabajo();

    @Override
    public void run() {
        trabajo.realizarTarea();
    }
}
