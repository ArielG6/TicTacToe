package api;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario ();			//Sin condiciones
	void Agregar(int clave, int valor);		//Diccionario inicializado
	void Eliminar(int clave);				//Diccionario inicializado
	int Recuperar(int clave);				//Diccionario inicializado y existe la clave
	ConjuntoTDA Claves();					//Diccionario inicializado
}
