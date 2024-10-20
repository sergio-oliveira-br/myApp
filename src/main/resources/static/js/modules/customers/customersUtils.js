//src/main/resources/static/js/modules/customers/customersUtils.js

function loadCustomersListForm(selectId) {
    ajaxRequestTypeGet("/api/v1/customer", function(data) {
        const rentCustomerSelect = $(selectId);

        rentCustomerSelect.empty();
        data.forEach(function(customer) {
            rentCustomerSelect.append(`<option value="${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}">
                ${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}</option>`
            );
        });
    });
}