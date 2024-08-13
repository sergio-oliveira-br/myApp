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

/** Method: Create a list of all items and display it in the Product field of the Sales form*/
function loadProductListByProductType(productType){
    ajaxRequest("/productByType?productType=" + encodeURIComponent(productType), function(data)
    {
        //variable
        let saleItemSelect = $('#saleItem');

        //cleaning to display each item only once
        saleItemSelect.empty();

        //Iteration
        data.forEach(function(product){
            saleItemSelect.append('<option id="' + product.id +'" price="' + product.itemPrice + '">' + product.itemDescription + '</option>');
        });
    });
}

//Everytime that the user change the field item, the price will be updated
$('#saleItem').change(function() {
    console.log('Change event triggered');

    let selectedOption = $('#saleItem option:selected');
    console.log('Selected option:', selectedOption);

    let salePriceInput = $('#salePrice');

    let price = selectedOption.attr('price');

    salePriceInput.val(price);
});

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



