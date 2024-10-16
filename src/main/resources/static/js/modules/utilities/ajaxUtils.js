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

//This file contain generic AJAX request functions.
//src/main/resources/static/js/modules/utilities/ajaxUtils.js

/**
 * Method: ajaxRequest(url, successCallback)
 * Info: Generic function to perform an AJAX request and handle success and error responses
 */
function ajaxRequest(url, successCallback) {
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
function ajaxRequestTypePut(url, successCallback) {
    $.ajax({
        url: url,
        type: "PUT", //Used to update an existing resource on the server.
        contentType: 'application/json',
        success: successCallback,

        error: function(xhr, status, error) {
            //call the function from errorHandling.js file
            errorHandler(error);
        }
    });
}

/**
 * Method: ajaxRequest(url, successCallback)
 * Info: Generic function to perform an AJAX request and handle success and error responses
 */
function ajaxRequestTypePost(url, successCallback) {
    $.ajax({
        url: url,
        type: "POST", //Used to submit new data to a server.
        contentType: 'application/json',
        success: successCallback,

        error: function(xhr, status, error) {
            //call the function from errorHandling.js file
            errorHandler(error);
        }
    });
}


/** THIS WILL BE THE FUTERE
 * function ajaxRequest(url, method, data, successCallback, failureCallback) {
 *     $.ajax({
 *         url: url,                   //O endereço URL para a requisição.
 *         type: method,               //O método HTTP a ser utilizado (GET, POST, PUT, DELETE, etc.).
 *         data: data,                 //Os dados a serem enviados no corpo da requisição (opcional).
 *         success: successCallback,   //A função a ser chamada em caso de sucesso.
 *         error: failureCallback      //A função a ser chamada em caso de erro.
 *     });
 * }
 */

