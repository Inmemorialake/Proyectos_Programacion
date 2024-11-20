#ifndef CONTIENENUMEROS_H
#define CONTIENENUMEROS_H
#include "Numero.h"


class ContieneNumeros
{
    private:
        Numero numeros[100];
        int cantidad;
    public:
        ContieneNumeros();
        void LlenarArregloNumeros();
        void metodoOpcional();
        virtual ~ContieneNumeros();
};

#endif // CONTIENENUMEROS_H
