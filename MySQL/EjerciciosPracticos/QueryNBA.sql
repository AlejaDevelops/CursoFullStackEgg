select * from equipos;
Select * from estadisticas;
Select * from jugadores;
Select * from partidos;
-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
Select nombre from jugadores order by Nombre asc;

-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.
select * from jugadores where posicion ='C' and peso > 200 order by Nombre asc; 

-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
select nombre from equipos order by nombre asc;

-- 4. Mostrar el nombre de los equipos del este (East). 
select nombre, Conferencia from equipos where Conferencia = "East";

-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
select nombre, ciudad from equipos where ciudad like 'c%' order by nombre asc;

-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
select nombre As Nombre_Jugador, nombre_equipo FROM JUGADORES order by nombre_equipo asc;

-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
select nombre As Nombre_Jugador, nombre_equipo FROM JUGADORES where nombre_equipo = "Raptors"  order by nombre asc;

-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
select Puntos_por_partido from estadisticas where jugador = (Select codigo from jugadores where nombre = "Pau Gasol");

-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
select Puntos_por_partido from estadisticas where temporada = "04/05" and jugador = (Select codigo from jugadores where nombre = "Pau Gasol");

-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.
select jugador, format(sum(Puntos_por_partido), 2) as Puntos_Totales from estadisticas group by jugador order by sum(Puntos_por_partido) desc;

-- 11. Mostrar el número de jugadores de cada equipo.
select Nombre_equipo, count(*) as Cantidad_Jugadores from jugadores group by nombre_equipo;

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT jugador, FORMAT(SUM(Puntos_por_partido), 2) AS Puntos_Totales FROM estadisticas GROUP BY jugador HAVING SUM(Puntos_por_partido) = (
    SELECT MAX(PuntosTotales) FROM (SELECT jugador, SUM(Puntos_por_partido) as PuntosTotales FROM estadisticas GROUP BY jugador)AS PuntosPorJugador
);