#include "Libro.h"

Libro::Libro() : nombreL(""), numeroPaginas(0), paginasRotas(0) {}

Libro::Libro(string nombre, int paginas) : nombreL(nombre), numeroPaginas(paginas), paginasRotas(0) {}

string Libro::romper(int paginas) {
    if (paginas <= 0) {
        throw invalid_argument("El número de páginas a romper debe ser positivo.");
    }
    if (paginasRotas + paginas > numeroPaginas) {
        throw out_of_range("No se pueden romper más páginas de las que tiene el libro.");
    }
    paginasRotas += paginas;
    return "Páginas rotas: " + to_string(paginasRotas);
}

string Libro::getNombre() {
    return nombreL;
}

int Libro::getNumeroPaginas() {
    return numeroPaginas;
}

int Libro::getPaginasRotas() {
    return paginasRotas;
}
