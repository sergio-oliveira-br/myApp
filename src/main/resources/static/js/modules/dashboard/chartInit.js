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

//Method to initialize the dashboard and make AJAX calls to load the data.
//src/main/resources/static/js/modules/dashboard/chartInit.js

/**
 * Page: Dashboard
 * Item: Initialization
 * Method: Load data and render charts
 */
$(document).ready(function () {
    ajaxRequest('/items-total-price', renderItemsChart);
    ajaxRequest('/rent-payment-status', renderPaymentChart);
    ajaxRequest('/item-quantity', renderQtyItemsChart);
});
