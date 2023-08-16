let n;
let nMayor = 0;
let nMenor = 0;
let contador = 0;
let suma = 0;
do {
  n = parseInt(prompt("Ingresa un número (0 para salir)"));
  if (n === 0) {
    break;
  }
  contador++;
  suma = suma + n;

  contador === 1 
    ? ((nMayor = n), (nMenor = n))  : n > nMayor ? (nMayor = n) : n < nMenor ? (nMenor = n) : null;
  
} while (n != 0);

let promedio = contador === 0 ? 0 : suma / contador;

alert(`El numero mayor es: ${nMayor}
El numero menor es: ${nMenor}
El promedio de los numeros ingresados es: ${promedio}`);

// contador === 1: Primera Vuelta, se inicializan las variables nMayor y nMenor con el primer número ingresao y empezar las comparaciones
