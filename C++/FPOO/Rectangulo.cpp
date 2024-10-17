#include <iostream>
#include <string>

using namespace std;

class Rectangulo {
private:
    // atributos
    int largo, ancho;
public:
    // metodos
    Rectangulo(int largo, int ancho); // constructor
    void perimetro();
    void area();
};

// constructor
Rectangulo::Rectangulo(int _largo, int _ancho) {
    largo = _largo;
    ancho = _ancho;

}

void Rectangulo::perimetro() {
    cout << "El perimetro es: " << 2 * (largo + ancho) << endl;
}

void Rectangulo::area() {
    cout << "El area es: " << largo * ancho << endl;
}

int main() {
    int b, a;
    string aux;
    cout << "Ingrese el largo del rectangulo: ";
    getline(cin, aux);
    b = stoi(aux);
    aux.clear();
    cout << "Ingrese el ancho del rectangulo: ";
    getline(cin, aux);
    a = stoi(aux);

    Rectangulo r1(b, a);
    r1.perimetro();
    r1.area();
    return 0;
}