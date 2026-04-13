package com.mycompany.tarea9;

/**
 * @author micha
 */
public class ListaDobleEstudiantes {
    private NodoEstudianteDoble cabeza;
    private NodoEstudianteDoble cola;
    
    public ListaDobleEstudiantes() {
        this.cabeza = null;
        this.cola = null;
    }
        
    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
        
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
    }
    
    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
        
        if (cola == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }
    
    public boolean eliminarPorCarnet(String carnet) {
        if (cabeza == null){
            return false;
        }
        
        NodoEstudianteDoble actual = cabeza;
        
        while (actual != null && !actual.getCarnet().equals(carnet)) {
            actual = actual.getSiguiente();
        }
        
        if (actual == null){
            return false;
        } 
        
        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
        }
        else if (actual == cabeza) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null);
            }
        }

        else if (actual == cola) {
            cola = cola.getAnterior();
            if (cola != null) {
                cola.setSiguiente(null);
            }
        }
        else {
            NodoEstudianteDoble anterior = actual.getAnterior();
            NodoEstudianteDoble siguiente = actual.getSiguiente();
            
            if (anterior != null) {
                anterior.setSiguiente(siguiente);
            }
            if (siguiente != null) {
                siguiente.setAnterior(anterior);
            }
        }
        
        return true;
    }

    
    public void imprimirAdelante() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        
        NodoEstudianteDoble actual = cabeza;
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() + 
                               ", Nombre: " + actual.getNombre() + 
                               ", Nota: " + actual.getNota());
            actual = actual.getSiguiente();
        }
    }
    
    public void imprimirAtras() {
        if (cola == null) {
            System.out.println("Lista vacía");
            return;
        }
        
        NodoEstudianteDoble actual = cola;
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() + 
                               ", Nombre: " + actual.getNombre() + 
                               ", Nota: " + actual.getNota());
            actual = actual.getAnterior();
        }
    }
   
    
    public void insertarOrdenado(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
        
        if (cabeza == null) {
            cabeza = cola = nuevo;
            return;
        }
        
        if (nota <= cabeza.getNota()) {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            return;
        }
        

        if (nota >= cola.getNota()) {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
            return;
        }
        

        NodoEstudianteDoble actual = cabeza;
        while (actual != null && actual.getNota() < nota) {
            actual = actual.getSiguiente();
        }
        
  
        if (actual != null) {
            NodoEstudianteDoble anterior = actual.getAnterior();
            
            nuevo.setSiguiente(actual);
            nuevo.setAnterior(anterior);
            
            if (anterior != null) {
                anterior.setSiguiente(nuevo);
            }
            actual.setAnterior(nuevo);
        }
    }
}