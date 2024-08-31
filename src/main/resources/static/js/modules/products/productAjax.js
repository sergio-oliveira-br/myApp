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

//This file will contain generic functions for performing AJAX requests, used by the other modules.
//src/main/resources/static/js/modules/products/productAjax.js

/**
 * Method: Generic function to perform an AJAX request and handle success and error responses
 * Type: GET
 */
function ajaxRequest(url, successCallback) {
    $.ajax({
        url: url,
        type: "GET",

        success: successCallback,

        error: function(xhr, status, error) {
            console.error(error);
            let errorMessage = xhr.responseText;
            alert("From the Server: " + errorMessage);
        }
    });
}
