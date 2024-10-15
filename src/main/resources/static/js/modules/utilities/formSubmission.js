//src/main/resources/static/js/modules/utilities/formSubmission.js

function formSubmission(formId, url, formDataFunction, successCallback) {

    $(document).ready(function() {
        $(formId).on('submit', function(event) {
            event.preventDefault();

            // Obtenha o elemento do formulário
            const formElement = this; // 'this' refere-se ao formulário que disparou o evento
            let formData = formDataFunction();

            if(validateForm (formElement)) {
                ajaxRequestTypePost(url, formData, successCallback);
            }
        });
    });
}
