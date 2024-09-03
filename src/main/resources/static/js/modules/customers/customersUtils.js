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

//This file contain functions related to the manipulation of customer data.
//src/main/resources/static/js/modules/customers/customersUtils.js

/**
 * Function: loadCustomers(selectId)
 * Info: Load customers and populate the select dropdown
 */
function loadCustomersListForm(selectId) {
    ajaxRequest("/customers", function(data) {
        const rentCustomerSelect = $(selectId);

        rentCustomerSelect.empty();
        data.forEach(function(customer) {
            rentCustomerSelect.append(`<option value="${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}">
                ${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}</option>`
            );
        });
    });
}

//PRECISA SER VALIDADO, MAS ACREDITO QUE PODE SER UTILIZADO DENTRO DO MODAL TAMBEM!
// function loadCustomersListModal() {
//     ajaxRequest("/customers", function(data) {
//         const rentCustomerSelect = $('#editRentFirstName');
//
//         rentCustomerSelect.empty();
//
//         data.forEach(function(customer) {
//             rentCustomerSelect.append('<option value="' + customer.firstName + " " + customer.lastName + " - " + customer.phoneNumber + '">' +
//                 customer.firstName + " " + customer.lastName + " - " + customer.phoneNumber + '</option>');
//         });
//     });
// }
