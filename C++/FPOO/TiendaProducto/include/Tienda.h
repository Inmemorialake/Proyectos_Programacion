#ifndef TIENDA_H
#define TIENDA_H

#include "Producto.h"

class Tienda {
private:
    Producto productos[10];
    int numProductos;
public:
    Tienda();
    void ingresarProducto();
    void mostrarProductos();
    void buscarProductoPorNombre();
    void calcularPorcentajesDeStock();
    void buscarProductosPorRangoDePrecios();
    void modificarPrecioProducto();
};

#endif // TIENDA_H
