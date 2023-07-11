select * from oficina;
select * from cliente;
select * from empleado;
select * from gama_producto;
select * from  pago;
select * from pedido;
select * from  producto;
-- 1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
select codigo_oficina, ciudad from oficina;

-- 2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
select ciudad, telefono from oficina where pais like 'España';

-- 3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7.
select nombre, apellido1, apellido2, email, codigo_jefe from empleado where codigo_jefe = 7;

-- 4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
select puesto AS Cargo, nombre, apellido1, apellido2, email from empleado where codigo_jefe is null;

-- 5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
select nombre, apellido1, apellido2, puesto AS Cargo from empleado where puesto not like 'Representante ventas';

-- 6. Devuelve un listado con el nombre de los todos los clientes españoles.
select nombre_cliente from cliente where pais like 'Spain';

-- 7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select distinct estado from pedido;

-- 8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago
-- en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan
-- repetidos. Resuelva la consulta: 

-- Utilizando la función DATE_FORMAT de MySQL.
SELECT distinct codigo_cliente FROM pago WHERE DATE_FORMAT(fecha_pago, '%Y') = '2008';

-- Sin utilizar ninguna de las funciones anteriores.
select distinct codigo_cliente from pago where fecha_pago between '2008-01-01' and '2008-12-31';

-- Utilizando la función YEAR de MySQL.
SELECT distinct codigo_cliente FROM pago WHERE YEAR(fecha_pago) = 2008;

-- 9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
select * from pedido where estado like 'Entregado' Having fecha_entrega > fecha_esperada; 

-- 10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.

-- Utilizando la función ADDDATE de MySQL.
SELECT * FROM pedido WHERE estado LIKE 'Entregado' AND fecha_esperada <= ADDDATE(fecha_entrega, -2);
-- Utilizando la función DATEDIFF de MySQL.
SELECT * FROM pedido WHERE estado LIKE 'Entregado' AND DATEDIFF(fecha_entrega, fecha_esperada) >= 2;
-- Sin utilizar funcions
select * from pedido where estado like 'Entregado' and fecha_esperada - 2 >= fecha_entrega;

-- 11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
select * from pedido where estado like 'Rechazado' and YEAR(fecha_entrega) = 2009;

-- 12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
select * from pedido where estado like 'Entregado' and date_format(fecha_entrega, '%m') = 01;

-- 13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor.
select * from pago where forma_pago like 'PayPal' and YEAR(fecha_pago) = 2008 ORDER BY total DESC;

-- 14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
SELECT distinct forma_pago from pago;

-- 15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
select * from producto where gama like 'Ornamentales' and cantidad_en_stock > 100 order by precio_venta desc;

--  16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30.
select * from cliente where ciudad like 'Madrid' and codigo_empleado_rep_ventas in (11,30);



-- Consultas multitabla (Composición interna)
-- Las consultas se deben resolver con INNER JOIN.

-- 1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
select nombre_cliente, nombre as NombreVendedor, concat(apellido1," " ,apellido2) as ApellidosVendedor from cliente inner join empleado on codigo_empleado = codigo_empleado_rep_ventas;

-- 2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
select distinct nombre_cliente, concat(nombre," ", apellido1) as Vendedor from cliente 
	inner join empleado on codigo_empleado = codigo_empleado_rep_ventas
    inner join pago on pago.codigo_cliente = cliente.codigo_cliente;

-- 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.
select distinct nombre_cliente, concat(nombre," ", apellido1) as Vendedor from cliente  
	inner join empleado on codigo_empleado = codigo_empleado_rep_ventas
    where codigo_cliente not in (select codigo_cliente from pago);
    
-- 4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
Select distinct nombre_cliente, concat(nombre," ", apellido1) as Vendedor, oficina.ciudad as CiudadOficina from cliente
	inner join empleado on codigo_empleado = codigo_empleado_rep_ventas
	inner join pago on pago.codigo_cliente = cliente.codigo_cliente    
    inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina;

-- 5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
select distinct nombre_cliente, concat(nombre," ", apellido1) as Vendedor, oficina.ciudad as Vendedor from cliente  
	inner join empleado on codigo_empleado = codigo_empleado_rep_ventas
    inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina
    where codigo_cliente not in (select codigo_cliente from pago); 
        
-- 6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
select distinct concat(oficina.linea_direccion1," ",oficina.linea_direccion2) as DirecciónOficinasConClientesEnFuenlabrada, cliente.nombre_cliente,cliente.ciudad from oficina 
	inner join empleado on empleado.codigo_oficina = oficina.codigo_oficina
    inner join cliente on empleado.codigo_empleado = cliente.codigo_empleado_rep_ventas
	where cliente.ciudad like 'Fuenlabrada';

-- 7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.
select distinct nombre_cliente, concat(nombre," ", apellido1) as Vendedor, oficina.ciudad as Vendedor from cliente  
	inner join empleado on codigo_empleado = codigo_empleado_rep_ventas
    inner join oficina on empleado.codigo_oficina = oficina.codigo_oficina;

-- 8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
select concat(e1.nombre," ", e1.apellido1) as Empleado, concat(e2.nombre," ", e2.apellido1) as Jefe from empleado e1
	inner join empleado e2 on e2.codigo_empleado = e1.codigo_jefe;

-- 9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
select nombre_cliente, codigo_pedido from cliente
	inner join pedido on cliente.codigo_cliente = pedido.codigo_cliente
    where estado like 'Entregado' and fecha_entrega > fecha_esperada;

-- 10. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
select distinct cliente.nombre_cliente, producto.gama from producto
    inner join detalle_pedido on detalle_pedido.codigo_producto = producto.codigo_producto
    inner join pedido on detalle_pedido.codigo_pedido = pedido.codigo_pedido
	inner join cliente on pedido.codigo_cliente = cliente.codigo_cliente;

-- Consultas multitabla (Composición externa)
-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, JOIN.
-- 1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
select * from cliente 



-- 2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
-- 3. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.
-- 4. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
-- 5. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
-- 6. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.
-- 7. Devuelve un listado de los productos que nunca han aparecido en un pedido.
-- 8. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
-- 9. Devuelve un listado con los clientes que han realizado algún pedido, pero no han realizado ningún pago.
-- 10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.





