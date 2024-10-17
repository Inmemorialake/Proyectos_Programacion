#include <iostream>

using namespace std;

// Declaración de funciones
void ingresarDatos(int arr[], int tam);
void mostrarDatos(const int arr[], int tam);
int sumarDatos(const int arr[], int tam);
void mostrarPares(const int arr[], int tam);

int main() {
    const int TAM = 10;
    int arreglo[TAM] = {0};
    int opcion;

    do {
        // Mostrar el menú
        cout << "--------------------------------------" << endl;
        cout << "**** PROGRAMA MENU DE ARREGLOS ****" << endl;
        cout << "Digite el numero para ingresar a una opcion:" << endl;
        cout << "1-Ingresar datos en arreglo" << endl;
        cout << "2-Mostrar los datos del arreglo" << endl;
        cout << "3-Sumar datos del arreglo" << endl;
        cout << "4-Mirar datos de las posiciones pares" << endl;
        cout << "5-Salir" << endl;
        cin >> opcion;

        // Realizar la acción correspondiente
        switch (opcion) {
            case 1:
                ingresarDatos(arreglo, TAM);
                break;
            case 2:
                mostrarDatos(arreglo, TAM);
                break;
            case 3:
                cout << "La suma de los datos es: " << sumarDatos(arreglo, TAM) << endl;
                break;
            case 4:
                mostrarPares(arreglo, TAM);
                break;
            case 5:
                cout << "Saliendo del programa..." << endl;
                break;
            default:
                cout << "Opcion invalida. Intente de nuevo." << endl;
        }
        cout << endl;
    } while (opcion != 5);

    return 0;
}

// Función para ingresar datos en el arreglo
void ingresarDatos(int arr[], int tam) {
    cout << "Ingrese " << tam << " numeros enteros:" << endl;
    for (int i = 0; i < tam; i++) {
        cout << "Dato " << i + 1 << ": ";
        cin >> arr[i];
    }
}

// Función para mostrar los datos del arreglo
void mostrarDatos(const int arr[], int tam) {
    cout << "Los datos del arreglo son:" << endl;
    for (int i = 0; i < tam; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

// Función para sumar los datos del arreglo
int sumarDatos(const int arr[], int tam) {
    int suma = 0;
    for (int i = 0; i < tam; i++) {
        suma += arr[i];
    }
    return suma;
}

// Función para mostrar los datos de las posiciones pares
void mostrarPares(const int arr[], int tam) {
    cout << "Los datos en posiciones pares son:" << endl;
    for (int i = 0; i < tam; i += 2) {
        cout << "Posicion " << i << ": " << arr[i] << endl;
    }
}
