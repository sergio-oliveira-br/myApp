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
 * Method: When the page is loaded or reloaded, the methods here will be updated
 */
$(document).ready(function () {
    // Load the available customers
    loadCustomers('#saleFirstName');

    // Load the items classified as "Vendas" in productType
    loadProductListByProductType("Venda");

    // Render the sales table
    loadSales();
});

/**
 * Method: Send the sales data by using AJAX
 */
formSubmission('#saleForm', '/saveSale', saleFormData, saleSaveSuccess, saveError);

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
    alert("Sale successfully saved");
    console.log(response);
    // Update the sales table
    loadSales();

    // Clear the form
    document.getElementById('saleForm').reset();
}

/**
 * Method: Calculate the total price by multiplying (qty x unit price)
 */
function loadTotalPriceSales() {
    let qty = document.getElementById('saleQtyItem').value;
    let unitPrice = parseFloat(document.getElementById('salePrice').value);
    let finalTotalPrice = parseFloat(qty * unitPrice);

    document.getElementById('saleTotalPrice').value = finalTotalPrice.toFixed(2);
    console.log("Final Price Calculated: " + finalTotalPrice);
}

// Update the total price when these fields change
document.getElementById('saleItem').addEventListener('change', loadTotalPriceSales);
document.getElementById('saleQtyItem').addEventListener('change', loadTotalPriceSales);
