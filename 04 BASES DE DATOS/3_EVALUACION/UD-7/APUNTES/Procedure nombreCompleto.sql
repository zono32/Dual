use Jardineria;

DELIMITER //
	DROP PROCEDURE IF EXISTS nombreCompleto //
    CREATE PROCEDURE nombreCompleto()
		BEGIN
            CALL agregarNombre();
            CALL agregarPrimerApellido();
            CALL agregarSegundoApellido();
        END
// DELIMITER ;

DELIMITER // 
	DROP PROCEDURE IF EXISTS agregarNombre // -- Nos aseguramos que no exista una función con este nombre
    CREATE PROCEDURE agregarNombre()
		BEGIN
			SET @nombre = 'Fulgencio';
        END
// DELIMITER ;

DELIMITER // 
	DROP Function IF EXISTS nombre_Completo // -- Nos aseguramos que no exista una función con este nombre
    CREATE FUNCTION nombre_Completo( nombre varchar(50), primerApellido varchar(50), segundoApellido varchar(50) )
		RETURNS varchar(200)
        DETERMINISTIC
		BEGIN
			DECLARE nombreCompleto varchar(200);
            SET nombreCompleto = CONCAT( nombre, ' ', primerApellido, ' ', segundoApellido );
            return nombreCompleto;
        END
// DELIMITER ;
DELIMITER // 
	DROP Function IF EXISTS nombre_completo_Ingles // -- Nos aseguramos que no exista una función con este nombre
    CREATE FUNCTION nombre_completo_Ingles( nombre varchar(50), primerApellido varchar(50), segundoApellido varchar(50) )
		RETURNS varchar(200)
        DETERMINISTIC
		BEGIN
			DECLARE nombreCompleto varchar(200);
            SET nombreCompleto = CONCAT( primerApellido, ' ', segundoApellido, ', ', nombre );
            return nombreCompleto;
        END
// DELIMITER ;

-- --------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------
DELIMITER // 
	DROP PROCEDURE IF EXISTS agregarPrimerApellido //
    CREATE PROCEDURE agregarPrimerApellido()
		BEGIN
			SET @nombre = CONCAT( @nombre, ' ', 'Guillermino' );
        END
// DELIMITER ;

DELIMITER // 
	DROP PROCEDURE IF EXISTS agregarSegundoApellido //
    CREATE PROCEDURE agregarSegundoApellido()
		BEGIN
			SET @nombre = CONCAT( @nombre, ' ', 'Pancracio' );
        END
// DELIMITER ;

DELIMITER // 
	DROP FUNCTION IF EXISTS sumarEnteros //
    CREATE FUNCTION sumarEnteros( a integer, b integer )
		RETURNS integer
        DETERMINISTIC
		BEGIN
          DECLARE  Resultado integer;	-- 
          SET Resultado = a + b;
			return Resultado;
        END
// DELIMITER ;
DELIMITER // 
	DROP FUNCTION IF EXISTS sumarDecimales //
    CREATE FUNCTION sumarDecimales( a double, b double )
		RETURNS double
        DETERMINISTIC
		BEGIN
          DECLARE  Resultado double;	-- 
          SET Resultado = a + b;
			return Resultado;
        END
// DELIMITER ;

delimiter !!
	drop procedure if exists calculos !!
    create procedure calculos( a int, b int, c int )
		begin
			declare r double;
            set r = a + b + c;
            set r = r / 3;
             select 'Valor medio:' + r;
        end
!! delimiter ;

delimiter //
	drop procedure if exists tablaMultiplicar //
    create procedure tablaMultiplicar( numero int )
		begin
			declare indice int;
            declare cadena varchar( 255 );
            set indice = 1;
            set cadena = '';
            mult:	while indice < 11 do
				set cadena = concat( cadena, '\n', concat( indice, ' * ', numero, ' = ', indice * numero ) );
                set indice = indice + 1;
            end while mult;
           select cadena;
        end
// delimiter ;

SET @nombre = '';
call nombreCompleto();
select @nombre;

select sumar(1,2);


set @res = sumarEnteros( 10.4, 45 );	select @res;
set @res = sumarDecimales( 10.1, 8.8 );	select @res;
select nombre_Completo( 'Fulgencio', 'Guillermino', 'Pancracio' );
select nombre_completo_Ingles( 'Fulgencio', 'Guillermino', 'Pancracio' );
select nombre_Completo( 'Fulgencio', 'Guillermino', 'Pancracio' ), nombre_completo_Ingles( 'Fulgencio', 'Guillermino', 'Pancracio' );
call calculos(1,2,4);
call tablaMultiplicar( 6 );
call numeroRomano( 555 );
