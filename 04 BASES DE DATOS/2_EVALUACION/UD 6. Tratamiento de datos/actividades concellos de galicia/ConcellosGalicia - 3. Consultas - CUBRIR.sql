#*******************************************************************************************
#	UTILIZACIÓN DE LA BASE DE DATOS 'ConcellosGalicia'
#*******************************************************************************************


#*******************************************************************************************
#	CONCELLOS CON CÓDIGO, NOMBRE, SUPERFICIE, MUJERES Y HOMBRES
#*******************************************************************************************
#		Crea una vista llamada 'DatosConcellos' en función de la consulta de
#			- identificador del Concello
#			- nombre del Concello
#			- superficie del Concello
#			- mujeres del Concello
#			- hombres del Concello
#			- comarca a la que pertenece el Concello
#			- provincia a la que pertenece el Concello
#*******************************************************************************************
select 	__ as 'Concello', 
		__ as 'Nombre',
        __ as 'Superficie',
        ( select mujeres from Poblacion where idConcello = Concello.idConcello limit 1 ) as 'Mujeres',
		__ as 'Hombres',
        __ as 'Comarca',
        __ as 'Provincia'
        from Concello;
        
        
 DROP VIEW IF EXISTS VistaDatosConcellos;       
CREATE VIEW	VistaDatosConcellos	AS	select T1.idconcello as 'concello',
					nombre as ;
                    
                    
		# mostramos los concellos con menor superficie:
        
select * from VistaDatosConcellos where supericie = (select min(superficie) from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie in (select min(superficie) from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie <= all (select superficie from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie = any (select min(superficie) from VistaDatosConcellos);

		# mostramos los concellos con mayor superficie:
        
select * from VistaDatosConcellos where supericie = (select max(superficie) from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie in (select max(superficie) from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie >= all (select superficie from VistaDatosConcellos);
select * from VistaDatosConcellos where supericie = any (select max(superficie) from VistaDatosConcellos);

        # concello con la mayor diferencia entre hombres y mujeres:
        
select abs(mujeres-hombres), nombre from VistaDatosConcellos order by 1 desc limit 1;        
select abs(mujeres-hombres), nombre from VistaDatosConcellos where abs(mujeres-hombres) =
		(select max(abs(mujeres-hombres)) from VistaDatosConcellos);
        
 # concello con la menor diferencia entre hombres y mujeres:
        
select abs(mujeres-hombres), nombre from VistaDatosConcellos order by 1 asc limit 1;        
select abs(mujeres-hombres), nombre from VistaDatosConcellos where abs(mujeres-hombres) =
		(select min(abs(mujeres-hombres)) from VistaDatosConcellos);
        


#*******************************************************************************************
#	COMARCAS CON CÓDIGO, NOMBRE, SUPERFICIE, MUJERES Y HOMBRES
#*******************************************************************************************
#		Crea una vista llamada 'DatosComarcas' en función de la consulta de
#			- identificador de la Comarca
#			- nombre de la Comarca
#			- superficie de la Comarca
#			- mujeres de la Comarca
#			- hombres de la Comarca
#			- provincia a la que pertenece la Comarca
#*******************************************************************************************
select 	__ as 'Comarca', 
		__ as 'Nombre',
		__ as 'Superficie',
        __ as 'Mujeres',
        __ as 'Hombres',
        __ as 'Provincia'
        from Comarca;

CREATE VIEW DatosComarcas	AS	__;
#*******************************************************************************************
#	PROVINCIAS CON CÓDIGO, NOMBRE, SUPERFICIE, MUJERES Y HOMBRES
#*******************************************************************************************
#		Crea una vista llamada 'DatosProvincias' en función de la consulta de
#			- identificador de la Provincia
#			- nombre de la Provincia
#			- superficie de la Provincia
#			- mujeres de la Provincia
#			- hombres de la Provinica
#*******************************************************************************************
select 	__ as 'Provincia', 
		__ as 'Nombre',
		__ as 'Superficie',
        __ as 'Mujeres',
        __ as 'Hombres'
        from Provincia;

CREATE VIEW	DatosProvincias	AS __;


#*******************************************************************************************
#	 1.	Concello con mayor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 2.	Concello con menor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 3.	Concellos con mayor y menor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 4.	Comarcas con mayor y menor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 5.	Provincias con mayor y menor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 6.	Concellos agrupados por Comarcas con mayor y menor superficie
#*******************************************************************************************

#*******************************************************************************************
#	 7.	Comarcas agrupadas por Provincias con mayor y menor superficie
#*******************************************************************************************

            


#*******************************************************************************************
#	BORRAR VISTAS
#*******************************************************************************************

	drop view DatosConcellos;
	drop view DatosComarcas;
    drop view DatosProvincias;
