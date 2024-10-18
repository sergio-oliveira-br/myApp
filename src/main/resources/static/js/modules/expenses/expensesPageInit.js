//src/main/resources/static/js/modules/expenses/expensesPageInit.js

$(document).ready(function () {
    //Load the table
    loadExpenseTable();

    //(Modal) Send the data by clicking on submit button
    $('#editModal').on('submit', function(e) {
        e.preventDefault();
    });
})