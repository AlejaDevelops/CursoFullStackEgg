let averiguarTipoDato = (dato) => {
  return typeof dato;
};

let input = prompt("Ingresa un dato");
let dato;

if (!isNaN(input)) {
  dato = parseFloat(input); //Convierto el dato en un número
} else if (input.toLowerCase() === "true" || input.toLowerCase() === "false") {
  dato = input.toLowerCase() === "true";
} else {
  dato = input;
}

alert(
  "El tipo de dato es: " +
    averiguarTipoDato(dato) +
    " el dato ingresado es: " +
    dato
);
