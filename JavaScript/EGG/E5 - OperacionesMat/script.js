let n1 = parseInt(prompt("Ingresa un número"));
let n2 = parseInt(prompt("Ingresa otro número"));
let key = prompt(`Elige una operación del siguiente menú:
S - Suma
R - Resta
M - Multiplicación
D - División`);

switch (key) {
  case "S":
    alert(`${n1}+${n2} = ${n1 + n2}`);
    break;
  case "R":
    alert(`${n1}-${n2} = ${n1 - n2}`);
    break;
  case "M":
    alert(`${n1} x ${n2} = ${n1 * n2}`);
    break;
  case "D":
    alert(`${n1} / ${n2} = ${n1 / n2}`);
    break;
  default:
    alert("Opción no válida");
    break;
}
