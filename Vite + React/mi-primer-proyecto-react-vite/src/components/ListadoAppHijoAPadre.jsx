import React, { useState } from "react";
import { AgregarEstudianteHijoAPadre } from "./AgregarEstudianteHijoAPadre";

const Items = ({ nombre, activo }) => {
  return (
    <li className="rojito">
      {nombre}
      {activo ? "😃" : "🥵"}
    </li>
  );
};

export const ListadoAppHijoAPadre = () => {
  const addTask = () => {
    setArreglo([...arreglo, { nombre: "nuevo", visto: false }]);
  };
  let listadoEstudiantes = [
    { id: 1, nombre: "Aleja", activo: true },
    { id: 2, nombre: "Paola", activo: true },
    { id: 3, nombre: "Pepe", activo: false },
    { id: 4, nombre: "Ale", activo: true },
    { id: 5, nombre: "David", activo: false },
    { id: 6, nombre: "Juan", activo: false },
    { id: 7, nombre: "Luis", activo: true },
    { id: 8, nombre: "Paco", activo: false },
    { id: 9, nombre: "Hugo", activo: false },
    { id: 10, nombre: "Robert", activo: true },
    { id: 11, nombre: "Bobby", activo: false },
    { id: 12, nombre: "Clara", activo: true },
    { id: 13, nombre: "Sol", activo: false },
    { id: 14, nombre: "Betty", activo: true },
    { id: 15, nombre: "Luz", activo: true },
    { id: 16, nombre: "Ana", activo: false },
  ];

  const [arreglo, setArreglo] = useState(listadoEstudiantes);

  const onAgregarEstudianteHijoAPadre = (val) => {
    let valor = val.trim(); //Elimina los espacios vacíos de inicio y del final del string, aunque dentro de un <li/> se eliminan
    if (val < 1) return; //Valida que val no llegue vacío y se guarden objetos sin nombre
    const envio = {
      id: arreglo.length + 1, //Valida que no se repita el id y lo genere automáticamente
      nombre: val,
      visto: false,
    };
    setArreglo([...arreglo, envio]);
  };

  return (
    <>
      <h1>Listado de Personas</h1>
      <AgregarEstudianteHijoAPadre
        agregarEstudianteHijoAPadre={onAgregarEstudianteHijoAPadre}
      ></AgregarEstudianteHijoAPadre>
      <ol>
        {arreglo.map((estudiante) => (
          <Items
            key={estudiante.id}
            nombre={estudiante.nombre}
            activo={estudiante.activo}
          ></Items>
        ))}
      </ol>
    </>
  );
};
