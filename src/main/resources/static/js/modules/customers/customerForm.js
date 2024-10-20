//src/main/resources/static/js/modules/customers/customerForm.js

submitForm('#customerForm', '/api/v1/customer/create-customer', customerFormData, customerSaveSuccess);


function customerFormData() {
    return {
        firstName: $('#customerFirstName').val(),
        lastName: $('#customerLastName').val(),
        phoneNumber: $('#customerPhoneNumber').val(),
        additionalInfo: $('#additionalInformation').val(),
        city: $('#customerCity').val()
    };
}


function customerSaveSuccess(response) {
    alert('Cliente salvo com sucesso!');
    loadCustomersTable();
}
