//src/main/resources/static/js/modules/rent/rentReport/rentStatusFilter.js

function getRentByStatus(status) {
    let url = "/api/v1/rent/rent-by-status?rentStatus=" + encodeURIComponent(status);
    ajaxRequestTypeGet(url, renderRentTableReport);
}