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

//This file is responsible for handling the rental editing modal.
//src/main/resources/static/js/modules/rent/rentModal.js

/**
 * Page: Rent
 * Item: Form (modal)
 * Method: Calculates the difference of the days
 */
function updateRentDays() {
    let newStart = $('#editRentStarts').val();
    let newEnd = $('#editRentEnds').val();

    let newRentTotalDays = mathDays(newStart, newEnd);
    console.log("New Total Days has been calculated: " + newRentTotalDays);

    $('#editRentTotalDays').val(newRentTotalDays);
}

/**
 * Page: Rent
 * Item: Form (modal)
 * Method: Calculates the total price on Modal
 */
function updateTotalPrice() {
    let newRentPriceModal = parseFloat($('#editRentPrice').val().replace(',', '.')) || 0;
    let newRentQtyItemModal = parseInt($('#editRentQtyItem').val()) || 0;
    let newRentTotalDaysModal = parseInt($('#editRentTotalDays').val());

    let newRentTotalPriceModal = (newRentPriceModal * newRentQtyItemModal * newRentTotalDaysModal);

    $('#editRentTotalPrice').val(newRentTotalPriceModal.toFixed(2));
}

/**
 * Page: Rent and Index
 * Item: Form (modal)
 * Method: This is a jQuery method that allows the user to make asynchronous requests to the server
 * to send or receive data without having to reload the page.
 */
function openEditModal(rentId) {
    console.log("Open Edit Modal, ID: " + rentId);

    ajaxRequest("/rent/" + rentId, function(rent) {
        $('#editRentId').val(rent.id);
        $('#editRentFirstName').val(rent.rentFirstName);
        $('#editRentLastName').val(rent.rentLastName);
        $('#editRentAddress').val(rent.rentAddress);
        $('#editRentItem').val(rent.rentItem);
        $('#editRentQtyItem').val(rent.rentQtyItem);
        $('#editRentPrice').val(rent.rentPrice);
        $('#editRentStarts').val(rent.rentStarts);
        $('#editRentEnds').val(rent.rentEnds);
        $('#editRentTotalDays').val(rent.rentTotalDays);
        $('#editRentTotalPrice').val(rent.rentTotalPrice.toFixed(2));
        $('#editRentPaymentStatus').val(rent.rentPaymentStatus);
        $('#editRentDetails').val(rent.rentDetails);
        $('#editRentStatus').val(rent.rentStatus);

        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}