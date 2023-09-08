import { useState } from "react";

export const AgregarEstudiante = ({ agregarEstudiante }) => {
  const [inputValue, setInputValue] = useState("");
  const onInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const onSubmit = (event) => {
    const envio = {
      nombre: inputValue,
      activo: false,
    };
    event.preventDefault();
    agregarEstudiante((estudiantes) => [...estudiantes, envio]);
  };

  return (
    <>
      <form onSubmit={(event) => onSubmit(event)}>
        <input
          type="text"
          placeholder="Ingresa un nuevo estudiante"
          value={inputValue}
          onChange={onInputChange}
        />
      </form>
    </>
  );
};
