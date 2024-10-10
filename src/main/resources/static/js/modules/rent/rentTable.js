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
function loadRentTable() {
    ajaxRequest("/api/v1/rent", function(data) {
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
                '<td><button class="btn btn-primary" onclick="populateRentModal(' + rent.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}









