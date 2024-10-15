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

//This file handles the submission of the client form and updating the client table.
//src/main/resources/static/js/modules/customers/customerForm.js

/**
 * Method: Send the customer data by using AJAX
 */
formSubmission('#customerForm', '/api/v1/customer/create-customer', customerFormData, customerSaveSuccess);

/**
 * Get the form data from the form
 */
function customerFormData() {
    return {
        firstName: $('#customerFirstName').val(),
        lastName: $('#customerLastName').val(),
        phoneNumber: $('#customerPhoneNumber').val(),
        additionalInfo: $('#additionalInformation').val(),
        city: $('#customerCity').val()
    };
}

/**
 * Callback function for success
 */
function customerSaveSuccess(response) {
    alert('Cliente salvo com sucesso!');
    loadCustomersTable(); // Update the customer table

    // Clear the form by resetting it
    document.getElementById('customerForm').reset();
}
