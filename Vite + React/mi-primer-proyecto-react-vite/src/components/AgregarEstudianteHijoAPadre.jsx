import { useState } from "react";

export const AgregarEstudianteHijoAPadre = ({
  agregarEstudianteHijoAPadre,
}) => {
  const [inputValue, setInputValue] = useState("");
  const onInputChange = (event) => {
    setInputValue(event.target.value);
  };

  const onSubmit = (event) => {
    event.preventDefault();
    agregarEstudianteHijoAPadre(inputValue);
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
