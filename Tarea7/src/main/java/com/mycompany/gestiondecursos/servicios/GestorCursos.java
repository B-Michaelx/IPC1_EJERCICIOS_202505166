package com.mycompany.gestiondecursos.servicios;
import com.mycompany.gestiondecursos.modelos.Curso;
import com.mycompany.gestiondecursos.modelos.Tarea;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class GestorCursos {
    private Curso[] cursos;
    private int totalCursos;
    
    public GestorCursos(){
        this.cursos = new Curso[100];
        this.totalCursos = 0;
    
}
    public void crearCruso(String nombre, String codigo, String tutor){
        for(int i = 0; i < totalCursos; i++){
            if(cursos[i].getCodigo().equalsIgnoreCase(codigo)){
                System.out.println("Error: ya existe un curso son este codigo");
                return;
            }
           
        }
         if (totalCursos < 100){
             cursos[totalCursos] = new Curso(nombre, codigo, tutor);
             totalCursos++;
             System.out.println("Curso creado con exito");
         }else{
             System.out.println("límite de cursos alcanzado");
         }
    }
    
    public void agregarTareas(String codigoCurso, String titulo, String descripcion, String fechastr){
        Curso curso = null;
        for (int i = 0; i < totalCursos; i++){
            if(cursos[i].getCodigo().equalsIgnoreCase(codigoCurso)){
                curso = cursos[i];
                break;
            }
        }
        if (curso == null){
            System.out.println("Error: no se encuentra el curso con codigo" + codigoCurso);
            return;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechastr, formatter);
            Tarea tarea = new Tarea(titulo, descripcion, fecha);
            curso.agregarTarea(tarea);
        }catch (DateTimeParseException e){
            System.out.println("Error: formato de fecha invalida");
        }
                
    }
    
    public void mostrarCurso(){
        if (totalCursos == 0){
            System.out.println("No hay cursos registrados");
            return;
        }
        
        System.out.println("Lista de Cursos");
        for(int i = 0; i < totalCursos; i++){
            cursos[i].mostrarinformacion();
        }   
        
        System.out.println("Total: " + totalCursos + " cursos");
    }
    
    public boolean hayCursos(){
        return totalCursos > 0;
    }
   
}
