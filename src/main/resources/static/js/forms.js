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
 Page: Customers, Rent, Sales, Product and Expenses
 Item: Form
 Method: Send the customer data by using AJAX
 */
function formSubmission(formId, url, formDataFunction, successCallback, errorCallback)
{
    $(document).ready(function()
    {
        //Get the form ID that contain the all data. Remember: FormID is ID from the form on HTML
        $(formId).on('submit', function(event)
        {
            //Prevents the default behavior of the browser, which would reload the page and send the form data synchronously
            event.preventDefault();

            //Get the form data
            let formData = formDataFunction();

            $.ajax({
                url: url,
                data: JSON.stringify(formData),
                type: 'POST',
                contentType: 'application/json',
                success: function(response){
                    if(successCallback)
                    {
                        successCallback(response);
                    }
                },
                error: function(xhr, status, error)
                {
                    if(errorCallback)
                    {
                        let errorMessage = xhr.responseText;
                        alert("From the Server: " + errorMessage);
                        errorCallback(error);
                    }
                }
            });
        });
    });
}

/** Method: Callback function for error */
function saveError(error) {
    alert('Failed to add this form. Please try again.');
    console.error(error);
}



/**
 Page: Rent and Index
 Item: Form (modal)
 Method: Send the data to update my database
 */
function submitEditForm() {
    let rentData = {
        id: $('#editRentId').val(),
        rentFirstName: $('#editRentFirstName').val(),
        rentLastName: $('#editRentLastName').val(),
        rentAddress: $('#editRentAddress').val(),
        rentItem: $('#editRentItem').val(),
        rentQtyItem: parseInt($('#editRentQtyItem').val()),
        rentPrice: parseFloat($('#editRentPrice').val()),
        rentStarts: $('#editRentStarts').val(),
        rentEnds: $('#editRentEnds').val(),
        rentTotalDays: parseInt($('#editRentTotalDays').val()),
        rentTotalPrice: parseFloat($('#editRentTotalPrice').val()),
        rentPaymentStatus: $('#editRentPaymentStatus').val(),
        rentDetails: $('#editRentDetails').val(),
        rentStatus: $('#editRentStatus').val()
    };

    //this is a log to check what's it will send
    console.log(rentData);

    $.ajax({ //allows updating parts of a web page without reloading the entire page
        url: '/rent/' + rentData.id, //indicates the endpoint
        type: 'PUT', //HTTP request methods used to INSERT data to the server (backend), indicating by the endpoint specified by the URL
        contentType: 'application/json',
        data: JSON.stringify(rentData),

        success: function(response) {
            alert('Rent updated successfully');
            $('#editModal').modal('hide');
            loadRent();
        },
        error: function(xhr, status, error) {
            console.error(error);
            alert('Oops, something went wrong! | Error: ', error);
        }
    });
}

