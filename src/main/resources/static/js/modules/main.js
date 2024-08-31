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
import { loadProductListByProductType } from './sales/salesForm.js';
import { loadCustomers } from './customer/customerUtils.js';


//Main function for initialization
$(document).ready(function() {
    //Load initial data
    // loadProductListByProductType('default'); // Exemplo de uso inicial
    // loadCustomers('#customerSelect'); // Exemplo de uso inicial

    //General settings
    setupEventListeners();

});

//Function to configure event listeners
function setupEventListeners() {
    // Adiciona ouvintes de eventos globais, se necessário
    $('#exampleButton').on('click', function() {
        alert('Button clicked!');
    });

    // Outras configurações ou inicializações
    // Por exemplo, configurações de plugins, eventos personalizados, etc.
}
