USE DatosConcello;
SELECT * FROM DatosConcello;

#-----------------------------------------------------------------------
#   1. Crea una función que devuelva los Concellos de una Comarca.
#-----------------------------------------------------------------------
DELIMITER //
DROP FUNCTION  IF EXISTS obtenerConcellosXComarca//
	CREATE FUNCTION obtenerConcellosXComarca(comarcaBuscar VARCHAR(40)) RETURNS TEXT
		DETERMINISTIC
        BEGIN
			DECLARE ConcellosXComarca TEXT DEFAULT '';
			
			SELECT GROUP_CONCAT(Nombre SEPARATOR ', ') INTO ConcellosXComarca
				FROM DatosConcello
				WHERE Comarca = comarcaBuscar;
                
                IF(ConcellosXComarca IS NULL) THEN
					SET ConcellosXComarca = CONCAT('No se encontraron Concellos para la Comarca de "', comarcaBuscar,' ".');
                END IF;
			RETURN ConcellosXComarca;
		END //
  DELIMITER ;           

SELECT obtenerConcellosXComarca( 'VIGO' ) AS 'Concellos que hay en la Comarca';
#-----------------------------------------------------------------------
#   2. Crea una función que devuelva los Concellos de una Provincia.
#-----------------------------------------------------------------------
DELIMITER //
DROP FUNCTION  IF EXISTS obtenerConcellosXProvincia//
	CREATE FUNCTION obtenerConcellosXProvincia(provinciaBuscar VARCHAR(40)) RETURNS TEXT
		DETERMINISTIC
        BEGIN
			DECLARE ConcellosXProvincia TEXT DEFAULT '';
			
			SELECT GROUP_CONCAT(Nombre SEPARATOR ', ') INTO ConcellosXProvincia
				FROM DatosConcello
				WHERE Provincia = provinciaBuscar;
                
                IF(ConcellosXProvincia IS NULL) THEN
					SET ConcellosXProvincia = CONCAT('No se encontraron Concellos para la Provincia de "', provinciaBuscar,' ".');
                END IF;
			RETURN ConcellosXProvincia;
		END //
  DELIMITER ;           

SELECT ObtenerConcellosXProvincia( 'A Coruña' ) AS 'Concellos que hay en la Provincia';

SELECT ObtenerConcellosXProvincia( 'Pontevedra' ) AS 'Concellos que hay en la Provincia';

#-----------------------------------------------------------------------
#   3. Crea una función que devuelva las Comarcas de una Provincia.
#-----------------------------------------------------------------------
DELIMITER //
DROP FUNCTION  IF EXISTS obtenerComarcasXProvincia//
	CREATE FUNCTION obtenerComarcasXProvincia(provinciaBuscar VARCHAR(40)) RETURNS TEXT
		DETERMINISTIC
        BEGIN
			DECLARE ComarcasXProvincia TEXT DEFAULT '';
			
			SELECT GROUP_CONCAT(Comarca SEPARATOR ', ') INTO ComarcasXProvincia
				FROM DatosConcello
				WHERE Provincia = provinciaBuscar;
                
                IF(ComarcasXProvincia IS NULL) THEN
					SET ComarcasXProvincia = CONCAT('No se encontraron Comarcas para la Provincia de "', provinciaBuscar,' ".');
                END IF;
			RETURN ComarcasXProvincia;
		END //
  DELIMITER ;           

SELECT obtenerComarcasXProvincia( 'Pontevedra' ) AS 'Comarcas que hay en la Provincia';
SELECT obtenerComarcasXProvincia( 'Vigo' ) AS 'Comarcas que hay en la Provincia';

#-----------------------------------------------------------------------
#   4. Crea una función que devuelva los Concellos con mayor y menor superficie.
#-----------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS ObtenerConcellosMayorMenorSuperficie//
    CREATE PROCEDURE ObtenerConcellosMayorMenorSuperficie()
		BEGIN
			SELECT CONCAT('Concellos con mayor superficie(', MAX(Superficie),'):',
				GROUP_CONCAT(Nombre SEPARATOR', ')) AS 'Concellos con mayor y menor superficie'
				FROM DatosConcello
				WHERE Superficie = (SELECT MAX(Superficie) FROM DatosConcello)
            UNION
            SELECT CONCAT('Concellos con menor superficie(',MIN(Superficie),'):',
				GROUP_CONCAT(Nombre SEPARATOR', '))
            FROM DatosConcello
            WHERE Superficie = (SELECT MIN(Superficie) FROM DatosConcello);            
        END

//DELIMITER ;

CALL ObtenerConcellosMayorMenorSuperficie
#-----------------------------------------------------------------------
#   5. Crea una función que devuelva las Comarcas con mayor y menor superficie.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   6. Crea una función que devuelva las Provincias con mayor y menor superficie.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   7. Crea una función que devuelva los Concellos con mayor y menor población. 
#-----------------------------------------------------------------------



#-----------------------------------------------------------------------
#   8. Crea una función que devuelva las Comarcas con mayor y menor población.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#   9. Crea una función que devuelva las Provincias con mayor y menor población.
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------


#-----------------------------------------------------------------------
#    . 
#-----------------------------------------------------------------------

