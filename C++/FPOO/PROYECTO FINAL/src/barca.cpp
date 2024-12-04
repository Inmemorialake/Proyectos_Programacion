#include "barca.h"

Barca::Barca(){
    this->Individuos = new Individuo*[2]; 

    for(int i = 0; i < 2; i++){
        Individuos[i] = nullptr;
    }

    this->size = 2;    
}

int Barca::checks(){
    if(Lugar::checks() == 1){
        for(int i = 0; i < size; i++){
            if(Individuos[i] != nullptr){
                if(Individuos[i]->giveType() == 1) return 1;
            }

            else if(i == size-1){
                mensaje += "No hay robot en la barca. ";
                return 5;
            }
        }

        mensaje += "No hay espacio en la barca. ";
        return 6;
    }

    return Lugar::checks();
}

void Barca::CambiarLado(){
    if(lado == 'L'){
            lado = 'R';
            return;
    }
    else {lado = 'L';}
}

char Barca::giveLado(){
    return lado;
}

Barca::~Barca(){}