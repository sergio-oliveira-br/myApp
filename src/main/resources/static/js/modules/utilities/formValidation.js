//src/main/resources/static/js/modules/utilities/formValidation.js

// Reference: https://getbootstrap.com/docs/5.0/forms/validation/

// Checking form submissions if there are invalid fields
function validateForm(form) {

    if (form instanceof HTMLFormElement && form.checkValidity()) {
        return true; // Form is valid
    } else {
        const firstInvalidElement = $(form).find(':invalid').first();
        if (firstInvalidElement) {
            firstInvalidElement.focus();
        }
        return false;
    }
}



// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
    'use strict';
    const forms = document.querySelectorAll('.needs-validation');

    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            // Aqui estamos usando validateForm passando o elemento 'form'
            if (!validateForm(form)) {
                event.preventDefault();
                event.stopPropagation();
            }

            form.classList.add('was-validated');
        }, false);
    });
})();


