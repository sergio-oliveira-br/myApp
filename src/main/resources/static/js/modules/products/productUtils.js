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

//This file contain product-related utility functions.
//src/main/resources/static/js/modules/products/productUtils.js

/**
 * Method: Confirmation message for changing stock
 */
document.getElementById('editItemQtyAvailable').addEventListener('change', stockAlert);
function stockAlert() {
    let confirmationMsg = "Você tem certeza eu deseja alterar o Estoque?";
    if (confirm(confirmationMsg)) {
        submitEditForm(); // Send the data after confirmation from the user
    } else {
        alert('Operação cancelada!');
    }
}
