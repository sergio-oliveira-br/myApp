//src/main/resources/static/js/modules/utilities/formSubmission.js

function submitForm(formId, url, formDataFunction, successCallback) {

    $(document).ready(function() {
        $(formId).on('submit', function(event) {
            event.preventDefault();

            // Obtenha o elemento do formulário
            const formElement = this; // 'this' refere-se ao formulário que disparou o evento
            let formData = formDataFunction();

            if(validateForm (formElement)) {
                ajaxRequestTypePost(url, formData, successCallback);
                cleanFormAfterSubmission(formElement);
            }
        });
    });
}

function cleanFormAfterSubmission(formElement) {
    formElement.reset();
    formElement.classList.remove('was-validated');
}
