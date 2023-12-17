document.addEventListener('DOMContentLoaded', function () {
    const passwordInput = document.getElementById('passwordInput');
    const togglePassword = document.getElementById('togglePassword');

    togglePassword.addEventListener('click', function () {
        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);

        // Toggle the Font Awesome icon class
        if (type === 'password') {
              this.classList.remove('fa-eye-slash');
              this.classList.add('fa-eye');
        } else {
              this.classList.remove('fa-eye');
              this.classList.add('fa-eye-slash');

        }
    });
});
