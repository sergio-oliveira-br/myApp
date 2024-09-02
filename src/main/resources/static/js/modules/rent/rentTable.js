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

//This file is responsible for loading and rendering the rent table.
//src/main/resources/static/js/modules/rent/rentTable.js

/**
 * Page: Rent
 * Item: Table
 * Method: The script will load all items in a table
 */
function loadRent() {
    ajaxRequest("/rent", function(data) {
        $('#rentList').empty(); // First clean
        data.forEach(function(rent) {
            $('#rentList').append('<tr>' +
                '<td>' + rent.id + '</td>' +
                '<td>' + rent.rentFirstName + '</td>' +
                '<td>' + rent.rentAddress + '</td>' +
                '<td>' + rent.rentItem + '</td>' +
                '<td>' + rent.rentQtyItem + '</td>' +
                '<td>' + rent.rentPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
                '<td>' + rent.rentStarts + '</td>' +
                '<td>' + rent.rentEnds + '</td>' +
                '<td>' + rent.rentTotalDays + '</td>' +
                '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
                '<td><button class="btn btn-primary" onclick="???(' + rent.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}

/**
 * Function to render rent table
 */
function renderIndexRentTable(data) {
    $('#rentListIndex').empty();

    data.forEach(function(rent) {
        $('#rentListIndex').append('<tr>' +
            '<td>' + rent.rentFirstName + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
            '<td>' + rent.rentPaymentStatus + '</td>' +
            '<td>' + rent.rentTotalPrice + '</td>' +
            '<td>' + rent.rentStatus + '</td>' +
            '<td><button class="btn btn-primary" onclick="???(' + rent.id + ')">Edit</button></td>' +
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

    ajaxRequest(url, renderIndexRentTable);
}

/**
 * Page: Index
 * Method: To display a modal and load the rent list
 */
function displayRentByStatusIndex(status) {
    let modal = new bootstrap.Modal(document.getElementById('displayRentModal'));
    modal.show();

    let url = `/rentByStatus?rentStatus=${encodeURIComponent(status)}`;

    ajaxRequest(url, renderIndexRentTable);
}

/**
 * Function to render rent table
 */
function renderRentTable(data) {
    $('#rentList').empty();

    data.forEach(function (rent) {
        $('#rentList').append('<tr>' +
            '<td>' + rent.id + '</td>' +
            '<td>' + rent.rentFirstName + '</td>' +
            '<td>' + rent.rentAddress + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
            '<td>' + rent.rentQtyItem + '</td>' +
            '<td>' + rent.rentPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
            '<td>' + rent.rentStarts + '</td>' +
            '<td>' + rent.rentEnds + '</td>' +
            '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
            '<td>' + rent.rentPaymentStatus + '</td>' +
            '<td>' + rent.rentStatus + '</td>' +
            '<td>' + rent.rentDetails + '</td>' +
            '</tr>'
        );
    });
}

/**
 * Page: Rent
 * Item: Table
 * Method: Load all rent records
 */
function getAllRent() {
    ajaxRequest("/rent", renderRentTable);
}

