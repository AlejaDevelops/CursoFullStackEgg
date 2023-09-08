import React, { useState } from "react";
import { AgregarEstudiante } from "./AgregarEstudiante";

const Items = ({ nombre, activo }) => {
  return (
    <li className="rojito">
      {nombre}
      {activo ? "😃" : "🥵"}
    </li>
  );
};

export const ListadoAppMap = () => {
  const addTask = () => {
    setArreglo([...arreglo, { nombre: "nuevo", visto: false }]);
  };
  let listadoEstudiantes = [
    { nombre: "Aleja", activo: true },
    { nombre: "Paola", activo: true },
    { nombre: "Pepe", activo: false },
    { nombre: "Ale", activo: true },
    { nombre: "David", activo: false },
    { nombre: "Juan", activo: false },
    { nombre: "Luis", activo: true },
    { nombre: "Paco", activo: false },
    { nombre: "Hugo", activo: false },
    { nombre: "Robert", activo: true },
    { nombre: "Bobby", activo: false },
    { nombre: "Clara", activo: true },
    { nombre: "Sol", activo: false },
    { nombre: "Betty", activo: true },
    { nombre: "Luz", activo: true },
    { nombre: "Ana", activo: false },
  ];

  const [arreglo, setArreglo] = useState(listadoEstudiantes);
  console.log(arreglo);
  return (
    <>
      <h1>Listado de Personas</h1>
      <AgregarEstudiante agregarEstudiante={setArreglo}></AgregarEstudiante>
      <ol>
        {arreglo.map((estudiante) => (
          <Items
            key={estudiante.nombre}
            nombre={estudiante.nombre}
            activo={estudiante.activo}
          ></Items>
        ))}
      </ol>
    </>
  );
};
