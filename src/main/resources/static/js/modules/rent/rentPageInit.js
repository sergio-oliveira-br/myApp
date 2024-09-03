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
//src/main/resources/static/js/modules/rent/rentPageInit.js

$(document).ready(function () {
    console.log('Rent Page initialized');

    //Load Rent the table on Rent page
    loadRentTable();

    //load customers created in the form as a list
    loadCustomersListForm('#rentFirstName'); //original form
    loadCustomersListForm('#editRentFirstName'); //modal edit

    //load product created in the form as a list
    loadProductListByProductType('Aluguel');

    //(Modal) Submit the data updated by using the method PUT
    $('#editRentForm').on('submit', function(e) {
        e.preventDefault();
        $('#displayRentModal').modal('hide');
        rentFormSubmissionModal(); //Used to update an existing resource on the server.
    });

    //(Modal)Update the rent status, if is "Finished", the item stock will return to total available
    $('#editRentStatus').on('change', function() {
        alert('O status do aluguel foi alterado.' +
            '\nCertifique-se de que você escolheu a opção correta!');

        console.log('Rent Status Changed');
    });

    //(Modal)Update total price when price or quantity change
    $('#editRentPrice, #editRentQtyItem, #editRentStarts, #editRentEnds').on('change', function() {
        console.log('Price or Quantity input changed');
        updateTotalPrice();
    });
});