cmake_minimum_required(VERSION 3.10)  # Establece la versión mínima de CMake requerida

project(Libro)  # Nombre del proyecto

set(CMAKE_CXX_STANDARD 17)  # Establece el estándar de C++
set(CMAKE_CXX_STANDARD_REQUIRED True)

include_directories(include)  # Añade el directorio de encabezados
file(GLOB SOURCES "src/*.cpp")  # Añade todos los archivos fuente

add_executable(Libro ${SOURCES})  # Añade el ejecutable y los archivos fuente
