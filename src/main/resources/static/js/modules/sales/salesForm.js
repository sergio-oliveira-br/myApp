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

//This file handles the sales form, including the calculation of the total price and sending the data.
//src/main/resources/static/js/modules/sales/salesForm.js


/**
 * Method: Send the sales data by using AJAX
 */
formSubmission('#saleForm', '/saveSale', saleFormData, saleSaveSuccess);

/**
 * Get the form data from the form
 */
function saleFormData() {
    return {
        saleFirstName: $('#saleFirstName').val(),
        saleLastName: $('#saleLastName').val(),
        saleAddress: $('#saleAddress').val(),
        saleItem: $('#saleItem').val(),
        saleQtyItem: $('#saleQtyItem').val(),
        salePrice: parseFloat($('#salePrice').val()),
        saleDate: $('#saleDate').val(),
        saleTotalPrice: parseFloat($('#saleTotalPrice').val()),
        salePaymentStatus: $('#salePaymentStatus').val(),
        saleDetails: $('#saleDetails').val()
    };
}

/**
 * Callback function for success
 */
function saleSaveSuccess(response) {
    alert("Venda salva com sucesso!");
    console.log(response);
    loadSalesTable();    // Update the sales table

    //Clear the form by resetting it
    document.getElementById('saleForm').reset();
}


