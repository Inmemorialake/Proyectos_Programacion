# Requiere una versión mínima de CMake
cmake_minimum_required(VERSION 3.10)

# Nombre del proyecto
project(EjercicioTienda)

# Establece el estándar de C++
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# Incluye la carpeta de encabezados
include_directories(include)

# Añade los archivos fuente (puedes agregar más archivos aquí si es necesario)
file(GLOB SOURCES src/*.cpp)

# Crea el ejecutable del proyecto
add_executable(Tienda ${SOURCES})