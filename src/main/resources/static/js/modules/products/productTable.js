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

//This file will contain functions that deal with the creation and updating of the product table on the page
//src/main/resources/static/js/modules/products/productTable.js

/**
 * Page: Products
 * Info: Creates a table with all products via AJAX
 */
function loadProductTable() {
    ajaxRequest("/product", function(data) {
        $('#productList').empty();

        console.log("There are " + data.length + " products in your DB");

        //Iteration
        data.forEach(function(product) {
            $('#productList').append('<tr>' +
                '<td>' + product.id + '</td>' +
                '<td>' + product.itemDescription + '</td>' +
                '<td>' + product.itemPrice + '</td>' +
                '<td>' + product.itemQuantity +'</td>' +
                '<td>' + product.itemAvailableQty + '</td>' +
                '<td>' + product.productType + '</td>' +
                '<td><button class="btn btn-primary" onclick="openProductEditModal(' + product.id + ')">Edit</button></td>' +
                '</tr>');
        });
    });
}

/**
 * Update
 * Method: Populate product select dropdown in the edit modal form
 */
function updateLoadProductForm() {
    console.log("Here where the method updateLoadProductForm() is used. !IMPORTANT: CHECK THE NEED");

    ajaxRequest("/product", function(data) {
        let productSelect = $('#editItemQty');
        productSelect.empty();
        data.forEach(function(product) {
            productSelect.append('<option value="' + product.id + '">' + product.name + '</option>');
        });
    });
}

