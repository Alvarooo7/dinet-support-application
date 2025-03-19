# Solicitudes App - Spring WebFlux y ReactJS

Este proyecto implementa un sistema de registro, consulta y exportación de solicitudes.  
Se ha desarrollado con **Spring WebFlux** para el backend y **ReactJS** para el frontend.  
La base de datos utilizada es **PostgreSQL**, y **Gradle** se emplea como herramienta de compilación.

## 📌 Funcionalidades Implementadas

### 1️⃣ Registro de Solicitudes
- Formulario con los siguientes campos:
    - **Marca**
    - **Tipo de Solicitud**
    - **Fecha de Envío** (con DatePicker)
    - **Número de Contacto** (solo números)
    - **Nombre del Contacto**
    - **Lista de Contactos Asociados** (Nombre y Número de Contacto)
- El código de solicitud se genera automáticamente al crearse.
- Los datos se almacenan en PostgreSQL con una estructura relacional.

### 2️⃣ Listado de Solicitudes
- Tabla ordenable por columnas.
- Muestra todos los campos registrados.
- El código de solicitud es un enlace a su información detallada.
- Filtros disponibles:
    - **Fecha**
    - **Código**
    - **Tipo de Solicitud**
- Botón para registrar una nueva solicitud.

### 3️⃣ Información de la Solicitud
- Página que muestra todos los detalles de una solicitud registrada.

### 4️⃣ Exportación de Solicitudes
- Botón en la lista de solicitudes para exportar registros en **formato CSV**.

## 🛠️ Tecnologías Utilizadas

### Backend:
- **Spring WebFlux** (programación reactiva)
- **PostgreSQL** (base de datos)
- **Gradle** (compilación y dependencias)
- **Swagger** (documentación de API)

### Frontend:
- **ReactJS** (interfaz de usuario)
- **React Hooks** y **Context API** (gestión de estado)
- **Material-UI / TailwindCSS** (estilizado)

## 🚀 Instalación y Configuración

### 1️⃣ Backend
#### Requisitos previos:
- **Java 17+**
- **Gradle**
- **PostgreSQL** (con una base de datos configurada)

#### Pasos:
```sh
git clone <repositorio>
cd backend
./gradlew bootRun
