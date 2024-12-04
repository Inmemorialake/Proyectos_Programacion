#include "individuo.h"

Individuo::Individuo(){this->type = 0; this->order = 0;}

int Individuo::giveType(){return type;}

int Individuo::getOrder(){return order;}

/*Usado para poder intercambiar objetos entre los array Individuos de cada lugar.
Es virtual para que pueda ser overwriteado por las clases hijas.
Es un puntero de individuo porque solo crea la memoria dinamica que se le asigna a los index de nuevo.
el const = 0 es para indicar que cada clase hija requiere definirlo por si misma. Esta clase base no lo tendra implementado.*/

Individuo::~Individuo(){}