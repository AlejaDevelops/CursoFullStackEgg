let palabraMasLarga = (frase) => {
  const palabras = frase.split(" ");
  let palabraMasLarga = "";

  for (const aux of palabras) {
    if (aux.length > palabraMasLarga.length) {
      palabraMasLarga = aux;
    }
  }

  return palabraMasLarga;
};

let frase = prompt("Escribe una frase ");
alert("La palabra más larga es: " + palabraMasLarga(frase));
