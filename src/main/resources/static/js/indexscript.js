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

/**                             ------------ Generic Function ------------ */
$(document).ready(function ()
{
    //This will display a number by status within the cards
    loadNumRentUnpaid();
    loadNumRentByStatus('New');
    loadNumRentByStatus('InProgress');

    //(MODAL)The script will load the available items and customers in the rental form when the page loads
    loadEditItemsForRentFormModal();
    updateLoadCustomerForRentForm();

    //(Modal)
    $('#editRentForm').on('submit', function(e) {
        e.preventDefault();
        submitEditForm();
    });

});


/**
 Item: Card (UNPAID)
 Method: Obtain the number of rent witch the status is UNPAID
 */
function loadNumRentUnpaid ()
{
    //Call the generic function, that perform an AJAX request
    ajaxRequest("/qtyRentUnpaid", function (data)
    {
        if (data == 0)
        {
            $('#loadRentUnpaid').text("That's Good! All your rentals have been paid");
        }

        else
        {
            $('#loadRentUnpaid').text('You have ' + data + ' rentals unpaid.');
            alert("You have " + data + " rentals unpaid.");
        }
    });
}



/**
 Method: Obtain the number of rent witch the status is NEW
 */
function loadNumRentByStatus(status)
{
    //local variable
    let url = "/qtyRentStatus" + status; //indicates the endpoint
    let selector;

    if (status === 'New')
    {
        selector = '#loadRentStatusNew';
    }

    else if (status === 'InProgress')
    {
        selector = '#loadRentStatusInProgress';
    }

    //Call the generic function, that perform an AJAX request
    ajaxRequest(url, function (data)
    {
        $(selector).text('You have ' + data + ' Rents')
    });
}

/**                                    ------------ Generic Function ------------
 Page: Index
 Method: Display the current stock by clicking in the card called "stock"
*/
function loadCurrentStock()
{

    //Open the modal
    let stockModal = new bootstrap.Modal(document.getElementById('stockModal'));
    stockModal.show();

    //Call the generic function, that perform an AJAX request
    ajaxRequest("/product", function(data)
    {
        //first cleaning: This makes sure that the list will appear only once
        $('#productList').empty();

        //Iteration
        data.forEach(function(product)
        {
            $('#productList').append('<tr>' +
                    '<td>' + product.itemDescription + '</td>' +
                    '<td>' + product.itemAvailableQty + '</td>' +
                '</tr>'
            );
        });
    });
}



/**
 * Function to render rent table
 */
function renderIndexRentTable(data)
{
    $('#rentListIndex').empty();

    data.forEach(function (rent)
    {
        $('#rentListIndex').append('<tr>' +
            '<td>' + rent.rentFirstName + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
            '<td>' + rent.rentPaymentStatus + '</td>' +
            '<td>' + rent.rentTotalPrice  + '</td>' +
            '<td>' + rent.rentStatus + '</td>' +
            '<td><button class="btn btn-primary" onclick="openEditModal(' + rent.id + ')">Edit</button></td>' +
            '</tr>');
        console.log(rent.id);
    });
}

/**
 Page: Index
 Method: To display a modal and load the rent list
 */
function displayRentByPaymentStatusIndex(status)
{
    //Display the modal
    let modal = new bootstrap.Modal(document.getElementById('displayRentModal'));
    modal.show();

    //Build the URL
    let url = "/rentByPaymentStatus?paymentStatus=" + encodeURIComponent(status);

    //Call the Ajax Request rending the Table
    ajaxRequest(url, renderIndexRentTable);
}


/**
 Page: Index
 Method: To display a modal and load the rent list
 */
function displayRentByStatusIndex(status)
{
    //Display the modal
    let modal = new bootstrap.Modal(document.getElementById('displayRentModal'));
    modal.show();

    //Build the URL
    let url = "/rentByStatus?rentStatus=" + encodeURIComponent(status);

    //Call the Ajax Request rending the Table
    ajaxRequest(url, renderIndexRentTable);
}




