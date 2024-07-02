/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */

$(document).ready(function ()
{
    //load the table with all rent paid information from rental database
    getRentByPaymentStatus('Paid');
})

/**
 * Function to render rent table
 */
function renderRentTable(data) {
    $('#rentList').empty();

    data.forEach(function (rent) {
        $('#rentList').append('<tr>' +
            '<td>' + rent.id + '</td>' +
            '<td>' + rent.rentFirstName + '</td>' +
            /** '<td>' + rent.rentLastName + '</td>' + */
            '<td>' + rent.rentAddress + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
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
 Page: Rent
 Item: Table
 Method: The script will load all items in a table by selecting the Payment Status and,
         by clicking on the buttons on navbar "filter by"
 */
function getRentByPaymentStatus(status)
{
    //Building the URL
    let url = "/rentByPaymentStatus?paymentStatus=" + encodeURIComponent(status);

    //Call method Ajax Request with the render method table
    ajaxRequest(url, renderRentTable);
}


/**
 Page: Rent
 Item: Table
 Method: The script will load all items in a table by selecting the Status and,
        by clicking on the buttons on navbar "filter by"
 */
function getRentByStatus(status)
{
    //Building the URL
    let url = "/rentByStatus?rentStatus=" + encodeURIComponent(status);

    //Call method Ajax Request with the render method table
    ajaxRequest(url, renderRentTable);
}


/**
 Page: Rent Report
 Item: Table -> Date (Month and Year) in NAVBAR
 Method: This will filter date by selecting Month and Year
 */
function getRentByMonth(year, month)
{
    //Building the URL
    let url = "/rentByDate?year=" + encodeURIComponent(year) + "&month=" + encodeURIComponent(month);

    //Call method Ajax Request with the render method table
    ajaxRequest(url, renderRentTable);
}