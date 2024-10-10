use jardineria
#---------------------------------------------------------------------------------
#----------------------------FUNCION FACTORIAL------------------------------------
#---------------------------------------------------------------------------------
DELIMITER //
DROP FUNCTION IF EXISTS Permutacion ;
CREATE FUNCTION Permutacion (Número INTEGER) RETURNS INT8
	DETERMINISTIC
	BEGIN
		DECLARE Resultado INT8;
        SET Resultado = 1;
        WHILE ( Número > 1) DO
			SET Resultado = Resultado* Número;
            SET Número = Número - 1;
		END WHILE;
        RETURN Resultado;
	END//
DELIMITER ;

#---------------------------------------------------------------------------------
#---------------------------------------------------------------------------------

SELECT Permutacion(3);
SELECT Permutacion(6);
SELECT Permutacion(0);
SELECT Permutacion(5);
SELECT Permutacion(1);