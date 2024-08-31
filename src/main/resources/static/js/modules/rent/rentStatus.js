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

//Methods related to the status and amount of rents.
//src/main/resources/static/js/modules/rent/rentStatus.js

/**
 * Method: Obtain the number of rent which the status is UNPAID
 */
function loadQtyRentByPaymentStatus(paymentStatus) {
    let url = `/qtyRentByPaymentStatus?paymentStatus=${encodeURIComponent(paymentStatus)}`;

    let selectors = {
        'Pendente': '#loadRentUnpaid'
    };

    let selector = selectors[paymentStatus];

    if (!selector) {
        console.warn(`No selector found for status: ${paymentStatus}`);
        return;
    }

    ajaxRequest(url, function(data) {
        $(selector).text('Voce possui ' + data + ' aluguéis com pagamentos "' + paymentStatus + '".');
    });
}

/**
 * Method: Obtain the number of rent which the status are "Novo", "Em andamento" or "Encerrado"
 */
function loadQtyRentByStatus(status) {
    let url = `/qtyRentByStatus?rentStatus=${encodeURIComponent(status)}`;

    let selectors = {
        'Novo': '#loadRentStatusNew',
        'Em andamento': '#loadRentStatusInProgress'
    };

    let selector = selectors[status];

    if (!selector) {
        console.warn(`No selector found for status: ${status}`);
        return;
    }

    ajaxRequest(url, function(data) {
        $(selector).text('Voce possui ' + data + ' aluguéis com o status "' + status + '".');
    });
}
