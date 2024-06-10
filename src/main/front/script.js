document.addEventListener("DOMContentLoaded", function () {
    const cadastroForm = document.querySelector("#cadastro-form");
    const loginForm = document.querySelector("#login-form");
   


    // Função para cadastrar
    function cadastrar() {
        const xname = cadastroForm.querySelector(".name");
        const xemail = cadastroForm.querySelector(".email");
        const xphone = cadastroForm.querySelector(".phone");
        const xpassword = cadastroForm.querySelector(".password");

        fetch("http://localhost:8080/users", {
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
            .then(function (response) {
                console.log(response);
                if (response.ok) {
                    alert('Cadastro realizado com sucesso!');
                } else {
                    alert('Erro no cadastro');
                }
            })
            .catch(function (error) {
                console.error('Error:', error);
                alert('Erro no cadastro');
            });
    }

    // Função para login
    function login() {
        const xemail = loginForm.querySelector(".email");
        const xpassword = loginForm.querySelector(".password");

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
                localStorage.setItem('userName', user.name);
                window.location.href = 'landingpage.html';
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Login failed: ' + error.message);
            });
    }

    

    // Event listener para o formulário de cadastro
    cadastroForm.addEventListener("submit", function (event) {
        event.preventDefault();
        cadastrar();
        cadastroForm.reset(); // Limpar o formulário após o envio
    });

    // Event listener para o formulário de login
    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();
        login();
        loginForm.reset(); // Limpar o formulário após o envio
    });
});


document.addEventListener('DOMContentLoaded', event => {
    const userName = localStorage.getItem('userName');
    const profileLink = document.getElementById('profile-link');
    if (userName) {
        profileLink.textContent = `Olá ${userName}`;
    }
});