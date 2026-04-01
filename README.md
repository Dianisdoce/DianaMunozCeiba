SauceDemo Automation 
Este repositorio contiene la automatización del flujo crítico de compra para la plataforma SauceDemo. El proyecto ha sido desarrollado bajo estándares de calidad, utilizando el patrón de diseño Screenplay y el framework Serenity BDD.

Stack Tecnológico
Lenguaje: Java 17

Framework: Serenity BDD con Cucumber (Gherkin)

Patrón de Diseño: Screenplay (Actors, Tasks, UI, Questions)

Gestor de Dependencias: Gradle

Reportes: Serenity HTML Reports

Arquitectura del Proyecto:
Se implementó el patrón Screenplay, el cual permite una separación clara de responsabilidades y facilita la escalabilidad del código:

Actors: Representan al usuario que realiza las acciones en el sistema.

Tasks: Clases que encapsulan la lógica de negocio (Autenticarse, SeleccionarProducto, FinalizarCompra).

User Interfaces: Definición de localizadores (XPaths/CSS) mediante la clase Target.

Questions: Verificaciones de estado para las aserciones de la prueba (ElMensaje).

Pruebas Funcionales y Documentación:
Toda la documentación estratégica se encuentra en la carpeta /documents:

Plan de Pruebas: Estrategia, matriz de casos de prueba (positivos y negativos) y alcance.

Cuestionario Técnico: Respuestas al componente teórico de la prueba.

Ejecución y Reportes

Para ejecutar la
suite de pruebas completa y generar el reporte visual interactivo de Serenity,
abrir una terminal en la raíz del proyecto y ejecutar: ./gradlew clean test
aggregate

Serenity genera un reporte
detallado con capturas de pantalla de cada paso. Podrá encontrarlo en la
siguiente ruta del proyecto: target/site/serenity/index.html
