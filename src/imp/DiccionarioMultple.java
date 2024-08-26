package imp;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DiccionarioMultple implements DiccionarioMultipleTDA {
	
	class Elemento{
		int clave;
		//ConjuntoTDA valor;
		int[] valores;
		int cantvalores;
	}
	
	Elemento[] elementos;
	int cant;
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cant = 0;
	}

	public void Agregar(int clave, int valor) {
		int i = Clave2Indice(clave);
		if (i==-1) {
			i = cant;
			elementos[i]= new Elemento();
			elementos[i].clave=clave;
			elementos[i].cantvalores = 0;
			elementos[i].valores = new int[100];
			cant++;
		}
		Elemento e = elementos[i];
		int j = Valor2Indice(e,valor);
		if(j==-1) {
			e.valores[e.cantvalores]= valor;
			e.cantvalores++;
		}
		

	}
	
	private int Clave2Indice (int clave) {
		int i = cant-1;
		while (i>=0 && elementos[i].clave!=clave) {
			i--;
		}
		return i;
	}
	
	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantvalores-1;
		while (i>=0 && e.valores[i]!=valor) {
			i--;
		}
		return i;
	}
	public void Eliminar(int clave) {
		int i = Clave2Indice(clave);
		if (i!=-1) {
			elementos[i] = elementos[cant-1];
			cant--;
		}
	}

	public void EliminarValor(int clave, int valor) {
		int i = Clave2Indice(clave);
		if (i!=-1) {
			Elemento e = elementos[i];
			int j = Valor2Indice(e,valor);
			if (j!=-1) {
				e.valores[j]=e.valores[e.cantvalores-1];
				e.cantvalores--;
				if (e.cantvalores==0) {
					Eliminar(clave);
				}
			}
		}
	}

	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		int i = Clave2Indice(clave);
		if (i!=-1) {
			Elemento e = elementos[i];
			for (int j=0;j<e.cantvalores;j++) {
				valores.Agregar(e.valores[j]);
			}
		}
		return valores;
	}

	public ConjuntoTDA Claves() {
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		for (int i=0; i<cant;i++) {
			claves.Agregar(elementos[i].clave);
		}
		return claves;
	}

}
