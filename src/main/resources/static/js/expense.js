// /**
//  * National College of Ireland - NCI
//  *    Higher Diploma in Computing
//  *         Final Project
//  *              ---
//  * Author: Sergio Vinicio da Silva Oliveira
//  * ID: x23170981@student.ncirl.ie
//  * Project Commencing May 2024
//  * Version: 1.0
//  */
//
// /** Load content when the page is loaded */
// $(document).ready(function () {
//  //load the table with all expenses
//  loadExpenseTable();
//
//  //Modal
//  $('#editModal').on('submit', function(e)
//  {
//   e.preventDefault();
//   submitEditForm();
//  })
//
// });
//
//
// /**
//  Page: Expense
//  Item: Table
//  Method: The script will load all expenses in a table
//  */
// function loadExpenseTable()
// {
//  //Call the generic method, that perform an Ajax Request
//  ajaxRequest("/expense", function (data){
//   //clean
//   $('#expenseTable').empty();
//
//   //Iteration
//   data.forEach(function(expense){
//    $('#expenseTable').append('<tr>' +
//     '<td>' + expense.id + '</td>' +
//     '<td>' + expense.expenseDescription + '</td>' +
//     '<td>' + expense.expenseAmount + '</td>' +
//     '<td>' + expense.expenseDate + '</td>' +
//     '<td>' + expense.expenseCategory + '</td>' +
//     '<td>' + expense.expenseAdditionalNotes + '</td>' +
//     '<td><button class="btn btn-primary" onclick="openEditModal(' + expense.id + ')">Edit</button></td>' +
//     '</tr>'
//    )
//   });
//  });
// }
//
//
// /**
//  Item: Form
//  Method: Send the customer data by using AJAX
//  */
// formSubmission('#expenseForm', '/saveExpense', expenseFormData, expenseSaveSuccess, saveError);
//
// //Get the form data from the form
// function expenseFormData()
// {
//  return {
//   expenseDescription: $('#expenseDescription').val(),
//   expenseAmount: $('#expenseAmount').val(),
//   expenseDate: $('#expenseDate').val(),
//   expenseCategory: $('#expenseCategory').val(),
//   expenseAdditionalNotes: $('#expenseAdditionalNotes').val()
//  };
// }
//
// /**
//  Item: Form, Save
//  Method: Callback function for success
//  */
// function expenseSaveSuccess(response)
// {
//  alert('Despesa adicionada com sucesso!');
//  console.log(response);
//  loadExpenseTable(); //update the customer table
//
//  //Clear the form by resetting it
//  document.getElementById('expenseForm').reset();
// }
//
//
// /**
//  Page: Expense
//  Item: Form (modal) -> OpenEditModal() -> SubmitEditForm()
//  Method: This is a jQuery method that allows
//  the user to make asynchronous requests to the server
//  to send or receive data without having to reload the page
//  (There is a confirmation msg method as well)
//  */
// function openEditModal(expenseId){
//  //call the ajaxRequest method, and the GET approach will retrieve the data
//  ajaxRequest('/expense/' + expenseId, function (expense){
//   console.log(expense);
//
//   $('#editExpenseId').val(expenseId);
//   $('#editExpenseDescription').val(expense.expenseDescription);
//   $('#editExpenseAmount').val(expense.expenseAmount);
//   $('#editExpenseDate').val(expense.expenseDate);
//   $('#editExpenseCategory').val(expense.expenseCategory);
//   $('#editExpenseAdditionalNotes').val(expense.expenseAdditionalNotes);
//
//   //open the modal
//   let editModal = new bootstrap.Modal(document.getElementById('editModal'));
//   editModal.show();
//  });
// }
//
// function submitEditForm(){
//  let itemData = {
//   id: $('#editExpenseId').val(),
//   expenseDescription: $('#editExpenseDescription').val(),
//   expenseAmount: parseFloat($('#editExpenseAmount').val()),
//   expenseDate: $('#editExpenseDate').val(),
//   expenseCategory: $('#editExpenseCategory').val(),
//   expenseAdditionalNotes: $('#editExpenseAdditionalNotes').val()
//  };
//
//  console.log(itemData);
//
//  //Remember: PUT -> Send data to the server to update an existing resource
//  $.ajax({url:'/expense/' + itemData.id,
//   type: 'PUT',
//   contentType: 'application/json',
//   data: JSON.stringify(itemData),
//
//   success: function(response){
//   let msg = "Despesa alterada com sucesso";
//    alert(msg);
//    console.log(msg + response);
//
//    $('#editModal').modal('hide');
//
//    loadExpenseTable();
//   },
//
//    error: function(xhr, status, error) {
//    console.error("Error: " + error);
//    alert('Error: ' + xhr.responseText + " | Mensagem: " + error.responseText );
//   }
//  });
// }
//
// //maybe call a confirmation msg
//
