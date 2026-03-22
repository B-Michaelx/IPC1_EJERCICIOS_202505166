package com.mycompany.gestiondecursos;
import com.mycompany.gestiondecursos.servicios.GestorCursos;
import java.util.Scanner;

public class GestionDeCursos {
    private static Scanner sc = new Scanner(System.in);
    private static GestorCursos gestor = new GestorCursos();

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Sistema de Gestion De Cursos y Tareas");
        System.out.println("Escuela de Ciencias y Sistemas");
        System.out.println("=====================================");
        
        int op;
        do{
            mostrarMenu();
            op = leerOpcion();
            
            switch (op){
                case 1:
                    crearCurso();
                    break;
                case 2:
                    agregarTareas();
                    break;
                case 3:
                    gestor.mostrarCurso();
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(op != 4);
        sc.close();
    }
    
    public static void mostrarMenu(){
        System.out.println("=================================");
        System.out.println("Bienvenido, eliga una opcion");
        System.out.println("1. Crear Curso");
        System.out.println("2. Agregar Tarea");
        System.out.println("3. Ver Cursos");
        System.out.println("4. Salir");
        System.out.print("Opcion: ");

    }
    
    public static int leerOpcion(){
        try{
            return Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    
    
    public static void crearCurso(){
        System.out.println("====Nuevo Curso====");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("Tutor: ");
        String tutor = sc.nextLine();
        gestor.crearCruso(nombre, codigo, tutor);
    }
    
    public static void agregarTareas(){
        if(!gestor.hayCursos()){
            System.out.println("Cree un curso primero");
            return;
        }
        System.out.println("====Nueva Tarea====");
        System.out.print("Codigo del curso: ");
        String codigo = sc.nextLine();
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Fecha de entrega: ");
        String fecha = sc.nextLine();
        
        gestor.agregarTareas(codigo, titulo, descripcion, fecha);
           
    }
}
