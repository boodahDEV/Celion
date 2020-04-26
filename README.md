# Celion
Este repositorio es para desarrollar una Web-app con el stack ~> MEAN (Mongodb, Express, Angular y Nodejs)
con el fin que " **croco KEY** " (app final) sea mi administrador personal de contraseñas, implementando SHA-256 y alguillo
mas para parametrizar y garantizar que el almacenamiento de mis contraseñas (todas en general) no se vean vulneradas de ciertamanera.



## Instalacion 

PRIMERO QUE TODO TENER CADA UNO DEL STACK MEAN (MongoDB, AngularCLI, NodeJS)

* ##### Para instalar MongoDB => =>
```console
boodah@ElRond:~$ sudo apt install -y mongodb
```
```console
+ Comprueba si el servicio esta ejecutando y que la base de dato funcione
boodah@ElRond:~$ sudo systemctl status mongodb
```
```console
+ Con esto se mostrarán la versión actual de la base de datos y el puerto del servidor
boodah@ElRond:~$ mongo --eval 'db.runCommand({ connectionStatus: 1 })'
+ Verifica que el puerto que utilice mongoDB sea el 27017 
+ Si ok: 1 ==> el servidor funciona correctamente.
```

* ##### Para instalar NodeJS y NPM => =>  En mi caso utilice la manera NVM siguiendo este tutorial => 
  * [https://tecadmin.net/install-nodejs-with-nvm/]

* ##### Para instalar Angular CLI => =>
```console
boodah@ElRond:~$ npm install -g @angular/cli
```

* ##### Tomando en cuenta comandos basicos de ejecucion de proyectos con NPM  (tanto dentro del backend como en el frontend) => =>
```console
boodah@ElRond:~/GitHub/Celion/$  npm i
+ Si da algun tipo de errores por vulnerabilidades simplemente usa -> npm audit fix --force
```



 ## Ejecucion 
 * ##### Levantar el backend 
    * En un terminal ejecutar el siguiente comando:
    ```console
    boodah@ElRond:~/GitHub/Celion/$ npm run dev-server
    ```
    * En otra terminal levantamos mongoDB para poder conectarnos a la base de datos:
    ```console
    +  Si es el caso de que no este activo el servicio
    boodah@ElRond:~/GitHub/Celion/$ mongod
    + Igualmente el servidor al levantar muestra informacion si lo esta o no.
    ```
 * ##### Frontend
    * EL forntend no esta siendo trabajado aun, pero su ejecucion corresponde a un proyecto en angular comun:
    ```console
    boodah@ElRond:~/GitHub/Celion/$ npm run start-view
    ```
    

    
## Funcionamiento
El principal funcionamiento que se quiere lograr con **crocoKEY** es ser un administrador de contraseñas general
en el cual debe alojar seguramente dentro de una base de dato local en mongoDB, garantizando que el descifrado externo 
de las claves alojadas no se efectue con exito.



### A medida que avanza el desarrollo este documento se ira detallando aun mas.


```diff
# Version actual: 0.20.12
+ Esta versión engloba cambios en los accesos a baules directamente en el servidor, metiendole musculo poco 
+ a poco para asi garantizar que los baules sean si y solo si de acceso unico por parte de su creador.

# Las solicitudes de extracción y aportes al desarrollo son bienvenidas.
# boodah
```


