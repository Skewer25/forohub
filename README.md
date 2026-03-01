<em> Challenge ONE G9 Forohub </em>  
Estado del proyecto: Completado ✅

# Aviso
Las funciones CRUD de los usuarios, cursos y respuestas aun no estan completas, el challenge solo se enfocaba en los topicos; espero actualizar el repositorio para arreglar eso en 
algun momento.

# Introduccion
Es una API Rest centrada en la creacion, visualizacion, actualizacion y eliminacion de topicos; la API utiliza MySQL para guardar los datos; parte de las tareas en el programa ONE 
G9.

# 🔨Como funciona la API?
- `Paso 1`: Lo primero seria ejecutar el codigo para ello ve al archivo ForohubApplication desde el IDE de tu preferencia.

[Imagen de ForohubApplication]<img width="1280" height="984" alt="image" src="https://github.com/user-attachments/assets/228ada7f-d0ab-4382-9356-e16c2d7bfe25" />


- `Paso 2`: Luego de eso podras empezar a hacer requests, recuerda que la mayoria de las requests disponibles seran para el endpoint /topicos, para empezar a hacer las pruebas
necesitas un usuario en la base de datos, deberas insertar uno en la tabla 'usuarios' (necesitas usar un encriptador a Bcrypt para insertar la contraseña), la base de datos se llama
forohub_api (en la base de datos ya hay un usuario de prueba sus credenciales son john.doe@gmail.com / 123456).

- `Paso 3`: Muy bien, ya teniendo el usuario creado solo iras al endpoint /login y enviaras un body en formato json con tus credenciales, se te devolvera un token que usuras para hacer las requests al resto de endponts.

[Body enviado al endpoint y body recibido]<img width="840" height="529" alt="image" src="https://github.com/user-attachments/assets/58b5b61b-3649-42d2-a778-f5fb6f85be28" />

# Lista de requests disponibles
Muy bien ahora te dejare una lista del tipo de request que acepta los endpoint /topicos y /topicos/{id}  
## /topicos:  
POST  
Body enviado:  
{  
	"titulo": "texto",  
	"mensaje": "texto",  
	"idAutor": 1,  
	"idCurso": 1  
}  
Recibido:  
{  
	"titulo": "texto",  
	"mensaje": "texto",  
	"fecha_creacion": "2026-02-22T23:28:22.3994007",  
	"status": "ABIERTO",  
	"idAutor": 1,  
	"idCurso": 1  
}  

PUT  
Body enviado:  
{  
	"id": id del topico a modificar,  
	"campo a modificar": valor  
}  
Recibido:  
Igual que el anterior pero con el valor aplicado al campo seleccionado  

GET  
Body enviado:  
no se envia  
Recibido:  
{  
	"titulo": "texto",  
	"mensaje": "texto",  
	"fecha_creacion": "2026-02-22T23:28:22",  
	"status": "ABIERTO",  
	"idAutor": 1,  
	"idCurso": 1  
}  
{  
			"titulo": "texto",  
			"mensaje": "texto",  
			"fecha_creacion": "2026-02-22T23:28:00",  
			"status": "ABIERTO",  
			"idAutor": 1,  
			"idCurso": 1  
}  

## /topicos/{id}:  
GET  
Body enviado:  
no se envia  
Recibido:  
{  
	"titulo": "texto",  
	"mensaje": "texto",  
	"fecha_creacion": "2026-02-22T23:28:22",  
	"status": "ABIERTO",  
	"idAutor": 1,  
	"idCurso": 1  
}  

DELETE  
Body enviado:  
no se envia  
Recibido:  
204 No Content  

# 📁 Acceso al proyecto
Para descargar el proyecto solo debes presionar el boton "<> Code" y te desplegara unas opciones, la forma mas facil sería darle a la opcion de "Download ZIP", este automaticamente 
descargará el archivo y se guardara en la carpeta de descargas de tu equipo. Tambien puedes clonarlo usando git para eso tendrias que crear un repositorio local con git y poner 
este comando "git clone " (reemplaza "url" por la url que te proporciona el repositorio).

# 🛠️ Abre y ejecuta el proyecto
Para abrir en caso de que lo hayas descargado, solo tendrias que descomprimir el ZIP, abrir tu IDE, ir al menú File y darle a la opcion de "open", de ahi solo tienes que navegar 
hasta donde está la carpeta del proyecto, seleccionarla y darle en "select folder" (el proceso varía segun el IDE). En caso de que lo hayas clonado, el proceso es el mismo solo que 
se salta el paso de descomprimir el ZIP ya que al clonarlo el proyecto se descargará directamente en la carpeta que hayas seleccionado al crear el repositorio.

Ya por ultimo para ejecutarlo solo tienes que ir a la clase "ForohubApplication" y darle en "Run" (la opcion "Run" varia segun el IDE). (Si, me da pereza crear un ejecutable de consola pronto lo agregare al repositorio).

# Autor
<img width="420" height="420" alt="image" src="https://github.com/user-attachments/assets/f6b0f57c-827c-4b95-8e7b-c9af98e91254" />  

Geremy Quiñonez
