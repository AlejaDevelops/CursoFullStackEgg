let n = parseFloat(prompt("Ingresa un número a validar"));

n === 0
  ? alert("El numero ingresado no es par ni impar")
  : n % 2 === 0
  ? alert("El número ingresado en par")
  : alert("El número ingresado en impar");
