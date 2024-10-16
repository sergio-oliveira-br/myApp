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
//
// /**
//  Page: Rent
//  Item: Table
//  Method: Create a table with
//  all customers via AJAX
//  */
//
// $(document).ready(function()
// {
//     loadRent();
//
//     loadRentDays();
//
//     //The script will load the available customers in the rental form when the page loads
//     // loadCustomerForRentForm(); //This is for original form
//     loadCustomers('#rentFirstName');
//
//     //The script will load the available items in the rental form when the page loads
//     // loadItemsForRentForm();
//     //load the items witch are classified as "Aluguel" em productType
//     loadProductListByProductType('Aluguel');
//     // loadEditItemsForRentFormModal(); //This is for edit modal
//
//     //(Modal)The script will load the available items in the rental form when the page loads
//     updateLoadCustomerForRentForm();
//
//     //(Modal)Update the rent status, if is "Finished", the item stock will return to total available
//     $('#editRentStatus').on('change', function() {
//         console.log('Rent Status Changed');
//         updateRentStatus();
//     });
//
//     //(Modal)Update total price when price or quantity change
//     $('#editRentPrice, #editRentQtyItem, #editRentStarts, #editRentEnds').on('change', function() {
//         console.log('Price or Quantity input changed');
//         updateTotalPrice();
//     });
//
//     //(Modal)Update total price when dates change
//     $('#editRentStarts, #editRentEnds').on('change', function() {
//         console.log('Start or End date changed');
//         //loadRentDays();
//         updateRentDays();
//     });
//
//     //(Modal)
//     $('#editRentForm').on('submit', function(e) {
//         e.preventDefault();
//         submitEditForm();
//     });
// });
//
//
// /**
//  Page: Rent
//  Item: Table
//  Method: The script will load all items in a table
//  */
// function loadRent() {
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/rent", function(data) {
//         //first clean
//         $('#rentList').empty();
//
//         //Iteration
//         data.forEach(function(rent) {
//             $('#rentList').append('<tr>' +
//                 '<td>' + rent.id + '</td>' +
//                 '<td>' + rent.rentFirstName + '</td>' +
//                 '<td>' + rent.rentAddress + '</td>' +
//                 '<td>' + rent.rentItem + '</td>' +
//                 '<td>' + rent.rentQtyItem + '</td>' +
//                 '<td>' + rent.rentPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
//                 '<td>' + rent.rentStarts + '</td>' +
//                 '<td>' + rent.rentEnds + '</td>' +
//                 '<td>' + rent.rentTotalDays + '</td>' +
//                 '<td>' + rent.rentTotalPrice.toFixed(2) + '</td>' + //Formatting to two decimal places
//                 '<td><button class="btn btn-primary" onclick="openEditModal(' + rent.id + ')">Edit</button></td>' +
//                 '</tr>'
//             )
//         });
//     });
// }
//
//
// /**
//  Page: Rent
//  Item: Form -> Days = (End - Start)
//  Method: Simple math to calculate the days
//  */
// function mathDays(end, start) {
//     let start_Date = new Date(start);
//     let end_Date = new Date(end);
//     let diffTime = Math.abs(end_Date - start_Date);
//     let diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
//
//     return diffDays;
// }
//
//
//
// /**
//  Page: Rent
//  Item: Form -> Days = (End - Start)
//  Method: applying the mathDays method
//  */
// function loadRentDays() {
//     //Variables
//     let newStart = document.getElementById('rentStarts').value;
//     let newEnd = document.getElementById('rentEnds').value;
//
//     //Call the method
//     let rentTotalDays = mathDays(newEnd, newStart);
//
//     //Write in the field
//     document.getElementById('rentTotalDays').value = rentTotalDays;
//     console.log("The days has been calculated", rentTotalDays);
//
//     //update the rentTotalPrice every time that any date has been changed
//     loadTotalPrice();
// }
//
//
// /**
//  Page: Rent
//  Item: Form -> Total Price = (Days * Qty * UnitPrice)
//  Method: Simple math to calculate the total price and update
//  */
// function loadTotalPrice() {
//     //Variable
//     let newTotalDays = parseInt(document.getElementById('rentTotalDays').value);
//     let newTotalQty = parseInt(document.getElementById('rentQtyItem').value);
//     let newUnitPrice = parseFloat(document.getElementById('rentPrice').value); //this is a float number
//
//     //Calculating
//     let newRentTotalPrice = (newTotalDays * newTotalQty * newUnitPrice);
//
//     //Write the field
//     document.getElementById('rentTotalPrice').value = newRentTotalPrice.toFixed(2);
//     console.log("The Rent Total Price was calculated by loadTotalPrice(). Result: " + newRentTotalPrice.toFixed(2));
// }
//
// //Update everytime that one of these five field is changed
// document.getElementById('rentTotalDays').addEventListener('change', loadTotalPrice);
// document.getElementById('rentQtyItem').addEventListener('change', loadTotalPrice);
// document.getElementById('rentPrice').addEventListener('change', loadTotalPrice);
//
// document.getElementById('rentStarts').addEventListener('change',loadRentDays);
// document.getElementById('rentEnds').addEventListener('change',loadRentDays);
//
//
// /**
//  Page: Rent
//  Item: Form (modal)
//  Method: Calculates the difference of the days
//  */
// function updateRentDays() {
//     //Get the variables from the modal
//     let newStart = $('#editRentStarts').val();
//     let newEnd = $('#editRentEnds').val();
//
//     //Call the method mathDays()
//     let newRentTotalDays = mathDays(newStart, newEnd);
//     console.log("New Total Days has been calculated: " + newRentTotalDays);
//
//     //Write in the field
//     $('#editRentTotalDays').val(newRentTotalDays);
//
// }
// //Update everytime that one of these two field is changed
// document.getElementById('editRentStarts').addEventListener('change',updateRentDays);
// document.getElementById('editRentEnds').addEventListener('change',updateRentDays);
//
//
//
// /**
//  Page: Rent
//  Item: Form (modal)
//  Method: Calculates the total price on Modal
//  */
// function updateTotalPrice() {
//     //Get the variables
//     let newRentPriceModal = parseFloat($('#editRentPrice').val().replace(',', '.')) || 0;
//     let newRentQtyItemModal = parseInt($('#editRentQtyItem').val()) || 0;
//     let newRentTotalDaysModal = parseInt($('#editRentTotalDays').val());
//
//     //Calculating
//     let newRentTotalPriceModal = (newRentPriceModal * newRentQtyItemModal * newRentTotalDaysModal);
//
//     //Writing
//     $('#editRentTotalPrice').val(newRentTotalPriceModal.toFixed(2));
// }
//
//
//
//
//
// /**
//  Item: Form
//  Method: Send the order (rent or sale) data by using AJAX
//  */
// formSubmission('#rentForm', '/saveRent', orderFormData, orderSaveSuccess, saveError);
//
// //Get the form data from the form
// function orderFormData() {
//     return {
//         rentFirstName: $('#rentFirstName').val(),
//         // rentLastName: $('#rentLastName').val(),
//         rentAddress: $('#rentAddress').val(),
//         rentItem: $('#rentItem').val(),
//         rentQtyItem: $('#rentQtyItem').val(),
//         rentPrice: $('#rentPrice').val(),
//         rentStarts: $('#rentStarts').val(),
//         rentEnds: $('#rentEnds').val(),
//         rentTotalDays: $('#rentTotalDays').val(),
//         rentTotalPrice: parseFloat($('#rentTotalPrice').val()),
//         rentPaymentStatus: $('#rentPaymentStatus').val(),
//         rentDetails: $('#rentDetails').val(),
//         rentStatus: $('#rentStatus').val()
//     };
// }
//
// /**
//  Item: Form
//  Method: Callback function for success
//  */
// function orderSaveSuccess(response) {
//     alert('Order added successfully!');
//     console.log(response);
//     loadRent(); //update the customer table
//
//     //Clear the form by resetting it
//     document.getElementById('rentForm').reset();
// }
//
