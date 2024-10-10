package metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Creacion {

    public static void crear(int tipoBD, Statement sentencia) {
        switch (tipoBD) {
            case 1:
                crearMySQL(sentencia);
                break;
            case 2:
                crearSQLite(sentencia);
                break;
            case 3:
            case 4:
                crearH2HSQL(sentencia);
        }
    }

    public static void crearMySQL(Statement sentencia) {
        ResultSet res;
        try {
            res = sentencia.executeQuery("show databases like 'empleadosdepartamentos';");
            if (!res.first()) {
                sentencia.execute("create database empleadosdepartamentos;");
                sentencia.execute("use empleadosdepartamentos;");
                sentencia.execute("create table departamentos("
                        + "clave_dep int(2) unsigned zerofill not null auto_increment,"
                        + "nombre_dep varchar(30) not null,"
                        + "localidad varchar(30) not null,"
                        + "primary key (clave_dep),"
                        + "unique index ak1_nombre_dep (nombre_dep)"
                        + ");");
                sentencia.execute("create table empleados( "
                        + "dni char(9) not null primary key,"
                        + "nombre varchar(30) not null,"
                        + "estudios varchar(10) not null,"
                        + "direccion varchar(30) not null,"
                        + "fecha_alta date not null default '0000-00-00',"
                        + "salario float not null,"
                        + "comision float not null,"
                        + "clave_dep int(2) unsigned not null,"
                        + "foreign key (clave_dep) references departamentos (clave_dep) on delete cascade on update cascade"
                        + ");");
                System.out.println("Base de datos creada");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void crearSQLite(Statement sentencia) {
        try {
            sentencia.execute("create table departamentos("
                    + "clave_dep INTEGER primary key autoincrement not null default 0,"
                    + "nombre_dep varchar(30) not null,"
                    + "localidad varchar(30) not null"
                    + ");");
            sentencia.execute("create table empleados( "
                    + "dni char(9) not null primary key,"
                    + "nombre varchar(30) not null,"
                    + "estudios varchar(10) not null,"
                    + "direccion varchar(30) not null,"
                    + "fecha_alta date not null default '0000-00-00',"
                    + "salario float not null,"
                    + "comision float not null,"
                    + "clave_dep int(2) not null,"
                    + "foreign key (clave_dep) references departamentos (clave_dep) on delete cascade on update cascade"
                    + ");");
            System.out.println("Base de datos creada");
        } catch (SQLException e) {
            System.out.println("Las tablas ya existen");
            System.out.println("Error: " + e);
        }
    }

    public static void crearH2HSQL(Statement sentencia) {
        try {
            sentencia.execute("create table departamentos("
                    + "clave_dep int(2) not null auto_increment,"
                    + "nombre_dep varchar(30) not null,"
                    + "localidad varchar(30) not null,"
                    + "primary key (clave_dep),"
                    + "unique index ak1_nombre_dep (nombre_dep)"
                    + ");");
            sentencia.execute("create table empleados( "
                    + "dni char(9) not null primary key,"
                    + "nombre varchar(30) not null,"
                    + "estudios varchar(10) not null,"
                    + "direccion varchar(30) not null,"
                    + "fecha_alta date not null default '0000-00-00',"
                    + "salario float not null,"
                    + "comision float not null,"
                    + "clave_dep int(2) unsigned not null,"
                    + "foreign key (clave_dep) references departamentos (clave_dep) on delete cascade on update cascade"
                    + ");");
            System.out.println("Base de datos creada");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
