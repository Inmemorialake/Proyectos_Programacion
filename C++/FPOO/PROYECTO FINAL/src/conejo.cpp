#include "conejo.h"

Conejo::Conejo(int order){this->type = 3; this->order = order;}

//Metodo clone necesario de implementar en cada clase hija.
Individuo* Conejo::clone() const{
    return new Conejo(order);
}

Conejo::~Conejo(){}