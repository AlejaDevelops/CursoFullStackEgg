/*const boton = document.getElementsByClassName("boton");
boton[0].addEventListener("click", function () {
  alert("¡BIENVENIDO!");
});*/

const boton = document.querySelectorAll(".boton");

boton.forEach((element) => {
  element.addEventListener("click", function () {
    alert("¡BIENVENIDO!");
  });
});
