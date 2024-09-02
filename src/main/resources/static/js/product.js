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
//  Page: Product
//  Method: Ready()
//
//  Info: As soon as the page's Document Object Model (DOM)
//  is ready for manipulation, JavaScript code can be executed.
//  */
// $(document).ready(function()
// {
//     //Load the table
//     loadProduct(); ok
//
//
//     //(Modal)The script will load the available items in the Product form when the page loads
//     updateLoadProductForm();
//
//     //Modal
//     $('#editModal').on('submit', function(e) {
//         e.preventDefault();
//     });
// });
//
//
// /**
//  Page: Products
//  Item: Table
//  Method: Create a table with all products via AJAX
//  */
// function loadProduct()
// {
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/product", function(data)
//     {
//         //first clean
//         $('#productList').empty();
//
//         //Iteration
//         data.forEach(function(product)
//         {
//             $('#productList').append('<tr>' +
//                 '<td>' + product.id + '</td>' +
//                 '<td>' + product.itemDescription + '</td>' +
//                 '<td>' + product.itemPrice + '</td>' +
//                 '<td>' + product.itemQuantity +'</td>' +
//                 '<td>' + product.itemAvailableQty + '</td>' +
//                 '<td>' + product.productType + '</td>' +
//                 '<td><button class="btn btn-primary" onclick="openEditModal(' + product.id + ')">Edit</button></td>'
//             );
//         });
//     });
// }
//
//
//
// /**
//  Page: Products
//  Item: Form (modal) -> OpenEditModal() -> SubmitEditForm()
//  Method: This is a jQuery method that allows
//     the user to make asynchronous requests to the server
//     to send or receive data without having to reload the page
//     (There is a confirmation msg method as well)
// */
// function openEditModal(productId)
// {
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/product/" + productId, function(product)
//     {
//         $('#editProductId').val(productId);
//         $('#editItemDescription').val(product.itemDescription);
//         $('#editItemQty').val(product.itemQuantity);
//         $('#editItemPrice').val(product.itemPrice);
//         $('#editProductType').val(product.productType);
//         $('#editItemQtyAvailable').val(product.itemAvailableQty)
//
//         //Open the modal
//         let editModal = new bootstrap.Modal(document.getElementById('editModal'));
//         editModal.show();
//     });
// }
//
// function submitEditForm() {
//     let currentDate = new Date();
//
//     let itemData = {
//         id: $('#editProductId').val(),
//         itemDescription: $('#editItemDescription').val(),
//         itemQuantity: $('#editItemQty').val(),
//         itemPrice: $('#editItemPrice').val(),
//         productType: $('#editProductType').val(),
//         itemAvailableQty: $('#editItemQtyAvailable').val(),
//         dateModified: currentDate,
//     };
//     //Remember: PUT -> Send data to the server to update an existing resource
//     $.ajax({url: "/product/" + itemData.id,
//         type: "PUT",
//         contentType: 'application/json',
//         data: JSON.stringify(itemData),
//
//         success: function(response) {
//             console.log('Item updated: ' , response);
//             alert('Item atualizado com sucesso!');
//
//             $('#editModal').modal('hide');
//             loadProduct(); // Reload the product list after update
//         },
//         error: function(xhr, status, error) {
//             console.error(error);
//             alert('Oops, não foi possivel realizar esta atualização! Erro: ' + xhr.responseText );
//         }
//     })
// }
//
// //Confirmation msg
// document.getElementById('editModal').addEventListener('submit', function(event) {
//     //Displays the confirmation msg
//     let confirmation = confirm('Tem certeza de que deseja salvar as modificações?');
//
//     //If the user cancels, do not send the form!
//     if (confirmation) {
//         submitEditForm(); //send the data after the confirmation from the user
//     }
//
//     else{
//         event.preventDefault();
//         console.log('Usuário cancelou a operação.')
//     }
//
// });
//
// //Update
// function updateLoadProductForm()
// {
//     //Call the generic function, that perform an AJAX request
//     ajaxRequest("/product", function(data)
//     {
//         //Local variable
//         let productSelect = $('#editItemQty');
//
//         //First clean
//         productSelect.empty();
//
//         //Iteration
//         data.forEach(function(product)
//         {
//             productSelect.append('<option value="' + product.id + '">' + product.name + '</option>');
//         });
//     });
// }
//
// //This is just to get a confirmation from the user, that they will change a sensitive data
// document.getElementById('editItemQtyAvailable').addEventListener('change',stockAlert);
// function stockAlert() {
//     let confirmationMsg = "Você tem certeza eu deseja alterar o Estoque?"
//
//     if (confirm(confirmationMsg)) {
//         submitEditForm(); //send the data after the confirmation from the user
//     }
//     else{
//         alert('Operação cancelada!')
//     }
//
// }
//
//
//
// /**
//  Item: Form
//  Method: Send the Product data by using AJAX
//  */
// formSubmission('#itemForm', '/saveProduct', productFormData, productSaveSuccess, saveError);
//
// //Get the form data from the form
// function productFormData()
// {
//     let currentDate = new Date();
//
//     return {
//         itemDescription: $('#itemDescription').val(),
//         itemQuantity: $('#itemQty').val(),
//         productType: $('#productType').val(),
//         dateCreated: currentDate,
//         dateModified: currentDate,
//         itemPrice: $('#itemPrice').val(),
//     };
// }
//
// /**
//  Item: Form
//  Method: Callback function for success
//  */
// function productSaveSuccess(response)
// {
//     alert('Produto adicionado com sucesso!');
//     console.log(response);
//     loadProduct(); //update the product table
//
//     //Clear the form by resetting it
//     document.getElementById('itemForm').reset();
// }
//
//
