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

// Method to initialize the dashboard and make AJAX calls to load the data.
// src/main/resources/static/js/modules/dashboard/dashboardRentPageInit.js

/**
 * Page: Dashboard
 * Item: Initialization
 * Method: Load data and render charts
 */
$(document).ready(function () {
    ajaxRequestTypeGet('/items-total-price', renderItemsChart);
    ajaxRequestTypeGet('/rent-payment-status', renderPaymentChart);
    ajaxRequestTypeGet('/item-quantity', renderQtyItemsChart);
});

/**
 Separation of Concerns: This approach separates the logic for rendering charts (JavaScript)
    from the application's main functionalities (potentially handled by Java code).
    This makes the code more maintainable and easier to understand.

 Modularity: Individual chart rendering functions become reusable components
    that can be used in different parts of the application without duplication.

 Efficiency: JavaScript libraries can handle chart rendering more efficiently than server-side Java code.

 Client-Side Interactions: This approach allows for interactive charts
    that can be manipulated by the user without additional server requests.
 */