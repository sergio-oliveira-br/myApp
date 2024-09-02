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

//Method to send data from forms via AJAX
//src/main/resources/static/js/modules/utilities/formSubmission.js

/**
 Page: Customers, Rent, Sales, Product and Expenses
 Item: Form
 Method: Send the customer data by using AJAX
 */
function formSubmission(formId, url, formDataFunction, successCallback)
{
    $(document).ready(function()
    {
        //Get the form ID that contain the all data. Remember: FormID is ID from the form on HTML
        $(formId).on('submit', function(event)
        {
            //Prevents the default behavior of the browser, which would reload the page and send the form data synchronously
            event.preventDefault();

            //Get the form data
            let formData = formDataFunction();

            $.ajax({
                url: url,
                data: JSON.stringify(formData),
                type: 'POST',
                contentType: 'application/json',
                success: function(response){
                    if(successCallback)
                    {
                        successCallback(response);
                    }
                },
                error: function(xhr, status, error) {
                    let errorMessage = 'Não foi possível salvar este formulário. Por favor, tente novamente. ' + error;

                    alert(errorMessage);
                    console.error(errorMessage);

                    if(xhr.status === 400){
                        //O erro 400, ou "Bad Request", indica que o servidor não conseguiu entender a solicitação enviada pelo cliente.
                        //Isso geralmente ocorre quando há algum problema com a formatação da requisição,
                        //como dados ausentes, inválidos ou com um formato inesperado.
                        alert('Erro 400: Verifique os dados preenchidos.');
                    }
                    else{
                        console.error("Erro: " + xhr.responseText);
                    }
                }
            });
        });
    });
}
