Algoritmo Ejemplo
	Definir num Como Entero;
	Definir num2 Como Entero;
	
	Escribir "Introduzca un n�mero";
	Leer num;
	
	Escribir "Introduzca el siguiente n�mero";
	Leer num2;

	
	Seg�n num2 Hacer
		Caso 0:
			Escribir "Uno de los factores es 0";
		Caso 1:
			Escribir "El resultado es: ", num;
		De Otro Modo:
			Escribir "El resultado es: ", num*num2;
	FinSegun
	
	
//	Si num2 = 0 
//		Entonces
	//	Escribir "Uno de los factores es 0"
//	SiNo
	//	Escribir "El resultado es: ", num*num2;
	//FinSi
FinAlgoritmo
