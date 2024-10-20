//src/main/resources/static/js/modules/rent/rentUtils.js

function calculateRentDuration(end, start) {
    let start_Date = new Date(start);
    let end_Date = new Date(end);
    let diffTime = Math.abs(end_Date - start_Date);
    let diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

    return diffDays;
}

function loadRentDays() {
    let newStart = document.getElementById('rentStarts').value;
    let newEnd = document.getElementById('rentEnds').value;

    let rentTotalDays = calculateRentDuration(newEnd, newStart);
    document.getElementById('rentTotalDays').value = rentTotalDays;
    console.log("Os dias foram calculados: ", rentTotalDays);

    loadTotalPrice();
}

//Update everytime that one of these five field is changed
document.getElementById('rentStarts').addEventListener('change',loadRentDays);
document.getElementById('rentEnds').addEventListener('change',loadRentDays);


function loadTotalPrice() {
    let newTotalDays = parseInt(document.getElementById('rentTotalDays').value);
    let newTotalQty = parseInt(document.getElementById('rentQtyItem').value);
    let newUnitPrice = parseFloat(document.getElementById('rentPrice').value);

    let newRentTotalPrice = (newTotalDays * newTotalQty * newUnitPrice);
    document.getElementById('rentTotalPrice').value = newRentTotalPrice.toFixed(2);
}

//Update everytime that one of these five field is changed
document.getElementById('rentTotalDays').addEventListener('change', loadTotalPrice);
document.getElementById('rentQtyItem').addEventListener('change', loadTotalPrice);
document.getElementById('rentPrice').addEventListener('change', loadTotalPrice);


