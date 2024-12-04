#include "zorro.h"

Zorro::Zorro(int order){this->type = 2; this->order = order;}

//Metodo clone necesario de implementar en cada clase hija.
Individuo* Zorro::clone() const{
    return new Zorro(order);
}

Zorro::~Zorro(){}