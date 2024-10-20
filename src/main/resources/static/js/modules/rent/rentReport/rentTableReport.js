//src/main/resources/static/js/modules/rent/rentReport/rentTableReport.js

function renderRentTableReport(data) {
    //clean
    $('#rentList').empty();

    //iteration
    data.forEach(function (rent) {
        $('#rentList').append('<tr>' +
            '<td>' + rent.id + '</td>' +
            '<td>' + rent.rentFirstName + '</td>' +
            '<td>' + rent.rentAddress + '</td>' +
            '<td>' + rent.rentItem + '</td>' +
            '<td>' + rent.rentQtyItem + '</td>' +
            '<td>' + rent.rentPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
            '<td>' + rent.rentStarts + '</td>' +
            '<td>' + rent.rentEnds + '</td>' +
            '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
            '<td>' + rent.rentPaymentStatus + '</td>' +
            '<td>' + rent.rentStatus + '</td>' +
            '<td>' + rent.rentDetails + '</td>' +
            '</tr>'
        );
    });
}