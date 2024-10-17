#include "Producto.h"
#include <algorithm>
#include <iostream>

Producto::Producto(string nombre, float precio, int cantidadEnStock) {
    this->nombre = nombre;
    this->precio = precio;
    this->cantidadEnStock = cantidadEnStock;
}

string Producto::getNombre() {
    return nombre;
}

float Producto::getPrecio() {
    return precio;
}

int Producto::getCantidadEnStock() {
    return cantidadEnStock;
}

void Producto::setPrecio(float precio) {
    this->precio = precio;
}

void Producto::setCantidadEnStock(int cantidad) {
    this->cantidadEnStock = cantidad;
}

void Producto::actualizarStock(int cantidad) {
    this->cantidadEnStock += cantidad;
}

void Producto::toLowerCase() {
    transform(nombre.begin(), nombre.end(), nombre.begin(), ::tolower);
}
