#--------------------------------------------------------------------------------------------
#	1.	UTILIZAMOS LA BASE DE DATOS 'NBA'
#--------------------------------------------------------------------------------------------
#	USE <base de datos>
#--------------------------------------------------------------------------------------------

    USE NBA;
    
#--------------------------------------------------------------------------------------------
#	2. 	BORRAMOS Y CREAMOS LOS USUARIOS: hay 2 Conferencias (East, West) y 3 divisiones en cada una (Atlantic, SouthEast, Central) y (Pacific, SouthWest, NorthWest)
#	Los usuarios serán creados todos con la misma clave 'abc'
#--------------------------------------------------------------------------------------------
#	DROP USER IF EXISTS <usuario>		CREATE USER <usuario>	IDENTIFIED BY <clave>
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
drop user if exists Fulgencio;
create user Fulgencio identified by 'abc';

drop user if exists Fulgencia;
create user Fulgencia identified by 'abc';

drop user if exists Guillermino;
create user Guillermino identified by 'abc';

drop user if exists Guillermina;
create user Guillermina identified by 'abc';

drop user if exists Pancracio;
create user Pancracio identified by 'abc';

drop user if exists Pancracia;
create user Pancracia identified by 'abc';

drop user if exists Filomeno;
create user Filomeno identified by 'abc';

drop user if exists Filomena;
create user Filomena identified by 'abc';

drop user if exists Anaximandro;
create user Anaximandro identified by 'abc';

drop user if exists Anaximandra;
create user Anaximandra identified by 'abc';

drop user if exists Romino;
create user Romino identified by 'abc';

drop user if exists Romina;
create user Romina identified by 'abc';

drop user if exists Agapito;
create user Agapito identified by 'abc';

drop user if exists Agapita;
create user Agapita identified by 'abc';

drop user if exists Apolonio;
create user Apolonio identified by 'abc';

drop user if exists Apolonia;
create user Apolonia identified by 'abc';

drop user if exists Luzdivino;
create user Luzdivino identified by 'abc';

drop user if exists Luzdivina;
create user Luzdivina identified by 'abc';


drop user if exists 'Fulgencio', 'Fulgencia','Guillermino', 'Guillermina','Pancracio', 'Pancracia','Filomeno', 'Filomena','Anaximandro', 'Anaximandra','Romino', 'Romina','Agapito',
 'Agapita','Apolonio', 'Apolonia','Luzdivino', 'Luzdivina';
create user 'Fulgencio', 'Fulgencia','Guillermino', 'Guillermina','Pancracio', 'Pancracia','Filomeno', 'Filomena','Anaximandro', 'Anaximandra','Romino', 'Romina','Agapito',
 'Agapita','Apolonio', 'Apolonia','Luzdivino', 'Luzdivina' identified by 'abc';

