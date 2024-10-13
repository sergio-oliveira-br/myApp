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


//This file is responsible for loading and rendering the sales table.
//src/main/resources/static/js/modules/sales/salesTable.js

/**
 * Page: Sale - Table
 * Method: Load all sales items into a table
 */
function loadSalesTable() {
    ajaxRequest("/api/v1/sale", function (data) {
        $('#saleList').empty();
        data.forEach(function (sale) {
            $('#saleList').append('<tr>' +
                '<td>' + sale.id + '</td>' +
                '<td>' + sale.saleFirstName + '</td>' +
                '<td>' + sale.saleAddress + '</td>' +
                '<td>' + sale.saleItem + '</td>' +
                '<td>' + sale.saleQtyItem + '</td>' +
                '<td>' + sale.salePrice.toFixed(2) + '</td>' +
                '<td>' + sale.saleDate + '</td>' +
                '<td>' + sale.saleTotalPrice.toFixed(2) + '</td>' +
                '<td><button class="btn btn-primary" onclick="populateSaleModal(' + sale.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}
