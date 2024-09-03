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
//src/main/resources/static/js/modules/sales/salesPageInit.js

/**
 * Method: When the page is loaded or reloaded, the methods here will be updated
 */
$(document).ready(function () {
    console.log('Sale Page initialized');

    //load customers created in the form as a list
    loadCustomersListForm('#saleFirstName'); //original form
    loadCustomersListForm('#editSaleFirstName'); //modal edit

    // Load the items classified as "Vendas" in productType
    loadProductListByProductType('Venda');

    // Render the sales table
    loadSalesTable();

    //(Modal) Submit the data updated by using the method PUT
    $('#editSaleForm').on('submit', function(e) {
        e.preventDefault();
        $('#editModal').modal('hide');
        saleFormSubmissionModal(); //Used to update an existing resource on the server.
    });

    //(Modal)Update total price when price or quantity change
    $('#editSaleQtyItem, #editSaleItem').on('change', function() {
        console.log('Sale: Price or Quantity input changed');
        updateTotalPriceSaleModal();
    });
});