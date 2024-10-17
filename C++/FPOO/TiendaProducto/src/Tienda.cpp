#include "Tienda.h"
#include <iostream>
#include <algorithm>
#include <cctype>

using namespace std;

Tienda::Tienda() {
    numProductos = 0;
}

void Tienda::ingresarProducto() {
    if (numProductos >= 10) {
        cout << "No se pueden ingresar más productos. La tienda está llena.\n";
        return;
    }

    string nombre;
    float precio;
    int cantidad;

    cout << "Ingrese el nombre del producto: ";
    getline(cin, nombre);
    cout << "Ingrese el precio del producto: ";
    cin >> precio;
    cout << "Ingrese la cantidad en stock del producto: ";
    cin >> cantidad;
    cin.ignore(); // Para limpiar el buffer

    // Convertir nombre a minúsculas
    transform(nombre.begin(), nombre.end(), nombre.begin(), ::tolower);

    for (int i = 0; i < numProductos; ++i) {
        if (productos[i].getNombre() == nombre) {
            productos[i].actualizarStock(cantidad);
            cout << "Producto actualizado con éxito.\n";
            return;
        }
    }

    productos[numProductos] = Producto(nombre, precio, cantidad);
    numProductos++;
    cout << "Producto ingresado con éxito.\n";
}

void Tienda::mostrarProductos() {
    for (int i = 0; i < numProductos; ++i) {
        cout << "Nombre: " << productos[i].getNombre() << ", Precio: " << productos[i].getPrecio() << ", Cantidad en stock: " << productos[i].getCantidadEnStock() << endl;
    }
}

void Tienda::buscarProductoPorNombre() {
    string nombre;
    cout << "Ingrese el nombre del producto a buscar: ";
    getline(cin, nombre);

    // Convertir nombre a minúsculas
    transform(nombre.begin(), nombre.end(), nombre.begin(), ::tolower);

    for (int i = 0; i < numProductos; ++i) {
        string productoNombre = productos[i].getNombre();
        if (productoNombre.find(nombre) != string::npos) {
            cout << "Nombre: " << productos[i].getNombre() << ", Precio: " << productos[i].getPrecio() << ", Cantidad en stock: " << productos[i].getCantidadEnStock() << endl;
        }
    }
}

void Tienda::calcularPorcentajesDeStock() {
    int totalUnidades = 0;
    for (int i = 0; i < numProductos; ++i) {
        totalUnidades += productos[i].getCantidadEnStock();
    }

    for (int i = 0; i < numProductos; ++i) {
        float porcentaje = (productos[i].getCantidadEnStock() / (float)totalUnidades) * 100;
        cout << "Nombre: " << productos[i].getNombre() << ", Cantidad en stock: " << productos[i].getCantidadEnStock() << ", Porcentaje: " << porcentaje << "%" << endl;
    }
}

void Tienda::buscarProductosPorRangoDePrecios() {
    float min, max;
    cout << "Ingrese el precio mínimo: ";
    cin >> min;
    cout << "Ingrese el precio máximo: ";
    cin >> max;
    cin.ignore(); // Para limpiar el buffer

    for (int i = 0; i < numProductos; ++i) {
        if (productos[i].getPrecio() >= min && productos[i].getPrecio() <= max) {
            cout << "Nombre: " << productos[i].getNombre() << ", Precio: " << productos[i].getPrecio() << endl;
        }
    }
}

void Tienda::modificarPrecioProducto() {
    string nombre;
    cout << "Ingrese el nombre del producto al que desea modificar el precio: ";
    getline(cin, nombre);

    // Convertir nombre a minúsculas
    transform(nombre.begin(), nombre.end(), nombre.begin(), ::tolower);

    for (int i = 0; i < numProductos; ++i) {
        if (productos[i].getNombre() == nombre) {
            float precioActual = productos[i].getPrecio();
            float nuevoPrecio;
            cout << "Precio actual: " << precioActual << "\nIngrese el nuevo precio: ";
            cin >> nuevoPrecio;
            cin.ignore(); // Para limpiar el buffer
            productos[i].setPrecio(nuevoPrecio);
            cout << "Precio actualizado con éxito.\n";
            return;
        }
    }

    cout << "Producto no encontrado.\n";
}
