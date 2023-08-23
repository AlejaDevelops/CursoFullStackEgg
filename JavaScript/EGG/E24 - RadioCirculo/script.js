//document.addEventListener("");

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("calculo");
  const resultadoElement = document.getElementById("resultado");

  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Evitar que el formulario se envíe de forma predeterminada, permite realizar validaciones antes

    const diametro = parseFloat(document.getElementById("diametro").value);
    const radio = diametro / 2;

      resultadoElement.textContent = `El radio del círculo es: ${radio.toFixed(2
    )}`;
  });
});
