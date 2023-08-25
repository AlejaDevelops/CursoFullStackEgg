let palabra = prompt("Ingresa una palabra");

let evaluarPalindromo = (palabra) =>
  palabra.split("").reverse().join("") === palabra
    ? alert("La palabra ingresada es Palíndromo")
    : alert("La palabra ingresada no es Palíndromo");

evaluarPalindromo(palabra);

/*function evaluarPalindromo(palabra) {
  let array2 = palabra.split("").reverse().join("");
  alert("Array 2 " + array2);

  if (array2 === palabra) {
    alert("La palabra ingresada es Palíndromo");
  } else {
    alert("La palabra ingresada no es Palíndromo");
  }
}*/
