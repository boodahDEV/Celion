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
boodah@ElRond:~/GitHub/Celion/backend$  npm i
boodah@ElRond:~/GitHub/Celion/frontend$  npm i 
```

 ## Ejecucion 
 * ##### Levantar el backend 
    * En un terminal posicionarse dentro de la carpeta de backend ejecutar el siguiente comando:
    ```console
    boodah@ElRond:~/GitHub/Celion/backend$ npm run dev
    ```
    * En otra terminal levantamos mongoDB para poder conectarnos a la base de datos:
    ```console
    boodah@ElRond:~/GitHub/Celion/backend$ mongod
    ```
 * ##### Frontend
    * EL forntend no esta siendo trabajado aun, pero su ejecucion corresponde a un proyecto en angular comun:
    ```console
    boodah@ElRond:~/GitHub/Celion/frontend$ ng serve
    ```
    
## Funcionamiento
El principal funcionamiento que se quiere lograr con **crocoKEY** es ser un administrador de contraseñas general
en el cual debe alojar seguramente dentro de una base de dato local en mongoDB, garantizando que el descifrado externo 
de las claves alojadas no se efectue con exito.



### A medida que avanza el desarrollo este documento se ira detallando aun mas.


```diff
# Version actual: 0.20.05
# Las solicitudes de extracción y aportes al desarrollo son bienvenidas.
# boodah
```


