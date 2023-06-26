USE superheroes;
INSERT INTO creador (nombre) VALUES ('Marvel'), ('DC Comics');
SELECT * FROM creador;
INSERT INTO personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creadorFK) VALUES 
('Bruce Banner', 'Hulk', 160, '600mil', 75, 98, 1962, 'Físico nuclear', 1),
('Tony Stark', 'Iron Man', 170, '200mil', 70, 98, 1963, 'Inventor industrial', 1),
('Thor Odinson', 'Thor', 145, 'Infinita', 100, 98, 1962, 'Rey de Asgard', 1), 
('Wanda Maximoff', 'Bruja Escarlata', 170, '100mil', 90, 345, 1964, 'Bruja', 1), 
('Carol Danvers','Capitana Marvel', 157, '250 mil', 85, 128, 1968, 'Oficial de inteligencia', 1), 
('Thanos', 'Thanos', 170, 'infinita', 170, '306', 1973, 'Adorador de la muerte', 1), 
('Peter Parker', 'Spiderman', 165, '25 mil', 80, 74, 1962, 'Fotografo', 1), 
('Steve Rogers' ,'Capitan America', 145, '600', 45, 60, 1941, 'Oficial federal', 1), 
('Bobby Drake', 'Ice Man', 140, '2 mil', 64, 122, 1963, 'Contador', 1), 
('Barry Allen', 'FLash', 160, '10mil', 120, 168, 1956, 'Científico forence', 2), 
('Bruce Wayne', 'Batman', 170, '500', 32, 47, 1939, 'Hombre de negocios', 2), 
('Clark Kent', 'Superman', 165, 'infinita', 120, 182, 1948, 'Reportero', 2), 
('Diana Prince', 'Mujer maravilla', 160, 'infinita', 95, 127, 1949,'Princesa guerrera', 2);
SELECT * FROM personajes; 
UPDATE personajes SET aparicion = 1938 where id_personaje = 12;
DELETE FROM personajes where id_personaje = 10; 
DELETE FROM personajes where personaje='Superman' and id_personaje = 12;
select nombre_real FROM personajes;
SELECT nombre_real FROM personajes WHERE nombre_real LIKE "b%";
select * FROM personajes order by inteligencia desc;
SELECT COUNT(id_personaje), aparicion FROM personajes GROUP BY aparicion HAVING COUNT(id_personaje) >= 1;