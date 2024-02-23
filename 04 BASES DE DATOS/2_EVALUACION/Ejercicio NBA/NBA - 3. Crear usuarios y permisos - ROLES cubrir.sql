#--------------------------------------------------------------------------------------------
#	1.	UTILIZAMOS LA BASE DE DATOS 'NBA'
#--------------------------------------------------------------------------------------------
#	USE <base de datos>
#--------------------------------------------------------------------------------------------
			use nba;
#--------------------------------------------------------------------------------------------
#	2. 	BORRAMOS Y CREAMOS LOS ROLES
#--------------------------------------------------------------------------------------------
#	Rol asociado a NBA y a cada Conferencia (Este, Oeste) y a cada División (Atlántico, Sudeste, Central, Pacífico, Sudoeste y Noroeste)
#--------------------------------------------------------------------------------------------
#	CREATE ROLE <rol>
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	3. BORRAMOS Y CREAMOS LAS VISTAS
#--------------------------------------------------------------------------------------------
#	DROP VIEW IF EXISTS <vista>							CREATE VIEW	<vista>	AS <consulta>
#--------------------------------------------------------------------------------------------
#		Vista General de TODOS los Equipos, otra para TODOS los Jugadores, otra para TODAS las Estadísticas y otra para TODOS los partidos
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia ESTE
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia OESTE
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Atlantica
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudeste
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Central
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Pacífico
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudoeste
#		Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Noroeste
#--------------------------------------------------------------------------------------------
	
    
    DROP VIEW IF EXISTS VistaNBA_EQUIPOS;						CREATE VIEW VistaNBA_EQUIPOS						AS SELECT * FROM NBA.equipos;
	DROP VIEW IF EXISTS VistaNBA_JUGADORES;						CREATE VIEW VistaNBA_JUGADORES						AS SELECT * FROM NBA.jugadores;
	DROP VIEW IF EXISTS VistaNBA_ESTADISTICAS;					CREATE VIEW VistaNBA_ESTADISTICAS					AS SELECT * FROM NBA.estadisticas;
	DROP VIEW IF EXISTS VistaNBA_PARTIDOS;						CREATE VIEW VistaNBA_PARTIDOS						AS SELECT * FROM NBA.partidos;


    
    DROP VIEW IF EXISTS VistaCONFERENCIA_ESTE_EQUIPOS;			CREATE VIEW VistaCONFERENCIA_ESTE_EQUIPOS			AS SELECT * FROM NBA.equipos 		where Conferencia = 'East';
	DROP VIEW IF EXISTS VistaCONFERENCIA_ESTE_JUGADORES;		CREATE VIEW	VistaCONFERENCIA_ESTE_JUGADORES			AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from VistaCONFERENCIA_ESTE_EQUIPOS);
    DROP VIEW IF EXISTS VistaCONFERENCIA_ESTE_ESTADISTICAS;		CREATE VIEW VistaCONFERENCIA_ESTE_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaCONFERENCIA_ESTE_JUGADORES);
	DROP VIEW IF EXISTS VistaCONFERENCIA_ESTE_PARTIDOS;			CREATE VIEW VistaCONFERENCIA_ESTE_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaCONFERENCIA_ESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaCONFERENCIA_ESTE_EQUIPOS);
    
	DROP VIEW IF EXISTS VistaCONFERENCIA_OESTE_EQUIPOS;			CREATE VIEW VistaCONFERENCIA_OESTE_EQUIPOS			AS SELECT * FROM NBA.equipos 		where Conferencia = 'West';
    DROP VIEW IF EXISTS VistaCONFERENCIA_OESTE_JUGADORES;		CREATE VIEW	VistaCONFERENCIA_OESTE_JUGADORES		AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from VistaCONFERENCIA_OESTE_EQUIPOS);
	DROP VIEW IF EXISTS VistaCONFERENCIA_OESTE_ESTADISTICAS;	CREATE VIEW VistaCONFERENCIA_OESTE_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaCONFERENCIA_OESTE_JUGADORES);
    DROP VIEW IF EXISTS VistaCONFERENCIA_OESTE_PARTIDOS;		CREATE VIEW VistaCONFERENCIA_OESTE_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaCONFERENCIA_OESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaCONFERENCIA_OESTE_EQUIPOS);
    
    DROP VIEW IF EXISTS VistaDIVISION_ATLANTICA_EQUIPOS;		CREATE VIEW	VistaDIVISION_ATLANTICA_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'Atlantic';
	DROP VIEW IF EXISTS VistaDIVISION_ATLANTICA_JUGADORES;		CREATE VIEW	VistaDIVISION_ATLANTICA_JUGADORES		AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from VistaDIVISION_ATLANTICA_EQUIPOS);
    DROP VIEW IF EXISTS VistaDIVISION_ATLANTICA_ESTADISTICAS;	CREATE VIEW	VistaDIVISION_ATLANTICA_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_ATLANTICA_JUGADORES);
	DROP VIEW IF EXISTS VistaDIVISION_ATLANTICA_PARTIDOS;		CREATE VIEW VistaDIVISION_ATLANTICA_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_ATLANTICA_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_ATLANTICA_EQUIPOS);

	DROP VIEW IF EXISTS VistaDIVISION_SUDESTE_EQUIPOS;			CREATE VIEW	VistaDIVISION_SUDESTE_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'SouthEast';
    DROP VIEW IF EXISTS VistaDIVISION_SUDESTE_JUGADORES;		CREATE VIEW	VistaDIVISION_SUDESTE_JUGADORES			AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from VistaDIVISION_SUDESTE_EQUIPOS);
	DROP VIEW IF EXISTS VistaDIVISION_SUDESTE_ESTADISTICAS;  	CREATE VIEW	VistaDIVISION_SUDESTE_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_SUDESTE_JUGADORES);
    DROP VIEW IF EXISTS VistaDIVISION_SUDESTE_PARTIDOS;			CREATE VIEW	VistaDIVISION_SUDESTE_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_SUDESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_ATLANTICA_EQUIPOS);

    DROP VIEW IF EXISTS VistaDIVISION_CENTRAL_EQUIPOS;			CREATE VIEW	VistaDIVISION_CENTRAL_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'Central';
	DROP VIEW IF EXISTS VistaDIVISION_CENTRAL_JUGADORES;		CREATE VIEW	VistaDIVISION_CENTRAL_JUGADORES			AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from VistaDIVISION_SUDESTE_EQUIPOS);
    DROP VIEW IF EXISTS VistaDIVISION_CENTRAL_ESTADISTICAS;		CREATE VIEW	VistaDIVISION_CENTRAL_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_CENTRAL_JUGADORES);
	DROP VIEW IF EXISTS VistaDIVISION_CENTRAL_PARTIDOS;			CREATE VIEW	VistaDIVISION_CENTRAL_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_CENTRAL_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_CENTRAL_EQUIPOS);

	DROP VIEW IF EXISTS VistaDIVISION_PACIFIC_EQUIPOS;			CREATE VIEW	VistaDIVISION_PACIFIC_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'Pacific';
	DROP VIEW IF EXISTS VistaDIVISION_PACIFIC_JUGADORES;		CREATE VIEW	VistaDIVISION_PACIFIC_JUGADORES			AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from VistaDIVISION_PACIFIC_EQUIPOS);
    DROP VIEW IF EXISTS VistaDIVISION_PACIFIC_ESTADISTICAS;		CREATE VIEW	VistaDIVISION_PACIFIC_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_PACIFIC_JUGADORES);
	DROP VIEW IF EXISTS VistaDIVISION_PACIFIC_PARTIDOS;			CREATE VIEW VistaDIVISION_PACIFIC_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_PACIFIC_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_PACIFIC_EQUIPOS);

	DROP VIEW IF EXISTS VistaDIVISION_SUDOESTE_EQUIPOS;			CREATE VIEW	VistaDIVISION_SUDOESTE_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'SouthWest';
    DROP VIEW IF EXISTS VistaDIVISION_SUDOESTE_JUGADORES;		CREATE VIEW	VistaDIVISION_SUDOESTE_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from VistaDIVISION_SUDOESTE_EQUIPOS);
	DROP VIEW IF EXISTS VistaDIVISION_SUDOESTE_ESTADISTICAS; 	CREATE VIEW	VistaDIVISION_SUDOESTE_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_SUDOESTE_JUGADORES);
    DROP VIEW IF EXISTS VistaDIVISION_SUDOESTE_PARTIDOS;		CREATE VIEW	VistaDIVISION_SUDOESTE_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_SUDOESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_SUDOESTE_EQUIPOS);

    DROP VIEW IF EXISTS VistaDIVISION_NOROESTE_EQUIPOS;			CREATE VIEW	VistaDIVISION_NOROESTE_EQUIPOS			AS SELECT * FROM NBA.equipos		where Division = 'NorthWest';
	DROP VIEW IF EXISTS VistaDIVISION_NOROESTE_JUGADORES;		CREATE VIEW	VistaDIVISION_NOROESTE_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from VistaDIVISION_NOROESTE_EQUIPOS);
    DROP VIEW IF EXISTS VistaDIVISION_NOROESTE_ESTADISTICAS;	CREATE VIEW	VistaDIVISION_NOROESTE_ESTADISTICAS		AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from VistaDIVISION_NOROESTE_JUGADORES);
	DROP VIEW IF EXISTS VistaDIVISION_NOROESTE_PARTIDOS;		CREATE VIEW	VistaDIVISION_NOROESTE_PARTIDOS			AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from VistaDIVISION_NOROESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from VistaDIVISION_NOROESTE_EQUIPOS);




