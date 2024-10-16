//src/main/resources/static/js/modules/customers/customerTable.js

function loadCustomersTable() {
    ajaxRequest("/api/v1/customer", function (data) {
        // First clean
        $('#customerList').empty();

        //Iteration
        data.forEach(function (customer) {
            $('#customerList').append('<tr>' +
                '<td>' + customer.id + '</td>' +
                '<td>' + customer.firstName + '</td>' +
                '<td>' + customer.lastName + '</td>' +
                '<td>' + customer.phoneNumber + '</td>' +
                '<td>' + customer.city + '</td>' +
                '<td>' + customer.additionalInfo + '</td>' +
                '</tr>');
        });
    });
}
