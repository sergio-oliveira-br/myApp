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
 Method: When the page is loaded or reloaded, the methods here will be updated
 */
$(document).ready(function () {
    //load the available customer
    loadCustomerList();

})


/**
 Method: Create a list of all clients and display it in the client field of the form
 */
function loadCustomerList(){
    ajaxRequest("/customers", function (data){
        //variable
        let saleCustomerSelect = $('#saleFirstName');

        //cleaning to display each item only once
        saleCustomerSelect.empty();

        //Iteration
        data.forEach(function(customer){
            saleCustomerSelect.append('<option value="' + customer.firstName +  + customer.lastName + " - " + customer.phoneNumber + '">' +
                customer.firstName + " " + customer.lastName + " - " + customer.phoneNumber +'</option>');
        });
    });
}


