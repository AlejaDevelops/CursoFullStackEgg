function getFormValores() {
  let nombre = document.querySelector('input[name="nombre"]').value;
  let apellido = document.querySelector('input[name="apellido"]').value;

  alert(`Su nombre es: ${nombre} ${apellido}`);
  return false;
}
