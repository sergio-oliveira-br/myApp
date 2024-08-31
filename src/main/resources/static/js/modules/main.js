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

//The main.js should act as the starting point for running and configuring your project.
//It should import and coordinate the JavaScript modules you have created
//to ensure that your application’s functionality is well structured and easy to maintain.
//src/main/resources/static/js/modules/main.js

//Import functions from modules

/**
 * Function to initialize the application on document ready.
 */
$(document).ready(function () {
    // Initialize the application
    initializeApp();

    // Setup event listeners for user interactions
    setupEventListeners();
});


// //Main function for initialization
// $(document).ready(function() {
//     //Load initial data
//     // loadProductListByProductType('default'); // Exemplo de uso inicial
//     // loadCustomers('#customerSelect'); // Exemplo de uso inicial
//
//     //General settings
//     setupEventListeners();
//
// });

//Function to configure event listeners
function setupEventListeners() {

}


//*********




/**
 * Initialization function for setting up the application.
 */
function initializeApp() {
    // Initialize dashboard charts
    initializeDashboard();

    // Other initialization tasks can be added here
    console.log("Application initialized.");
}


/**
 * Function to initialize the dashboard by loading data and rendering charts.
 */
function initializeDashboard() {
    //Load and render charts on the dashboard
    ajaxRequest('/items-total-price', renderItemsChart);
    ajaxRequest('/item-quantity', renderQtyItemsChart);
    ajaxRequest('/rent-payment-status', renderPaymentChart);

}
