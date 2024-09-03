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

//This file contain error handling functions.
//src/main/resources/static/js/modules/utilities/errorHandling.js

/**
 * Function: handleError(errorMessage)
 * Info: Handle errors by showing the error message to the user
 */
function errorHandler(error) {
    //Treat the error generically
    alert('Oops! Infelizmente ocorreu um erro!' + error);

    //Specific treatment for different types of errors
    if(error instanceof TypeError){
        //Um TypeError é lançado quando você tenta realizar uma operação em um valor que não é do tipo esperado.
        console.error('Erro de tipo: ', error.message);
        alert('Houve um erro inesperado no tipo de dado. Por favor, tente novamente.');
    }

    if(error instanceof Range){
        //Um RangeError ocorre quando um valor numérico está fora do intervalo válido para uma determinada operação.
        console.error('Erro no intervalo: ', error.message);
        alert('O valor inserido está fora do intervalo permitido.')
    }

    else if (typeof error === 'string'){
        alert(error);
    }

    else if (error && error.response && error.response.status){
        switch (error.response.status){
            case 400:
                alert('400: Solicitação inválida. Verifique os dados enviados.');
                break;

            case 404:
                alert('404: Página não encontrada.');
                break;

            case 500:
                alert('Erro 500: O servidor encontrou um erro interno e não pôde completar sua solicitação.');
                break;

            default:
                alert('Error status: ' + error.response.status +
                    '\nOcorreu um erro inesperado. Por favor, tente novamente.');
        }
    }
}


/**
 * Lembrete: INSTANCEOF
 *
 * O operador instanceof é uma ferramenta poderosa
 * para verificar tipos de objetos em JavaScript.
 * Ele permite que você trate diferentes tipos de erros de forma específica,
 * tornando seu código mais robusto e fácil de manter.
 *
 * Retorno: True ou False
 *
 * Beneficio: Tratamento personalizado
 * Permite tratar diferentes tipos de erros de forma específica,
 * oferecendo mensagens mais precisas ao usuário.
 */
