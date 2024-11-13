#ifndef LIBRO_H
#define LIBRO_H

#include <string>
#include <stdexcept>

using namespace std;

class Libro {
private:
    string nombreL;
    int numeroPaginas;
    int paginasRotas;

public:
    Libro();
    Libro(string, int);
    string romper(int);
    string getNombre();
    int getNumeroPaginas();
    int getPaginasRotas();
};

#endif // LIBRO_H
