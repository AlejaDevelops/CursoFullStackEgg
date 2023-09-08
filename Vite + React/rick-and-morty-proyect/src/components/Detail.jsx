import { useEffect, useState } from "react";
import { NavLink, useParams } from "react-router-dom";

export const Detail = () => {
  const { id } = useParams();
  const [personaje, setPersonaje] = useState(null);

  const cargarPersonaje = async () => {
    try {
      const response = await fetch(
        `https://rickandmortyapi.com/api/character/${id}`
      );
      const data = await response.json();
      setPersonaje(data);
      console.log(data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    cargarPersonaje();
  }, [id]);
  console.log(personaje);

  if (!personaje) {
    return <p>Cargando...</p>;
  }

  return (
    <>
      <div className="card mb-3" width={100}>
        <div className="row g-0">
          <div class="col-md-4">
            <img
              src={personaje.image}
              class="img-fluid rounded-start"
              alt="..."
            />
          </div>
          <div className="col-md-8">
            <div className="card-body">
              <h5 className="card-title">{personaje.name}</h5>
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  Especie: {personaje.species}
                </li>
                <li className="list-group-item">
                  Created: {personaje.created}
                </li>
                <li className="list-group-item">Gender: {personaje.gender}</li>
                <li className="list-group-item">
                  Species: {personaje.species}
                </li>
                <li className="list-group-item">Status: {personaje.status}</li>
                <li className="list-group-item">Type: {personaje.type}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div className="card-body">
        <NavLink to="/">Inicio</NavLink>
      </div>
    </>
  );
};
