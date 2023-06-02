# 			VERDANKS FITNESS || DAW 2023

En el siguiente repositorio se detalla la aplicación Verdansk Fitness, realizada por David Seoane y Fernando Lago

Dicha aplicación va destinada al mundo de la salud y el deporte, en la que a través de la recogida de la información que nos proposciona el usuario se ofrece de forma personalizada una dieta y una tabla de ejercicios acorde a sus necesidades.

### Para la realización del proyecto se han utilizado las siguientes librerías:

1. Para la realización de los PDF´s, Itext5.
2. Para la base de datos, MySQL Connector JAVA y JDBC.
3. Gson para la lectura y escritura de ficheros JSON.
4. Las propias librerías de Java.

El archivo SQL de volcado de la base de datos y sus tablas se encuentra en la carpeta recursos. Este proyecto además incluye una implementación del patron Observer mediante el cual se informa al cliente cuando su nivel de
experiencia cambia en la base de datos.

### El funcionamiento de la aplicación es el siguiente:

Se registra un usuario donde se recogen todos los datos necesarios (nombre, apellidos,peso,altura, etc...) y se recogen esos datos para guardarlos en la base de datos. Una vez obtenida la informacion del usuario, éste tiene la posibilidad de escoger la opcion que más se le adecúe a sus necesidades; de tal modo que tiene para elegir entre Definicion, Volumen o Mantenimiento. Una vez registrada la actividad que desea realizar, se le ofrece una dieta al usuario dividida en varias comidas (desayuno, comida, merienda y cena) y una rutina de ejercicios acorde a dicha etapa, y tambien divida para que realice los ejercicios de forma correcta. Dichos ejercicios se dividen entre pecho, espalda, pierna y brazo.

Dentro de la aplicación se recogen todos y cada uno de los métodos necesarios para la realización de cada uno de los apartados: Para la dieta se recogen los metodos para el calculo de la tasa metabolica basal (TMB), y así como el calculo de hidratos, proteinas y grasas necesarias para el usuario. Posteriormente se hace una seleccion de los ejercicios y finalmente se asignan ambas al usuario.

Finalmente, el usuario tiene la opción de descargar su programa en formato PDF o bien puede ver el planning desde la propia aplicacion.

El seguimiento y progreso de la aplicación se puede observar en la rama Main consultando los commits "Seguimiento".