
package com.mycompany.tarea9;

/**
 *
 * @author micha
 */
public class ListaEstudiantes {
    private NodoEstudiante cabeza;
    
    public ListaEstudiantes(){
        this.cabeza = null;
    }
    
     public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
    }
     
      public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        NodoEstudiante actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }
      
      public boolean eliminarPorCarnet(String carnet) {
        if (cabeza == null){
            return false;
        }

     
        if (cabeza.getCarnet().equals(carnet)) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        NodoEstudiante actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getCarnet().equals(carnet)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
      
      public NodoEstudiante buscarPorCarnet(String carnet) {
        NodoEstudiante actual = cabeza;
        while (actual != null) {
            if (actual.getCarnet().equals(carnet)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
      
      
       public void imprimirLista() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoEstudiante actual = cabeza;
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() + 
                               ", Nombre: " + actual.getNombre() + 
                               ", Nota: " + actual.getNota());
            actual = actual.getSiguiente();
        }
    }
       
        public double obtenerPromedio() {
        if (cabeza == null){
            return 0.0;
        }
        
        double suma = 0;
        int contador = 0;
        NodoEstudiante actual = cabeza;
        
        while (actual != null) {
            suma += actual.getNota();
            contador++;
            actual = actual.getSiguiente();
        }
        return suma / contador;
    }

         public NodoEstudiante obtenerMejorNota() {
        if (cabeza == null){
            return null;
        }
        
        NodoEstudiante mejor = cabeza;
        NodoEstudiante actual = cabeza.getSiguiente();
        
        while (actual != null) {
            if (actual.getNota() > mejor.getNota()) {
                mejor = actual;
            }
            actual = actual.getSiguiente();
        }
        return mejor;
    }

}
