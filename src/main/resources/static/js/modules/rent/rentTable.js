//src/main/resources/static/js/modules/rent/rentTable.js

function loadRentTable() {
    ajaxRequestTypeGet("/api/v1/rent", function(data) {
        $('#rentList').empty(); // First clean
        data.forEach(function(rent) {
            $('#rentList').append('<tr>' +
                '<td>' + rent.id + '</td>' +
                '<td>' + rent.rentFirstName + '</td>' +
                '<td>' + rent.rentItem + '</td>' +
                '<td>' + rent.rentQtyItem + '</td>' +
                // '<td>' + rent.rentPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
                '<td>' + rent.rentStarts + '</td>' +
                '<td>' + rent.rentEnds + '</td>' +
                '<td>' + rent.rentTotalDays + '</td>' +
                '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + // Formatting to two decimal places
                '<td><button class="btn btn-primary" onclick="populateRentModal(' + rent.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}









