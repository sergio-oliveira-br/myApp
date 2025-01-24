//Este método é responsavel por carregar o menu para dentro das páginas
$(document).ready(function () {
    //verifica se o menu esta no cache
    let cachedMenu = localStorage.getItem('menuHTML');

    if(cachedMenu) {
        $('#menu-sidebar').html(cachedMenu);
        setActiveMenu();
    }
    else {
        // Faz a requisição AJAX apenas se o menu não estiver no cache
        $.get('/layouts/menu.html')
            .done(function (data) {
                $('#menu-sidebar').html(data);
                localStorage.setItem('menuHTML', data); // Armazena o menu no cache
                setActiveMenu();
            })
            .fail(function () {
                console.error('Falha ao carregar o menu');
            });
    }
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



