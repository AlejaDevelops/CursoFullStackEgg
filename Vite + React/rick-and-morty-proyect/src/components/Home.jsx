import { useEffect, useState } from "react";
import { Card } from "./Card";

export const Home = () => {
  const [personajes, setPersonajes] = useState([]);

  const cargarPersonajes = async () => {
    try {
      const response = await fetch("https://rickandmortyapi.com/api/character");
      const data = await response.json();
      setPersonajes(data.results);
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    cargarPersonajes();
  }, []);

  return (
    <>
      <section className="py-5 text-center container">
        <div className="row py-lg-5">
          <div className="col-lg-6 col-md-8 mx-auto">
            <h1 className="fw-light">Album de Personajes </h1>
            <h2 className="fw-light">Serie Rick and Morty</h2>
            <p className="lead text-body-secondary">
              Después de haber estado desaparecido durante casi 20 años, Rick
              Sánchez llega de imprevisto a la puerta de la casa de su hija Beth
              y se va a vivir con ella y su familia utilizando el garaje como su
              laboratorio personal.
            </p>
            <p>
              <h5>Ver review</h5>
              <a
                href="https://www.filmaffinity.com/es/film551351.html"
                className="btn btn-primary my-2"
                target="blank"
              >
                FilmAfinnity
              </a>
              <a
                href="https://www.rottentomatoes.com/tv/rick_and_morty"
                className="btn btn-secondary my-2"
                target="blank"
              >
                RottenTomatoes
              </a>
            </p>
          </div>
        </div>
      </section>
      {Array.isArray(personajes) ? (
        <div className="album py-5 bg-body-tertiary">
          <div className="container">
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
              {personajes.map((personaje) => (
                <Card
                  key={personaje.id}
                  id={personaje.id}
                  imagen={personaje.image}
                  nombre={personaje.name}
                  especie={personaje.species}
                  status={personaje.status}
                ></Card>
              ))}
            </div>
          </div>
        </div>
      ) : (
        <p>Error: personajes no es un arreglo válido</p>
      )}
    </>
  );
};
