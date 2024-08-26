package api;

public interface GrafoTDA {
	void InicializarGrafo();						//Sin precondiciones
	void AgregarVertice(int v);						//Grafo inicializado y no existe el vértice
	void EliminarVertice(int v);					//Grafo inicializado y existe el vértice
	ConjuntoTDA Vertices();							//Grafo inicializado
	void AgregarArista(int v1, int v2, int peso);	//Grafo inicializado, existen vértices y no existe la arista previamente
	void EliminarArista(int v1, int v2);			//Grafo inicializado y xiste la arista
	boolean ExisteArista(int v1, int v2);				//Grafo inicializado y existen los vértices
	int PesoArista(int v1, int v2);					//Grafo inicializado y existe la arista
}
