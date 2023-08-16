let nLimite = parseInt(prompt("Ingresa el numero límite"));

let suma = 0;
do {
  let n = parseInt(prompt("Ingresa un número"));
  suma = suma + n; //suma+ =n
} while (suma <= nLimite);

prompt(`Los números ingresados han sobrepasado el límite. 
Suma = ${suma}`);