#--------------------------------------------------------------------------------------------
#	3. BORRAMOS Y CREAMOS LAS VISTAS
#--------------------------------------------------------------------------------------------
#	DROP VIEW IF EXISTS <vista>							CREATE VIEW	<vista>	     AS <consulta>
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


    DROP VIEW IF EXISTS NBA_EQUIPOS;					CREATE VIEW NBA_EQUIPOS							AS SELECT * FROM NBA.equipos;
	DROP VIEW IF EXISTS NBA_JUGADORES;					CREATE VIEW NBA_JUGADORES						AS SELECT * FROM NBA.jugadores;
	DROP VIEW IF EXISTS NBA_ESTADISTICAS;				CREATE VIEW NBA_ESTADISTICAS					AS SELECT * FROM NBA.estadisticas;
	DROP VIEW IF EXISTS NBA_PARTIDOS;					CREATE VIEW NBA_PARTIDOS						AS SELECT * FROM NBA.partidos;


    
    DROP VIEW IF EXISTS CONFERENCIA_ESTE_EQUIPOS;		CREATE VIEW CONFERENCIA_ESTE_EQUIPOS		AS SELECT * FROM NBA.equipos 		where Conferencia = 'East';
	DROP VIEW IF EXISTS CONFERENCIA_ESTE_JUGADORES;		CREATE VIEW	CONFERENCIA_ESTE_JUGADORES		AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from CONFERENCIA_ESTE_EQUIPOS);
    DROP VIEW IF EXISTS CONFERENCIA_ESTE_ESTADISTICAS;	CREATE VIEW CONFERENCIA_ESTE_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from CONFERENCIA_ESTE_JUGADORES);
	DROP VIEW IF EXISTS CONFERENCIA_ESTE_PARTIDOS;		CREATE VIEW CONFERENCIA_ESTE_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from CONFERENCIA_ESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from CONFERENCIA_ESTE_EQUIPOS);
    
	DROP VIEW IF EXISTS CONFERENCIA_OESTE_EQUIPOS;		CREATE VIEW CONFERENCIA_OESTE_EQUIPOS		AS SELECT * FROM NBA.equipos 		where Conferencia = 'West';
    DROP VIEW IF EXISTS CONFERENCIA_OESTE_JUGADORES;	CREATE VIEW	CONFERENCIA_OESTE_JUGADORES		AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from CONFERENCIA_OESTE_EQUIPOS);
	DROP VIEW IF EXISTS CONFERENCIA_OESTE_ESTADISTICAS;	CREATE VIEW CONFERENCIA_OESTE_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from CONFERENCIA_OESTE_JUGADORES);
    DROP VIEW IF EXISTS CONFERENCIA_OESTE_PARTIDOS;		CREATE VIEW CONFERENCIA_OESTE_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from CONFERENCIA_OESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from CONFERENCIA_OESTE_EQUIPOS);
    
    DROP VIEW IF EXISTS DIVISION_ATLANTICA_EQUIPOS;		CREATE VIEW	DIVISION_ATLANTICA_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'Atlantic';
	DROP VIEW IF EXISTS DIVISION_ATLANTICA_JUGADORES;	CREATE VIEW	DIVISION_ATLANTICA_JUGADORES	AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from DIVISION_ATLANTICA_EQUIPOS);
    DROP VIEW IF EXISTS DIVISION_ATLANTICA_ESTADISTICAS;CREATE VIEW	DIVISION_ATLANTICA_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_ATLANTICA_JUGADORES);
	DROP VIEW IF EXISTS DIVISION_ATLANTICA_PARTIDOS;	CREATE VIEW DIVISION_ATLANTICA_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_ATLANTICA_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_ATLANTICA_EQUIPOS);

	DROP VIEW IF EXISTS DIVISION_SUDESTE_EQUIPOS;		CREATE VIEW	DIVISION_SUDESTE_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'SouthEast';
    DROP VIEW IF EXISTS DIVISION_SUDESTE_JUGADORES;		CREATE VIEW	DIVISION_SUDESTE_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from DIVISION_SUDESTE_EQUIPOS);
	DROP VIEW IF EXISTS DIVISION_SUDESTE_ESTADISTICAS;  CREATE VIEW	DIVISION_SUDESTE_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_SUDESTE_JUGADORES);
    DROP VIEW IF EXISTS DIVISION_SUDESTE_PARTIDOS;		CREATE VIEW	DIVISION_SUDESTE_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_SUDESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_ATLANTICA_EQUIPOS);

    DROP VIEW IF EXISTS DIVISION_CENTRAL_EQUIPOS;		CREATE VIEW	DIVISION_CENTRAL_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'Central';
	DROP VIEW IF EXISTS DIVISION_CENTRAL_JUGADORES;		CREATE VIEW	DIVISION_CENTRAL_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from DIVISION_SUDESTE_EQUIPOS);
    DROP VIEW IF EXISTS DIVISION_CENTRAL_ESTADISTICAS;	CREATE VIEW	DIVISION_CENTRAL_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_CENTRAL_JUGADORES);
	DROP VIEW IF EXISTS DIVISION_CENTRAL_PARTIDOS;		CREATE VIEW	DIVISION_CENTRAL_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_CENTRAL_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_CENTRAL_EQUIPOS);

	DROP VIEW IF EXISTS DIVISION_PACIFIC_EQUIPOS;		CREATE VIEW	DIVISION_PACIFIC_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'Pacific';
	DROP VIEW IF EXISTS DIVISION_PACIFIC_JUGADORES;		CREATE VIEW	DIVISION_PACIFIC_JUGADORES		AS SELECT * FROM NBA.jugadores 		where Equipo 	  IN (select nombre from DIVISION_PACIFIC_EQUIPOS);
    DROP VIEW IF EXISTS DIVISION_PACIFIC_ESTADISTICAS;	CREATE VIEW	DIVISION_PACIFIC_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_PACIFIC_JUGADORES);
	DROP VIEW IF EXISTS DIVISION_PACIFIC_PARTIDOS;		CREATE VIEW DIVISION_PACIFIC_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_PACIFIC_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_PACIFIC_EQUIPOS);

	DROP VIEW IF EXISTS DIVISION_SUDOESTE_EQUIPOS;		CREATE VIEW	DIVISION_SUDOESTE_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'SouthWest';
    DROP VIEW IF EXISTS DIVISION_SUDOESTE_JUGADORES;	CREATE VIEW	DIVISION_SUDOESTE_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from DIVISION_SUDOESTE_EQUIPOS);
	DROP VIEW IF EXISTS DIVISION_SUDOESTE_ESTADISTICAS; CREATE VIEW	DIVISION_SUDOESTE_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_SUDOESTE_JUGADORES);
    DROP VIEW IF EXISTS DIVISION_SUDOESTE_PARTIDOS;		CREATE VIEW	DIVISION_SUDOESTE_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_SUDOESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_SUDOESTE_EQUIPOS);

    DROP VIEW IF EXISTS DIVISION_NOROESTE_EQUIPOS;		CREATE VIEW	DIVISION_NOROESTE_EQUIPOS		AS SELECT * FROM NBA.equipos		where Division = 'NorthWest';
	DROP VIEW IF EXISTS DIVISION_NOROESTE_JUGADORES;	CREATE VIEW	DIVISION_NOROESTE_JUGADORES		AS SELECT * FROM NBA.jugadores		where Equipo 	  IN (select nombre from DIVISION_NOROESTE_EQUIPOS);
    DROP VIEW IF EXISTS DIVISION_NOROESTE_ESTADISTICAS;	CREATE VIEW	DIVISION_NOROESTE_ESTADISTICAS	AS SELECT * FROM NBA.estadisticas	where jugador 	  IN (select codigo from DIVISION_NOROESTE_JUGADORES);
	DROP VIEW IF EXISTS DIVISION_NOROESTE_PARTIDOS;		CREATE VIEW	DIVISION_NOROESTE_PARTIDOS		AS SELECT * FROM NBA.partidos		where EquipoLocal IN (select nombre from DIVISION_NOROESTE_EQUIPOS) AND EquipoVisitante IN (select nombre from DIVISION_NOROESTE_EQUIPOS);




#--------------------------------------------------------------------------------------------
#	4. ASIGNAMOS PRIVILEGIOS (O PERMISOS) A LOS USUARIOS
#--------------------------------------------------------------------------------------------
#	GRANT <permiso>	ON <vista>	TO <usuario>, ...
#--------------------------------------------------------------------------------------------
#		USUARIOS						ACCESO
#
#	Fulgencio y Fulgencia					Todos los datos de Equipos, Jugadores, Estadisticas y Partidos
#	Guillermino y Guillermina				Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la Conferencia ESTE
#	Pancracio y Pancracia					Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la Conferencia OESTE
#	Filomeno y Filomena						Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Atlántica
#	Anaximandro y Anaximandra				Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Sudeste
#	Romino y Romina							Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Central
#	Agapito y Agapita						Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Pacífico
#	Apolonio y Apolonia						Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Sudoeste
#	Luzdivino y Luzdivina					Todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la División Noroeste
#--------------------------------------------------------------------------------------------


#--------------------------------------------------------------------------------------------
#	5. REFRESCAMOS LOS PRIVILEGIOS
#--------------------------------------------------------------------------------------------
#	FLUSH PRIVILEGES;
#--------------------------------------------------------------------------------------------
    
