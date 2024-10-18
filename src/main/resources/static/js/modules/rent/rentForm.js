//src/main/resources/static/js/modules/rent/rentForm.js

submitForm('#rentForm', '/api/v1/rent/create-rent', rentFormData, rentSaveSuccess);

function rentFormData() {
    return {
        rentFirstName: $('#rentFirstName').val(),
        rentAddress: $('#rentAddress').val(),
        rentItem: $('#rentItem').val(),
        rentQtyItem: $('#rentQtyItem').val(),
        rentPrice: $('#rentPrice').val(),
        rentStarts: $('#rentStarts').val(),
        rentEnds: $('#rentEnds').val(),
        rentTotalDays: $('#rentTotalDays').val(),
        rentTotalPrice: parseFloat($('#rentTotalPrice').val()),
        rentPaymentStatus: $('#rentPaymentStatus').val(),
        rentDetails: $('#rentDetails').val(),
        rentStatus: $('#rentStatus').val()
    };
}

function rentSaveSuccess(response) {
    alert('Aluguel criado com sucesso!');
    loadRentTable(); // Update the rent table
}