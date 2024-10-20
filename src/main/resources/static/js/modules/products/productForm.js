//src/main/resources/static/js/modules/products/productForm.js

submitForm('#itemForm', '/api/v1/product/create-product', productFormData, productSaveSuccess);

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

function productSaveSuccess(response) {
    alert('Produto salvo com sucesso!');
    loadProductTable(); //update the product table
}




