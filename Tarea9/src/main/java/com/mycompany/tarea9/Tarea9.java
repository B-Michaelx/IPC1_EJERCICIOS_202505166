package com.mycompany.tarea9;

/**
 * @author micha
 */
public class Tarea9 {

    public static void main(String[] args) {
        System.out.println("=== LISTA SIMPLEMENTE ENLAZADA ===");
        
        ListaEstudiantes listaSimple = new ListaEstudiantes();
        
        listaSimple.agregarInicio("00003", "Pedro", 85.5);
        listaSimple.agregarInicio("00001", "Sofia", 92.0);
        listaSimple.agregarFinal("00005", "Diego", 78.0);
        
        System.out.println("Lista completa:");
        listaSimple.imprimirLista();
        
        System.out.println("Promedio: " + listaSimple.obtenerPromedio());
        
        System.out.println("Mejor nota:");
        NodoEstudiante mejor = listaSimple.obtenerMejorNota();
        System.out.println(mejor.getNombre() + " - " + mejor.getNota());
        
        System.out.println("Buscar carnet 00001:");
        NodoEstudiante encontrado = listaSimple.buscarPorCarnet("00001");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }
        
        System.out.println("Eliminar carnet 00003:");
        listaSimple.eliminarPorCarnet("00003");
        listaSimple.imprimirLista();
        
        System.out.println("\n=== LISTA DOBLEMENTE ENLAZADA ===");
        
        ListaDobleEstudiantes listaDoble = new ListaDobleEstudiantes();
        
        listaDoble.insertarOrdenado("00003", "Andres", 85.5);
        listaDoble.insertarOrdenado("00001", "Valeria", 92.0);
        listaDoble.insertarOrdenado("00005", "Fernando", 78.0);
        
        System.out.println("Adelante (por nota ascendente):");
        listaDoble.imprimirAdelante();
        
        System.out.println("Atras:");
        listaDoble.imprimirAtras();
        
        System.out.println("Eliminar carnet 00003:");
        listaDoble.eliminarPorCarnet("00003");
        listaDoble.imprimirAdelante();
    }
}