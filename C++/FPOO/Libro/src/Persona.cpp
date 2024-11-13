#include "Persona.h"

Persona::Persona() : nombre(""), unL(nullptr) {}

Persona::Persona(string nombre) : nombre(nombre), unL(nullptr) {}

Libro* Persona::prestar(Libro* libro) {
    unL = libro;
    return unL;
}

string Persona::recibe(Libro* libro) {
    unL = libro;
    return "Libro recibido: " + libro->getNombre();
}

string Persona::rompePaginas(int paginas) {
    if (!unL) {
        throw logic_error("No hay libro para romper páginas.");
    }
    return unL->romper(paginas);
}

string Persona::getNombre() {
    return nombre;
}

Libro* Persona::getLibro() {
    return unL;
}
