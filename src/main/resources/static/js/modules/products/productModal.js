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
function openProductEditModal(productId) {
    ajaxRequest("/api/v1/product/" + productId, function(product) {
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
function submitProductEditForm() {
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

    console.log(itemData);

    $.ajax({
        url: "/api/v1/update-product/" + itemData.id,
        type: "PUT",
        contentType: 'application/json',
        data: JSON.stringify(itemData),

        success: function(response) {
            let successMsg = "Produto alterado com sucesso.";

            alert(successMsg);
            console.log(successMsg, currentDate);

            $('#editModal').modal('hide');

            loadProductTable(); // Reload the product list after update
        },
        error: function(xhr, status, error) {
            try {
                let response = JSON.parse(xhr.responseText);
                alert('Oops! Ocorreu um erro. ' + response);
            }
            catch (parseError) {
                console.log('Análise do erro:', parseError);
            }
        }
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
        console.log(cancelMsg);
    }
});
