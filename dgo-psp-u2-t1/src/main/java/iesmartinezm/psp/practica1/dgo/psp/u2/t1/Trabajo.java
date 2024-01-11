package iesmartinezm.psp.practica1.dgo.psp.u2.t1;

import java.util.List;

public class Trabajo {

    private List<String> tareasPendientes;
    private List<String> tareasRealizadas;
    private final int CARGA_MAXIMA_TRABAJO = 500, CMXT = CARGA_MAXIMA_TRABAJO;
    private final int OBJETIVO_TRABAJO = 2000, OBJT = OBJETIVO_TRABAJO;

    private int picoMaximoTrabajoAcumulado = 0;

    public synchronized void agregarTareaListaPendientes(){
        while (tareasRealizadas.size() < OBJT){
            if (tareasPendientes.size() >= CMXT){
                System.out.println("Se ha excedido la carga máxima de tareas.");
                break;
            }
        }
    }

    public synchronized void realizarTarea(){
        while (tareasPendientes.size() > 0){

        }
    }



}
