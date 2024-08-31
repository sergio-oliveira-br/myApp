/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie, oliveira-sergio@outlook.com
 * Project Commencing May 2024 | Version: 1.0
 * Refactoring & New Features - Aug 2024 | Version: 2.0
 */

//This file contain code related to form validation using Bootstrap.
//src/main/resources/static/js/modules/utilities/formValidation.js


// Reference: https://getbootstrap.com/docs/5.0/forms/validation/
// Checking form submissions if there are invalid fields
(function () {
    var forms = document.querySelectorAll('.needs-validation');

    Array.prototype.slice.call(forms).forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
                console.log('Checking the form...');
            }
            form.classList.add('was-validated');
        }, false);
    });
})();
