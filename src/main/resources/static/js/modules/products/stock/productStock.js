//src/main/resources/static/js/modules/products/stock/productStock.js

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
