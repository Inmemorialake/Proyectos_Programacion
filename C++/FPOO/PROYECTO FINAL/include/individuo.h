/*
Archivo: individuo.h
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
CLASE: Individuo
INTENCIÓN: Padre de Robot, Conejo, Zorro, y Lechuga. Es una clase abstracta, ya que solamente es usada para que los
diferentes tipos de individuos compartan un mismo padre, metodos generales y atributo type. Que sean hijas de 
individuo nos permite que puedan ser guardados en nuestro array de punteros a tipo Individuo.
RELACIONES:
- es una clase.
- no contiene.
- no conoce.
*/

#ifndef INDIVIDUO_H
#define INDIVIDUO_H

#include "utilities.h"

//Clase abstracta; No puede ser instanciada, solamente sirve como clase padre para las demas (Esto gracias al metodo puramente virtual clone())
class Individuo{
    protected:
        //Nos permite diferenciar el tipo de objeto
        int type;

        //Nos permite identificar el orden del objeto (Saber si es el primer robot, segundo robot, tercer robot, etc)
        int order; 
    public:
        //Constructor de individuo. Convierte el tipo a 0 (aunque despues el constructor de cada clase hija lo cambia por su respectivo numero)
        Individuo();

        //Metodo que devuelve el tipo del individuo. Es heredado por las clases hijas.
        int giveType();

        //Metodo que devuelve el orden del individuo. Es heredado por las clases hijas.
        int getOrder();

        /*Usado para poder intercambiar objetos entre los array Individuos de cada lugar.
        Es virtual para que pueda ser overwriteado por las clases hijas.
        Es un puntero de individuo porque solo crea la memoria dinamica que se le asigna a los index de nuevo.
        el const = 0 es para indicar que cada clase hija requiere definirlo por si misma. Esta clase base no lo tendra implementado.*/
        virtual Individuo* clone() const = 0;

        //Destructor
        virtual ~Individuo();
};

#else
    class Individuo;
#endif