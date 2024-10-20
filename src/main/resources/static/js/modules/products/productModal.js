//src/main/resources/static/js/modules/products/productModal.js

function openProductEditModal(productId) {
    ajaxRequestTypeGet("/api/v1/product/" + productId, function(product) {
        $('#editProductId').val(productId);
        $('#editItemDescription').val(product.itemDescription);
        $('#editItemQty').val(product.itemQuantity);
        $('#editItemPrice').val(product.itemPrice);
        $('#editProductType').val(product.productType);
        $('#editItemQtyAvailable').val(product.itemAvailableQty);
        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}


function submitProductEditForm() {
    let currentDate = new Date();

    let formData = {
        id: $('#editProductId').val(),
        itemDescription: $('#editItemDescription').val(),
        itemQuantity: $('#editItemQty').val(),
        itemPrice: $('#editItemPrice').val(),
        productType: $('#editProductType').val(),
        itemAvailableQty: $('#editItemQtyAvailable').val(),
        dateModified: currentDate,
    };

    ajaxRequestTypePut("/api/v1/product/update-product/" + formData.id, formData, function(response) {
        alert('Produto alterado com sucesso!');
        $('#editModal').modal('hide');
        loadProductTable(); // Reload the product list after update
    });
}

// Confirmation message for form submission
document.getElementById('editModal').addEventListener('submit', function(event) {
    let confirmation = confirm('Tem certeza de que deseja salvar as modificações?');

    if (confirmation) {
        submitProductEditForm();
    }
    else {
        event.preventDefault();
        $('#editModal').modal('hide');//close the modal

        //Build and print a message
        let cancelMsg = 'Operaçao cancelada pelo usuario! \nOs dados não foram alterados.';
        alert(cancelMsg)
    }
});
