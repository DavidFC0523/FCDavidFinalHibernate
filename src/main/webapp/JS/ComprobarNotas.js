document.addEventListener('DOMContentLoaded', function () {
    let inputs = document.getElementById("notascontenedor");
    inputs.addEventListener("input", CambiarNota);
    console.log(inputs)



});



function CambiarNota(e) {

    if (e.target.value >= 0 && e.target.value <= 10 && e.target.value != "") {
        console.log(e.target.getAttribute("idnota"))


        let url = "././ControladorAjax";
        let formData = new FormData();
        formData.append("Accion", "CambiarNota");
        formData.append("idNota", e.target.getAttribute("idnota"));
        formData.append("nota", e.target.value);
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
                    console.log("nota Cambiaada correctamente");
                })
                .catch(function (err) {
                    console.log(err);
                });


    } else {
        e.target.value = 1;
    }

}


 