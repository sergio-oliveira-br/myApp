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
    loadRentTable("Paid");
})


/**
 Page: Rent
 Item: Table
 Method: The script will load all items in a table
 */

function loadRentTable(status)
{
    //Call the generic function, that perform an AJAX request
    ajaxRequest("/listRentStatus" + '?status=' + status, function(data)
    {
        //first clean
        $('#rentList').empty();

        //Iteration
        data.forEach(function(rent)
        {
            $('#rentList').append('<tr>' +
                '<td>' + rent.id + '</td>' +
                '<td>' + rent.rentFirstName + '</td>' +
                /** '<td>' + rent.rentLastName + '</td>' + */
                '<td>' + rent.rentAddress + '</td>' +
                '<td>' + rent.rentItem + '</td>' +
                '<td>' + rent.rentPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
                '<td>' + rent.rentStarts + '</td>' +
                '<td>' + rent.rentEnds + '</td>' +
                '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
                '<td>' + rent.rentPaymentStatus + '</td>' +
                '<td>' + rent.rentStatus+ '</td>' +
                '<td>' + rent.rentDetails + '</td>' +
                '</tr>'
            );
        });
    });
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

    //Call the ajax request
    ajaxRequest(url,function (data)
    {
        //first clean
        $('#rentList').empty();

        //Iteration
        data.forEach(function(rent)
        {
            $('#rentList').append('<tr>' +
                '<td>' + rent.id + '</td>' +
                '<td>' + rent.rentFirstName + '</td>' +
                /** '<td>' + rent.rentLastName + '</td>' + */
                '<td>' + rent.rentAddress + '</td>' +
                '<td>' + rent.rentItem + '</td>' +
                '<td>' + rent.rentPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
                '<td>' + rent.rentStarts + '</td>' +
                '<td>' + rent.rentEnds + '</td>' +
                '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
                '<td>' + rent.rentPaymentStatus + '</td>' +
                '<td>' + rent.rentStatus+ '</td>' +
                '<td>' + rent.rentDetails + '</td>' +
                '</tr>'
            );
        });
    });
}






/**
 Method: By clicking on the buttons on navbar" filter by", the table will load the info selected.
 */
//Rent Status: New
function displayAllRentStatusNew()
{
    loadRentTable('New');
}

//Rent Status: New
function displayAllRentStatusInProgress()
{
    loadRentTable('InProgress');
}

//Rent Status: Sold
function displayListAllRentStatusSold()
{
    loadRentTable( 'Sold');
}

//Rent Payment Status: Unpaid
function displayListAllRentStatusUnpaid()
{
    loadRentTable( 'Unpaid');
}

//Rent Payment Status: Paid
function displayListAllRentStatusPaid()
{
    loadRentTable( 'Paid');
}