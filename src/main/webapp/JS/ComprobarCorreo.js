document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("Email").addEventListener('input', GestionEmail);
});

let EmailCorrecto = 0;
function GestionEmail() {
    //Funcion para Gestionar el Email
    let Email = document.getElementById("Email");
    let exp = /\S+@\S+\.\S+/;
    let span = document.getElementById("SpanEmail");
    let response;
    
    //Si el Email cumple con la expresion regular
    if (exp.test(Email.value)) {
        Email.style.backgroundColor = "green";
        span.innerHTML = "";
        let url = "././ControladorAjax";
    //Creamos un Formulario
    let formData = new FormData();
    formData.append("Accion", "comprobarEmail");
    formData.append("Email", Email.value);
    //Lanzamos el AJAX
    var request = new Request(url, {
        method: 'POST',
        body: formData
    });
    fetch(request)
            .then(function (response) {
                if (response.ok) {
                    return response.json()
                } else {
                    throw "Error en la llamada Ajax";
                }
            })
            .then(function (texto) {
               GestionAjaxEmail(texto);
            })
            .catch(function (err) {
                console.log(err);
            });
    
    } else {
        //Si no cumple con la expresion regular entra por aqui
        Email.style.backgroundColor = "red";
        EmailCorrecto = 0;
        span.innerHTML = "El formato no es correcto";
    }
}

function GestionAjaxEmail(data) {
    //Gestionamos la respuesta del AJAX de Email
    let Email = document.getElementById("Email");
    let span = document.getElementById("SpanEmail");
    if (data.length == 1) {
        //Si el Email esta en uso entra por aqui
        Email.style.backgroundColor = "red";
        span.innerHTML = "El correo esta en uso";
        EmailCorrecto = 0;
        Comprobar();
    } else {
        //Si el Email no esta en USO entra por aqui
        span.innerHTML = "";
        Email.style.backgroundColor = "green";
        EmailCorrecto = 1;
        Comprobar();
    }
}

function Comprobar(){
    
    setTimeout(() => {

    
    
    if( EmailCorrecto == 0){
        document.querySelector("#registrar").setAttribute("disabled",true);
    }else{
        document.querySelector("#registrar").removeAttribute("disabled");
    }
        }, 100);

}