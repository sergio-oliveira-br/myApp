//src/main/resources/static/js/modules/rent/rentReport/rentSearchFilter.js

function searchRent() {
    let year = $('#yearInput').val();
    let month = $('#monthInput').val();
    let name = $('#nameInput').val();

    if (name) {
        if (year || month) {
            alert('Desculpe! Não é possível combinar nome e data ainda.' +
                '\nPor favor tente pesquisar apenas pelo nome ou pela data composta por mês e ano.');
        } else {
            getRentByName(name + '%'); // Finds any values that start with "name"
        }

    } else if (year && month) {
        getRentByMonth(year, month);

    } else {
        alert("Desculpe! Para pesquisar, por favor entre com o Nome ou a combinação de Mês e Ano.");
    }
}


function getRentByMonth(year, month) {
    let url = "/api/v1/rent/rent-by-date?year=" + encodeURIComponent(year) + "&month=" + encodeURIComponent(month);
    ajaxRequestTypeGet(url, renderRentTableReport);
}


function getRentByName(name) {
    let url = "/api/v1/rent/rent-by-name?customerName=" + encodeURIComponent(name);
    ajaxRequestTypeGet(url, renderRentTableReport);
}
