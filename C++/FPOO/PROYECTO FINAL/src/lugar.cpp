#include "lugar.h"

Lugar::Lugar(){this->Individuos = nullptr; this->size = 0;}

int Lugar::checks(){
    int dangerZorro = false;
    int dangerConejo = false;
    int dangerLechuga = false;
    mensaje = "";

    for(int i = 0; i < size; i++){
        if(Individuos[i] != nullptr){
            if(Individuos[i]->giveType() == 1){
                return 1;
            }
            //usamos tambien el check de la variable en false para evitar que el codigo se repita innecesariamente
            if(Individuos[i]->giveType() == 2){
                dangerZorro = true;
            }

            if(Individuos[i]->giveType() == 3){
                dangerConejo = true;
            }

            if(Individuos[i]->giveType() == 4){
                dangerLechuga = true;
            }
        }
    }

    if(dangerZorro && dangerConejo){
        mensaje += "El zorro se ha comido al conejo! ";
        return 2;
    }
    else if(dangerConejo && dangerLechuga){ 
        mensaje += "El conejo se ha comido la lechuga! ";
        return 3;
    }
    
    return 1;
}

bool Lugar::addIndividuo(Individuo* individuo){

    for(int i = 0; i < size; i++){
        if(Individuos[i]  == nullptr){
            Individuos[i] = individuo->clone();
            return true;
        }
    }

    return false;
}

bool Lugar::removeIndividuo(int index){
    delete Individuos[index];

    for(int i = index; i < size-1; i++){
        Individuos[i] = Individuos[i+1];
    }

    Individuos[size-1] = nullptr;

    return true;
}

Individuo**& Lugar::getIndividuos(){
    return Individuos;
}

int Lugar::giveSize(){
    return size;
}

string Lugar::giveMensaje(){
    return mensaje;
}

Lugar::~Lugar(){
    for(int i = 0; i < size; i++){
        delete Individuos[i];
    }
    delete[] Individuos;
}