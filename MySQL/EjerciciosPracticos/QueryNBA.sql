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
SELECT jugador, SUM(Puntos_por_partido) as PuntosTotales FROM estadisticas GROUP BY jugador; -- Lista de los puntos totales de cada jugado
SELECT MAX(PuntosTotales) FROM (SELECT jugador, SUM(Puntos_por_partido) as PuntosTotales FROM estadisticas GROUP BY jugador)AS PuntosPorJugador; -- Puntaje máximo de la búsqueda anterior

SELECT jugador, FORMAT(SUM(Puntos_por_partido), 2) AS Puntos_Totales FROM estadisticas GROUP BY jugador HAVING SUM(Puntos_por_partido) = (
    SELECT MAX(PuntosTotales) FROM (SELECT jugador, SUM(Puntos_por_partido) as PuntosTotales FROM estadisticas GROUP BY jugador)AS PuntosPorJugador);

-- 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
Select Nombre_equipo from jugadores where Altura = (Select max(Altura)from jugadores);
Select nombre, conferencia, division from equipos where Nombre = (Select Nombre_equipo from jugadores where Altura = (Select max(Altura)from jugadores));

-- 14. Mostrar la media de puntos en partidos de los equipos de la división Pacific. (Asumiendo que ambos equipos deben ser de la division Pacific y que la media de puntos de cada partido es la suma de todos los puntos entre 2)
Select equipo_local, equipo_visitante, (puntos_local + puntos_visitante)/2  as MediaDePuntosPorPartido from partidos; -- Cálculo de la media de puntos por partido

select equipo_local, equipo_visitante, (puntos_local + puntos_visitante)/2  as MediaDePuntosPorPartidoDeEquiposDivisionPacific from partidos 
	join equipos AS locales on partidos.equipo_local = locales.Nombre  -- Se une la tabla partidos con la tabla equipos para buscar solo los equipos locales
	join equipos As visitantes on partidos.equipo_visitante = visitantes.Nombre -- Se une la tabla partidos con la tabla equipos nuevamente, pero esta vez para buscar los equipos visitantes 
	where locales.Division = "Pacific" and visitantes.Division = "Pacific";

-- Mostrando la media total de los partidos...
select avg((puntos_local + puntos_visitante)/2)  as MediaDePuntosPartidosDivisionPacific from partidos 
	join equipos AS locales on partidos.equipo_local = locales.Nombre  -- Se une la tabla partidos con la tabla equipos para buscar solo los equipos locales
	join equipos As visitantes on partidos.equipo_visitante = visitantes.Nombre -- Se une la tabla partidos con la tabla equipos nuevamente, pero esta vez para buscar los equipos visitantes 
	where locales.Division = "Pacific" and visitantes.Division = "Pacific";

-- 15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
SELECT equipo_local, equipo_visitante, ABS(puntos_local - puntos_visitante) AS DiferenciaPuntos FROM partidos ORDER BY DiferenciaPuntos DESC LIMIT 1; -- En caso de que solo exista un equipo con la diferencia máxima

Select equipo_local, equipo_visitante, DiferenciaPuntos from -- En caso de que existan varios equipos con la máxima diferencia
	(Select equipo_local, equipo_visitante, abs(puntos_local-puntos_visitante) As DiferenciaPuntos from partidos) As subconsulta	
		where DiferenciaPuntos = (Select Max(abs(puntos_local-puntos_visitante)) from partidos);        

-- 16. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
-- ¿Es el mismo punto 14?

-- 17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante. (Se mostrarán los equipos con la suma de los puntos )
select sum(puntos_local)  FROM PARTIDOS group by equipo_local;
select sum(puntos_visitante) FROM PARTIDOS group by equipo_visitante;

select equipos.nombre, PuntosComoLocal.puntos as PuntosComoLocal, PuntosComoVisitante.puntos as PuntosComoVisitante from equipos
	LEFT JOIN (SELECT equipo_local, SUM(puntos_local) AS Puntos FROM partidos GROUP BY equipo_local) AS PuntosComoLocal ON PuntosComoLocal.equipo_local = equipos.nombre
	LEFT JOIN (SELECT equipo_visitante, SUM(puntos_visitante) AS Puntos FROM partidos GROUP BY equipo_visitante) AS PuntosComoVisitante ON PuntosComoVisitante.equipo_visitante = equipos.nombre;
    
-- 18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
select *, 
	CASE 
		WHEN puntos_local > puntos_visitante THEN equipo_local
        WHEN puntos_local < puntos_visitante THEN equipo_visitante  
        else 'Empate'
        end As EquipoGanador
	from partidos; 

-- CANDADO A / Posicion 2 / Clave 14043
select * from estadisticas where Asistencias_por_partido = (select max(Asistencias_por_partido) from estadisticas); 

Select sum(Peso) from jugadores 
	INNER JOIN equipos on equipos.Nombre = jugadores.Nombre_equipo
    where equipos.Conferencia like 'East' and jugadores.Posicion like '%C%';

-- CANDADO B / Posicion 3 / Clave 3480
select count(jugador) from estadisticas 
    where Asistencias_por_partido > (Select count(*) from jugadores where Nombre_equipo like 'Heat');
    
select count(*) from partidos where temporada like '%99%';

-- CANDADO C / Posicion 1 / Clave 631
select count(*)/(select count(*) from jugadores where Peso >= 195)+0.9945 from jugadores where Procedencia like '%Michigan%' and Nombre_equipo in (select Nombre from equipos where conferencia like 'West');
select count(*) from jugadores where Peso >= 195;

select avg(Puntos_por_partido)+count(Asistencias_por_partido)+sum(Tapones_por_partido) from estadisticas 
	inner join jugadores on jugadores.codigo = estadisticas.jugador
	inner join equipos on equipos.Nombre = jugadores.Nombre_equipo
    where Division like 'Central';
 


-- CANDADO D / Posicion 4 / Clave 191
select Tapones_por_partido from estadisticas where jugador = (select codigo from jugadores where Nombre like 'Corey Maggette') and temporada like '00/01';
select sum(Puntos_por_partido) from estadisticas where jugador in (select codigo from jugadores where Procedencia like 'Argentina');


