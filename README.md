<h1>Evaluacion3-DanielaGomezPalacios</h1>
En este repositorio se encuentra la evaluación parcial 3 de la asignatura Desarrollo Orientado a Objetos

Este proyecto tiene como objetivo desarrollar un sistema de software para la empresa "MotoRenta", especializado en el alquiler de motocicletas. El sistema permitirá gestionar de manera eficiente los datos de clientes, motocicletas y arrendamientos, facilitando las operaciones diarias de la empresa.

<h2>Funcionalidades</h2>

<h3>Gestión de Clientes:</h3>

Registro de nuevos clientes con RUT, nombre completo, teléfono y correo electrónico.

Eliminación de clientes existentes.

Modificación: Actualización de datos de clientes.

<h3>Gestión de Motocicletas:</h3>

Registro de nuevas motocicletas con patente, marca, modelo, máxima velocidad, cilindrada (alta o baja), rendimiento y si posee ABS.

Consulta: Listado de motocicletas con posibilidad de filtrar por tipo de cilindrada.

<h3>Gestión de Arrendamientos:</h3>

Alta: Registro de nuevos arrendamientos, incluyendo fecha y hora, cliente asociado y motocicleta alquilada.
Consulta: Listado de todos los arrendamientos, con posibilidad de filtrar por tipo de motocicleta (alta o baja cilindrada).
Reportes:
Generación de reportes detallados de todos los arrendamientos realizados, segmentados por tipo de motocicleta.
<h3>Requisitos Técnicos</h3>
Obligatorio: Todos los campos para registrar clientes, motocicletas y arrendamientos son obligatorios.
Polimorfismo: Implementar un método para mostrar los datos de las motocicletas, el cual deberá ser sobrescrito según el tipo de motocicleta (alta o baja cilindrada).
<h2>Diseño del Sistema</h2>

<h3>Entidades:</h3>
Cliente, Motocicleta, Arriendo.
<h3>Relaciones:</h3>
Un cliente puede realizar múltiples arrendamientos.
Una motocicleta puede ser alquilada múltiples veces.
Un arrendamiento involucra un cliente y una motocicleta.
<h3>Atributos:</h3>
Cliente: RUT, nombre, teléfono, correo electrónico.
Motocicleta: patente, marca, modelo, máxima velocidad, cilindrada, rendimiento, ABS.
Arriendo: fecha y hora, cliente, motocicleta, valor.