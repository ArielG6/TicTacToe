package api;

public interface ConjuntoTDA {
	void InicializarConjunto();		//Sin condiciones
	void Agregar(int x);			//Conjunto inicializado
	void Sacar(int x);				//Conjunto inicializado y no vac�o
	int Elegir();					//Conjunto inicializado y no vac�o
	boolean Pertenece(int x);		//Conjunto inicializado y no vac�o
	boolean ConjuntoVacio();		//Conjunto inicializado
	
}
