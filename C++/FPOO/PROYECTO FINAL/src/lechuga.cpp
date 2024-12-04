#include "lechuga.h"

Lechuga::Lechuga(int order){this->type = 4; this->order = order;}

//Metodo clone necesario de implementar en cada clase hija.
Individuo* Lechuga::clone() const{
    return new Lechuga(order);
}

Lechuga::~Lechuga(){}