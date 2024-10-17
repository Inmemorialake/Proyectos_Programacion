#include <iostream>
#include "Producto.h"
#include "Tienda.h"

using namespace std;

int main() {
    Tienda tienda;
    int opcion;
    do {
        cout << "Menu de opciones:\n";
        cout << "1. Ingresar producto\n";
        cout << "2. Mostrar productos\n";
        cout << "3. Buscar producto por nombre\n";
        cout << "4. Calcular porcentajes de stock\n";
        cout << "5. Buscar productos por rango de precios\n";
        cout << "6. Modificar precio de producto\n";
        cout << "7. Salir\n";
        cout << "Ingrese una opción: ";
        cin >> opcion;
        cin.ignore(); // Para limpiar el buffer

        switch(opcion) {
            case 1: tienda.ingresarProducto(); break;
            case 2: tienda.mostrarProductos(); break;
            case 3: tienda.buscarProductoPorNombre(); break;
            case 4: tienda.calcularPorcentajesDeStock(); break;
            case 5: tienda.buscarProductosPorRangoDePrecios(); break;
            case 6: tienda.modificarPrecioProducto(); break;
            case 7: cout << "Saliendo...\n"; break;
            default: cout << "Opción inválida\n"; break;
        }
    } while(opcion != 7);

    return 0;
}
