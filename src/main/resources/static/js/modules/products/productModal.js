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

//This file deal with the logic related to the modality of editing products.
//src/main/resources/static/js/modules/products/productModal.js

/**
 * Page: Products
 * Item: Form (modal) -> OpenEditModal() -> SubmitEditForm()
 * Method: Open modal and load product data
 */
function openEditModal(productId) {
    ajaxRequest("/product/" + productId, function(product) {
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

/**
 * Method: Submit the edit form
 */
function submitEditForm() {
    let currentDate = new Date();
    let itemData = {
        id: $('#editProductId').val(),
        itemDescription: $('#editItemDescription').val(),
        itemQuantity: $('#editItemQty').val(),
        itemPrice: $('#editItemPrice').val(),
        productType: $('#editProductType').val(),
        itemAvailableQty: $('#editItemQtyAvailable').val(),
        dateModified: currentDate,
    };
    $.ajax({
        url: "/product/" + itemData.id,
        type: "PUT",
        contentType: 'application/json',
        data: JSON.stringify(itemData),
        success: function(response) {
            console.log('Item updated: ', response);
            alert('Item atualizado com sucesso!');
            $('#editModal').modal('hide');
            loadProduct(); // Reload the product list after update
        },
        error: function(xhr, status, error) {
            console.error(error);
            alert('Oops, não foi possivel realizar esta atualização! Erro: ' + xhr.responseText );
        }
    });
}

// Confirmation message for form submission
document.getElementById('editModal').addEventListener('submit', function(event) {
    let confirmation = confirm('Tem certeza de que deseja salvar as modificações?');
    if (confirmation) {
        submitEditForm();
    } else {
        event.preventDefault();
        console.log('Usuário cancelou a operação.')
    }
});
