package api;

public interface ConjuntoTDA {
	void InicializarConjunto();		//Sin condiciones
	void Agregar(int x);			//Conjunto inicializado
	void Sacar(int x);				//Conjunto inicializado y no vacío
	int Elegir();					//Conjunto inicializado y no vacío
	boolean Pertenece(int x);		//Conjunto inicializado y no vacío
	boolean ConjuntoVacio();		//Conjunto inicializado
	
}
