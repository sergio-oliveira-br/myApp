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

/**
 Page: All
 Objective: When the page is loaded,
 all information will be displayed
 */
$(document).ready(function()
{
    //Create a table with all customers via AJAX
    loadCustomers();

});



/**
 Page: Customers
 Item: Table
 Method: Create a table with
 all customers via AJAX
 */
function loadCustomers()
{
    ajaxRequest("/customers", function (data)
    {
        //first clean
        $('#customerList').empty();

        //Iterate over clients and add them to the list
        data.forEach(function(customer)
        {
            $('#customerList').append('<tr>' +
                '<td>' + customer.id + '</td>' +
                '<td>' + customer.firstName + '</td>'+
                '<td>' + customer.lastName + '</td>' +
                '<td>' + customer.city + '</td>' +
                '<td>' + customer.additionalInfo + '</td>' +
                '</tr>');
        });
    });
}




/**
 Page: Customers
 Item: Form
 Method: Send the customer data by using AJAX
 */
function formSubmission(formId, url, formDataFunction, successCallback, errorCallback)
{
    $(document).ready(function()
    {
        //Get the form ID that contain the all data
        $(formId).on('submit', function(event)
        {
            event.preventDefault();

            //get the form data
            let formData = customerFormData();

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






//Get the form data in a generic way
function customerFormData()
{
    return {
        firstName: $('#customerFirstName').val(),
        lastName: $('#customerLastName').val(),
        phoneNumber: $('#customerPhoneNumber').val(),
        additionalInfo: $('#additionalInformation').val(),
        city: $('#customerCity').val()
    };
}
//Callback function for success
function saveSuccess(response)
{
    alert('Form added successfully!');
    console.log(response);
    loadCustomers(); // update the table
}

//Callback function for error
function saveError(error) {
    alert('Failed to add this form. Please try again.');
    console.error(error);
}

formSubmission('#customerForm', '/saveCustomer', customerFormData, saveSuccess, saveError);

