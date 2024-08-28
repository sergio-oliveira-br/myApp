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
    loadQtyRentByStatus('Novo');
    loadQtyRentByStatus('Em andamento');

    loadQtyRentByPaymentStatus('Pendente');

    //(MODAL)The script will load the available items and customers in the rental form when the page loads
    updateLoadCustomerForRentForm();

    //(Modal)
    $('#editRentForm').on('submit', function(e) {
        e.preventDefault();
        submitEditForm();
    });

    //(Modal)Update the rent status, if is "Finished", the item stock will return to total available
    $('#editRentStatus').on('change', function() {
        console.log('Rent Status Changed');
        updateRentStatus();
    });

});


/**
 Item: Card (UNPAID)
 Method: Obtain the number of rent which the status is UNPAID
 */
// function loadNumRentUnpaid(rentStatus)
// {
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/qtyRentByStatus" + rentStatus ,  function (data)
//     {
//         if (data == 0)
//         {
//             $('#loadRentUnpaid').text("That's Good! All your rentals have been paid");
//         }
//
//         else
//         {
//             $('#loadRentUnpaid').text('You have ' + data + ' rentals unpaid.');
//             alert("You have " + data + " rentals unpaid.");
//         }
//     });
// }


/**
 Method: Obtain the number of rent which the status is UNPAID
 */
function loadQtyRentByPaymentStatus(paymentStatus) {
    //Sets the endpoint URL with the payment status parameter "pago" or "a receber"
    let url = `/qtyRentByPaymentStatus?paymentStatus=${encodeURIComponent(paymentStatus)}`

    //Set the selector based on payment status
    let selectors = {
        'Pendente' : '#loadRentUnpaid'
    };

    let selector = selectors[paymentStatus];

    //Handling Exceptions
    if (!selector) {
        console.warn(`No selector found for status: ${paymentStatus}`);
        return;
    }

    ajaxRequest(url, function(data) {
        $(selector).text('Voce possui ' + data + ' aluguéis com pagamentos "' + paymentStatus + '".')
    });
}


/**
 Method: Obtain the number of rent which the status are "Novo", "Em andamento" or "Encerrado"
 */
function loadQtyRentByStatus(status)
{
    //Sets the endpoint URL with the status parameter
    //let url = "/qtyRentByStatus?rentStatus=" + (status); //indicates the endpoint
    let url = `/qtyRentByStatus?rentStatus=${encodeURIComponent(status)}`

    //Set the selector based on status
    let selectors = {
        'Novo' : '#loadRentStatusNew',
        'Em andamento' : '#loadRentStatusInProgress'
    };

    //Get the appropriate selector
    let selector = selectors[status];

    //Handling Exceptions
    if (!selector) {
        console.warn(`No selector found for status: ${status}`);
        return;
    }

    //Call the generic function, that perform an AJAX request
    ajaxRequest(url, function (data)
    {
        $(selector).text('Voce possui ' + data + ' aluguéis com o status "' + status + '".')
    });
}

/**                                    ------------ Generic Function ------------
 Page: Index
 Method: Display the current stock by clicking in the card called "stock"
*/
// function loadCurrentStock()
// {
//
//     //Open the modal
//     let stockModal = new bootstrap.Modal(document.getElementById('stockModal'));
//     stockModal.show();
//
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/product", function(data)
//     {
//         //first cleaning: This makes sure that the list will appear only once
//         $('#productList').empty();
//
//         //Iteration
//         data.forEach(function(product)
//         {
//             $('#productList').append('<tr>' +
//                     '<td>' + product.itemDescription + '</td>' +
//                     '<td>' + product.itemAvailableQty + '</td>' +
//                 '</tr>'
//             );
//         });
//     });
// }

/** Method: Create a list of all items and display it in the Product field of the Sales form*/
function loadCurrentStockByType(productType){

    //Open the modal
    let stockModal = new bootstrap.Modal(document.getElementById('stockModal'));
    stockModal.show();

    //Call the generic function, that perform an AJAX request
    ajaxRequest("/productQtyByType?productType=" + encodeURIComponent(productType), function(data)
    {
        //variable
        let productItemSelect = $('#productList');

        //cleaning to display each item only once
        productItemSelect.empty();

        //Iteration
        data.forEach(function(product){
            productItemSelect.append('<tr>' +
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




