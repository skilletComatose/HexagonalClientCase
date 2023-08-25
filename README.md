# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyecto y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y finalmente el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture - Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo Gradle perteneciente a la capa del dominio implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En la sección de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos; se realiza el uso de generics para modelar comportamientos genéricos de los diferentes objetos de persistencia que puedan existir. Este tipo de implementaciones se realizan basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006).

Estas clases no pueden existir solas y su comportamiento debe heredarse en los **Driven Adapters**.

### Driven Adapters

Los driven adapters representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios REST, SOAP, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura; es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de uso (UseCases) de forma automática, inyectando en ellos instancias concretas de las dependencias declaradas. Además, inicia la aplicación (es el único módulo del proyecto donde encontraremos la función `public static void main(String[] args)`.

**Los beans de los casos de uso se disponibilizan automáticamente gracias a un '@ComponentScan' ubicado en esta capa.**

## Endpoints
POST : http://localhost:8090/api/v1/client
>> status :200
>>> #### Request
>>```json
>>{
>>    "documentType":"C",
>>    "documentNumber": "23445322"
>>} 
>>```
>>#### Response
>>```json
>>{
>>    "firstName": "Alice",
>>    "middleName": "Wich",
>>    "lastName": "torres",
>>    "secondLastName": "escobar",
>>    "phoneNumber": "555-123-4567",
>>    "address": "789 Oak St",
>>    "residenceCity": "cll 22,...."
>>}
>```

>> status :400
>>> #### Request
>>```json
>>{
>>    "documentNumber": "23445322"
>>} 
>>```
>>#### Response
>>```json
>>{
>>  "code": 400,
>>  "msg": [
>>          "El tipo de documento es obligatorio"
>>  ],
>>  "data": null
>>}
>```

>> status :404
>>> #### Request
>>```json
>>{
>>    "documentType":"P",
>>    "documentNumber": "23445322"
>>} 
>>```
>>#### Response
>>```json

>```