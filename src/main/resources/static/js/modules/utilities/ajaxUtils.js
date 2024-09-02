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
            try{
                let response = JSON.parse(xhr.responseText);
                alert('Opps! Ocorreu um erro. ' + response.message);

            }catch(parseError){
                console.log('Análise do erro: ', parseError);

                if (xhr.status === 500){
                    // Problema no lado do servidor (erro de programação, configuração, etc.)
                    alert('Erro 500: O servidor encontrou um erro interno e não pôde completar sua solicitação.');
                }
                else if(xhr.status === 404){
                    // Problema no lado do cliente (URL incorreta, recurso removido).
                    alert('Erro 404: Página não encontrada.')
                }
                else{
                    alert('Ocorreu um erro inesperado. Por favor, entre em contato com o suporte');
                }
            }
        }
    });
}


