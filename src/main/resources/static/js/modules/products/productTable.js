//src/main/resources/static/js/modules/products/productTable.js

function loadProductTable() {
    ajaxRequestTypeGet("/api/v1/product", function(data) {
        $('#productList').empty();

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