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
// function displayMsgWIP()
// {
//     alert("Sorry! Working in progress...")
// }
//
// //Redirecting the user to the reports page
// function goToReportPage()
// {
//     window.location.href = "report.html";
// }
//
// //Redirecting the user to the expense reports page
// function goToExpenseReportPage()
// {
//     window.location.href = "expensesreport.html";
// }
//
// //Redirecting the user to the expense page
// function goToExpensePage()
// {
//     window.location.href = "expenses.html";
// }
//
//
// //Reference: https://getbootstrap.com/docs/5.0/forms/validation/
// //Checking form submissions if there are invalid fields: Used by "Rent Form"/"Rent Form Edit"
// (function () {
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     var forms = document.querySelectorAll('.needs-validation')
//
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(forms)
//         .forEach(function (form) {
//             form.addEventListener('submit', function (event) {
//                 if (!form.checkValidity()) {
//                     event.preventDefault()
//                     event.stopPropagation()
//                     console.log('Checking the form...')
//                 }
//                 form.classList.add('was-validated')
//             }, false)
//         })
// })()
//
//
//
// /**
//  Method: Generic function to perform an AJAX request and handle success and error responses
//  Type: GET
//  */
// function ajaxRequest(url, successCallback)
// {
//     $.ajax({
//         url: url,     //indicates the endpoint from the argument to the ajaxRequest function
//         type: "GET",  //HTTP request methods used to RETRIEVE data from the server (backend)
//
//         //If the request is successful,
//         //a callback function will be called from the argument to the ajaxRequest function
//         success: successCallback,
//
//         //If there is any error
//         error: function(xhr, status, error)
//         {
//             console.error(error); //log
//             let errorMessage = xhr.responseText;
//             alert("From the Server: " + errorMessage);
//         }
//     });
// }
//
//
// /** Function: Handle errors, showing the error message to the user */
// function handleError(errorMessage)
// {
//     alert(errorMessage);
// }
//
//
// /** Method: Create a list of all items and display it in the Product field of the Sales and Rent Form*/
// function loadProductListByProductType(productType){
//     ajaxRequest("/productByType?productType=" + encodeURIComponent(productType), function(data)
//     {
//         //variable
//         // let saleItemSelect = $('#saleItem');
//         // let rentItemSelect = $('#rentItem');
//
//         let productSelects = [$('#saleItem'), $('#rentItem'), $('#editRentItem')]; // Array of both select elements
//         productSelects.forEach(function (selectElement) {
//             //cleaning to display each item only once
//             selectElement.empty();
//
//             //Iteration
//             data.forEach(function (product)
//             {
//                 selectElement.append('<option id="' + product.id + '" price="' + product.itemPrice + '">' + product.itemDescription + '</option>');
//             });
//         });
//     });
// }
//
//
// //Everytime that the user change the field item, the price will be updated
// $('#rentItem, #editRentItem, #saleItem').change(function() {
//     console.log('Change event triggered');
//
//     let selectedOption = $(this).find(':selected');
//
//     let price = selectedOption.attr('price');
//
//     if ($(this).attr('id') === 'rentItem') {
//         console.log('Selected option:', selectedOption);
//         $('#rentPrice').val(price);
//     }
//
//     else if ($(this).attr('id') === 'editRentItem') {
//         console.log('Selected option:', selectedOption);
//         $('#editRentPrice').val(price);
//         updateTotalPrice();
//     }
//
//     else if ($(this).attr('id') === 'saleItem') {
//         console.log('Selected option:', selectedOption);
//         $('#salePrice').val(price);
//
//         //any changes needed to update the total price !NEED TO PUT THIS ON MODAL
//         loadTotalPriceSales();
//     }
//
//
//
// });
//
//
// function loadCustomers(selectId) {
//     ajaxRequest("/customers", function (data) {
//         const customerSelect = $(selectId);
//         customerSelect.empty();
//
//         data.forEach(function (customer) {
//             customerSelect.append(
//                 `<option value="${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}">${customer.firstName} ${customer.lastName} - ${customer.phoneNumber}</option>`
//             );
//         });
//     });
// }
//
//
//
//
//
//
//
