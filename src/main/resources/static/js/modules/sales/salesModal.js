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

//This file is responsible for handling the sales editing modal.
//src/main/resources/static/js/modules/sales/salesModal.js

/**
 * Page: Sales
 * Item: Form (modal)
 * Method: This is a jQuery method that allows the user to make asynchronous requests to the server
 * to send or receive data without having to reload the page.
 */

function populateSaleModal(saleId) {
    console.log("Open Edit Modal, ID: " + saleId);

    ajaxRequest('/api/v1/sales/' + saleId, function (sale){
        $('#editSaleId').val(sale.id);
        $('#editSaleFirstName').val(sale.saleFirstName);
        $('#editSaleAddress').val(sale.saleAddress);
        $('#editSaleItem').val(sale.saleItem);
        $('#editSaleQtyItem').val(sale.saleQtyItem);
        $('#editSalePrice').val(sale.salePrice);
        $('#editSaleDate').val(sale.saleDate);
        $('#editSaleTotalPrice').val(sale.saleTotalPrice);
        $('#editSaleDetails').val(sale.saleDetails);
        $('#editSalePaymentStatus').val(sale.salePaymentStatus);

        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}

/**
 Page: Sales
 Item: Form (modal)
 Method: Send the data to update my database
 */

function saleFormSubmissionModal(){
    let currentDate = new Date();

    let saleData = {
        id: $('#editSaleId').val(),
        saleFirstName: $('#editSaleFirstName').val(),
        saleAddress: $('#editSaleAddress').val(),
        saleItem: $('#editSaleItem').val(),
        saleQtyItem: $('#editSaleQtyItem').val(),
        salePrice: $('#editSalePrice').val(),
        saleDate: $('#editSaleDate').val(),
        saleTotalPrice: $('#editSaleTotalPrice').val(),
        salePaymentStatus: $('#editSalePaymentStatus').val(),
        saleDetails: $('#editSaleDetails').val()
    };

    //this is a log to check what's it will send
    console.log(saleData);
    $.ajax({
        url: '/api/v1/sales/' + saleData.id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(saleData),

        success: function (response) {
            let successMsg = "Venda alterada com sucesso";
            alert(successMsg);

            $('#editModal').modal('hide');

            console.log(successMsg, currentDate);

            loadSalesTable();
        },
        error: function (xhr, status, error) {
            //call the function from errorHandling.js file
            errorHandler(error);
        }
    });
}