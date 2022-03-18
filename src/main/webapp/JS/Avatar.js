/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
let file__avatar;
document.addEventListener("DOMContentLoaded", asignarEventos);

function asignarEventos() {
    file__avatar = document.getElementById("file__avatar");
    file__avatar.onchange = (function () {
        readURL(this);
    });
}

function readURL(input) {
    let regexFormatoImg = /\.(jpg|png)$/i;
    if (input.files && input.files[0]) {
        let dimensionesImagen = input.files[0].size;
        if (dimensionesImagen > 102400) {
            file__avatar.value = "";
            //marco error=>comunico a usuario error
        } else if (!regexFormatoImg.test(input.files[0].name)) {
            file__avatar.value = "";
        } else {
            let reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById("avatar__img").setAttribute("src", e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }

    }
}