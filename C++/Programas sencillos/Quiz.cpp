#include <iostream>
#include <string>
#include <cmath>

using namespace std;

bool esPrimo(int numero) {
    if (numero <= 1) {
        return false;
    }
    for (int i = 2; i <= sqrt(numero); i++) {
        if (numero % i == 0) {
            return false;
        }
    }
    return true;
}

string abecedario = "abcdefghijklmnñopqrstuvwxyz";

int main() {
    string palabra = "";
    cout <<"Ingrese la palabra que desea cifrar: ";
    getline(cin, palabra);
    int primos[27];
    int contador = 0;

    for (int i = 0; i < 104; i++) {
        if (esPrimo(i) == true){
            primos[contador] = i;
            contador = contador + 1;
        }
    }

    int tamano = palabra.size();
    int *cifrado = new int[tamano];

    for (int i = 0 ; i < tamano ;i++) {
        int posicion = abecedario.find(tolower(palabra[i]));
        cifrado[i] = primos[posicion];
    }

    cout <<"la palabra cifrada es: ";
    for (int i = 0 ; i < tamano ; i++){
        cout << cifrado[i] << ",";
    }
}
