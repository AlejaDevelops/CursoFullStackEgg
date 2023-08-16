var n1 = prompt("Ingresa un número");
var n2 = prompt("Ingresa otro número");
var resta = n1 - n2;

if (resta > 0) {
  console.log("La resta es los números ingresados es mayor que cero");
  if (resta % 2 == 0) {
    console.log("El resultado de la resta es par");
  } else {
    console.log("El resultado de la resta es impar");
  }
} else {
  console.log("La resta de los números ingresados es menor o igual que cero");
}
