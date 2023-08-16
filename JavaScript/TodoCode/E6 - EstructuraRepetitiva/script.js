var contador = 0;

console.log("CICLO WHILE:");
while (contador < 10) {
  console.log("Estoy en la vuelta N° " + contador);
  contador++;
}

console.log("CICLO FOR:");
for (let i = 0; i < 10; i++) {
  console.log("Vuelta N° " + i);
}

console.log("CICLO DO WHILE");
contador = 0;
do {
  console.log("Vuelta N° " + contador);
  contador++;
} while (contador < 10);
