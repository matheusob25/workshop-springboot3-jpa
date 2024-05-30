const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const xname = document.querySelector(".name");
const xemail = document.querySelector(".email");
const xphone = document.querySelector(".phone");
const xpassword = document.querySelector(".password");

function cadastrar(){
    fetch("http://localhost:8080/users",
    {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
             },
            method: "POST",
            body: JSON.stringify({
                name: xname.value,
                email: xemail.value,
                phone: xphone.value,
                password: xpassword.value
            })
    })
    .then(function(response){ console.log(response) })
    .catch(function(response) { console.log(response) })
}

function limpar(){
    xname.value = "";
    xemail.value = "";
    xphone.value = "";
    xpassword.value = "";
}

formulario.addEventListener("submit", function(event){
    event.preventDefault();
    cadastrar();
    limpar();
});