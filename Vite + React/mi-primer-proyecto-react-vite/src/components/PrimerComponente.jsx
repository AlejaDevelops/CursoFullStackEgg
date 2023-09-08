import PropTypes from "prop-types";

const Button = () => {
  return <button>Soy un botón</button>;
};

export const PrimerComponente = ({ titulo = "Hola", subtitulo }) => {
  console.log(titulo);
  console.log(subtitulo);
  return (
    <div>
      <h1>{titulo}</h1>
      <h2>{subtitulo + 1}</h2>
      <Button></Button>
    </div>
  );
};

PrimerComponente.PropTypes = {
  titulo: PropTypes.string.isRequired,
  subtitulo: PropTypes.number.isRequired,
};

PrimerComponente.default = {
  titulo: "Holis!",
};
