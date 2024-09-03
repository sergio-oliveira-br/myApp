/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie, oliveira-sergio@outlook.com
 * Project Commencing May 2024 | Version: 1.0
 * Refactoring & New Features - Aug 2024 | Version: 2.0
 */

//This file handles the submission of the rental form and updating the rent table.
//src/main/resources/static/js/modules/rent/rentForm.js

/**
 * Method: Send the order (rent or sale) data by using AJAX
 */
formSubmission('#rentForm', '/saveRent', orderFormData, orderSaveSuccess);

/**
 * Get the form data from the form
 */
function orderFormData() {
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

/**
 * Callback function for success
 */
function orderSaveSuccess(response) {
    alert('Aluguel criado com sucesso!');
    console.log(response);
    loadRentTable(); // Update the rent table

    // Clear the form by resetting it
    document.getElementById('rentForm').reset();
}


/**
 * (MODAL) The script will load the available items and customers in the rental form when the page loads
 */
$('#editRentForm').on('submit', function(e) {
    e.preventDefault(); // Prevents the standard form submission
    // submitExpenseEditForm(); refatorei o nome incluido a palavraExpense para separar os metodos que estao misturados
    $('#displayRentModal').modal('hide');
});


// /**
//  * Page: Rent and Index
//  * Item: Form (modal) -> Field Customer
//  * Method: The script will load the available customers in the rental form when the page loads
//  */
// function updateLoadCustomerForRentForm() {
//     ajaxRequest("/customers", function(data) {
//         var rentCustomerSelect = $('#editRentFirstName');
//         rentCustomerSelect.empty();
//
//         data.forEach(function(customer) {
//             rentCustomerSelect.append('<option value="' + customer.firstName + " " + customer.lastName + " - " + customer.phoneNumber + '">' +
//                 customer.firstName + " " + customer.lastName + " - " + customer.phoneNumber + '</option>');
//         });
//     });
// }

/**
 * Page: Rent and Index
 * Item: Form (modal) -> Edit Rent Status
 * Method: This update the stock, adding the qty in to stock available
 */
function updateRentStatus() {
    let rentId = $('#editRentId').val();
    console.log(rentId);

    let status = $('#editRentStatus').val();
    console.log(status);

    $.ajax({
        url: "/rent/status/" + rentId + "?rentStatus=" + status,
        type: 'PUT',
        data: { status: status },

        success: function(response) {
            console.log(response);
            $('#editRentForm').modal('hide');
        },
        error: function(xhr, status, error) {
            console.error("Erro ao atualizar o status do aluguel.| Error:" + error);
        }
    });
}
