//src/main/resources/static/js/modules/utilities/errorHandling.js

function errorHandler(error) {
    alert('Oops... Infelizmente ocorreu um erro!' );

    // Verifica se a resposta contém dados de erro
    if (error && error.responseJSON) {
        const problemDetails = error.responseJSON;

        // Exibir uma mensagem baseada nos detalhes do problema retornado pelo backend
        if (problemDetails.title && problemDetails.status && problemDetails.details) {
            alert(`Erro: ${problemDetails.title}
                    \nStatus: ${problemDetails.status}
                    \nDetalhes: ${problemDetails.details}
                    \nType: ${problemDetails.type}`);

            console.error(`Erro: ${problemDetails.title} Detalhes: ${problemDetails.details}`);

        // Mensagem genérica para quando não temos todas as informações
        } else {
            alert(`Erro: ${problemDetails.status || 'Erro Desconhecido'}
                    \nDetalhes: ${problemDetails.details || 'Sem detalhes disponíveis.'}`);

            console.error(`Erro não específico: ${JSON.stringify(problemDetails)}`);
        }
    } else {
        // Caso o erro não seja um objeto xhr
        alert(`Erro não tratado: ${error.message || 'Um erro desconhecido ocorreu.'}`);
        console.error('Erro não tratado:', error);
    }
}

//Lembrete: INSTANCEOF
//
// O operador instanceof é uma ferramenta poderosa
// para verificar tipos de objetos em JavaScript.
// Ele permite que você trate diferentes tipos de erros de forma específica,
// tornando seu código mais robusto e fácil de manter.
//
// Retorno: True ou False
//
// Beneficio: Tratamento personalizado
// Permite tratar diferentes tipos de erros de forma específica,
// oferecendo mensagens mais precisas ao usuário.