//Escribir un Pseudoc�digo que reciba un n�mero 
// y compruebe si es par o impar
Algoritmo parImpar
	Definir resultado como Cadena;
	Definir N Como Entero;
	Escribir "Ingrese el numero: ";
	Leer N;
	
	Si N % 2 = 0 Entonces
		resultado <- "par"
	SiNo
		resultado <- "impar"
	FinSi
	
	Escribir "El n�mero introducido es ", resultado;	
FinAlgoritmo
