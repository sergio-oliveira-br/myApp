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

//Methods related to the modal of editing expenses.
//src/main/resources/static/js/modules/expenses/expensesModal.js

/**
 * Page: Expense
 * Item: Form (modal) -> OpenEditModal() -> SubmitEditForm()
 * Method: This is a jQuery method that allows the user to make asynchronous requests to the server
 * to send or receive data without having to reload the page
 */
function openEditModal(expenseId) {
    ajaxRequest('/expense/' + expenseId, function (expense) {
        console.log(expense);

        $('#editExpenseId').val(expenseId);
        $('#editExpenseDescription').val(expense.expenseDescription);
        $('#editExpenseAmount').val(expense.expenseAmount);
        $('#editExpenseDate').val(expense.expenseDate);
        $('#editExpenseCategory').val(expense.expenseCategory);
        $('#editExpenseAdditionalNotes').val(expense.expenseAdditionalNotes);

        // Open the modal
        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}

/**
 * Page: Expense
 * Item: Form (modal) -> Submit
 * Method: Submit the form with updated expense data
 */
function submitEditForm() {
    let itemData = {
        id: $('#editExpenseId').val(),
        expenseDescription: $('#editExpenseDescription').val(),
        expenseAmount: parseFloat($('#editExpenseAmount').val()),
        expenseDate: $('#editExpenseDate').val(),
        expenseCategory: $('#editExpenseCategory').val(),
        expenseAdditionalNotes: $('#editExpenseAdditionalNotes').val()
    };

    console.log(itemData);

    $.ajax({
        url: '/expense/' + itemData.id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(itemData),

        success: function (response) {
            let msg = "Despesa alterada com sucesso";
            alert(msg);
            console.log(msg + response);

            $('#editModal').modal('hide');

            loadExpenseTable();
        },

        error: function (xhr, status, error) {
            console.error("Error: " + error);
            alert('Error: ' + xhr.responseText + " | Mensagem: " + error.responseText);
        }
    });
}
