//src/main/resources/static/js/modules/products/productUtils.js


function loadProductListByProductType(productType) {
    ajaxRequestTypeGet("/api/v1/product/product-by-type?productType=" + encodeURIComponent(productType), function(data) {

        // Array of select elements
        let productSelects = [$('#rentItem'), $('#editRentItem'),        //rent
            $('#saleItem'), $('#editSaleItem')];                               //sales

        productSelects.forEach(function (selectElement) {
            selectElement.empty();
            data.forEach(function (product) {
                selectElement.append('<option id="' + product.id + '" price="' + product.itemPrice + '">'
                    + product.itemDescription + '</option>');
            });
        });
    });
}

// Update price when the user changes the item field
$('#rentItem, #editRentItem, #saleItem, #editSaleItem').change(function() {
    console.log('Change event triggered');

    let selectedOption = $(this).find(':selected');
    let price = selectedOption.attr('price');

    if ($(this).attr('id') === 'rentItem') {
        $('#rentPrice').val(price);
    }

    else if ($(this).attr('id') === 'editRentItem') {
        $('#editRentPrice').val(price);
        updateTotalPrice();
    }

    else if ($(this).attr('id') === 'saleItem') {
        $('#salePrice').val(price);
    }

    else if ($(this).attr('id') === 'editSaleItem') {
        $('#editSalePrice').val(price);
        updateTotalPriceSaleModal();
    }
});