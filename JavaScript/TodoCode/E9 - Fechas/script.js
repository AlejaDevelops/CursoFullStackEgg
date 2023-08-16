//Fecha del PC
var fecha = new Date();
console.log("1. La fecha de hoy es " + fecha);

//Fecha personalizada - No se indica la hora
var fecha2 = new Date(1986, 1, 20); //Se debe anotar un numero de mes menor al deseado
console.log("2. la Fecha de mi cumpleaños es " + fecha2);

//Fecha a partir de un string
var fecha3 = new Date("02/20/1986"); //Se debe poner MES DIA AÑO
console.log("3. la Fecha de mi cumpleaños es " + fecha3);

//Partes de una fecha
var dia = fecha3.getDate();
var mes = fecha3.getMonth();
var anio = fecha3.getFullYear();
console.log(
  "4. Fecha de mi cumpleaños. Día: " +
    fecha3.getDate() +
    " Mes: " +
    (fecha3.getMonth() + 1) +
    " Año: " +
    fecha3.getFullYear()
);

alert(
  "Fecha de mi cumpleaños. Día: " + dia + " Mes: " + (mes + 1) + " Año: " + anio
);

