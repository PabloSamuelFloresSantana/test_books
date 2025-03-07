# Proyecto Test - Backend y Frontend

Este proyecto consiste en una aplicación full-stack desarrollada con Java 1.8 (Spring Boot) para el backend, Oracle 21c como base de datos y Angular CLI 17 para el frontend.

## Tecnologías Utilizadas
- **Java 1.8**
- **Oracle Database 21c Express Edition (XE)**
- **Angular CLI 17**

## Configuración de la Base de Datos

### Requisitos Previos
1. Descargar e instalar **Oracle Database 21c XE** desde:  
   [https://www.oracle.com/database/technologies/xe-downloads.html](https://www.oracle.com/database/technologies/xe-downloads.html)

### Creación de Usuario
1. Conéctate a la base de datos con el usuario `SYSTEM` (Ej. Usando DataGrip).
2. Ejecuta los siguientes comandos SQL:

```sql
-- Habilitar creación de usuarios
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- Crear usuario y asignar permisos
CREATE USER root IDENTIFIED BY "root";
ALTER USER root QUOTA UNLIMITED ON USERS;
GRANT CREATE SESSION TO root;
GRANT CONNECT, RESOURCE TO root;
ALTER USER root DEFAULT ROLE "RESOURCE";
```

## Configuración del Backend (Java Spring Boot)

### Pasos Iniciales
1. Abre el proyecto `test` en tu IDE (Eclipse, IntelliJ, etc.).
2. Localiza el archivo de propiedades:  
   `src/main/resources/application.properties`

3. **Primera Ejecución**:  
   Cambia la línea:  
   `spring.sql.init.mode=never` → `spring.sql.init.mode=always`  
   Esto creará las tablas y cargará datos de prueba.

4. Ejecuta la aplicación Spring Boot.

5. **Después de la Primera Ejecución**:  
   Vuelve a cambiar la propiedad a:  
   `spring.sql.init.mode=never`  
   (Para evitar que se reinicien los datos en futuras ejecuciones).

## Configuración del Frontend (Angular 17)

### Instalar Angular CLI
1. Instala Angular CLI globalmente:
```bash
npm install -g @angular/cli@17
```

### Ejecutar la Aplicación
1. Navega a la carpeta del frontend:
```bash
cd client
```

2. Instala las dependencias:
```bash
npm i
```

3. Inicia el servidor de desarrollo:
```bash
ng serve
```

4. Accede a la aplicación desde:  
   [http://localhost:4200](http://localhost:4200)

## Notas Adicionales
- **Backend**: Asegúrate de que las credenciales de la base de datos en `application.properties` coincidan con las de tu entorno (usuario: `root`, contraseña: `root`).
- **Frontend**: Si ocurren errores de dependencias, elimina la carpeta `node_modules` y vuelve a ejecutar `npm i`.