//src/main/resources/static/js/modules/rent/rentReport/rentPaymentStatusFilter.js

function getRentByPaymentStatus(status) {
    let url = "/api/v1/rent/rent-by-payment-status?paymentStatus=" + encodeURIComponent(status);
    ajaxRequestTypeGet(url, renderRentTableReport);
}


