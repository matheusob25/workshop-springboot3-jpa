document.getElementById("cadastro-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const xname = document.querySelector(".name");
    const xemail = document.querySelector(".email");
    const xphone = document.querySelector(".phone");
    const xpassword = document.querySelector(".password");

    if (!xemail || !xpassword || !xname || !xphone || !xpassword) {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    if (xpassword.length < 6) {
        alert('A senha deve ter pelo menos 6 caracteres.');
        return;
    }

    // Se todas as validações passarem, enviar os dados
    cadastrar(xname, xemail, xphone, xpassword);
    document.getElementById("cadastro-form").reset();
});

function cadastrar(name, email, phone, password) {
   

    fetch("http://localhost:8080/users", {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            name: name.value,
            email: email.value,
            phone: phone.value,
            password: password.value
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



document.addEventListener("DOMContentLoaded", function () { 
    const loginForm = document.querySelector("#login-form");
   
   

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