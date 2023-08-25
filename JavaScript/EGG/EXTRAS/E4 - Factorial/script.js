let n = parseFloat(prompt("Ingresa un número"));

function calcularFactorial(n) {
  let factorial = 1;
  if (n !== 0) {
    for (let index = 1; index < n + 1; index++) {
      factorial = factorial * index;
    }
  }
  return factorial;
}

/*let factorial = (n) => (n === 0 ? 1 : factorial(n - 1) * n);
alert(factorial(parseInt(prompt("ingrese un número"))));*/

alert(`El factorial de ${n} es: ${calcularFactorial(n)}`);
