-- 2. Obtener los datos completos de los departamentos.
SELECT * FROM departamentos;

-- 1. Obtener los datos completos de los empleados.
SELECT * FROM empleados;

-- 3. Listar el nombre de los departamentos.
SELECT distinct nombre_depto FROM departamentos;

-- 4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp FROM empleados;

-- 5. Listar todas las comisiones.
SELECT distinct comision_emp FROM empleados;

-- 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT * FROM empleados where cargo_emp like 'Secretaria';

-- 7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
select * from empleados where cargo_emp = "Vendedor" order by nombre asc; 

-- 8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT nombre, cargo_emp, sal_emp FROM empleados order by sal_emp asc;

-- 9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
select nombre_jefe_depto, ciudad FROM departamentos where ciudad = 'CIUDAD REAL';  /*select nombre, cargo_emp FROM empleados where cargo_emp LIKE 'Jefe%' AND id_depto = ;*/

-- 10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
SELECT nombre AS Nombre, cargo_emp As Cargo From empleados;

-- 11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT sal_emp, comision_emp, id_depto FROM empleados where id_depto = 2000 order by comision_emp asc;

-- 12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del empleado y el total a pagar, en orden alfabético.
SELECT nombre, (sal_emp + comision_emp +500) As Total_a_pagar FROM empleados WHERE id_depto = 3000 order by nombre asc;

-- 13. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT nombre from empleados where nombre like 'j%';

-- 14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos empleados que tienen comisión superior a 1000.
select NOMBRE, SAL_EMP, COMISION_EMP, (SAL_EMP + COMISION_EMP) AS SALARIO_TOTAL FROM empleados where COMISION_EMP>1000;

-- 15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
select NOMBRE, SAL_EMP, COMISION_EMP, (SAL_EMP + COMISION_EMP) AS SALARIO_TOTAL FROM empleados where COMISION_EMP = 0;




SELECT NOMBRE, SAL_EMP, COMISION_EMP FROM empleados where COMISION_EMP > SAL_EMP; 
SELECT NOMBRE, format(SAL_EMP,0) As Salario, format(COMISION_EMP,0) As Comisión FROM EMPLEADOS WHERE COMISION_EMP<= (SAL_EMP*0.3);
SELECT NOMBRE FROM  EMPLEADOS where  NOMBRE not LIKE '%ma%';
-- SELECT NOMBRE_DEPTO FROM departamentos WHERE NOMBRE_DEPTO = 'VENTAS' or NOMBRE_DEPTO = 'INVESTIGACION' or NOMBRE_DEPTO = 'MANTENIMIENTO';
select * from DEPARTAMENTOS where nombre_depto in ("Ventas", "Investigación", "Mantenimiento") order by nombre_depto;
select * from DEPARTAMENTOS where nombre_depto not in ("Ventas", "Investigación", "Mantenimiento") order by nombre_depto;
-- SELECT NOMBRE_DEPTO FROM departamentos WHERE NOT NOMBRE_DEPTO = 'VENTAS' and NOT NOMBRE_DEPTO = 'INVESTIGACION' and NOT NOMBRE_DEPTO = 'MANTENIMIENTO';
SELECT format(MAX(SAL_EMP),0) As Salario_máximo FROM EMPLEADOS;
SELECT NOMBRE FROM EMPLEADOS ORDER BY NOMBRE desc LIMIT 3;
select max(nombre) from empleados; 
select format(max(SAL_EMP),0) as Salario_más_Alto, Format(min(SAL_EMP),0) as Salario_más_bajo, Format((max(SAL_EMP)-min(SAL_EMP)),0) as Diferencia From EMPLEADOS;
select format(avg(SAL_EMP),0) As Promedio_Salario_por_Depto, id_depto from empleados group by id_depto; 
SELECT id_depto, AVG(sal_emp) FROM empleados GROUP BY id_depto HAVING avg(sal_emp);
Select id_depto, count(NOMBRE) as Cantidad_empleados FROM EMPLEADOS GROUP BY id_depto having count(NOMBRE)>3;
-- (Select id_depto, count(NOMBRE) as Cantidad_empleados FROM EMPLEADOS GROUP BY id_depto having count(NOMBRE)>3


Select empleados.nombre, departamentos.nombre_depto from empleados right join departamentos on departamentos.id_depto = empleados.id_depto order by empleados.nombre asc; 
-- select nombre_depto from departamentos where (Select id_depto from empleado where (Select id_depto, count(NOMBRE) as Cantidad_empleados FROM EMPLEADOS GROUP BY id_depto having count(NOMBRE)>3));


-- 26. Hallar los departamentos que no tienen empleados Consulta Multitabla (Uso de la sentencia JOIN/LEFT JOIN/RIGHT JOIN)
SELECT id_depto, count(nombre) from empleados group by id_depto having count(nombre)=0;
-- drop id_depto from departamentos where id_depto = 4000;
Select nombre, nombre_depto, nombre_jefe_depto from departamentos inner join empleados on departamentos.id_depto = empleados.id_depto order by empleados.nombre asc;

-- 27. Mostrar la lista de empleados, con su respectivo departamento y el jefe de cada departamento.
select  nombre, id_depto, format(sal_emp,0) from empleados where sal_emp >= (select avg(sal_emp) As Salario_Promedio from empleados) order by id_depto;

-- Consulta con Subconsulta
-- 28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
select  nombre, sal_emp, id_depto from empleados where sal_emp >= (select avg(sal_emp) from empleados) order by id_depto;
select format(AVG(sal_emp),0) As Salario_Promedio from empleados;



/* 1. Obtener los datos completos de los empleados.
2. Obtener los datos completos de los departamentos.
3. Listar el nombre de los departamentos.
4. Obtener el nombre y salario de todos los empleados.
5. Listar todas las comisiones.
6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
7. Obtener los datos de los empleados vendedores, ordenados por nombre
alfabéticamente.
8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a
mayor.
9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad
de “Ciudad Real”
10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las
respectivas tablas de empleados.
11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado
por comisión de menor a mayor.
12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta
de: sumar el salario y la comisión, más una bonificación de 500. Mostrar el nombre del
empleado y el total a pagar, en orden alfabético.
13. Muestra los empleados cuyo nombre empiece con la letra J.
14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de aquellos
empleados que tienen comisión superior a 1000.
15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen
comisión.
16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o
‘Mantenimiento.
20. Ahora obtener el contrariocontrario, los nombres de los departamentos que no sean “Ventas” ni
“Investigación” ni ‘Mantenimiento.
21. Mostrar el salario más alto de la empresa.
22. Mostrar el nombre del último empleado de la lista por orden alfabético.
23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
24. Hallar el salario promedio por departamento.
Consultas con Having
25. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de
empleados de esos departamentos.






*/