#include "ContieneNumeros.h"

ContieneNumeros::ContieneNumeros(){
}

void ContieneNumeros::LlenarArregloNumeros(){
    string aux = "", aux1 = "";
    cout <<"Ingrese la cantidad de numeros que desea ingresar: ";
    getline(cin, aux);
    int cantidad = stoi(aux);
    for(int i=0; cantidad; i++){
        cout << "/nIngrese el tipo de numero que desea ingresar en la posición" << i ;
        getline(cin, aux);
        cout << "/nIngrese el valor del numero que desea ingresar en la posición" << i ;
        getline(cin, aux1);
        numeros[i] = Numero(aux, stoi(aux1));
        aux="";
        aux1="";
    }
}
void ContieneNumeros::metodoOpcional(){

}

ContieneNumeros::~ContieneNumeros()
{
    //dtor
}
