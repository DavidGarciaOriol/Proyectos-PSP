/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iesmartinezm.psp.practica1.dgo.psp.u3.p1;

import java.io.Serializable;

/**
 *
 * @author ciclot
 */
public class Acreditacion implements Serializable{
    
    private boolean participacionValida;
    private String mensaje;
    
    public Acreditacion(){
        this.participacionValida = false;
        this.mensaje = "";
    }
    
    public void validarAcreditacion(){
        this.participacionValida = true;
        this.mensaje = "Acreditación válida";
    }
    
    public void invalidarAcreditacion(){
        this.participacionValida = false;
        this.mensaje = "Acreditación denegada";
    }

    public boolean isParticipacionValida() {
        return participacionValida;
    }
    
    public String getMensaje() {
        return mensaje;
    }
}
