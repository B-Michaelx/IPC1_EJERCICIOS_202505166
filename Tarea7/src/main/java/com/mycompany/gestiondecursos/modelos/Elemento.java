
package com.mycompany.gestiondecursos.modelos;

public abstract class Elemento {
    protected String nombre;
    
    public Elemento(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void mostrarinformacion();  
    
}
