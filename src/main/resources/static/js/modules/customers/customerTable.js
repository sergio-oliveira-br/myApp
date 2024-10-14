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

//This file is responsible for loading and rendering the client table.
//src/main/resources/static/js/modules/customers/customerTable.js

/**
 * Page: Customers
 * Item: Table
 * Method: Create a table with all customers via AJAX
 */
function loadCustomersTable() {
    ajaxRequest("/api/v1/customer", function (data) {
        // First clean
        $('#customerList').empty();

        console.log('There are ' + data.length + ' customers in your customers DB.');

        //Iteration
        data.forEach(function (customer) {
            $('#customerList').append('<tr>' +
                '<td>' + customer.id + '</td>' +
                '<td>' + customer.firstName + '</td>' +
                '<td>' + customer.lastName + '</td>' +
                '<td>' + customer.phoneNumber + '</td>' +
                '<td>' + customer.city + '</td>' +
                '<td>' + customer.additionalInfo + '</td>' +
                '</tr>');
        });
    });
}
