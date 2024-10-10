# proyectoSymfony

   //////////////////////////////////////////////////////////////
   ///////////       Joaquin Lafuente Espino          ///////////
   //////////////////////////////////////////////////////////////

Tarea08. Hito 1 (2 puntos)


https://github.com/zono32/proyectoSymfony.git


1- Crea un nuevo proyecto Symfony tarea08. Apunta el comando que has utilizado. (0,2 puntos)

- composer create-project symfony/skeleton:"7.0.*" tarea08 
- composer require webapp

2- Prepara la cadena de conexión que acceda a una base de datos en el fichero .env. El nombre de la base de datos debe coincidir con tu nombre de usuario para acceder dominio. (0,1 puntos)

DATABASE_URL="mysql://root@127.0.0.1:3306/a21joaquinle?serverVersion=10.4.28-MariaDB&charset=utf8mb4"


3- Crea la base de datos con los comandos correspondientes. Apunta el comando que has utilizado (0,2 puntos)

- php bin/console doctrine:database:create

4- Lee la URL https://symfony.com/doc/current/security.html hasta la sección JSON Login sin desviarte con los numerosos enlaces que hay hasta entonces.

Prueba a registrar un usuario y comprueba que se ha creado en la base de datos (1,5 puntos)

5- Crea un repositorio privado en GitHub y añádeme como colaborador dudwcs

6- Avísame para enseñarme el resultado

Añade en el README del repositorio los comandos de los apartados 1, 3 y la URL de tu repositorio.







Tarea08. Hito 2 (3,5 puntos sobre 8 de la parte práctica de la UD8)
Sobre el proyecto resultado de Tarea08 Hito 1 realiza las siguientes acciones:

1- Piensa en una nueva entidad en tu aplicación que tenga propiedades PHP, además del id autogenerado, de al menos tres tipos diferentes: String, un float y un DateTime. Deberá estar asociada con un único usuario (la entidad que hayas creado en el Hito1) en una relación 1:N bidireccional. Entrega un breve documento de 3 o 4 líneas con una propuesta de entidad, indicando las propiedades y sus tipos de datos. La entidad no podrá repetirse entre alumnos/as. Avisa a la docente para que lo lea y lo apruebe antes de continuar. Cuando el documento reciba el apto en comentarios, crea la entidad y establece las relaciones. (0,5 puntos)

- Un registro de peliculas String titulo de la pelicula, Float duracion, DateTaime Fecha de estreno.
 
2- Crea la funcionalidad de creación de esa nueva entidad (sin utilizar los formularios programáticos de Symfony) con la división de responsabilidades de vista, controlador y servicio. (1 punto)

a) La nueva entidad deberá estar asociada al usuario autenticado. Si no hubiese usuario autenticado en el controlador, debería mostrarse un mensaje flash y redirigir a la página de login.  Indica de qué URL has obtenido la información para obtener el usuario autenticado en el README de tu repo. (0,5 puntos)

- https://symfony.com/doc/5.x/security.html#fetching-the-user-object

b) Añade mensajes flash para informar al usuario del éxito o fracaso de la operación. (0,25 puntos) Captura las posibles excepciones con try-catch (\Throwable $e) {...} (0,25 puntos)

c) Añade un menú con un enlace a la funcionalidad de crear entidad siempre visible.  (0,25 puntos)Utiliza estilos y JavaScript de Bootstrap con assetMapper. (0,25 puntos)

3- Incorpora una validación básica previa a la creación de una entidad de forma que no se puedan crear nuevas entidades si no se cumplen determinadas reglas. Por ejemplo, que la propiedad de tipo String deba tener menos de 5 caracteres. Añade mensajes flash para informar al usuario del éxito o fracaso de la operación. (0,5 puntos)







Tarea08. Hito 3 (2,5 puntos sobre 8 de la parte práctica de la UD8)
Sobre el proyecto resultado de Tarea08 Hito 2 realiza las siguientes acciones:

1- Incorpora una validación personalizada, siguiendo los pasos de la documentación de la UD8,  de forma que la creación de la entidad no pueda hacerse si existe otra entidad con los mismos datos para la propiedad String en la base de datos. Añade mensajes flash para informar al usuario del éxito o fracaso de la operación. (0,75 puntos). Añade en el README en qué consiste la validación personalizada.

- La validación personalizada consiste en verificar que los datos introducidos por el usuario cumplan los requisitos que el programador haya definido. En este caso se comprueba que el susuario no      introduzca un Titulo de Película que ya exista en la base de datos.

2- Crea la funcionalidad de listar todas las propiedades de las entidades existentes filtradas por el usuario autenticado.  Deberán mostrarse ordenadas por dos propiedades cualesquiera (primero se ordenará por una y después por otra) con la división de responsabilidades vista, controlador y servicio que corresponda. Si el usuario no está autenticado, redirige a la página de login. Añade en el README por qué dos propiedades ordenas. Añade un enlace al listado de entidades en el menú . (0,7 puntos)

- Lo ordeno por titulo y duración

3- Añade en la vista del listado de entidades por usuario, un formulario que  mediante POST permita eliminar cada entidad por su id, comprobando que el usuario autenticado es el propietario de la entidad antes de su eliminación de la base de datos.

Si no está autenticado, debería mostrar un mensaje flash y redirigir a login
Si el id no se corresponde con ninguna entidad existente, deberá mostrar un mensaje flash significativo y redirigir al listado
Si el usuario relacionado con la entidad a eliminar no es el usuario autenticado, deberá mostrar un mensaje flash significativo y redirigir al listado
Si ocurre cualquier excepción, deberá mostrar un mensaje flash significativo y redirigir al listado
Si se cumplen los requisitos, se eliminará la entidad, se mostrará un mensaje flash de éxito y se redirigirá al listado.
(0,75 puntos)

4- Fuerza que, tras el registro de usuario, se redirija a la página de login. Indica en el README, qué cambiaste y dónde. (0,15 puntos)

- En el archivo registro controler ya se utilizaba el metodo para redirigir, solo tuve que cambiar el que había por el del login.

5- Fuerza que, tras el login exitoso, se redirija al listado de entidades del apartado 3. Indica en el README, qué cambiaste y dónde. Indica de qué fuente obtuviste la información (0,15 puntos)

- El default_target_path se utiliza para especificar a dónde se redirigirá al usuario después de iniciar sesión. En este caso configure el archivo config/packages/security.yaml, poniendo dentro del form_login default_target_path: /listado.

- fuente de donde quité la información:
- https://symfony.com/doc/current/security/form_login.html
