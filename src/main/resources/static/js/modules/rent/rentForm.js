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

//This file handles the submission of the rental form and updating the rent table.
//src/main/resources/static/js/modules/rent/rentForm.js

/**
 * Method: Send the order (rent or sale) data by using AJAX
 */
formSubmission('#rentForm', '/saveRent', orderFormData, orderSaveSuccess, saveError);

/**
 * Get the form data from the form
 */
function orderFormData() {
    return {
        rentFirstName: $('#rentFirstName').val(),
        rentAddress: $('#rentAddress').val(),
        rentItem: $('#rentItem').val(),
        rentQtyItem: $('#rentQtyItem').val(),
        rentPrice: $('#rentPrice').val(),
        rentStarts: $('#rentStarts').val(),
        rentEnds: $('#rentEnds').val(),
        rentTotalDays: $('#rentTotalDays').val(),
        rentTotalPrice: parseFloat($('#rentTotalPrice').val()),
        rentPaymentStatus: $('#rentPaymentStatus').val(),
        rentDetails: $('#rentDetails').val(),
        rentStatus: $('#rentStatus').val()
    };
}

/**
 * Callback function for success
 */
function orderSaveSuccess(response) {
    alert('Order added successfully!');
    console.log(response);
    loadRent(); // Update the rent table

    // Clear the form by resetting it
    document.getElementById('rentForm').reset();
}
