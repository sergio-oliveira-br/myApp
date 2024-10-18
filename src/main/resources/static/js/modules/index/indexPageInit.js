//src/main/resources/static/js/modules/index/indexPageInit.js

$(document).ready(function () {
    //This will display a number by status within the cards
    loadQtyRentByStatus('Novo');
    loadQtyRentByStatus('Em andamento');
    loadQtyRentByPaymentStatus('Pendente');

    //load customers created in the form as a list
    loadCustomersListForm('#editRentFirstName'); //modal edit

    //(Modal)Submit the data updated by using the method PUT
    $('#editRentForm').on('submit', function(e) {
        e.preventDefault(); //Prevents the standard form submission
        rentFormSubmissionModal(); //Used to update an existing resource on the server.
        $('#displayRentModal').modal('hide');
    });

    //(Modal)When the user change/update the rent status, a msg will be displayed
    $('#editRentStatus').on('change', function() {
        alert('O status do aluguel foi alterado.' +
            '\nCertifique-se de que você escolheu a opção correta!');

        console.log('Rent Status Changed');
    });

    //(Modal)Presenting a message because of the significance of the field (payment) RENT
    $('#editRentPaymentStatus').on('change', function() {
        let paymentStatusChangedMsg = 'Status do pagamento do aluguel foi alterado!'

        alert(paymentStatusChangedMsg);
        console.log(paymentStatusChangedMsg);
    })

})