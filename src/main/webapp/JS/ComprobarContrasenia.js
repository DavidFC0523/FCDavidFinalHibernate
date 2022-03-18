document.addEventListener('DOMContentLoaded', function () {
  
    document.getElementById("password1").addEventListener('input', ComprobarPassword);
    document.getElementById("password2").addEventListener('input', ComprobarPassword);
    document.getElementById("password1").addEventListener('input', activarBoton);
    document.getElementById("password2").addEventListener('input', activarBoton);

});
let PasswordCorrecto = 0;

function ComprobarPassword() {
    //Comprobacion de la Password si son iguales
    let password1 = document.getElementById("password1");
    let password2 = document.getElementById("password2");
    let span = document.getElementById("SpanPassword");

    if (password1.value == password2.value && password1.value.length != 0) {
        //Si las Contrase�as son Iguales
        password1.style.backgroundColor = "green";
        password2.style.backgroundColor = "green";
       
        PasswordCorrecto = 1;
    } else {
        //Si las Contrase�as no son Iguales
        password1.style.backgroundColor = "red";
        password2.style.backgroundColor = "red";
        PasswordCorrecto = 0;
    }
}


function activarBoton() {
   
   let button = document.getElementById("botonActualizar");
        if (PasswordCorrecto == 1) {
            //Si si cumple las condiciones
            button.disabled = false;

        } else {
            //Si no cumple las condiciones
            button.disabled = true;
        }
   
}