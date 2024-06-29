/**
 * National College of Ireland - NCI
 *    Higher Diploma in Computing
 *         Final Project
 *              ---
 * Author: Sergio Vinicio da Silva Oliveira
 * ID: x23170981@student.ncirl.ie
 * Project Commencing May 2024
 * Version: 1.0
 */

/** Load content when the page is loaded */
$(document).ready(function ()
{
    //load the table with all expenses
    getAllExpenses();


});


/**
 Page: Expense Report
 Item: Table
 Method: The script will load all expenses in a table
    by clicking on filter by category
 */
function getExpensesByCategory(category)
{
    console.log("Category selected: " + category);

    //Build the URL
    let url = "/expensesByCategory?expenseCategory=" + category;

    //Call the Ajax request
    ajaxRequest(url, function (data)
    {
        //clean the table
        $('#expensesListReport').empty();

        //Iteration
        data.forEach(function (expense) {
            $('#expensesListReport').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
                '</tr>'
            );
        })
    });
}


/**
 Page: Expense Report
 Item: Table
 Method: The script will load all expenses in a table by clicking on without filter by ALL
 */
function getAllExpenses()
{
    //Call the Ajax Request
    ajaxRequest("/expense", function (data)
    {
        //clean the table
        $('#expensesListReport').empty();

        //Iteration
        data.forEach(function (expense) {
            $('#expensesListReport').append('<tr>' +
                '<td>' + expense.id + '</td>' +
                '<td>' + expense.expenseDescription + '</td>' +
                '<td>' + expense.expenseAmount + '</td>' +
                '<td>' + expense.expenseDate + '</td>' +
                '<td>' + expense.expenseCategory + '</td>' +
                '<td>' + expense.expenseAdditionalNotes + '</td>' +
            '</tr>');
        });
    });
}


