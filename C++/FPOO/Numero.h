#ifndef NUMERO_H
#define NUMERO_H
#include <string>
#include <iostream>

using namespace std;

class Numero{;
    private:
        string tipo;
        int valor;
    public:
        Numero();
        Numero(string, int);
        int getvalor();
        string getTipo();
        virtual ~Numero();
};

#endif // NUMERO_H
