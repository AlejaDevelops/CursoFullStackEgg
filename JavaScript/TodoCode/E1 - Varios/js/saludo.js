var nombre = "Alejandra";
var apellido = "Orjuela";
var edad = 37;
var presenteONo = false;
var estatura = 1.6;

console.log("Nombre: " + nombre + " " + typeof nombre);
console.log("Apellido: " + apellido + " " + typeof apellido);
console.log("Edad: " + edad + " " + typeof edad);
console.log("Presente: " + presenteONo + " " + typeof presenteONo);
console.log("Estatura: " + estatura + " " + typeof estatura);

if (true) {
  var nombre = "Juan";
}
console.log(nombre);

/*if (true) {
  let nombre = "Juan"; //Esta variable no puede se usada de esta forma... debe ser declarado su tipo antes de entrar al bloque if
}
console.log(nombre);*/

const email = "orjuela.alejandrap@gmail.com";
console.log(email);
/*email = "sssss"; //manifiesta este error: saludo.js:25 Uncaught TypeError: Assignment to constant variable. porque la variable tiene un valor asignado en la línea 24 y ya no se puede sobreescribir
//alert("Hola mundo con Javascript " + nombre + " " + apellido);*/

var suma = 35 + 7;
console.log(suma);

var resto = 30 % 5;
console.log(resto);

console.log(25 > 30);
console.log(25 < 30);
var num = 5;
console.log(4==num);

