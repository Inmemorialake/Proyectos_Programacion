#include <iostream>
#include <string>

using namespace std;

class Tiempo{
private: //atributos
    int hora, min, sec;

public: //metodos
    Tiempo(int hora, int min, int sec);
    Tiempo(long);
    void mostrar_tiempo();
};

Tiempo::Tiempo(int _hora, int _min, int _sec) {
    hora = _hora;
    min = _min;
    sec = _sec;
};

Tiempo::Tiempo(long _tiempo){
    hora = (_tiempo / 60) / 60;
    min = _tiempo / 60 - hora * 60;
    sec = _tiempo - ((min * 60) + (hora * 60 * 60));

}

void Tiempo::mostrar_tiempo() {
    cout <<"El tiempo dado son: " << hora << " hora(s), " << min << " minutos y " << sec << "segundos." << endl;
}

int main() {
    int a, b, c, opcion;
    long t;
    string aux;
    bool control = false;

    do{
        cout << "Seleccione el formato en el que desea ingresar el tiempo: \n1. horas/minutos/segundos \n2. Segundos" << endl;
        getline(cin, aux);
        opcion = stoi(aux);

        switch (opcion) {
        case 1: {
            cout <<"Ingrese el numero de horas: ";
            getline(cin,aux);
            a = stoi(aux);
            cout <<"Ingrese el numero de minutos: ";
            getline(cin,aux);
            b = stoi(aux);
            cout <<"Ingrese el numero de segundos: ";
            getline(cin,aux);
            c = stoi(aux);
            Tiempo t1(a,b,c);
            t1.mostrar_tiempo();
            control = true;
        }
        break;

        case 2: {
            cout << "Ingrese los segundos a convertir en horas, minutos y segundos: ";
            getline(cin,aux);
            t = stol(aux);
            Tiempo t2(t);
            t2.mostrar_tiempo();
            control = true;
        }
        break;
        
        default:
            cout << "Esa opción no es valida, por favor ingresa una opción valida: " << endl;
        break;
        }
    } while (control == false);
return 0;
}