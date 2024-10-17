//src/main/resources/static/js/modules/utilities/ajaxUtils.js


function ajaxRequestTypeGet(url, successCallback) {
    $.ajax({
        url: url,
        type: "GET",  // HTTP request methods used to RETRIEVE data from the server

        success: successCallback,

        error: function(xhr, status, error) {
            //build the object
            const ajaxError = {
                message: error, // Mensagem de erro genérica
                response: xhr,  // Inclui o objeto xhr para informações detalhadas
                status: status  // Status da resposta
            };
            //call the function from errorHandling.js file
            errorHandler(ajaxError);
        }
    });
}

/**
 * Method: ajaxRequest(url, successCallback)
 * Info: Generic function to perform an AJAX request and handle success and error responses
 */
function ajaxRequestTypePut(url, formData, successCallback) {
    $.ajax({
        url: url,
        type: "PUT", //Used to update an existing resource on the server.
        contentType: 'application/json',
        data: JSON.stringify(formData),

        success: function(response){
            if(successCallback) {
                successCallback(response);
                let currentDate = new Date();
                console.log(formData, currentDate);
            }
        },

        error: function(xhr, status, error) {
            errorHandler(error);
        }
    });
}


function ajaxRequestTypePost(url, formData, successCallback) {
    $.ajax({
        url: url,
        type: "POST", //Used to submit new data to a server.
        contentType: 'application/json',
        data: JSON.stringify(formData),

        success: function(response){
            if(successCallback) {
                successCallback(response);
                let currentDate = new Date();
                console.log(formData, currentDate);
            }
        },

        error: function(error) {
            errorHandler(error);
        }
    });
}