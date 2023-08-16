let num = parseInt(prompt("Ingresa un número"));

if (num === 0) {
  alert("El número ingresado no es par ni impar");
} else {
  let resto = num % 2;
  if ((resto == 0)) {
    alert("El número ingresado es par");
  } else {
    alert("El numero ingresado es impar");
  }
}
