package imp;

import api.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	
	public class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
		
	}
	NodoPrioridad mayorPrioridad;

	public void InicializarCola() {
		mayorPrioridad = null;

	}

	public void AcolarPrioridad(int x, int prioridad) {
		//Creo el nuevo nodo que voy a acolar
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		//Si la cola está vacía o bien es más prioritario que el primero
		//hay que agregarlo al principio
		if(mayorPrioridad != null || prioridad > mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}
		else {
			//Sabemos que mayorPrioridad no es null
			NodoPrioridad aux = mayorPrioridad;
			while (aux.sig!=null && aux.sig.prioridad>=prioridad) {
				aux= aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
	}

	public void Desacolar() {
		mayorPrioridad = mayorPrioridad.sig;

	}

	public int Primero() {
		return mayorPrioridad.info;
	}

	public int Prioridad() {
		return mayorPrioridad.prioridad;
	}

	public boolean ColaVacia() {
		return (mayorPrioridad==null);
	}

}
