//src/main/resources/static/js/modules/rent/rentModal.js

function updateRentDays() {
    let newStart = $('#editRentStarts').val();
    let newEnd = $('#editRentEnds').val();

    let newRentTotalDays = calculateRentDuration(newStart, newEnd);
    console.log("New Total Days has been calculated: " + newRentTotalDays);

    $('#editRentTotalDays').val(newRentTotalDays);
}
//Update everytime that one of these two field is changed
document.getElementById('editRentStarts').addEventListener('change',updateRentDays);
document.getElementById('editRentEnds').addEventListener('change',updateRentDays);


function updateTotalPrice() {
    let newRentPriceModal = parseFloat($('#editRentPrice').val().replace(',', '.')) || 0;
    let newRentQtyItemModal = parseInt($('#editRentQtyItem').val()) || 0;
    let newRentTotalDaysModal = parseInt($('#editRentTotalDays').val());

    let newRentTotalPriceModal = (newRentPriceModal * newRentQtyItemModal * newRentTotalDaysModal);

    $('#editRentTotalPrice').val(newRentTotalPriceModal.toFixed(2));
}


function populateRentModal(rentId) {

    ajaxRequestTypeGet("/api/v1/rent/" + rentId, function(rent) {
        $('#editRentId').val(rent.id);
        $('#editRentFirstName').val(rent.rentFirstName);
        $('#editRentLastName').val(rent.rentLastName);
        $('#editRentAddress').val(rent.rentAddress);
        $('#editRentItem').val(rent.rentItem);
        $('#editRentQtyItem').val(rent.rentQtyItem);
        $('#editRentPrice').val(rent.rentPrice);
        $('#editRentStarts').val(rent.rentStarts);
        $('#editRentEnds').val(rent.rentEnds);
        $('#editRentTotalDays').val(rent.rentTotalDays);
        $('#editRentTotalPrice').val(rent.rentTotalPrice.toFixed(2));
        $('#editRentPaymentStatus').val(rent.rentPaymentStatus);
        $('#editRentDetails').val(rent.rentDetails);
        $('#editRentStatus').val(rent.rentStatus);

        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}


function rentFormSubmissionModal() {

    let rentData = {
        id: $('#editRentId').val(),
        rentFirstName: $('#editRentFirstName').val(),
        rentLastName: $('#editRentLastName').val(),
        rentAddress: $('#editRentAddress').val(),
        rentItem: $('#editRentItem').val(),
        rentQtyItem: parseInt($('#editRentQtyItem').val()),
        rentPrice: parseFloat($('#editRentPrice').val()),
        rentStarts: $('#editRentStarts').val(),
        rentEnds: $('#editRentEnds').val(),
        rentTotalDays: parseInt($('#editRentTotalDays').val()),
        rentTotalPrice: parseFloat($('#editRentTotalPrice').val()),
        rentPaymentStatus: $('#editRentPaymentStatus').val(),
        rentDetails: $('#editRentDetails').val(),
        rentStatus: $('#editRentStatus').val()
    };

    ajaxRequestTypePut('/api/v1/rent/update-rent/' + rentData.id, rentData, function(response) {

       alert("Aluguel 'ID: " +rentData.id +  ", "  +  rentData.rentFirstName + "' alterado com sucesso!");
       $('#editModal').modal('hide');
       loadSalesTable();
    });
}