crearPersona();

function crearPersona() {
  let nombre = prompt("Ingresa tu nombre");
  let edad = prompt("Ingresa tu edad");
  let sexo = validacionSexo();
  let peso = parseFloat(prompt("Ingresa tu peso"));
  let altura = parseFloat(prompt("Ingresa tu altura"));

  const persona = {
    nombre: nombre,
    edad: edad,
    sexo: sexo,
    peso: peso,
    altura: altura,
  };
  const propiedadesPersona = Object.values(persona);

  console.log(propiedadesPersona);
  alert("Propiedades de la persona: " + propiedadesPersona.join(", "));
  return persona;
}

function validacionSexo() {
  let sexo;
  do {
    sexo = prompt("Ingresa tu sexo hombre(H), mujer(M), Otro(O)").toUpperCase();
    if (sexo != "H" && sexo != "M" && sexo != "O") {
      alert("Opción inválida, intenta nuevamente");
    }
  } while (sexo != "H" && sexo != "M" && sexo != "O");
  return sexo;
}
