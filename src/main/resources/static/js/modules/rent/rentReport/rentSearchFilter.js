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

//Methods to search rentals by name or date.
//src/main/resources/static/js/modules/rent/rentReport/rentSearchFilter.js

/**
 * Page: Rent
 * Item: Search and Display
 * Method: Search rents by name or date.
 */
function searchRent() {
    let year = $('#yearInput').val();
    let month = $('#monthInput').val();
    let name = $('#nameInput').val();

    if (name) {
        if (year || month) {
            alert('Desculpe! Não é possível combinar nome e data ainda.' +
                '\nPor favor tente pesquisar apenas pelo nome ou pela data composta por mês e ano.');
        } else {
            getRentByName(name + '%'); // Finds any values that start with "name"
        }
    } else if (year && month) {
        getRentByMonth(year, month);
    } else {
        alert("Desculpe! Para pesquisar, por favor entre com o Nome ou a combinação de Mês e Ano.");
    }
}

/**
 * Page: Rent Report
 * Item: Table -> Date (Month and Year) in NAVBAR
 * Method: Filter rents by selecting month and year
 */
function getRentByMonth(year, month) {
    let url = "/api/v1/rent/rent-by-date?year=" + encodeURIComponent(year) + "&month=" + encodeURIComponent(month);
    ajaxRequest(url, renderRentTableReport);
}

/**
 * Page: Rent Report
 * Item: Table -> Search (Name) in NAVBAR
 * Method: Filter rents by name
 */
function getRentByName(name) {
    let url = "/api/v1/rent/rent-by-name?customerName=" + encodeURIComponent(name);
    ajaxRequest(url, renderRentTableReport);
}
