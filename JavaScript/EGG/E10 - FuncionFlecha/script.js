let palabraAlReves = (palabra) => {
  return palabra.split("").reverse().join("");
};

let palabra = prompt("Escriba una palabra");

alert("Su palabra al reves es: " + palabraAlReves(palabra));
