#include "AplicacionUso.h"
#include "Persona.h"
#include "Libro.h"
#include <iostream>
#include <sstream>

const int MAX_PERSONAS = 10;

AplicacionUso::AplicacionUso() {}

void AplicacionUso::menu() {
    Persona personas[MAX_PERSONAS];
    int numPersonas = 0;
    Libro* libro = nullptr;
    string opcion;
    string input;
    string nombre;
    int paginas;
    
    while (true) {
        cout << "=================MENU=================\n";
        cout << "1 - Crear personas y libro\n";
        cout << "2 - Asignar libro a una persona\n";
        cout << "3 - Una persona le presta el libro a otra\n";
        cout << "4 - Una persona rompe paginas del libro\n";
        cout << "5 - Mostrar informacion de las personas\n";
        cout << "6 - Salir\n";
        cout << "Elija una opcion: ";
        getline(cin, opcion);
        cout << "======================================\n";

        try {
            if (opcion == "1") {
                if (numPersonas >= MAX_PERSONAS) {
                    cout << "No se pueden crear más personas.\n";
                    continue;
                }
                cout << "Ingrese el nombre del libro: ";
                getline(cin, nombre);
                cout << "Ingrese la cantidad de paginas del libro: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                libro = new Libro(nombre, paginas);
                cout << "Ingrese el nombre de la primera persona: ";
                getline(cin, nombre);
                personas[numPersonas++] = Persona(nombre);
                cout << "Ingrese el nombre de la segunda persona: ";
                getline(cin, nombre);
                personas[numPersonas++] = Persona(nombre);
                cout << "Se crearon personas y libro con exito\n";
            } else if (opcion == "2") {
                if (libro == nullptr) {
                    cout << "Primero cree personas y libro\n";
                    continue;
                }
                if (numPersonas == 0) {
                    cout << "No hay personas creadas.\n";
                    continue;
                }
                cout << "Personas creadas:\n";
                for (int i = 0; i < numPersonas; ++i) {
                    cout << i + 1 << ". " << personas[i].getNombre() << endl;
                }
                cout << "Digite el numero de la persona a la que se asigna el libro: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                if (paginas <= 0 || paginas > numPersonas) {
                    throw out_of_range("Numero de persona invalido.");
                }
                personas[paginas - 1].prestar(libro);
                cout << personas[paginas - 1].getNombre() << " recibio el libro: " << libro->getNombre() << endl;
            } else if (opcion == "3") {
                if (libro == nullptr) {
                    cout << "Primero cree personas y libro\n";
                    continue;
                }
                if (numPersonas == 0) {
                    cout << "No hay personas creadas.\n";
                    continue;
                }
                cout << "Personas creadas:\n";
                for (int i = 0; i < numPersonas; ++i) {
                    cout << i + 1 << ". " << personas[i].getNombre() << endl;
                }
                cout << "Digite el numero de la persona que tiene el libro: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                if (paginas <= 0 || paginas > numPersonas) {
                    throw out_of_range("Numero de persona invalido.");
                }
                Persona* p1 = &personas[paginas - 1];
                if (p1->getLibro() == nullptr) {
                    cout << p1->getNombre() << " no tiene ningun libro para prestar\n";
                    continue;
                }
                cout << "Digite el numero de la persona a la que se le presta el libro: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                if (paginas <= 0 || paginas > numPersonas) {
                    throw out_of_range("Numero de persona invalido.");
                }
                Persona* p2 = &personas[paginas - 1];
                p2->recibe(p1->getLibro());
                p1->prestar(nullptr);
                cout << p1->getNombre() << " presto el libro a " << p2->getNombre() << endl;
            } else if (opcion == "4") {
                if (libro == nullptr) {
                    cout << "Primero cree personas y libro\n";
                    continue;
                }
                if (numPersonas == 0) {
                    cout << "No hay personas creadas.\n";
                    continue;
                }
                cout << "Personas creadas:\n";
                for (int i = 0; i < numPersonas; ++i) {
                    cout << i + 1 << ". " << personas[i].getNombre() << endl;
                }
                cout << "Digite el numero de la persona que rompe las paginas: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                if (paginas <= 0 || paginas > numPersonas) {
                    throw out_of_range("Numero de persona invalido.");
                }
                cout << "Ingrese la cantidad de paginas a romper: ";
                getline(cin, input);
                stringstream(input) >> paginas;
                cout << personas[paginas - 1].rompePaginas(paginas) << endl;
            } else if (opcion == "5") {
                cout << "Informacion de las personas:\n";
                for (int i = 0; i < numPersonas; ++i) {
                    cout << "Persona: " << personas[i].getNombre() << endl;
                    if (personas[i].getLibro()) {
                        cout << "Libro: " << personas[i].getLibro()->getNombre() << endl;
                        cout << "Numero de paginas: " << personas[i].getLibro()->getNumeroPaginas() << endl;
                        cout << "Paginas rotas: " << personas[i].getLibro()->getPaginasRotas() << endl;
                    } else {
                        cout << "No tiene libro.\n";
                    }
                }
            } else if (opcion == "6") {
                cout << "Saliendo...\n";
                break;
            } else {
                cout << "Opcion invalida, intente nuevamente.\n";
            }
        } catch (const exception& e) {
            cout << "Error: " << e.what() << endl;
        }
    }
}

string AplicacionUso::leer(string mensaje) {
    string input;
    cout << mensaje;
    getline(cin, input);
    return input;
}