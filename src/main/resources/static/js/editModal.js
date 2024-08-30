/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 2.0
 */



/**
 Page: Rent and Index
 Item: Form (modal)
 Method: This is a jQuery method that allows the user to make asynchronous requests to the server
 to send or receive data without having to reload the page.
 */
function openEditModal(rentId)
{
    console.log("Open Edit Modal, ID: " + rentId);

    //Call the generic function, that perform an AJAX request
    ajaxRequest("/rent/" + rentId, function(rent)
    {
        //Fill in the form fields in the modal using Selectors $() to select HTML elements based on their IDs.
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

        //Open the modal
        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}

/**
 Page: Rent and Index
 Item: Form (modal) - > Field Customer
 Method: The script will load the available customers in the rental form when the page loads
 */
function updateLoadCustomerForRentForm()
{
    //Call the generic function, that perform an AJAX request
    ajaxRequest("/customers", function(data)
    {
        //Local variable
        var rentCustomerSelect = $('#editRentFirstName');

        //Cleaning
        rentCustomerSelect.empty();

        //Iteration
        data.forEach(function(customer)
        {
            rentCustomerSelect.append('<option value="' + customer.firstName + " "+ customer.lastName + " - " + customer.phoneNumber +'">' +
                customer.firstName + " "+ customer.lastName + " - " + customer.phoneNumber +'</option>');
        });
    });
}

/**
 Page: Rent and Index
 Item: Form (modal) -> Edit Rent Status
 Method: This update the stock, adding the qty in to stock available
 */
function updateRentStatus()
{
    //Get the rent ID from the hidden input field in the form
    let rentId = $('#editRentId').val();
    console.log(rentId);

    //Get the new status value from the dropdown menu
    let status = $('#editRentStatus').val();
    console.log(status);

    $.ajax({ //allows updating parts of a web page without reloading the entire page
        url: "/rent/status/" + rentId + "?rentStatus=" + status, //indicates the endpoint
        type: 'PUT', //HTTP request methods used to INSERT/UPDATE data to the server (backend)
        data: {status: status}, //The data to send in the request, here we're sending the new status

        //Callback function to execute if the request is successful
        success: function(response)
        {
            alert('O status do aluguel foi alterado.' +
                '\nCertifique-se de que você escolheu a opção correta!');
            console.log("Rent status has been changed", response);
        },
        //Callback function to execute if there's an error with the request
        error: function(xhr, status, error) {
            console.error("Erro ao atualizar o status do aluguel.| Error:" + error);
        }
    });
}




