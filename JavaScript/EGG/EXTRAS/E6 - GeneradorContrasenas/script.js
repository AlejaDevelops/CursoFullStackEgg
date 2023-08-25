/* SOLUCION 1

function generadorContrasena() {
  let numeros = (Math.random() * 899 + 100).toFixed(0);
  let letraMayuscula = String.fromCharCode(Math.random() * 26 + 65);
  let letraMinuscula = String.fromCharCode(Math.random() * 25 + 97);
  let especiales = String.fromCharCode(Math.random() * 4 + 33);

  return numeros + letraMayuscula + letraMinuscula + especiales;
}
alert("Contraseña generada: " + generadorContrasena());
*/

/* SOLUCION 2

function generadorNum() {
  return (Math.random() * 89 + 10).toFixed(0);
}

function generadorMayus() {
  return String.fromCharCode(Math.random() * 26 + 65);
}

function generadorMinus() {
  return String.fromCharCode(Math.random() * 25 + 97);
}

function generadorEspeciales() {
  return String.fromCharCode(Math.random() * 4 + 33);
}

function generadorContrasena() {
  let contrasena =
    generadorNum() +
    generadorMayus() +
    generadorMinus() +
    generadorEspeciales() +
    generadorMinus() +
    generadorNum() +
    generadorEspeciales() +
    generadorMayus() +
    generadorNum();

  return contrasena;
}
alert("Contraseña generada: " + generadorContrasena());

*/

function generadorContrasena() {
  let letraMayuscula = String.fromCharCode(Math.random() * 26 + 65);
  let numeros = (Math.random() * 899 + 100).toFixed(0);
  let letraMinuscula = String.fromCharCode(Math.random() * 25 + 97);
  let especiales = String.fromCharCode(Math.random() * 4 + 33);

  return numeros + letraMayuscula + letraMinuscula + especiales;
}

alert("Contraseña generada: " + generadorContrasena() + generadorContrasena());
