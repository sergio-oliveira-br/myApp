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

//This file is responsible for loading and rendering the rent table on INDEX page.
//src/main/resources/static/js/modules/rent/index/rentTableIndex.js

/**
 * Page: Index
 * Method: to render rent table ON INDEX PAGE
 */
function renderRentTableIndexPage(data) {
    $('#rentListIndex').empty();

    data.forEach(function(rent) {
        $('#rentListIndex').append('<tr>' +
            '<td>' + rent.rentFirstName + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
            '<td>' + rent.rentPaymentStatus + '</td>' +
            '<td>' + rent.rentTotalPrice + '</td>' +
            '<td>' + rent.rentStatus + '</td>' +
            '<td><button class="btn btn-primary" onclick="populateRentModal(' + rent.id + ')">Edit</button></td>' +
            '</tr>');
        console.log(rent.id);
    });
}

/**
 * Page: Index
 * Method: To display a modal and load the rent list
 */
function displayRentByPaymentStatusIndex(status) {
    let modal = new bootstrap.Modal(document.getElementById('displayRentModal'));
    modal.show();

    let url = `/rentByPaymentStatus?paymentStatus=${encodeURIComponent(status)}`;

    ajaxRequest(url, renderRentTableIndexPage);
}

/**
 * Page: Index
 * Method: To display a modal and load the rent list
 */
function displayRentByStatusIndex(status) {
    let modal = new bootstrap.Modal(document.getElementById('displayRentModal'));
    modal.show();

    let url = `/rentByStatus?rentStatus=${encodeURIComponent(status)}`;

    ajaxRequest(url, renderRentTableIndexPage);
}