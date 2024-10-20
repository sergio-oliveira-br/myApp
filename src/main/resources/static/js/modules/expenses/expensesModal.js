//src/main/resources/static/js/modules/expenses/expensesModal.js

function openExpenseEditModal(expenseId) {

    ajaxRequestTypeGet('/api/v1/expense/' + expenseId, function (expense) {
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


function submitExpenseEditForm() {

    let itemData = {
        id: $('#editExpenseId').val(),
        expenseDescription: $('#editExpenseDescription').val(),
        expenseAmount: parseFloat($('#editExpenseAmount').val()),
        expenseDate: $('#editExpenseDate').val(),
        expenseCategory: $('#editExpenseCategory').val(),
        expenseAdditionalNotes: $('#editExpenseAdditionalNotes').val()
    };

    ajaxRequestTypePut('/api/v1/expense/update-expense/' + itemData.id, itemData, function (response) {
        alert('Despesa alterada com sucesso!');
        $('#editModal').modal('hide');
        loadExpenseTable();
    })
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
    }
})
