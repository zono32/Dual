#------------------------------------------------------------------------------------------
#	CREAMOS LA BASE DE DATOS PLANETAS
#------------------------------------------------------------------------------------------
drop database if exists planetas;
create database planetas;
use planetas;
#------------------------------------------------------------------------------------------
#	CREAMOS LA TABLA PLANETA
#------------------------------------------------------------------------------------------
#		id			Identificador
#		nombre		Nombre del Planeta
#		distancia	Distancia al Sol en metros
#		masa		Masa del cuerpo en Kg
#		radio		Radio del cuerpo en m
#------------------------------------------------------------------------------------------
drop table if exists planeta;
create table planeta (
	idPlaneta				INT							AUTO_INCREMENT,
    nombrePlaneta 			VARCHAR( 20 ),
    distancia 				FLOAT,
    masa					FLOAT,
    radio 					FLOAT,
    
    Constraint		PK_Planeta						Primary Key( idPlaneta ),
    Constraint		UK_Nombre_Planeta				Unique Key( nombrePlaneta ),
    Constraint		Nombre_Planeta_NO_NULO			check( nombrePlaneta IS NOT NULL ),
    Constraint		Nombre_Planeta_NO_VACÍO			check( nombrePlaneta != '' ),
    Constraint		distancia_NO_NULO				check( distancia IS NOT NULL ),
    #Constraint		distancia_NO_VACÍO				check( distancia != '' ),
    Constraint		masa_NO_NULO					check( masa IS NOT NULL ),
    #Constraint		masa_NO_VACÍO					check( masa != '' ),
    Constraint		radio_NO_NULO					check( radio IS NOT NULL ),
    #Constraint		radio_NO_VACÍO					check( radio != '' ),    
    Index 			idNombre_Planeta( nombrePlaneta )
);


#------------------------------------------------------------------------------------------
#	AGREGAMOS LOS DATOS DEL Sol y de los ocho Planetas
#------------------------------------------------------------------------------------------
	INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Sol', 1, 1.9891e30, 695500000);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Mercurio',57900000000 , 1.3e23, 2439700);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Venus', 108200000000, 4.87e24, 6051800);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Tierra', 149600000000, 5.97e24, 6371000);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Marte', 227900000000, 6.42e23,3389500);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Jupiter', 778600000000, 1.898e27, 69911000);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Saturno', 1433500000000, 5.68e26, 58232000);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Urano', 2872500000000,8.68e25, 25362000);
    INSERT INTO planeta( nombrePlaneta, distancia, masa, radio )	VALUES( 'Neptuno', 4495100000000, 1.02e26, 24622000);


#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para realizar el cálculo de la gravedad a nivel de 
#	  superficie del cuerpo
#		CREATE FUNCTION calcularGravedad
#------------------------------------------------------------------------------------------
# La gravedad es igual a la constante G = 6.67430e-11
#------------------------------------------------------------------------------------------
#
#
#				G  *  Masa
#	g = -----------------------
#				r ^ 2 
#
#
#
#------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS gravedadPlaneta //
    CREATE function calcularGravedad(masa FLOAT, radio FLOAT)
    RETURNS FLOAT
		BEGIN
            DECLARE G FLOAT;
			SET G = 6.67430e-11;
			RETURN (G * masa) / POWER(radio, 2);
        END
// DELIMITER ;


#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para obtener la velocidad de escape de la superficie
#	  del cuerpo
#		CREATE FUNCTION calcularVelocidadEscape
#------------------------------------------------------------------------------------------
#
#				______________________
#			   |	2  *  G  *  Masa
#  Vescape = \ |----------------------
#			  \|		radio
#
#
#------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------
#	Creamos un procedimiento o función para obtener la velocidad orbital del cuerpo
#		CREATE FUNCTION calcularVelocidadOrbital
#------------------------------------------------------------------------------------------
# 	Calcular la velocidad de escape
#----------------------------------------
#
#				 ______________________
#			    |	G  *  Masa
#  Vorbital = \ |----------------------
#			   \|	  radio
#
#------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------
#	Creamos una vista que muestre el nombre del Planeta, Distancia al sol (m), Masa (Kg), Radio (m), Gravedad ecuatorial, Velocidad de escape (m/s), Velocidad Orbital
#		CREATE VIEW DatosPlanetas AS SELECT 
#------------------------------------------------------------------------------------------
DROP VIEW IF EXISTS DatosPlanetas;
CREATE VIEW DatosPlanetas AS 
SELECT 
    nombrePlaneta AS 'Planeta',
    distancia AS 'Distancia al sol (m)',
    masa AS 'Masa (kg)',
    radio AS 'Radio (m)',
    calcularGravedad(masa, radio) AS 'Gravedad ecuatorial'
   # calcularVelocidadEscape(masa, radio) AS 'Velocidad de escape (m/s)',
   # calcularVelocidadOrbital(masa, radio) AS 'Velocidad Orbital'
FROM Planeta;
#------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------

set @masa = (SELECT masa FROM Planeta WHERE nombrePlaneta = 'Tierra');
set @radio = (SELECT radio FROM Planeta WHERE nombrePlaneta = 'Tierra' );
set @distancia = (SELECT distancia FROM Planeta WHERE nombrePlaneta = 'Tierra' );
SELECT calcularGravedad( @masa, @radio );
#SELECT calcularVelocidadEscape( @masa, @radio );
SELECT * FROM DatosPlanetas;