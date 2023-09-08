import { NavLink, Link } from "react-router-dom";

export const Card = ({ id, imagen, nombre, especie, status }) => {
  return (
    <>
      <div className="card">
        <img src={imagen} alt={imagen} className="card-img-top" />
        <div className="card-body">
          <h5 className="card-title">{nombre}</h5>
        </div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item">Especie: {especie}</li>
          <li className="list-group-item">Status: {status}</li>
        </ul>

        <div className="card-body">
          <Link to={`/detail/${id}`}>Ver más</Link>
        </div>
      </div>
    </>
  );
};
