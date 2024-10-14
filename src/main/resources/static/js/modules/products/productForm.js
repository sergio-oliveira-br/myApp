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

//This file will contain functions related to the product form, including submission handling and form events.
//src/main/resources/static/js/modules/products/productForm.js


/** Method: Send the Product data by using AJAX*/
 formSubmission('#itemForm', '/api/v1/product/create-product', productFormData, productSaveSuccess);

/**
 * Page: Products
 * Method: productFormData()
 * Info: Get the form data from the form
 */
function productFormData() {
    let currentDate = new Date();

    return {
        itemDescription: $('#itemDescription').val(),
        itemQuantity: $('#itemQty').val(),
        productType: $('#productType').val(),
        dateCreated: currentDate,
        dateModified: currentDate,
        itemPrice: $('#itemPrice').val(),
    };
}

/**
 * Page: Products
 * Method: productSaveSuccess(response)
 * Info: Callback function for success
 */
function productSaveSuccess(response) {
    alert('Produto adicionado com sucesso!');
    loadProductTable(); //update the product table

    // Clear the form by resetting it
    document.getElementById('itemForm').reset();
}




