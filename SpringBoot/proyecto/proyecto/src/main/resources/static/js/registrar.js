// Call the dataTables jQuery plugin
$(document).ready(function() {

    //on ready
});

async function registrarUsuario(){

    let datos={};
    datos.nombre= document.getElementById('txtNombre').value;
    datos.apellido= document.getElementById('txtApellido').value;
    datos.password= document.getElementById('txtPassword').value;
    datos.email= document.getElementById('txtEmail').value; //ESTA PENDIENTE QUE EXISTA UNA VALIDACION DEL CORREO EN LA BD

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password){
        alert('Las contraseñas no coinciden');
        return;
    }

      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });

      alert('Registro exitoso!');
      location.reload();

}


