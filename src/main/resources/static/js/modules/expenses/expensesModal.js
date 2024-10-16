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
function openExpenseEditModal(expenseId) {
    ajaxRequestTypeGet('/api/v1/expense/' + expenseId, function (expense) {
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
function submitExpenseEditForm() {
    let currentDate = new Date();

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
        url: '/api/v1/expense/update-expense/' + itemData.id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(itemData),

        success: function (response) {
            let successMsg = "Despesa alterada com sucesso";

            alert(successMsg);
            console.log(successMsg, currentDate);

            $('#editModal').modal('hide');//close the modal

            loadExpenseTable();//Reload the table
        },

        error: function (xhr, status, error) {
            try {
                let response = JSON.parse(xhr.responseText);
                alert('Oops! Ocorreu um erro. ' + response);
            }
            catch (parseError) {
                console.log('Análise do erro: ', parseError);
            }
        }
    });
}

//Confirmation message for form submission
document.getElementById('editModal').addEventListener('submit', function (event) {
    let confirmationMsg = confirm('Tem certeza de que deseja salvar as modificações?');

    if(confirmationMsg){
        submitExpenseEditForm();
    }
    else {
        event.preventDefault();//The method cancels the event if it is cancelable
        $('#editModal').modal('hide');//close the modal

        //Build and print a message
        let cancelMsg = 'Operaçao cancelada pelo usuario! \nOs dados não foram alterados.';
        alert(cancelMsg)
        console.log(cancelMsg);
    }
})
