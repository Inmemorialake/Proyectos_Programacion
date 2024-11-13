#ifndef PERSONA_H
#define PERSONA_H

#include <string>
#include "Libro.h"

using namespace std;

class Persona {
private:
    string nombre;
    Libro* unL;

public:
    Persona();
    Persona(string);
    Libro* prestar(Libro*);
    string recibe(Libro*);
    string rompePaginas(int);
    string getNombre();
    Libro* getLibro();
};

#endif // PERSONA_H
