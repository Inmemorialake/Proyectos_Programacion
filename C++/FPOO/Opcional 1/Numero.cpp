#include "Numero.h"

Numero::Numero(){
}

Numero::Numero(string tipo,int valor){
    this->tipo = tipo;
    this->valor = valor;
}
int Numero::getvalor(){
    return valor;
}

string Numero:: getTipo(){
    return tipo;
}

Numero::~Numero()
{
    //dtor
}
