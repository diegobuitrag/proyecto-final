// Registro de Usuario
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const gender = document.getElementById('gender').value;

    const user = {
        firstName,
        lastName,
        email,
        password,
        gender
    };

    // Guardar en localStorage
    localStorage.setItem('user', JSON.stringify(user));

    alert('Usuario registrado correctamente!');
    window.location.href = 'login.html'; // Redirigir al login
});

// Login de Usuario
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const user = JSON.parse(localStorage.getItem('user'));

    if (user && user.email === email && user.password === password) {
        localStorage.setItem('loggedIn', true);
        window.location.href = 'index.html'; // Redirigir a la página de bienvenida
    } else {
        alert('Correo o contraseña incorrectos');
    }
});

// Mostrar el nombre del usuario en el menú si está logueado
window.onload = function() {
    const loggedIn = localStorage.getItem('loggedIn');
    const userMenu = document.getElementById('user-menu');

    if (loggedIn) {
        const user = JSON.parse(localStorage.getItem('user'));
        userMenu.innerHTML = `Bienvenido, ${user.firstName} <a href="#" onclick="logout()">Cerrar Sesión</a>`;
    }
};

function logout() {
    localStorage.removeItem('loggedIn');
    window.location.href = 'login.html'; // Redirigir al login
}
