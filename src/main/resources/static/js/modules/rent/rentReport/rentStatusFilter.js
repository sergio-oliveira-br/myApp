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

//Methods to filter rentals by general status. (novo, em andamento, encerrado)
//src/main/resources/static/js/modules/rent/rentReport/rentStatusFilter.js

/**
 * Page: Rent
 * Item: Table
 * Method: Filter rents by rent status
 */
function getRentByStatus(status) {
    let url = "/rentByStatus?rentStatus=" + encodeURIComponent(status);
    ajaxRequest(url, renderRentTableReport);
}