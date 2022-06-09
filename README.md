# FuegoQuasar
## Prueba de ingreso
Se realizó desarrolla un servicio de integración en spring boot, como gestor de dependencias se una la herramienta Maven, la versión de java es 1.8, se aplica Lombok para agilizar desarrollo, se una google formater para facilitar la lectura del código, las pruebas de unidad se desarrollan con Junit 4 y Mockito, para el desarrollo fuerte de la lógica se implementa la librería Trilateration para la triangulación de las coordenadas.
La aplicación se despliega en Heroku que presta una fácil accesibilidad de servicios en la nube.

## Clonación y Ejecución 
Clonar el proyecto, se debe contar con el JDK 1.8 JDK DOWNLOAD , Maven, mvn DOWNLOAD, lombok https://projectlombok.org/ desplegar la aplicación en Eclipse o STS, Compilar dependencia e iniciar el proyecto, las peticiones HTTP estarán expuestas, podrán ser gestadas mediante https://www.postman.com/  para la ejecución de manera local.

-http://localhost:8080/rebelAlliance/topsecret

![image](https://user-images.githubusercontent.com/107003968/172767661-0ac0aafd-d099-40e2-bb44-5aa44115aecb.png)

![image](https://user-images.githubusercontent.com/107003968/172767743-e61920cd-64fd-4fce-9511-b9037661c7b2.png)

-http://localhost:8080/rebelAlliance/topsecret_split?satellite_name=kenobi

![image](https://user-images.githubusercontent.com/107003968/172767817-cb8ccbb8-1c3e-427a-a72c-d973c01464d7.png)

Las url expuestas en el servidor de heroku se relacionan, actualmente el componente está en la nube y mediante un gestor de peticiones REST pueden ser consumidas. Se indican los Json para las peticiones.

```url
https://fuego-quasar-meli-cmontealegre.herokuapp.com/rebelAlliance/topsecret

```json
{
"satellites": [
        {
        "name": "kenobi",
        "distance": 100.0,
        "message": ["este", "", "", "mensaje", ""]
        },
        {
        "name": "skywalker",
        "distance": 115.5,
        "message": ["", "es", "", "", "secreto"]
        },
        {
        "name": "sato",
        "distance": 100.7,
        "message": ["este", "", "un", "", ""]
        }
    ]
}
```

https://fuego-quasar-meli-cmontealegre.herokuapp.com/topsecret_split?satellite_name=kenobi

```json
{
"satellites": [
        {
        "distance": 100.0,
        "message": ["este", "", "un", "mensaje", ""]
        }
    ]
}
```

las TestUnit fueron compiladas mediante Jacoco Coverage se realizan la cobertura a las clases fuertes del componente.

![image](https://user-images.githubusercontent.com/107003968/172768285-f418c58d-7278-4dbe-8012-5e01a5c16599.png)

