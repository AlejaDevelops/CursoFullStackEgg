var n1 = parseInt(window.prompt("Ingresa un número "));
var n2 = parseInt(window.prompt("Ingresa otro número "));

if (n1 > n2) {
  alert("El número " + n1 + " es el mayor");
  console.log("El número " + n1 + " es el mayor");
} /*else {
  alert("El número " + n2 + " es el mayor");
  console.log("El número " + n2 + " es el mayor");
}*/

if (n2 > n1) {
  alert("El número " + n2 + " es mayor que " + n1);
  console.log("El número " + n2 + " es mayor que " + n1);
}
if (n2 == n1) {
  alert("Los números son iguales");
  console.log("Los números son iguales");
}

let fecha1 = prompt("Ingresa una fecha", "mm/dd/yyyy");
let fecha2 = new Date(fecha1);
let dia = fecha2.getDay();
let diaSemana;
switch (dia) {
  case 0:
    diaSemana = "domingo";
    break;
  case 1:
    diaSemana = "lunes";
    break;
  case 2:
    diaSemana = "martes";
    break;
  case 3:
    diaSemana = "miércoles";
    break;
  case 4:
    diaSemana = "jueves";
    break;
  case 5:
    diaSemana = "viernes";
    break;
  case 6:
    diaSemana = "sábado";
    break;

  default:
    diaSemana = "null";
    break;
}
alert("El día de la semana que le corresponde a esa fecha es " + diaSemana);
