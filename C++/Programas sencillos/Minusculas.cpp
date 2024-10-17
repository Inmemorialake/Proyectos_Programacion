#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std;

int main() {
    string texto;
    cout << "Ingrese el texto que desea convertir: ";
    getline(cin, texto);

    stringstream ss(texto);
    string palabra;
    string resultado;

    while (ss >> palabra) {
        transform(palabra.begin(), palabra.end(), palabra.begin(), ::tolower);
        if (!palabra.empty()) {
            palabra[0] = toupper(palabra[0]);
        }
        resultado += palabra + " ";
    }

    // Eliminar el espacio adicional al final
    if (!resultado.empty()) {
        resultado.pop_back();
    }

    cout << resultado << endl;

    return 0;
}