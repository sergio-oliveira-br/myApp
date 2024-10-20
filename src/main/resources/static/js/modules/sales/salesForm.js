//src/main/resources/static/js/modules/sales/salesForm.js

submitForm('#saleForm', '/api/v1/sale/create-sale', saleFormData, saleSaveSuccess);

function saleFormData() {
    return {
        saleFirstName: $('#saleFirstName').val(),
        saleLastName: $('#saleLastName').val(),
        saleAddress: $('#saleAddress').val(),
        saleItem: $('#saleItem').val(),
        saleQtyItem: $('#saleQtyItem').val(),
        salePrice: parseFloat($('#salePrice').val()),
        saleDate: $('#saleDate').val(),
        saleTotalPrice: parseFloat($('#saleTotalPrice').val()),
        salePaymentStatus: $('#salePaymentStatus').val(),
        saleDetails: $('#saleDetails').val()
    };
}

function saleSaveSuccess(response) {
    alert("Venda salva com sucesso!");
    loadSalesTable();    // Update the sales table
}


