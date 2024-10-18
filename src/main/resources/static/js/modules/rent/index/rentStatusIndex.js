//src/main/resources/static/js/modules/rent/rentStatusIndex.js

function loadQtyRentByPaymentStatus(paymentStatus) {

    let url = `/api/v1/rent/qty/rent-by-payment-status?paymentStatus=${encodeURIComponent(paymentStatus)}`;

    let selectors = {
        'Pendente': '#loadRentUnpaid'
    };

    let selector = selectors[paymentStatus];

    if (!selector) {
        console.warn(`No selector found for status: ${paymentStatus}`);
        return;
    }

    ajaxRequestTypeGet(url, function(data) {
        $(selector).text('Voce possui ' + data + ' aluguéis com pagamentos "' + paymentStatus + '".');
    });
}


function loadQtyRentByStatus(status) {
    let url = `/api/v1/rent/qty/rent-by-status?status=${encodeURIComponent(status)}`;

    let selectors = {
        'Novo': '#loadRentStatusNew',
        'Em andamento': '#loadRentStatusInProgress'
    };

    let selector = selectors[status];

    if (!selector) {
        console.warn(`No selector found for status: ${status}`);
        return;
    }

    ajaxRequestTypeGet(url, function(data) {
        console.log("este e o data -->  " + data);
        $(selector).text('Voce possui ' + data + ' aluguéis com o status "' + status + '".');
    });
}
