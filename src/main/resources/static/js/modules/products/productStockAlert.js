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

//This file contain product-related stock alert functions.
//src/main/resources/static/js/modules/products/productStockAlert.js

/**
 * Method: Confirmation message for changing stock
 */
//document.getElementById('editItemQtyAvailable').addEventListener('change', stockAlert);

//(Modal) Send the data by clicking on submit button
$('#editItemQtyAvailable').on('change', function(e) {
    let confirmationMsg = "ESTE ALERTA AINDA NAO ESTA FUNCIONANDO CORRETAMENTE! \n Você tem certeza eu deseja alterar o Estoque?";

    if (!confirm(confirmationMsg)) {
        e.preventDefault();
        e.stopPropagation();
        alert('ESTE ALERTA AINDA NAO ESTA FUNCIONANDO CORRETAMENTE! \NOperação cancelada!');
        return false; // Interrompe a execução da função
    }
});
