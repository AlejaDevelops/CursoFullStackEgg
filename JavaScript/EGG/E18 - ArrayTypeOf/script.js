var valores = [true, 5, false, "hola", "adios", 2];
var palabraMayor = " ";
var logico1 = null;
var logico2 = null;
var flag = true;
var flag2 = true;
var n1 = null;
var n2 = null;

valores.forEach((element) => {
  if (typeof element === "string") {
    element.length > palabraMayor.length
      ? (palabraMayor = element)
      : palabraMayor;
  }

  if (typeof element === "boolean") {
    if (logico1 === null && flag === true) {
      logico1 = element;
    }
    if (logico2 === null && flag === false) {
      logico2 = element;

      alert(
        `Operación lógica 1{ ${logico1} && ${logico2} = ${logico1 && logico2}}`
      );
      alert(
        `Operación lógica 2{ ${logico1} || ${logico2} = ${logico1 || logico2}}`
      );
    }
    flag = false;
    /*if (logico1 !== null && logico2 !== null) {
      //Caso en el que recorrió los 2 primeros booleanos y el array tenga más
      logico1 = null;
      logico2 = null;
    }*/
  }

  if (typeof element === "number") {
    if (n1 === null && flag2 === true) {
      n1 = element;
    }
    if (n2 === null && flag2 === false) {
      n2 = element;

      alert(`Suma{ ${n1} + ${n2} = ${n1 + n2}}`);
      alert(`Resta{ ${n1} - ${n2} = ${n1 - n2}}`);
      alert(`Multiplicación{ ${n1} * ${n2} = ${n1 * n2}}`);
      alert(`División{ ${n1} / ${n2} = ${n1 / n2}}`);
      alert(`Potenciación{ ${n1} exp ${n2} = ${Math.pow(n1, n2)}}`);
    }
    flag2 = false;
  }
});
alert("La palabra más larga es: " + palabraMayor);
