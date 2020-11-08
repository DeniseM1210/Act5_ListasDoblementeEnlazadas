
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
	
	//3c) Eliminar dato especifico
	public int eliminarDatoEspecifico(int dato) {
		if(nodoInicio == null) {// caso 1: lista vacia 
			return -1;
		}else if(nodoInicio == nodoFin && nodoInicio.getDato() == dato) { //caso 2: Hay un solo nodo
			System.out.println("encontrado en el primero NODO");
			int n = nodoInicio.getDato();
			nodoInicio = nodoFin = null;
			return n;
		}else { // caso 3: hay mas de un nodo y el dato puede estar en alguno de ellos
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();
			
			while(nodoSiguiente != null && nodoSiguiente.getDato() != dato) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
			}
			
			if(nodoSiguiente != null && nodoSiguiente.getDato() == dato) {
				int n = nodoSiguiente.getDato();
				nodoAnterior.setNodoSiguiente(nodoSiguiente.getNodoSiguiente());
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				
				return n;
			}else {
				return -2;
			}
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
		
		System.out.println("\n -----------------------------------");
		//Se agregaron mas datos para pruebas
		lde.agregarAlInicio(12);
		lde.agregarAlFinal(17);
		lde.agregarAlInicio(15);
		
		lde.mostrarElementos();
		
		System.out.println("\n --- Eliminar dato especifico ---");
		int num = lde.eliminarDatoEspecifico(7);
	
		if(num == -1)
			System.out.println("Lista vacia");
		else if(num == -2)
			System.out.println("No se encontró el dato");
		else
			System.out.println("Se eliminó el " + num + " correctamente");
		
		lde.mostrarElementos();

	}

}
