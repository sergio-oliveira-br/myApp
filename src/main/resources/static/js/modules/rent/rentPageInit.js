//src/main/resources/static/js/modules/rent/rentPageInit.js

$(document).ready(function () {

    //Load rent the table on rent page
    loadRentTable();

    //load customers created in the form as a list
    loadCustomersListForm('#rentFirstName'); //original form
    loadCustomersListForm('#editRentFirstName'); //modal edit

    //load product created in the form as a list
    loadProductListByProductType('Aluguel');

    //(Modal) Submit the data updated by using the method PUT
    $('#editRentForm').on('submit', function(e) {
        e.preventDefault();
        $('#displayRentModal').modal('hide');
        rentFormSubmissionModal(); //Used to update an existing resource on the server.
    });

    //(Modal)Update the rent status, if is "Finished", the item stock will return to total available
    $('#editRentStatus').on('change', function() {
        alert('O status do aluguel foi alterado.' +
            '\nCertifique-se de que você escolheu a opção correta!');

        console.log('rent Status Changed');
    });

    //(Modal)Update total price when price or quantity change
    $('#editRentPrice, #editRentQtyItem, #editRentStarts, #editRentEnds').on('change', function() {

        //Personalizing Messages Based on Changes
        let qtyChangedMsg = 'A quantidade foi alterada! O preço total foi atualizado.'
        let itemChangedMsg = 'O item foi alterado! O preço total foi atualizado.'
        let dateChangedMsg = 'A data foi alterada! O preço total foi atualizado.'

        //Verifica qual campo foi alterado e exibe uma mensagem personalizada
        //Ao usar $(this).attr('id'), obtemos o ID do elemento que disparou o evento
        if($(this).attr('id') === "editRentStarts" || $(this).attr('id') === "editRentEnds") {
            alert(dateChangedMsg);
            console.log(dateChangedMsg);
        }

        else if ($(this).attr('id') === "editRentQtyItem") {
            alert(qtyChangedMsg);
            console.log(qtyChangedMsg);
        }

        else if ($(this).attr('id') === "editRentPrice") {
            alert(itemChangedMsg);
            console.log(itemChangedMsg);
        }
        updateTotalPrice();
    });
});