#include "orilla.h"

Orilla::Orilla(int size){
    Individuos = new Individuo*[size]; 

    //Inicializamos los punteros con nullptr para evitar problemas de leaks de memoria
    for(int i = 0; i < size; i++){
        Individuos[i] = nullptr;
    }

    this->size = size;
}

Orilla::Orilla(Individuo** Individuos, int size){
    this->size = size;
    this->Individuos = new Individuo*[this->size];

    for(int i = 0; i < size; i++){
        this->Individuos[i] = Individuos[i];
        Individuos[i] = nullptr;
    }

    Individuos = nullptr; /*Con la forma que hemos hecho, nos aseguramos de borrar totalmente el puntero
    que hemos pasado como referencia. Esto es lo mas similar a una operacion de "Mover", ya que ahora
    el puntero original de la referencia ha sido completamente borrado pero cada dato de su memoria ahora
    es accesible desde */
}

int Orilla::checks(){
    if(Lugar::checks() == 1){
        for(int i = 0; i < size; i++){
            if(Individuos[i] == nullptr) return 1;
        } 

        return 4;
        mensaje += "No hay espacio en esta orilla. ";
    }

    else{
        return Lugar::checks();
    }
}

Orilla::~Orilla(){} 