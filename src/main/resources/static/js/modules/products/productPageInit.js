//src/main/resources/static/js/modules/products/productPageInit.js

$(document).ready(function () {

    loadProductTable();

    //(Modal) Send the data by clicking on submit button
    $('#editModal').on('submit', function(e) {
        e.preventDefault();
    });
});

