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

//This file is responsible for loading and rendering the rent table on RENT REPORT PAGE.
//src/main/resources/static/js/modules/rent/rentReport/rentGetAllData.js

/**
 * Page: Rent Report
 * Item: Table
 * Method: Load all rent records
 */
function getAllRent() {
    ajaxRequest("/rent", renderRentTableReport);
}