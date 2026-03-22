package com.mycompany.gestiondecursos.modelos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

 public class Tarea extends Elemento {
     private String descripcion;
    private LocalDate fechaEntrega;
 
    public Tarea(String titulo, String descripcion, LocalDate fechaEntrega) {
        super(titulo);  
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }
    
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    @Override
   public void mostrarinformacion(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       System.out.println("Tarea: " +  nombre);
       System.out.println("Descripcion: " + descripcion);
       System.out.println("Fecha de Entrega: " + fechaEntrega.format(formatter));
   }
    
}


