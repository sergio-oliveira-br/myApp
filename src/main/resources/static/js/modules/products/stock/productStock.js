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

//Methods related to stock of products.
//src/main/resources/static/js/modules/products/stock/productStock.js

/**
 * Method: Create a list of all items and display it in the Product field of the Sales form
 */
function loadCurrentStockByType(productType) {
    let stockModal = new bootstrap.Modal(document.getElementById('stockModal'));
    stockModal.show();

    ajaxRequestTypeGet(`/api/v1/product/qty/product-by-type?productType=${encodeURIComponent(productType)}`, function(data) {
        let productItemSelect = $('#productList');
        productItemSelect.empty();

        data.forEach(function(product) {
            productItemSelect.append('<tr>' +
                '<td>' + product.itemDescription + '</td>' +
                '<td>' + product.itemAvailableQty + '</td>' +
                '</tr>'
            );
        });
    });
}