#--------------------------------------------------------------------------------------------
#	4. ASIGNAMOS PRIVILEGIOS (O PERMISOS) A LOS ROLES
#--------------------------------------------------------------------------------------------
#	GRANT <privilegio>	ON <vista>	TO 	<rol>
#--------------------------------------------------------------------------------------------

   
#--------------------------------------------------------------------------------------------
#	5. 	BORRAMOS Y CREAMOS LOS USUARIOS, ASINGNÁNDOLES POR DEFECTO SU ROL ASOCIADO
#	Los usuarios serán creados todos con la misma clave 'abc'
#--------------------------------------------------------------------------------------------
#	CREATE USER <usuario>	IDENTIFIED BY <clave>	DEFAULT ROLE <rol>
#--------------------------------------------------------------------------------------------
#	Fulgencio y Fulgencia
#	Guillermino y Guillermina
#	Pancracio y Pancracia
#	Filomeno y Filomena
#	Anaximandro y Anaximandra
#	Romino y Romina
#	Agapito y Agapita
#	Apolonio y Apolonia
#	Luzdivino y Luzdivina
#--------------------------------------------------------------------------------------------
 
 
#--------------------------------------------------------------------------------------------
#	6. REFRESCA LOS PRIVILEGIOS
#--------------------------------------------------------------------------------------------
#	FLUSH PRIVILEGES;
#--------------------------------------------------------------------------------------------
	FLUSH PRIVILEGES;
