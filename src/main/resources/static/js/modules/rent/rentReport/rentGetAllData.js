//src/main/resources/static/js/modules/rent/rentReport/rentGetAllData.js

function getAllRent() {
    ajaxRequestTypeGet("/api/v1/rent", renderRentTableReport);
}