//src/main/resources/static/js/modules/expenses/expensesTable.js

function loadExpenseTable() {

    ajaxRequestTypeGet("/api/v1/expense", function (data) {

        $('#expenseTable').empty();

        data.forEach(function (expense) {
            $('#expenseTable').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
                '<td><button class="btn btn-primary" onclick="openExpenseEditModal(' + expense.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}
