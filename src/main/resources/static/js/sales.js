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

    //load the items witch are classified as "Vendas" em productType
    loadProductListByProductType("Venda")

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


// //Everytime that the user change the field item, the price will be updated
// $('#saleItem').change(function() {
//     console.log('Change event triggered');
//
//     let selectedOption = $('#saleItem option:selected');
//     console.log('Selected option:', selectedOption);
//
//     let salePriceInput = $('#salePrice');
//
//     let price = selectedOption.attr('price');
//
//     salePriceInput.val(price);
// });

/** Method: Send the sales data by using AJAX */
formSubmission('#saleForm', '/saveSale', saleFormData, saleSaveSuccess, saveError);

//Get the form data from the form
function saleFormData(){
    return{
        saleFirstName: $('#saleFirstName').val(),
        saleAddress: $('#saleAddress').val(),
        saleItem: $('#saleItem').val(),
        saleQtyItem: $('#saleQtyItem').val(),
        salePrice: parseFloat($('#salePrice').val()),
        saleDate: $('#saleDate').val(),
        saleTotalPrice: parseFloat($('#saleTotalPrice').val()),
        salePaymentStatus: $('#salePaymentStatus').val(),
        saleDetails: $('#saleDetails').val()
    };
}

//Callback function for success
function saleSaveSuccess(response){
    alert("Sale successfully saved");
    console.log(response);
    //need to update the table

    //clear the form by resetting it
    //document.getElementById('saleForm').reset();
}

/** Method: Calculate the total price by multiplying (qty x unit price) */
function loadTotalPriceSales(){
    //Variables
    let qty = document.getElementById('saleQtyItem').value;
    let unitPrice = parseFloat(document.getElementById('salePrice').value);
    let finalTotalPrice;

    //Calculating
    finalTotalPrice = parseFloat(qty * unitPrice);

    //Write
    document.getElementById('saleTotalPrice').value = finalTotalPrice.toFixed(2);
    console.log("Final Price Calculated: " + finalTotalPrice);
}

//Update everytime that one of these five field is changed
document.getElementById('saleItem').addEventListener('change', loadTotalPriceSales);
document.getElementById('saleQtyItem').addEventListener('change', loadTotalPriceSales);




