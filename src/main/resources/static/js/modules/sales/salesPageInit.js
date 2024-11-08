//src/main/resources/static/js/modules/sales/salesPageInit.js

$(document).ready(function () {
    console.log('sale Page initialized');

    //load customers created in the form as a list
    loadCustomersListForm('#saleFirstName'); //original form
    loadCustomersListForm('#editSaleFirstName'); //modal edit

    //Load the items classified as "Vendas" in productType
    loadProductListByProductType('Venda');

    //Render the sales table
    loadSalesTable();

    //(Modal) Submit the data updated by using the method PUT
    $('#editSaleForm').on('submit', function(e) {
        e.preventDefault();
        $('#editModal').modal('hide');
        saleFormSubmissionModal(); //Used to update an existing resource on the server.
    });

    //(Modal)Update total price when price or quantity change
    $('#editSaleQtyItem, #editSaleItem').on('change', function() {
        //Personalizing Messages Based on Changes
        let qtyChangedMsg = 'O campo quantidade foi alterado! O preço total foi atualizado.'
        let itemChangedMsg = 'O campo item foi alterado! O preço total foi atualizado.'

        //Verifica qual campo foi alterado e exibe uma mensagem personalizada
        //Ao usar $(this).attr('id'), obtemos o ID do elemento que disparou o evento
        if($(this).attr('id') === "editSaleQtyItem") {
            alert(qtyChangedMsg);
            console.log(qtyChangedMsg);
        }
        else if ($(this).attr('id') === "editSaleItem") {
            alert(itemChangedMsg);
            console.log(itemChangedMsg);
        }
        updateTotalPriceSaleModal();
    });

    //(Modal)Presenting a message because of the significance of the field (payment)
    $('#editSalePaymentStatus').on('change', function() {
        let paymentStatusChangedMsg = 'Status do pagamento da venda foi alterado!'

        alert(paymentStatusChangedMsg);
        console.log(paymentStatusChangedMsg);
    })
});