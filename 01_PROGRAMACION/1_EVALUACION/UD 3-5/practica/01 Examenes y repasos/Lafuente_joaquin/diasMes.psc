Algoritmo diasMes
	Definir dia Como Entero;
	Definir  diasTotales Como Entero;
	
	Escribir " Dime un d�a: ";
	leer dia
	diasTotales = 0;
	
	Mientras dia <> -1 Hacer
		Escribir "Dime otro dia";
		leer dia;
		Si dia < 32 y dia >0 Entonces
			diasTotales = diasTotales +1
		SiNo 
			Si dia <> -1 Entonces
				Escribir" Error: d�a inv�lido ";	
			Fin Si
			
		Fin Si
		
	Fin Mientras
	Escribir "Se han introducido un total de " diasTotales+1 " d�as";
	
FinAlgoritmo
