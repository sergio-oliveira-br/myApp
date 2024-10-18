//src/main/resources/static/js/modules/sales/salesTable.js

function loadSalesTable() {

    ajaxRequestTypeGet("/api/v1/sale", function (data) {

        $('#saleList').empty();

        data.forEach(function (sale) {
            $('#saleList').append('<tr>' +
                '<td>' + sale.id + '</td>' +
                '<td>' + sale.saleFirstName + '</td>' +
                '<td>' + sale.saleAddress + '</td>' +
                '<td>' + sale.saleItem + '</td>' +
                '<td>' + sale.saleQtyItem + '</td>' +
                '<td>' + sale.salePrice.toFixed(2) + '</td>' +
                '<td>' + sale.saleDate + '</td>' +
                '<td>' + sale.saleTotalPrice.toFixed(2) + '</td>' +
                '<td><button class="btn btn-primary" onclick="populateSaleModal(' + sale.id + ')">Edit</button></td>' +
                '</tr>'
            );
        });
    });
}
