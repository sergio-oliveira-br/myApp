//Este método é responsavel por carregar o menu para dentro das páginas
$(document).ready(function () {

    $.get('/layouts/menu.html')
        .done(function (data) {
            $('#menu-sidebar').html(data);
            setActiveMenu();
        })

    .fail(function () {
        console.error('Falha ao carregar o menu');
    })
});

//Isto irá destacar o nome dentro da página aberta dentro do menu lateral
function setActiveMenu () {

    let currentPath = window.location.pathname;
    let allLinkOptions = document.getElementsByClassName('nav-link');

    Array.from(allLinkOptions).forEach((link) => {

        let href = link.getAttribute('href');
        if('/' + href === currentPath) {
            link.classList.add('active');
        }
    })
}



