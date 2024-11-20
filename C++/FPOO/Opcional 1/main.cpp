//Andrés Gerardo González Rosero
#include <iostream>
#include "Numero.h"
#include "ContieneNumeros.h"

using namespace std;

int main()
{
    ContieneNumeros Lista;
    string aux="";
    int opc;
    cout<<"¿Desea llenar el arreglo de numeros? Ingrese 1, de lo contrario ingrese 2";
    getline(cin, aux);
    opc = stoi(aux);
    if (opc==1){Lista.LlenarArregloNumeros();}
    return 0;
}
