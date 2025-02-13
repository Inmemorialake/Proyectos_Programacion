/*
Archivo: lugar.h
Autores:
Manuela Martínez Moncada Manuela.moncada@correounivalle.edu.co
Juan Esteban Arias Saldaña juan.arias.saldana@correounivalle.edu.co
Sebastian Calvo Carvajal sebastian.calvo@correounivalle.edu.co
Andrés Gerardo González Rosero  andres.gerardo.gonzalez@correounivalle.edu.co
Fecha creación: 2/11/2024
Fecha última modificación: 12/11/2024
Versión: 1.0.0
Licencia: GNU-GPL
*/
/**
CLASE: Lugar
INTENCION:  
RELACIONES:
- es padre de Orilla y Barca.
- Contiene a individuo.
- No conoce.
*/
#ifndef LUGAR_H
#define LUGAR_H

#include "utilities.h"
#include "robot.h"
#include "zorro.h"
#include "conejo.h"
#include "lechuga.h"

class Lugar{
    protected:
        /*Puntero a puntero; Nos permite tener un arreglo de punteros a objetos Individuo y derivados de este. Justamente por los
        derivados es que lo usamos: Necesitamos una forma de guardar en un mismo arreglo objetos de diferente tipo con una misma clase
        padre (Inidivuo), y esta es una de las formas de hacerlo (Los punteros que apuntan a Individuo tambien permiten que se apunte
        a clases derivadas de este)*/
        Individuo** Individuos;
        
        //Mensaje de error que el programa devuelve. Cada check añadira respectivamente al mensaje el output2
        string mensaje;

        //Usamos una variable size ya que los arreglos dinamicos no tienen una forma directa para obtener su tamaño, por ende lo tenemos que controlar con una var.
        int size;
    public:
        /*Constructor que deja nuestro array individuos siendo nullptr y el tamaño siendo igual a 0. De todas maneras,
        estos valores luego son reemplazados por el constructor de Orilla o de Barca*/
        Lugar();
        
        /*Realiza diferentes checks que pueden ser generales independientemente de si es una barca o una orilla (Los checks extra
        que cada uno de estos se realizan como un añadido en el override del metodo checks de cada uno de estos), tales como 
        la posibilidad de que el zorro se coma al conejo o de que el conejo se coma a la lechuga. Dependiendo de estos casos, devuelve un
        entero y añade un texto que describe la sitaucion en el atributo "mensaje"*/
        virtual int checks();

        //Recibe un puntero de tipo individuo, luego busca un espacio libre (nullptr) en el arreglo de individuos y clona el contenido del puntero al index del arreglo.
        bool addIndividuo(Individuo* individuo);

        /*Algoritmo que borra el index especificado y mueve todos los siguientes 
            una posicion atras. Ej: 
            ["Gato", "Perro", "Hora", "Default", "Default"] -> removeIndividuo(2) -> ["Gato", "Perro", "Default", "Default", "Default"]*/
        bool removeIndividuo(int index);

        //Metodo para devolver el arreglo de cada lugar, especialmente necesario para logica y para jugador.
        /*El significado del ampersand es para devolver una referencia directa de este puntero; Cuando creas la 
        funcion sin el ampersand, realmente lo que estas haciendo es devolver una copia de este puntero, lo cual
        de todas maneras funciona ya que esta copia sigue apuntando a las mismas direcciones de memoria del
        original, el problema es que cuando intentamos modificar directamente el arreglo en la funcion playAgain
        obtuvimos errores ya que no se necesitaba trabajar con los valores de memoria del puntero, sino con el puntero
        mismo para poder modificarlo.*/
        Individuo**& getIndividuos();

        //Retorna el tamaño del arreglo de individuos de lugar
        int giveSize();

        //Retorna el mensaje del lugar que se obtiene despues de hacer los checks
        string giveMensaje();

        //Destruye el arreglo de individuos index por index y luego a el mismo con delete[]
        virtual ~Lugar();
};

#else
    class Lugar;
#endif