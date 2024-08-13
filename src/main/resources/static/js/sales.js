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
$('#saleItem').change(function() {
    console.log('Change event triggered');

    let selectedOption = $('#saleItem option:selected');
    console.log('Selected option:', selectedOption);

    let salePriceInput = $('#salePrice');

    let price = selectedOption.attr('price');


    salePriceInput.val(price);

});





