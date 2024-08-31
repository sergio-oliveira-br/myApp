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
            console.error(error);
            let errorMessage = xhr.responseText;
            alert("From the Server: " + errorMessage);
        }
    });
}


