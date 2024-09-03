/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie, oliveira-sergio@outlook.com
 * Project Commencing May 2024 | Version: 1.0
 * Refactoring & New Features - Aug 2024 | Version: 2.0
 */

//This file contain product-related utility functions.
//src/main/resources/static/js/modules/products/productUtils.js

/**
 * Method: loadProductListByProductType(productType)
 * Info: Create a list of all items and display it in the Product field of the Sales and Rent Form
 */
function loadProductListByProductType(productType) {
    ajaxRequest("/productByType?productType=" + encodeURIComponent(productType), function(data) {
        let productSelects = [$('#saleItem'), $('#rentItem'), $('#editRentItem')]; // Array of select elements
        productSelects.forEach(function (selectElement) {
            selectElement.empty();
            data.forEach(function (product) {
                selectElement.append('<option id="' + product.id + '" price="' + product.itemPrice + '">' + product.itemDescription + '</option>');
            });
        });
    });
}

// Update price when the user changes the item field
$('#rentItem, #editRentItem, #saleItem').change(function() {
    console.log('Change event triggered');

    let selectedOption = $(this).find(':selected');
    let price = selectedOption.attr('price');

    if ($(this).attr('id') === 'rentItem') {
        $('#rentPrice').val(price);

    } else if ($(this).attr('id') === 'editRentItem') {
        $('#editRentPrice').val(price);
        updateTotalPrice();

    } else if ($(this).attr('id') === 'saleItem') {
        $('#salePrice').val(price);
        loadTotalPriceSales(); // Update the total price for sales
    }
});


// /**
//  * Page: Products
//  * Method: updateLoadProductForm()
//  * Info: Update the product form dropdown with available products
//  */
// function loadProductListForm(selectId) {
//     ajaxRequest("/product", function(data) {
//         const htmlId = $(selectId);
//
//         //clean
//         htmlId.empty();
//         data.forEach(function(product) {
//             htmlId.append('<option value="' + product.id + '">' + product.name + '</option>');
//         });
//     });
// }