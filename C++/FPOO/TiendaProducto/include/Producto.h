#ifndef PRODUCTO_H
#define PRODUCTO_H

#include <string>
using namespace std;

class Producto {
private:
    string nombre;
    float precio;
    int cantidadEnStock;
public:
    Producto(string nombre, float precio, int cantidadEnStock);
    string getNombre();
    float getPrecio();
    int getCantidadEnStock();
    void setPrecio(float precio);
    void setCantidadEnStock(int cantidad);
    void actualizarStock(int cantidad);
    void toLowerCase();
};

#endif // PRODUCTO_H