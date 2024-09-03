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

//This file is responsible for loading and rendering the rent table on REPORT page.
//src/main/resources/static/js/modules/rent/rentReport/rentTableReport.js

/**
 * Function to render rent table on report page
 */
function renderRentTableReport(data) {
    //clean
    $('#rentList').empty();

    //iteration
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