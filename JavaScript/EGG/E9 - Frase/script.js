let frase = prompt("Escribe una frase");
let frase2 = "";

for (let index = 0; index < frase.length; index++) {
  frase2 = frase2 + frase.substring(index, index + 1) + " ";
}

alert("Tu frase espaciada es: " + frase2);
