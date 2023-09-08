import { Hijo } from "./Hijo";

export const Body = () => {
  const titulo = "HOLA!";
  const subtitulo = "Soy el body";

  return (
    <>
      <h1>{titulo}</h1>
      <h2>{subtitulo}</h2>
      <Hijo nombre="Aleja"></Hijo>
      <Hijo nombre="Juan"></Hijo>
    </>
  );
};
