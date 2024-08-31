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
    console.log(response);
    loadProduct(); //update the product table

    // Clear the form by resetting it
    document.getElementById('itemForm').reset();
}

/**
 * Page: Products
 * Method: updateLoadProductForm()
 * Info: Update the product form dropdown with available products
 */
function updateLoadProductForm() {
    ajaxRequest("/product", function(data) {
        let productSelect = $('#editItemQty');
        productSelect.empty();

        data.forEach(function(product) {
            productSelect.append('<option value="' + product.id + '">' + product.name + '</option>');
        });
    });
}

// Stock alert confirmation before change
document.getElementById('editItemQtyAvailable').addEventListener('change', stockAlert);
function stockAlert() {
    let confirmationMsg = "Você tem certeza eu deseja alterar o Estoque?"

    if (confirm(confirmationMsg)) {
        submitEditForm(); //send the data after the confirmation from the user
    } else {
        alert('Operação cancelada!');
    }
}

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

