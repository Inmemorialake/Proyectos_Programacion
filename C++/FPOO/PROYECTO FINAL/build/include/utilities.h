/*
Archivo: utilities.h
Autores:
Manuela Martínez Moncada Manuela.moncada@correounivalle.edu.co
Juan Esteban Arias Saldaña juan.arias.saldana@correounivalle.edu.co
Sebastian Calvo Carvajal sebastian.calvo@correounivalle.edu.co
Andrés Gerardo González Rosero  andres.gerardo.gonzalez@correounivalle.edu.co
Fecha creación: 2/11/2024
Fecha última modificación: 12/11/2024
Versión: 1.0.0
Licencia: GNU-GPL
*/
/**
CLASE: Utilities
INTENCION: Este archivo contiene algunas funciones recurrentes dentro del programa, lo utilizamos como una forma de ahorrar lineas de codigo
           y agregar mas claridad al codigo.
*/
#ifndef UTILITIES_H
#define UTILITIES_H

#include<iostream>
#include<string>

using std::string;
using std::cout;
using std::cin;

#ifdef _WIN32
    #include<Windows.h>
#else
    #include<unistd.h>
#endif

inline void cls(){
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

inline void sleepFor(unsigned int milisegundos){
    #ifdef _WIN32
        Sleep(milisegundos);
    #else
        usleep(milisegundos * 1000);
    #endif
}

inline void wait4Enter(){
    cout<<"\n(Presiona Enter para continuar...)";
    getchar();
}

#endif