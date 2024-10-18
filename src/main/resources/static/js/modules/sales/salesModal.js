//src/main/resources/static/js/modules/sales/salesModal.js


function populateSaleModal(saleId) {

    ajaxRequestTypeGet('/api/v1/sale/' + saleId, function (sale){
        $('#editSaleId').val(sale.id);
        $('#editSaleFirstName').val(sale.saleFirstName);
        $('#editSaleAddress').val(sale.saleAddress);
        $('#editSaleItem').val(sale.saleItem);
        $('#editSaleQtyItem').val(sale.saleQtyItem);
        $('#editSalePrice').val(sale.salePrice);
        $('#editSaleDate').val(sale.saleDate);
        $('#editSaleTotalPrice').val(sale.saleTotalPrice);
        $('#editSaleDetails').val(sale.saleDetails);
        $('#editSalePaymentStatus').val(sale.salePaymentStatus);

        let editModal = new bootstrap.Modal(document.getElementById('editModal'));
        editModal.show();
    });
}


function saleFormSubmissionModal(){

    let saleData = {
        id: $('#editSaleId').val(),
        saleFirstName: $('#editSaleFirstName').val(),
        saleAddress: $('#editSaleAddress').val(),
        saleItem: $('#editSaleItem').val(),
        saleQtyItem: $('#editSaleQtyItem').val(),
        salePrice: $('#editSalePrice').val(),
        saleDate: $('#editSaleDate').val(),
        saleTotalPrice: $('#editSaleTotalPrice').val(),
        salePaymentStatus: $('#editSalePaymentStatus').val(),
        saleDetails: $('#editSaleDetails').val()
    };

    ajaxRequestTypePut('/api/v1/sale/update-sale/' + saleData.id, saleData, function (response) {

        alert("Venda 'ID: " + saleData.id +  ", "  +  saleData.saleFirstName + "' alterada com sucesso!");
        $('#editModal').modal('hide');
        loadSalesTable();
    })
}