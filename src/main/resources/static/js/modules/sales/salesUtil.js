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

//This file contains utility functions for sales-related calculations.
//src/main/resources/static/js/modules/sales/salesUtil.js

/**
 * Method: Calculate the total price by multiplying (qty x unit price)
 */
function loadTotalPriceSales() {
    let qty = document.getElementById('saleQtyItem').value;
    let unitPrice = parseFloat(document.getElementById('salePrice').value);
    let finalTotalPrice = parseFloat(qty * unitPrice);

    document.getElementById('saleTotalPrice').value = finalTotalPrice.toFixed(2);
    console.log("Final Price Calculated: " + finalTotalPrice);
}
// Update the total price when these fields change
document.getElementById('saleItem').addEventListener('change', loadTotalPriceSales);
document.getElementById('saleQtyItem').addEventListener('change', loadTotalPriceSales);