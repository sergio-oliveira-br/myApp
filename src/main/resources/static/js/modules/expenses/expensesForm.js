//src/main/resources/static/js/modules/expenses/expensesForm.js

submitForm('#expenseForm', '/api/v1/expense/create-expense', expenseFormData, expenseSaveSuccess);

function expenseFormData() {
    return {
        expenseDescription: $('#expenseDescription').val(),
        expenseAmount: $('#expenseAmount').val(),
        expenseDate: $('#expenseDate').val(),
        expenseCategory: $('#expenseCategory').val(),
        expenseAdditionalNotes: $('#expenseAdditionalNotes').val()
    };
}

function expenseSaveSuccess(response) {
    alert('Despesa adicionada com sucesso!');
    loadExpenseTable(); // update the expense table
}
