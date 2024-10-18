//src/main/resources/static/js/modules/sales/salesUtil.js

function loadTotalPriceSales() {
    let qty = document.getElementById('saleQtyItem').value;
    let unitPrice = parseFloat(document.getElementById('salePrice').value);
    let finalTotalPrice = parseFloat(qty * unitPrice);

    document.getElementById('saleTotalPrice').value = finalTotalPrice.toFixed(2);
}

// Update the total price when these fields change
document.getElementById('saleItem').addEventListener('change', loadTotalPriceSales);
document.getElementById('saleQtyItem').addEventListener('change', loadTotalPriceSales);


function updateTotalPriceSaleModal() {
    let newSalePrice = parseFloat($('#editSalePrice').val());
    let newSaleQty = parseInt($('#editSaleQtyItem').val());
    let newTotalPriceModal;
    
    if (isNaN(newSalePrice) || isNaN(newSaleQty)) {
        alert('Entrada inválida: Por favor, insira números válidos para preço e quantidade.')
        return; // Or handle the error in another way
    }

    newTotalPriceModal = (newSalePrice * newSaleQty);

    $('#editSaleTotalPrice').val(newTotalPriceModal.toFixed(2));
}