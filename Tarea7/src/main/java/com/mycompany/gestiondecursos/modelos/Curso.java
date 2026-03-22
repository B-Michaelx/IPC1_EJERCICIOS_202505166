package com.mycompany.gestiondecursos.modelos;

public class Curso extends Elemento {
    private String codigo;
    private String tutor;
    private Tarea[] tareas;
    private int cantidadTareas;
    
   public Curso(String nombre, String codigo, String tutor){
       super(nombre);
        this.codigo = codigo;
        this.tutor = tutor;
        this.tareas = new Tarea[50];
        this.cantidadTareas = 0;
   }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getTutor() {
        return tutor;
    }
    
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    
    public Tarea[] getTareas() {
        return tareas;
    }
    
    public int getCantidadTareas() {
        return cantidadTareas;
    }
   
   public void agregarTarea(Tarea tarea){
       if(cantidadTareas < 50){
           tareas[cantidadTareas] = tarea;
           cantidadTareas++;
           System.out.println("Tarea agregada al curso: " + nombre);
       }else{
           System.out.println("Limite alcanzado, no se pueden agragar mas tareas");
       }
   }   
   
   @Override
   public void mostrarinformacion(){
       System.out.println("Curso: " + nombre);
       System.out.println("Codigo: " + codigo);
       System.out.println("Tutor: " + tutor);
       System.out.println("Tareas: " + cantidadTareas);
       
       if (cantidadTareas == 0){
           System.out.println("Este curso no tiene tareas asignadas");
       }else{
           for (int i = 0; i < cantidadTareas; i++){
               tareas[i].mostrarinformacion();
           }
       }
       System.out.println();
   }
    
}
