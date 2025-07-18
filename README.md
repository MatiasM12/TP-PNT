# Proyecto de Ingreso a PNT - Resolución Personal

Este repositorio contiene mi resolución al proyecto de ingreso propuesto por **Somos PNT**, donde se trabaja sobre una aplicación Java utilizando **Spring Boot**, **TDD (Test Driven Development)**, y una arquitectura basada en **capas**.

## 📝 Descripción del proyecto

El objetivo del proyecto es desarrollar un servicio que permita buscar, guardar y filtrar provincias en una base de datos. El proyecto guía al desarrollador a través de la implementación de buenas prácticas como:

- Arquitectura de 3 capas (Presentación, Negocio, Datos).
- Desarrollo guiado por pruebas (TDD).
- Inyección de dependencias con Spring.
- Acceso a datos con Spring Data JPA y una base en memoria (HSQLDB).

## 💻 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Framework 6.x
- JUnit 5
- HSQLDB (base de datos en memoria)
- Maven
- NetBeans (IDE sugerido por el curso)
- Git

## 🧠 Conceptos aplicados

- Arquitectura en capas para separar responsabilidades.
- Implementación de TDD: partiendo del test, luego la lógica, y finalmente el refactor.
- Uso de `@Service`, `@Repository`, `@Autowired` para inyección de dependencias.
- Repositorios implementados con Spring Data JPA para consultas a la base de datos sin necesidad de SQL.
- Validaciones dentro de la capa de negocio para asegurar la calidad de los datos.

## 📂 Funcionalidades implementadas

- Buscar una provincia por ID:
  - Devuelve la provincia si existe.
  - Devuelve `null` si no existe.
  - Lanza `IllegalArgumentException` si el parámetro es `null`.
- Buscar provincias por nombre exacto:
  - Devuelve una lista si hay coincidencias exactas.
  - Valida que el string no sea `null` ni menor a 3 caracteres.
- Buscar provincias por nombre general (like, case insensitive).
- Crear una nueva provincia:
  - Valida que el nombre no sea `null` ni menor a 3 caracteres.
  - Guarda usando `save()` de Spring Data.
 
## 🗒️ Diagrama de clases

<img width="935" height="360" alt="diagrama-de-clases" src="https://github.com/user-attachments/assets/f8d85525-9b4e-4b29-8b39-92eeed0a7325" />

## 🧪 Testing

Los tests fueron desarrollados antes de cada funcionalidad utilizando TDD. Se implementaron tests unitarios y de componentes. Se utilizaron las anotaciones de JUnit y AssertJ para validaciones. También se integró Spring en los tests para probar los servicios con sus dependencias inyectadas automáticamente.

## 🚀 ¿Cómo correrlo?

1. Clonar el proyecto
2. Abrir en NetBeans o tu IDE favorito
3. Ejecutar `mvn clean install` para compilar y bajar dependencias
4. Ejecutar los tests desde el IDE o con `mvn test`
5. (Opcional) Ejecutar el proyecto y acceder a `http://localhost:8080`

## 🧩 Bonus opcional ("Yapa")

Como desafío adicional, se podría implementar una capa de presentación utilizando Spring MVC y Thymeleaf, con endpoints REST para realizar búsquedas desde el navegador.

## 📌 Conclusión

Este proyecto fue una excelente oportunidad para aplicar los fundamentos de Java moderno, buenas prácticas de desarrollo y herramientas profesionales del ecosistema Spring. La estructura, los tests y la implementación se hicieron siguiendo lo propuesto por PNT, asegurando un diseño limpio, mantenible y profesional.

---

> _Este proyecto es parte del proceso de ingreso a la empresa **Somos PNT**, y refleja mi compromiso con las buenas prácticas de desarrollo y mi entusiasmo por seguir creciendo como desarrollador Java._


### ¿Dónde puedo acceder al curso? ###

https://dosideas.com/cursos/course/introduccion-al-desarrollo-en-java-con-spring-framework-y-spring-boot
