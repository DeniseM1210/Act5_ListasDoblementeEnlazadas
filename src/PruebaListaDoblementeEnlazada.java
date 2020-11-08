
class Nodo{
	
	private Nodo nodoAnterior;
	private int dato;
	private Nodo nodoSiguiente;
	
	public Nodo(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	@Override
	public String toString() {
		return "Nodo [nodoAnterior=" + nodoAnterior + ", dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
	
}


/* OPERACIONES BASICAS
*  1)Creacion
*  2)Insercion
*   2a)Al inicio
*   2b)Al final
* 
*  3) Eliminacion
*   3a) Inicio
*   3b) Final
*   3c) Especifico
* 
*  4) Mostrar elementos
*/

class ListaDoblementeEnlazada{
	
	Nodo nodoInicio;
	Nodo nodoFin;
	
	//1) Creacion
	public ListaDoblementeEnlazada() {}
	
	public boolean verificarListaVacia() {

		return (nodoInicio == null) ? true : false;
	}
	
	//2a) Insercion al inicio
	public void agregarAlInicio(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nuevoNodo;
			//lista está vacía
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio.setNodoAnterior(nuevoNodo);
			nodoInicio = nuevoNodo;
		}
	}
	
	//2b) Insercion al final
	public void agregarAlFinal(int dato) {
		Nodo nodoNuevo = new Nodo(dato);
		
		if(verificarListaVacia()) {
			nodoInicio = nodoFin = nodoNuevo;
		}else {
			nodoFin.setNodoSiguiente(nodoNuevo);
			nodoFin = nodoNuevo;
		}
		
	}
	
	//3a) Eliminar elemento al inicio
	public void eliminarElementoInicio() {
		if(verificarListaVacia()) {
			System.out.println("No hay elementos para eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else{
			nodoInicio = nodoInicio.getNodoSiguiente();
			nodoInicio.getNodoAnterior();
		}
	}
	
	//3b) Eliminar elemento al final
	public void eliminarElementoFinal() {
		Nodo nodoActual = nodoInicio;
		
		if(verificarListaVacia()) {
			System.out.println("No hay elementos para eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else {
			while(nodoActual.getNodoSiguiente() != nodoFin) {
				nodoActual = nodoActual.getNodoSiguiente();
			}
			nodoActual.setNodoSiguiente(null);
			nodoFin = nodoActual;
		}
	}
	
	//4) Mostrar Elementos
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		
		while(nodoActual != null) {
			System.out.print("<--- [" + nodoActual.getDato() + "]---> " );
			nodoActual = nodoActual.getNodoSiguiente();
		}
	}
}

public class PruebaListaDoblementeEnlazada {

	public static void main(String[] args) {
		ListaDoblementeEnlazada lde = new ListaDoblementeEnlazada();
		
		lde.agregarAlInicio(7);
		lde.agregarAlInicio(8);
		lde.agregarAlFinal(10);
		lde.agregarAlFinal(11);
		
		
		lde.mostrarElementos();
		
		System.out.println("\n---Eliminar elemento inicio---");
		lde.eliminarElementoInicio();
		lde.mostrarElementos();
		
		System.out.println("\n --- Eliminar elemento final ---");
		lde.eliminarElementoFinal();
		lde.mostrarElementos();

	}

}
