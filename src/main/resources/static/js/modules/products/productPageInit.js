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

//This file centralizes all boot calls in one place, making it easy to understand and maintain.
//src/main/resources/static/js/modules/products/productPageInit.js

$(document).ready(function () {
    //Load the table
    loadProductTable();

    //(Modal) The script will load the available/saved items in the Product Form Modal
    updateLoadProductForm(); //!IMPORTANTE EU NAO TENHO CERTEZA SE ELE ESTA ALOCADO NO LUGAR CORRETO

    //(Modal) Send the data by clicking on submit button
    $('#editModal').on('submit', function(e) {
        e.preventDefault();
    });
})