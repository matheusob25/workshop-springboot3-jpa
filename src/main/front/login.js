const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const xemail = document.querySelector(".email");
const xpassword = document.querySelector(".password");

function login() {
    fetch("http://localhost:8080/users/login", {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            email: xemail.value,
            password: xpassword.value
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Login failed');
            }
        })
        .then(user => {
            console.log('Logged in user:', user);
            // Redirecionar ou armazenar informações do usuário conforme necessário
            window.location.href = 'landingpage.html';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Login failed: ' + error.message);
        });
}

formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    login();
});

